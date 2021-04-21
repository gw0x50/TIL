<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  jquery  --> 
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<!--  알람 swal  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!-- 카카오맵 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf8d72dd879feadc271a57950d99b238&libraries=services"></script>
<!-- index 관련 script -->
<script src="/resources/js/index.js"></script>
<style>
    .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
</style>
<script>
$(document).ready(function(){
	var container = document.getElementById("map"); // 지도를 표시할 div 
	
	var sessionAddress = '<%=(String)session.getAttribute("address")%>';

	var mapOptions = {
		center: new kakao.maps.LatLng(37.498095, 127.027610), // 기본 위도 경도값(강남역)
		level: 5 // 지도의 확대 레벨
	};
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 지도를 생성합니다   
	var map = new kakao.maps.Map(container, mapOptions);
	
	// 세션 주소로 좌표를 검색합니다
	geocoder.addressSearch(sessionAddress, function (result, status) {
		
		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {
		
			// 검색된 위도,경도 데이터 입력
			var moveLatLon = new kakao.maps.LatLng(result[0].y, result[0].x);
		
			// 지도 중심 위치 변경
			map.setCenter(moveLatLon);
		
			// 지도 축척 변경
			map.setLevel(2);
		
			// 마커가 표시될 위치입니다 
 			var markerPosition  = moveLatLon;
		
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				position: markerPosition
			});
		
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
		
			// 인포윈도우에 표출될 내용
			var iwContent = "<div style='padding:5px; color:blue;' >사용자 입력 주소</div>"; 
			var iwPosition = moveLatLon;
		
			// 인포윈도우를 생성합니다
			var infowindow = new kakao.maps.InfoWindow({
				position : iwPosition, 
				content : iwContent 
			});
		
			// 마커 위에 인포윈도우를 표시합니다.
        	infowindow.open(map, marker); 
		}// if End
	});// addressSearch End
	
	var clickedOverlay = null;
	
	<c:forEach items="${centerList}" var="center">
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch("${center.address}", function (result, status) {
		
			// 정상적으로 검색이 완료됐으면 
			if (status === kakao.maps.services.Status.OK) {
			
				// 검색 결과의 위도 경도 입력
				var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
				// 결과값으로 받은 위치를 마커로 표시합니다
				var marker = new kakao.maps.Marker({
					map: map,
					position: coords,
					clickable: true
				});
				
				// 커스텀 오버레이에 표시할 컨텐츠 입니다
				// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
				// 별도의 이벤트 메소드를 제공하지 않습니다.
				var content = '<div class="wrap">' + 
				            '    <div class="info">' + 
				            '        <div class="title">' + 
				            '       ' + "${center.name}" + 
				            '        </div>' + 
				            '        <div class="body">' +  + 
				            '            <div class="desc">' + 
				            '                <div class="address">' + 
				            '					<a href="https://map.kakao.com/link/map/'+ "${center.name}" + 
				            					',' + result[0].y + ',' + result[0].x + 
							'					" style="color:blue" target="_blank">' + "${center.address}" +
							'					</a></div>' + 
				            '                <div class="phone">' + "${center.phone}" + '</div>' + 
				            '                <div></div>' + 
				            '            </div>' + 
				            '        </div>' + 
				            '    </div>' +    
				            '</div>';
				          
				// 마커 위에 커스텀오버레이를 표시합니다
				// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
				var overlay = new kakao.maps.CustomOverlay({
					map: null,
					content: content,
					position: marker.getPosition()       
				});
				
				// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
				kakao.maps.event.addListener(marker, "click", function() {
				    if (clickedOverlay) {
				    	clickedOverlay.setMap(null);
				    }
					overlay.setMap(map);
					clickedOverlay = overlay;
				});							
	
			}// if End
		});// addressSearch End
	</c:forEach>
});
</script>

</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/views/frame/header.jsp"/>
		<div id="container">
			<jsp:include page="/WEB-INF/views/section/map.jsp"/>
		</div>
		<jsp:include page="/WEB-INF/views/frame/footer.jsp"/>
	</div>
</body>
</html>