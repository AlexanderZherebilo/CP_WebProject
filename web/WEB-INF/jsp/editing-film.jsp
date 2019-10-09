<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Редактирование фильма</title>
	<link href="/css/Content/style.css" rel="stylesheet" type="text/css" />
	<link href="/css/Content/ie6.css" rel="stylesheet" type="text/css" />
</head>
<body id="page6">
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
								<h3>Редактирование <span>фильма</span></h3>
								<form id="contacts-form" action="/Movies" method="post">
                                    <input type="hidden" name="command" value="edit_film"/>
									<fieldset>
                                        <c:set var="elem" value="${film_edit}" scope="page"></c:set>
										<div class="field"><label>Название фильма:</label><input type="text" name="film_name" value="${elem.name}"/></div>
										<div class="field"><label>Жанр фильма:</label><input type="text" name="film_genre" value="${elem.genre}"/></div>
										<div class="field"><label>Кинокомпания:</label>
											<select name="company" style="width: 180px; height: 20px">
												<c:forEach var="elem1" items="${companies_list}" varStatus="status">
													<option value="${elem1.name}">${elem1.name}</option>
												</c:forEach>
											</select></div>
										<div class="field"><label>Имя режиссёра:</label><input type="text" name="director_name" value="${elem.directorName}"/></div>
										<div class="field"><label>Фамилия режиссёра:</label><input type="text" name="director_surname" value="${elem.directorSurname}"/></div>
										<div class="field"><label>Возрастной рейтинг:</label>
											<select name="rating" style="width: 100px; height: 20px">
												<c:forEach var="elem2" items="${rating_list}" varStatus="status">
													<option value="${elem2.filmRating}">${elem2.filmRating}</option>
												</c:forEach>
											</select></div>
                                        <div class="field"><label>Бюджет фильма, $:</label><input type="number" name="budget" value="${elem.budget}"/></div>
                                        <div class="field"><label>Кассовые сборы, $:</label><input type="number" name="box_office" value="${elem.boxOffice}"/></div>
                                        <div class="field"><label>Год выхода:</label><input type="number" name="film_year" value="${elem.year}"/></div><br />
                                        <div class="field"><label>Имя картинки: (расположенной по адресу "css/Content/images/Films/")</label><input type="text" name="film-image" value="${elem.image}"/></div>
                                        <div class="wrapper">
											<span style="color: red; text-align: center !important; font-size: 14px">${error}</span>
											<div class="field"><label>Описание фильма:</label><textarea name="article" cols="1" rows="1"></textarea></div>
											<button style="width: 130px; height: 30px; float: right; font-size: 14px; color: white; background-color: #1d1d1d"
													onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
													onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Сохранить
											</button>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
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