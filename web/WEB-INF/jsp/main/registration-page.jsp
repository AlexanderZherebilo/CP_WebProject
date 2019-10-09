<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" pageEncoding="utf-8">
    <title>Регистрация</title>
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
						Меню регистрации
					</span>
                <input type="hidden" name="command" value="sign_up"/> <!-- Эта строка нужна для передачи сервлету значения комманды,
                                                                        которую нужно выполнить серверу для данной формы-->

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="text" name="name" placeholder="Имя">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="text" name="surname" placeholder="Фамилия">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Образец ввода: ex@abc.xyz">
                    <input class="input100" type="text" name="email" placeholder="Адрес эл. почты">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="text" name="country" placeholder="Страна">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-flag" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="text" name="login" placeholder="Логин">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-user-circle" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="password" name="first_password" placeholder="Пароль">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Обязательное поле">
                    <input class="input100" type="password" name="repeat_password" placeholder="Повторите пароль">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>
                <span style="color: red; text-align: center !important; font-size: 14px">${error}</span>
                <div class="container-login100-form-btn">
                    <button type="submit" class="login100-form-btn">
                        Зарегистрироваться
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
