<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Возрастные рейтинги</title>
	<link href="/css/Content/style.css" rel="stylesheet" type="text/css" />
	<link href="/css/Content/ie6.css" rel="stylesheet" type="text/css" />
</head>
<body id="page3">
<div class="tail-top">
	<div class="tail-bottom">
		<div id="main">
<!-- HEADER -->
			<div id="header">
				<div class="row-1">
					<div class="fleft"><a href="welcome-page.jsp">Мир <span>Кино</span></a></div>
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
						<li>
							<form action="/Movies" method="post">
								<input type="hidden" name="command" value="goto_home"/>
								<button type="submit" class="refbutton">Домой</button>
							</form>
						</li>
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
						<li><a class="active">О рейтингах</a></li>
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
				<div class="line-hor"></div>
				<div class="box">
					<div class="border-right">
						<div class="border-left">
							<div class="inner">
								<h3>Возрастные <span>рейтинги фильмов</span></h3>
								<br>Принятая в США система оценки содержания фильма, введённая Американской киноассоциацией. В зависимости от полученной оценки, зрительская аудитория картины может быть ограничена за счёт исключения из неё детей и подростков. Рейтинг Американской киноассоциации играет важную роль в прокатной судьбе фильма. Система введена в действие 1 ноября 1968 года и с некоторыми незначительными изменениями используется до сих пор.<br /> <br /> Для определения рейтинга MPAA для каждого конкретного фильма создается специальная комиссия, которая просматривает его. После просмотра и обсуждения происходит голосование, в ходе которого фильму присваивают его будущий рейтинг.
									Продюсерский состав и/или режиссёр кинокартины, в случае несогласия с решением комиссии, может подать апелляцию. В данном случае происходит создание повторной комиссии, состоящей из 14—18 человек. Комиссия повторно просматривает фильм, обсуждает несогласия создателей фильма, представленные в апелляции. Выявляются сцены, оказывающие определяющее влияние на рейтинг фильма, и вместе с официальным решением комиссии отправляются обратно создателям кинокартины. Далее создатели картины самостоятельно принимают решение — удалить эти сцены, переснять (перемонтировать) или согласиться с решением комиссии.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="content">
					<h3>Список <span>Рейтингов</span></h3>
					<ul class="list">
						<c:forEach var="elem" items="${rating_list}" varStatus="status">
						<li>
							<div id="rating-elem">
							<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Кодовое название:</span> <span style="font-size: 30px; font-weight: bold; color: #d72a18"><c:out value="${elem.filmRating}" /></span> <br />
							<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Общее название:</span> <span style="font-size: 16px;"><c:out value="${elem.name}" /></span> <br />
							<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Возрастное ограничение:</span> <span style="font-size: 20px; color: #d72a18"><c:out value="${elem.minAge}" />+</span> <br /><br/>
							<c:out value="${elem.article}"/>
							</div>
						</li>
						</c:forEach>
					</ul>
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