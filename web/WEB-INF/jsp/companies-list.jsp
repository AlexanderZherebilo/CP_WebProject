<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Список компаний</title>
	<link href="/css/Content/style.css" rel="stylesheet" type="text/css" />
	<link href="/css/Content/ie6.css" rel="stylesheet" type="text/css" />
</head>
<body id="page2">
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
						<li><a class="active">Компании</a></li>
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
				<div class="line-hor"></div>
				<div class="box">
					<div class="border-right">
						<div class="border-left">
							<div class="inner">
                                <h3><span>Кинокомпании</span></h3>
								<br>Кинопроизводство — процесс создания кинофильмов от первоначального замысла до непосредственного показа готового продукта аудитории в кинотеатрах, посредством телевидения или Интернета. Кинопроизводство существует во множестве стран и соприкасается с экономическими, социальными и политическими сферами жизнедеятельности. Как правило, кинопроизводство требует вовлечения большого количества людей, больших временных и материальных затрат. Ведущее место в производстве фильмов принадлежит художественным игровым фильмам, создание которых наиболее сложно и затратно.
                                Современное кинопроизводство. Съёмка комбинированного кадра в павильоне киностудии. В процессе задействованы роботизированный операторский кран и синий фон для съёмки по современной разновидности технологии блуждающей маски — Хромакей.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="content">
					<h3>Список <span>Кинокомпаний</span></h3>
					<ul class="list">
						<c:forEach var="elem" items="${companies_list}" varStatus="status">
							<li>
								<div id="company-elem">
                                    <img style="width: 35%; height: 25%; padding-left: 1%; padding-top: 2%" src="${elem.image}">
									<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Название:</span> <span style="font-size: 14px"><c:out value="${elem.name}" /></span> <br />
									<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Год основания:</span> <span style="font-size: 14px"><c:out value="${elem.year}" /></span> <br />
									<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Страна:</span> <span style="font-size: 14px"><c:out value="${elem.country}" /></span> <br />
									<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Основатели:</span> <span style="font-size: 14px"><c:out value="${elem.founderName} ${elem.founderSurname}" /></span> <br />
									<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Глава компании:</span> <span style="font-size: 14px"><c:out value="${elem.headName} ${elem.headSurname}" /></span> <br />
									<span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Веб-сайт:</span> <a href="http://www.${elem.site}"><span id="myref" style="font-size: 14px; color: dodgerblue; text-decoration: underline"><c:out value="${elem.site}" /></span></a> <br /><br />
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