<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Домашняя страница</title>

<link href="/css/Content/style.css" rel="stylesheet" type="text/css" />
<link href="/css/Content/ie6.css" rel="stylesheet" type="text/css" />

</head>
<body id="page1">
<div class="tail-top">
	<div class="tail-bottom">
		<div id="main">
<!-- HEADER -->
			<div id="header">
				<div class="row-1">
					<div class="fleft">Мир кино</div>
					<ul>
						<li>
							<form action="/Movies" method="post">
								<input type="hidden" name="command" value="sign_out"/>
								<button type="submit" style="background: #2e3133; width: 50px; height: 20px; border-radius: 5px; box-shadow: 0px 1px 3px; font-size: 12px; color: white">Выйти</button>
							</form>
						</li>
						<li style="font-weight: bold; text-decoration-line: underline; text-decoration-color: #d39e00" >${loggined}</li>
					</ul>
				</div>
				<div class="row-2">
					<ul>
						<li><a class="active">Домой</a></li>
						<li>
							<form action="/Movies" method="post">
								<input type="hidden" name="command" value="goto_companies_list"/>
								<button type="submit" class="refbutton">Компании</button>
							</form>
						</li>
						<li>
							<form action="/Movies" method="post">
								<input type="hidden" name="command" value="goto_films_list"/>
								<button type="submit" class="refbutton">Фильмы</button>
							</form>
						</li>
						<li>
							<form action="/Movies" method="post">
								<input type="hidden" name="command" value="goto_raiting_list"/>
								<button type="submit" class="refbutton">О рейтингах</button>
							</form>
						</li>
						<li>
							<form action="/Movies" method="post">
								<input type="hidden" name="command" value="goto_navigation"/>
								<button type="submit" class="refbutton">Управление</button>
							</form>
						</li>
					</ul>
				</div>
			</div>
<!-- CONTENT -->
			<div id="content">
				<div id="slogan">
					<div class="image png"></div>
					<div class="inside">
						<h2>Добро пожаловать</h2>
						<p>На этом сайте вы сможете узнать об имеющихся фильмах и оставить отзывы о них, узнать немного фактов о кинокомпаниях и возрастных рейтингах фильмов</p>
					</div>
				</div>
			</div>
<!-- FOOTER -->
			<div id="footer">
				<div class="left">
					<div class="right">
						<div class="inside">Copyright - Alexander Zherebilo<br />
							<div class="new_window">BSUIR 2019<br /></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"> Cufon.now(); </script>
</body>
</html>