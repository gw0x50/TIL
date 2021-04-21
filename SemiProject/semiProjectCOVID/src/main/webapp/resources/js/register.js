$(document).ready(function() {
	$("#registerForm").on("submit", function() {
		if (!$("#id").val()) {
			$("#id").focus();
			Swal.fire("잠시만요!", "아이디를 입력해주세요.", "warning");
			return false;
		}
		if ($("#idValidCheck").val() == "false") {
			Swal.fire("잠시만요!", "중복 검사를 해주세요.", "warning");
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
		if ($("#validCheck").val() == "false") {
			Swal.fire("잠시만요!", "중복 검사를 해주세요.", "warning");
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
	}); //insertCheck End

	$("#id").on("keyup", function() {
		$.ajax({
			url: "/member/validCheck",
			type: "post",
			data: { "id": $("#id").val() },
			dataType: "json",
			success: function(data) {
				if (data.check === "0") { //중복 아이디 존재함
					$("#idCheckMessage").css("color", "red");
					$("#idCheckMessage").html("이미 사용중인 아이디 입니다.");
					$("#idValidCheck").val("false");
				}
				else if (data.check === "1") { //사용 가능
					$("#idCheckMessage").css("color", "blue");
					$("#idCheckMessage").html("사용가능한 아이디 입니다.");
					$("#idValidCheck").val("true");
				}
			}
		});//ajax End
	});//idValidCheck End

	$("#password").on("keyup", function() {
		if ($("#password").val() == $("#passwordCheck").val() && $("#passwordCheck").val() != "") {
			$("#passwordCheckMessage").css("color", "blue");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치합니다.");
			$("#passwordEqualCheck").val("true");
		}
		else if ($("#password").val() != $("#passwordCheck").val() && $("#passwordCheck").val() != "") {
			$("#passwordCheckMessage").css("color", "red");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치하지 않습니다.");
			$("#passwordEqualCheck").val("false");
		}
	});
	$("#passwordCheck").on("keyup", function() {
		if ($("#password").val() == $("#passwordCheck").val()) {
			$("#passwordCheckMessage").css("color", "blue");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치합니다.");
			$("#passwordEqualCheck").val("true");
		}
		else {
			$("#passwordCheckMessage").css("color", "red");
			$("#passwordCheckMessage").html("비밀번호가 서로 일치하지 않습니다.");
			$("#passwordEqualCheck").val("false");
		}
	});//passwordEqualCheck End

	$("#searchAddr").on("click", function() {
		new daum.Postcode({
			oncomplete: function(data) {
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
});//ready End