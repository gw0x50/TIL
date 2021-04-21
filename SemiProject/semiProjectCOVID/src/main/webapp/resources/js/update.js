$(document).ready(function(){
	$("#registerForm").on("submit", function() {
		if (!$("#id").val()) {
			$("#id").focus();
			Swal.fire("잠시만요!", "아이디를 입력해주세요.", "warning");
			return false;
		}
		if (!$("#password").val()) {
			$("#password").focus();
			Swal.fire("잠시만요!", "비밀번호를 입력해주세요.", "warning");
			return false;
		}
		if (!$("#passwordCheck").val()) {
			$("#passwordCheck").focus();
			Swal.fire("잠시만요!", "비밀번호 확인을 입력해주세요.", "warning");
			return false;
		}
		if ($("#passwordEqualCheck").val() == "false") {
			Swal.fire("잠시만요!", "입력한 비밀번호를 확인해주세요.", "warning");
			return false;
		}
		if (!$("#name").val()) {
			$("#name").focus();
			Swal.fire("잠시만요!", "이름을 입력해주세요.", "warning");
			return false;
		}
		if (!$("#phone").val()) {
			$("#phone").focus();
			Swal.fire("잠시만요!", "전화번호를 입력해주세요.", "warning");
			return false;
		}
		if (!$("#email").val()) {
			$("#email").focus();
			Swal.fire("잠시만요!", "이메일을 입력해주세요.", "warning");
			return false;
		}
		if (!$("#address").val()) {
			$("#address").focus();
			Swal.fire("잠시만요!", "주소를 입력해주세요.", "warning");
			return false;
		}
		if (!$("#detailAddress").val()) {
			$("#detaillAddress").focus();
			Swal.fire("잠시만요!", "상세 주소를 입력해주세요.", "warning");
			return false;
		}
	});//insertCheck End
	
	$("#password").on("keyup", function(){
		if($("#password").val() == $("#passwordCheck").val() && $("#passwordCheck").val() != "") {
			$("#passwordCheckMessage").css("color","blue");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치합니다.");
			$("#passwordEqualCheck").val("true");
		}
		else if($("#password").val() != $("#passwordCheck").val() && $("#passwordCheck").val() != ""){
			$("#passwordCheckMessage").css("color","red");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치하지 않습니다.");
			$("#passwordEqualCheck").val("false");
		}
	});
	$("#passwordCheck").on("keyup", function(){
		if($("#password").val() == $("#passwordCheck").val()) {
			$("#passwordCheckMessage").css("color","blue");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치합니다.");
			$("#passwordEqualCheck").val("true");
		}
		else{
			$("#passwordCheckMessage").css("color","red");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치하지 않습니다.");
			$("#passwordEqualCheck").val("false");
		}
	});//passwordEqualCheck End
	
	$("#searchAddr").on("click", function(){
		new daum.Postcode({
			oncomplete: function (data) {
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 참고 항목 변수

				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = ' (' + extraRoadAddr + ')';
				}

				// 주소 정보를 해당 필드에 넣는다.
				$("#address").val(roadAddr);
			}
		}).open();
	});//searchAddr End
	
	$("#deleteForm").on("submit", function(event){
		Swal.fire({
			title: '회원 탈퇴를 진행하시겠습니까?',
			text: "탈퇴하시면 회원 정보는 복구가 불가능합니다.",
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#d33',
			confirmButtonText: '삭제',
			cancelButtonText: '취소',
		}).then((result) => {
			if (result.isConfirmed) {
				event.currentTarget.submit();
		  	}
		})
		return false;
	});//deleteMember End
});//ready End