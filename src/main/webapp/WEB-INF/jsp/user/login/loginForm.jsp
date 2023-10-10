<%@ page language="java" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="format-detection" content="telephone=no, email=no, address=no">
	
	<link rel="shortcut icon" type="image/x-icon" href="/resources/user/images/common/favicon.png">
	
	<script type="text/javascript" src="/resources/user/script/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/resources/user/script/lib/cipher/jsencrypt.min.js"></script>

	<title>로그인</title>
</head>

<body>
	<main id="wrap" class="login">
		<div class="login-area">
			<form>
				<fieldset>
					<h1>로그인</h1>

					<div class="inner">
						<form name="loginForm" id="loginForm" method="post" class="loginform">
							<span class="form-entry">
								<input type="text" name="memberNo" id="memberNo" placeholder="사번를 입력해주세요." title="사번 입력" data-required="true" tabindex="1">
							</span>
							<span class="form-entry">
								<input type="password" name="password" id="password" placeholder="임직원은 서클, FP는 FP월드 비밀번호입니다." title="비밀번호 입력" tabindex="2">
							</span>

							<button type="submit" id="submitBtn" class="btn fill mint" onclick="submit(); return false;">로그인</button>
						</form>
					</div>
				</fieldset>
			</form>
		</div>
	</main>

	<script type="text/javascript">
        function submit() {

            var password = $("#password").val();
            var rsaTimestamp = '${rsaTimestamp}';
            var rsaPublicKeyBase64 = '${rsaPublicKeyBase64}';

            if (rsaPublicKeyBase64 != null && rsaPublicKeyBase64.length > 0) {
                var rsaEncrypt = new JSEncrypt();
                rsaEncrypt.setPublicKey(rsaPublicKeyBase64);

                password = rsaEncrypt.encrypt(password); // 공개키 암호화
            }

            var param = {
                'memberNo' : $("#memberNo").val(),
                'password' : password,
                'rsaTimestamp' : rsaTimestamp
            };

            $.ajax({
                type : "POST",
                url : '/user/login/ajax/login.do',
                data : param,
                dataType : "json",
                success : function(response) {

                    var isSuccess = response.isSuccess;

                    if (isSuccess || isSuccess == 'true') {
                        location.href = '/user/main.do';

                    } else {
                        alert('로그인에 실패하였습니다.');
                    }
                },
                error : function(xhr, status, exception, exMap) {
                    // console.log(exception);
                }
            });
        }
    </script>

</body>
</html>