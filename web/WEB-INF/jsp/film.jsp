<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Комментарии к фильму</title>
	<link href="/css/Content/style.css" rel="stylesheet" type="text/css" />
	<link href="/css/Content/ie6.css" rel="stylesheet" type="text/css" />
</head>
<body id="page5">
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
			<div class="content">
				<div class="line-hor"></div>
				<div class="box">
					<div class="border-right">
						<div class="border-left">
							<div class="inner">
                                <c:set var="elem" value="${single_film}" scope="page"></c:set>
                                <img style="float: right; width: 30%; height: 24%; padding-right: 1%; padding-top: 1%" src="${elem.image}">
                                <span style="color: lightsteelblue; font-size: 25px; font-weight: bold;"><c:out value="${elem.name}" /></span><br /><br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Жанр:</span> <span style="font-size: 14px"><c:out value="${elem.genre}" /></span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Кинокомпания:</span> <span style="font-size: 14px"><c:out value="${elem.company.name}" /></span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Год выхода:</span> <span style="font-size: 14px"><c:out value="${elem.year}" /></span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Режиссёр:</span> <span style="font-size: 14px"><c:out value="${elem.directorName} ${elem.directorSurname}" /></span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Оценка:</span> <span style="font-size: 18px"><c:out value="${elem.rate}" />/10</span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Возрастной рейтинг:</span> <span style="font-size: 22px; color: #d72a18"><c:out value="${elem.filmRating}" /></span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Бюджет фильма:</span> <span style="font-size: 14px"><fmt:formatNumber value="${elem.budget}" /> $</span> <br />
                                <span style="color: white; font-size: 16px; font-weight: bold; text-decoration: underline;">Общие сборы:</span> <span style="font-size: 14px"><fmt:formatNumber value="${elem.boxOffice}" /> $</span> <br /><br />
                                <c:out value="${elem.article}"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- CONTENT -->
			<div id="content">
				<div class="content">
					<h3>Оставить <span>комментарий</span></h3>
					<form id="contacts-form" action="/Movies" method="post">
                        <input type="hidden" name="command" value="add_new_comment"/>
						<input type="hidden" name="film_id" value="${elem.id}"/>
						<input type="hidden" name="login_to_comment" value="${loggined}"/>
						<fieldset>
							<div class="field"><label>Ваша оценка фильму:</label><input class="range-style" type="range" list="tickmarks" name="rate" min="1" max="10" step="1" value="10"/></div>
							<datalist id="tickmarks">
								<option value="1" label="1">
								<option value="2" label="2">
								<option value="3" label="3">
								<option value="4" label="4">
								<option value="5" label="5">
								<option value="6" label="6">
								<option value="7" label="7">
								<option value="8" label="8">
								<option value="9" label="9">
								<option value="10" label="10">
							</datalist>
							<div class="field"><label>Комментарий:</label><textarea name="comment" cols="1" rows="1"></textarea></div>
							<div class="wrapper">
                                <button style="width: 130px; height: 30px; float: right; font-size: 14px; color: white; background-color: #1d1d1d"
                                        onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
                                        onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Отправить
                                </button>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
			<div class="content">
				<h3>Комментарии <span>(${comment_number})</span></h3>
				<ul class="list">
					<c:forEach var="elem" items="${comment_list}" varStatus="status">
						<li>
							<div id="comment-elem" style="border: slategrey solid 2px; margin: 1%; padding: 1%">
								<c:if test="${elem.user.loginUser eq loggined}">
									<form action="/Movies" method="post">
										<input type="hidden" name="command" value="delete_my_comment">
										<input type="hidden" name="film_id" value="${elem.film.id}"/>
										<input type="hidden" name="id_comment" value="${elem.id}">
									<button style="width: 90px; height: 30px; float: right; font-size: 14px; border-radius: 5px; color: white; background-color: #1d1d1d"
											onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
											onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Удалить
									</button>
									</form>
								</c:if>
								<span style="font-size: 20px; font-family: Arial; color: #57b846"><c:out value="${elem.user.loginUser}" /></span>  <fmt:formatDate value="${elem.date}" timeStyle="short"></fmt:formatDate> <br />
								<span style="font-size: 20px; color: #d72a18"><c:out value="${elem.rate}" />/10</span> <br /><br />
								<c:out value="${elem.article}"/><br />
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- FOOTER -->
			<br />
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