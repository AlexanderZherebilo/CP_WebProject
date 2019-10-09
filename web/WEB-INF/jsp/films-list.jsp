<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
<title>Список фильмов</title>
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
						<li><a class="active">Фильмы</a></li>
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
			<div id="content">
				<div class="line-hor"></div>
				<div class="box">
					<div class="border-right">
						<div class="border-left">
							<div class="inner">
								<h3><span>Фильмы</span></h3>
								<br>Фильм (англ. film — плёнка), а также — кино, кинофильм, телефильм, кинокартина — отдельное произведение киноискусства. В технологическом плане фильм представляет собой совокупность движущихся изображений (монтажных кадров), связанных единым сюжетом. Каждый монтажный кадр состоит из последовательности фотографических или цифровых неподвижных изображений (кадриков), на которых зафиксированы отдельные фазы движения. Фильм, как правило, имеет звуковое сопровождение.
								В начале XX века в России принято было говорить «фи́льма» (в женском роде), и, кроме привычного нам значения, это слово относилось к киноплёнке.
								Область человеческой деятельности, связанная с созданием и воспроизведением фильмов, называется кинематографом. Кинематограф включает в себя область применения фильма как одного из направлений искусства (киноискусство), (кинотехнику), а также киноиндустрию. Фильмы создаются путём записи движущихся изображений окружающего мира с помощью киносъёмочных аппаратов или цифровых кинокамер, а также производятся из отдельных изображений с использованием мультипликации или спецэффектов.
								Просмотр фильмов является частью современной культуры. Герои популярных фильмов и актёры, их играющие, зачастую становятся знаменитыми, а их образы узнаваемыми. Специально для массового просмотра фильмов строят кинотеатры. Обычно продолжительность фильма составляет 90—120 минут (1,5—2 часа). В домашних условиях для просмотра фильмов традиционно используется телевизор с подключенным к нему видеопроигрывателем, в последнее время все чаще для этих целей служит персональный компьютер, смартфон и другие электронные устройства воспроизведения видео.</p>
							</div>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="border-right">
						<div class="border-left">
							<div class="inner">
								<h3><span>Поиск фильмов</span></h3>
								<br>
								<form action="/Movies" method="post">
									<input type="hidden" name="command" value="search_film">
									<div class="field"><label style="color: #80bdff; font-size: 16px">Выберите критерий поиска: </label>
										<select name="search_type" style="width: 200px; height: 20px">
											<option value="filmName">По названию</option>
											<option value="genreName">По жанру</option>
										</select></div>
                                    <br />
                                    <label style="color: #80bdff; font-size: 14px">Значение: </label><input type="text" name="criterion" value="">
									<br /><br />
									<button style="width: 160px; height: 40px; font-size: 14px; color: white; background-color: #1d1d1d"
											onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
											onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Поиск
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
                <ul style="float: right; align-content: center">
                <li style="display: inline">
                    <form action="/Movies" method="post">
                        <input type="hidden" name="command" value="sort">
                    <button style="width: 120px; height: 20px; font-size: 14px; color: white; background-color: #1d1d1d"
                            onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
                            onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">По возрастанию
                    </button>
                    </form>
                </li>
                    <br/>
                <li style="display: inline">
                    <form action="/Movies" method="post">
                        <input type="hidden" name="command" value="sort_desc">
                    <button style="width: 120px; height: 20px; font-size: 14px; color: white; background-color: #1d1d1d"
                            onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
                            onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">По убыванию
                    </button>
                    </form>
                </li>
                </ul>
                <br />
				<div class="content">
					<h3>Список <span>фильмов</span></h3>
					<ul class="list">
						<c:forEach var="elem" items="${films_list}" varStatus="status">
							<li>
								<form id="company-elem" action="/Movies" method="post">
									<input type="hidden" name="command" value="show_film_comments"/>
									<input type="hidden" name="film_name" value="${elem.name}"/>
									<img style="width: 55%; height: 50%; padding-left: 1%; padding-top: 3%" src="${elem.image}">
									<button style="width: 130px; height: 30px; float: right; font-size: 14px; color: white; background-color: #1d1d1d"
											onmouseover="this.style.cursor='pointer'; this.style.color='black'; this.style.backgroundColor='white'"
											onmouseout="this.style.backgroundColor='#1d1d1d'; this.style.color='white'" type="submit">Комментарии >>
									</button>
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
								</form>
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