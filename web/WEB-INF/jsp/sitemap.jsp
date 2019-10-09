<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Навигация по сайту</title>
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
						<li class="last"><a class="active">Управление</a></li>
					</ul>
				</div>
			</div>
<!-- CONTENT -->
			<div id="content">
				<div class="line-hor"></div>
				<div class="box">
					<div class="border-right">
						<div class="border-left">
							<c:if test="${loggined eq 'Alex9'}">
							<div class="inner">
								<h3>Управление <span>фильмами</span></h3>
								<h4>Общее число фильмов - ${films_number}</h4>
								<ul>
									<li>
										<form action="/Movies" method="post">
											<input type="hidden" name="command" value="goto_adding_film"/>
										<button style="width: 150px; height: 30px; font-size: 14px; color: white; background-color: #1d1d1d"
												onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
												onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Добавить фильм
										</button>
										</form>
									</li>
									<li>
										<form action="/Movies" method="post">
											<input type="hidden" name="command" value="edit_selected_film"/>
									<br />
									<div class="field"><label style="color: #80bdff; font-size: 16px">Выберите фильм для редактирования:</label>
										<select name="film_select_update" style="width: 350px; height: 20px">
											<c:forEach var="elem" items="${films_list}" varStatus="status">
												<option value="${elem.id}">${elem.name}</option>
											</c:forEach>
										</select></div>
									<br />
										<button style="width: 150px; height: 30px; font-size: 14px; color: white; background-color: #1d1d1d"
												onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
												onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Редактировать фильм
										</button>
										</form>
									</li>
									<br />
									<li>
										<form action="/Movies" method="post">
											<input type="hidden" name="command" value="delete_selected_film"/>
											<div class="field"><label style="color: #80bdff; font-size: 16px">Выберите фильм для удаления:</label>
												<select name="film_select_delete" style="width: 350px; height: 20px">
													<c:forEach var="elem" items="${films_list}" varStatus="status">
														<option value="${elem.id}">${elem.name}</option>
													</c:forEach>
												</select></div>
											<br />
										<button style="width: 150px; height: 30px; font-size: 14px; color: white; background-color: #1d1d1d"
												onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
												onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Удалить фильм
										</button>
										</form>
										<span style="color: red; text-align: center !important; font-size: 14px">${delete_film_error}</span>
									</li>
								</ul>
							</div>
							<div class="inner">
								<h3>Управление <span>компаниями</span></h3>
								<h4>Общее число компаний - ${companies_number}</h4>
								<ul>
									<li>
										<form action="/Movies" method="post">
											<input type="hidden" name="command" value="goto_adding_company">
										<button style="width: 160px; height: 40px; font-size: 14px; color: white; background-color: #1d1d1d"
												onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
												onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Добавить компанию
										</button>
										</form>
									</li>
									<br />
									<li>
										<form action="/Movies" method="post">
											<input type="hidden" name="command" value="edit_selected_company">
									<div class="field"><label style="color: #80bdff; font-size: 16px">Выберите компанию для редактирования:</label>
										<select name="company_select_update" style="width: 200px; height: 20px">
											<c:forEach var="elem" items="${companies_list}" varStatus="status">
												<option value="${elem.id}">${elem.name}</option>
											</c:forEach>
										</select></div>
									<br />
										<button style="width: 160px; height: 40px; font-size: 14px; color: white; background-color: #1d1d1d"
												onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
												onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Редактировать компанию
										</button>
										</form>
									</li>
									<br />
									<li>
										<form action="/Movies" method="post">
											<input type="hidden" name="command" value="delete_selected_company">
											<div class="field"><label style="color: #80bdff; font-size: 16px">Выберите компанию для удаления:</label>
												<select name="company_select_delete" style="width: 200px; height: 20px">
													<c:forEach var="elem" items="${companies_list}" varStatus="status">
														<option value="${elem.id}">${elem.name}</option>
													</c:forEach>
												</select></div>
											<br />
										<button style="width: 160px; height: 40px; font-size: 14px; color: white; background-color: #1d1d1d"
												onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
												onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Удалить компанию
										</button>
										</form>
										<span style="color: red; text-align: center !important; font-size: 14px">${delete_company_error}</span>
									</li>
								</ul>
							</div>
							</c:if>
							<c:if test="${loggined != 'Alex9'}">
							<div class="inner" style="font-size: 20px; color: #d39e00">
								Этот раздел доступен только администратору - <span style="color: #d72a18">Alex9</span>
							</div>
							</c:if>
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