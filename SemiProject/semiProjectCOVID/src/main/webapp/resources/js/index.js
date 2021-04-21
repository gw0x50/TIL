$(document).ready(function(){
	$("#loginForm").on("submit", function(event){
		if (!$("#id").val()) {
			$("#id").focus();
			Swal.fire("잠시만요!", "아이디를 입력해주세요.", "warning");
			return false;
		}
		else if (!$("#password").val()) {
			$("#password").focus();
			Swal.fire("잠시만요!", "비밀번호를 입력해주세요.", "warning");
			return false;
		}
		else {
			$.ajax({
				url: "/member/loginCheck",
				type: "post",
				data: { "id": $("#id").val() , "password":$("#password").val()},
				dataType: "json",
				success: function (data) {
					if (data.check === "1") { //1일 경우 원하는 데이터가 있으므로 submit 처리
						event.currentTarget.submit();
					}
					else {
						Swal.fire("로그인 실패!", "로그인 정보를 확인해주세요!", "warning");
					}
				}
			});//ajax End
			return false;
		}
	});//Check End
});//ready End