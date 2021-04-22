<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세미 프로젝트</title>
<!-- jquery  --> 
<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
<!-- 알람 swal  -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<!-- 카카오맵 API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cf8d72dd879feadc271a57950d99b238&libraries=services"></script>
<!-- index 관련 script -->
<script src="/resources/js/index.js"></script>
<!-- header css -->
<link rel="stylesheet" href="/resources/css/header.css" type="text/css">
<!-- index 관련 css -->
<link rel="stylesheet" href="/resources/css/index.css" type="text/css">
<!-- map 관련 css -->
<link rel="stylesheet" href="/resources/css/map.css" type="text/css">
<!-- board 관련 css -->
<link rel="stylesheet" href="/resources/css/board.css" type="text/css">
<!-- footer css -->
<link rel="stylesheet" href="/resources/css/footer.css" type="text/css">
<!-- map 관련 script (jstl 때문에 js파일 분리하지 않았음) -->
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
		
			// 마커 이미지의 주소입니다
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
			
			// 마커 이미지의 이미지 크기입니다
			var imageSize = new kakao.maps.Size(24, 35); 
			
			// 마커 이미지를 생성합니다
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			
			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				position: markerPosition,
				image: markerImage
			});
		
			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			
			// 커스텀 오버레이에 표출될 내용
			var content = '<div class="customoverlay">' +
		    '    <span class="title">사용자 입력 주소<br>' + sessionAddress + '</span>' +
		    '  </a>' +
		    '</div>';
			var position = moveLatLon;
		
			// 마커 위에 커스텀오버레이를 표시합니다
			// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
			var overlay = new kakao.maps.CustomOverlay({
				map: map,
				content: content,
				position: position  
			});
			
			kakao.maps.event.addListener(marker, "click", function() {
				overlay.setMap(map);
			});	
			
			kakao.maps.event.addListener(map, "click", function() {
				overlay.setMap(null);
			});	
			
		}// if End
	});// addressSearch End
	
	// 마커 자동 닫힘을 위한 변수
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
				var content = '<div class="map_content">' + 
								'<div class="info">' + 
				            		'<div class="title">' + "${center.name}" +  '</div>' + 
				            		'<div class="body">' + 
				            			'<div class="desc">' + 
				            				'<div class="address">' + "${center.address}" + '</div>' + 
				            				'<div class="phone">' + "${center.phone}" + '</div>' + 
				            				'<div class="hour">' + '평일 : ' +"${center.weekdays}" + '</div>' +
				            				'<div class="hour">' +'토요일 : ' + "${center.saturday}" + ' / 일요일 : ' + "${center.sunday}" + '</div>' + 
				            				'<div class="link">' +
				            					'<a href="https://map.kakao.com/link/map/'+ "${center.name}" + 
				            						',' + result[0].y + ',' + result[0].x + 
													'"style="color:blue" target="_blank">' + "길 찾기로 이동" +
												'</a>' +
											'</div>' +				
				            			'</div>' + 
				            		'</div>' + 
				            	'</div>' +    
				            '</div>';
				
				// 마커 위에 커스텀오버레이를 표시합니다
				// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
				var overlay = new kakao.maps.CustomOverlay({
					map: null,
					content: content,
					position: marker.getPosition()       
				});
				
				// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
				// 또한 기존에 표시되던 커스텀 오버레이를 종료합니다
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
	<div class="wrap">
		<jsp:include page="/WEB-INF/views/frame/header.jsp"/>
		<div class="container">
			<jsp:include page="/WEB-INF/views/section/map.jsp"/>
			<jsp:include page="/WEB-INF/views/section/board.jsp"/>
		</div>
		<jsp:include page="/WEB-INF/views/frame/footer.jsp"/>
	</div>
</body>
</html>