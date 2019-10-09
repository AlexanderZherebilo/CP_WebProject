<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" pageEncoding="utf-8">
    <title>Авторизация</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/css/Authorization/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/css/Authorization/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/css/Authorization/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/css/Authorization/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/css/Authorization/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/css/Authorization/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/css/Authorization/css/util.css">
    <link rel="stylesheet" type="text/css" href="/css/Authorization/css/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">

            <form class="login100-form validate-form" action="/Movies" method="post">
					<span class="login100-form-title">
						Меню авторизации
					</span>
                <input type="hidden" name="command" value="sign_in"/> <!-- Эта строка нужна для передачи сервлету значения комманды,
                                                                        которую нужно выполнить серверу для данной формы-->

                <div class="wrap-input100 validate-input" data-validate = "Образец ввода эл почты: ex@abc.xyz">
                    <input class="input100" type="text" name="login" placeholder="Логин или адрес эл. почты">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user-circle" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="password" name="password" placeholder="Пароль">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button type="submit" class="login100-form-btn">
                        Войти
                    </button>
                    <span style="color: red; font-size: 14px">${error}</span>
                </div>
            </form>

            <div class="login100-pic">
                <img src="/css/Authorization/images/Movie-logo.jpg">
            </div>

            <form class="login100-form" action="/Movies" method="post">
                <input type="hidden" name="command" value="goto_sign_up"/>
                <div class="text-center p-t-12">
						<span class="txt1">
							Впервые у нас?
						</span>
                    <button type="submit" class="txt2">
                        Зарегистрируйтесь
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>




<!--===============================================================================================-->
<script src="/css/Authorization/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/css/Authorization/vendor/bootstrap/js/popper.js"></script>
<script src="/css/Authorization/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/css/Authorization/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/css/Authorization/vendor/tilt/tilt.jquery.min.js"></script>
<!--===============================================================================================-->
<script src="/css/Authorization/js/main.js"></script>

</body>
</html>
