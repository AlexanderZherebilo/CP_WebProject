<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Редактирование компании</title>
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
								<h3>Редактирование <span>компании</span></h3>
								<form id="contacts-form" action="/Movies" method="post">
                                    <input type="hidden" name="command" value="edit_company"/>
									<fieldset>
										<c:set var="elem" value="${company_edit}" scope="page"></c:set>
										<div class="field"><label>Название компании:</label><input type="text" name="company_name" value="${elem.name}"/></div>
										<div class="field"><label>Год основания:</label><input type="number" name="founding_year" value="${elem.year}"/></div>
										<div class="field"><label>Страна:</label><input type="text" name="company_country" value="${elem.country}"/></div>
										<div class="field"><label>Имя основателя:</label><input type="text" name="founder_name" value="${elem.founderName}"/></div>
										<div class="field"><label>Фамилия основателя:</label><input type="text" name="founder_surname" value="${elem.founderSurname}"/></div>
										<div class="field"><label>Имя главы компании:</label><input type="text" name="head_name" value="${elem.headName}"/></div>
										<div class="field"><label>Фамилия главы компании:</label><input type="text" name="head_surname" value="${elem.headSurname}"/></div>
										<div class="field"><label>Веб-сайт (после "www."):</label><input type="text" name="site" value="${elem.site}"/></div>
                                        <div class="field"><label>Имя картинки: (расположенной по адресу "css/Content/images/Companies/")</label><input type="text" name="company-image" value="${elem.image}"/></div>
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