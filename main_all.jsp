<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- YL CSS -->
   <link href="http://localhost/jsp_prj/common/css/yl_main.css" rel="stylesheet" >
   <!-- 학원 CSS -->
   <link rel="stylesheet" type ="text/css" href ="http://211.63.89.153/html_prj/common/css/main.css"/>  
   <!-- 메인슬라이드광고 CSS -->
   <link rel="stylesheet" href="http://localhost/jsp_prj/common/css/slider.css">
 <!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

    <title>상하의STREET</title>
    <script type="text/javascript">

</script>
<style>
.header{
	z-index: 1;
}
.title{
	margin-top : 20px;
	z-index: 1;
}
.best_title {
	display: flex;
	justify-content: center;
	align-items: center;
	margin: auto;
	font-size: 60px;
}
.best_imgs{
	display: flex;
	justify-content: center;
	margin: 10px;
}
.best_imgs2{
	display: flex;
	justify-content: center;
	margin: 10px;
}

.item {
	margin: 10px;
	width: 300px;
	height: 300px;
	border: 2px solid #dfdfdf;
	background-color: #dfdfdf;
	font-size: 30px;
	
	display: flex;
	justify-content: center;
	
}

.slider{
	z-index: 0;
    width: 1200px;
    height: 600px;
    position: relative;
    margin: 0 auto;
    margin-top: 5px;
    border: 2px solid #dfdfdf;
    background-color: #dfdfdf;
}
</style>
</head>

<body>
	<!-- header start -->
    <header class="header">
        <div class="main_nav">
            <div>
                <h1 class="title"><a href="#"><img src="http://localhost/jsp_prj/common/images/상하의스트릿.png"></a></h1>
                <ul class="navigation">
                    <a href="http://localhost/jsp_prj/prj2/guest_prod.jsp" style="color: black"><li>TOP</li></a>
                    <a href="http://localhost/jsp_prj/prj2/guest_prod.jsp" style="color: black"><li>BOTTOM</li></a>
                    <a href="http://localhost/jsp_prj/prj2/lookbook_main.jsp" style="color: black"><li>LOOKBOOK</li></a>
                    <a href="" style="color: black"><li>MYPAGE</li></a>
                </ul>
            </div>
            <ul class="icons">
                <li>
                    <p>login</p>
                    <a href="">
                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                        viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
                            <path d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148
                                C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962
                                c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216
                                h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40
                                c59.551,0,108,48.448,108,108S315.551,256,256,256z"/>
                    </svg>
                    </a>
                </li>
                <li>
                    <p>cart</p>
                    <a href="">
                    <svg id="Capa_1" enable-background="new 0 0 512 512" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
                        <path d="m472 452c0 11.046-8.954 20-20 20h-20v20c0 11.046-8.954 20-20 20s-20-8.954-20-20v-20h-20c-11.046 
                        0-20-8.954-20-20s8.954-20 20-20h20v-20c0-11.046 8.954-20 20-20s20 8.954 20 20v20h20c11.046 0 20 8.954 20 20zm0-312v192c0 
                        11.046-8.954 20-20 20s-20-8.954-20-20v-172h-40v60c0 11.046-8.954 20-20 20s-20-8.954-20-20v-60h-192v60c0 11.046-8.954 20-20 
                        20s-20-8.954-20-20v-60h-40v312h212c11.046 0 20 8.954 20 20s-8.954 20-20 20h-232c-11.046 0-20-8.954-20-20v-352c0-11.046 8.954-20 
                        20-20h60.946c7.945-67.477 65.477-120 135.054-120s127.109 52.523 135.054 120h60.946c11.046 0 20 8.954 20 20zm-121.341-20c-7.64-45.345-47.176-80-94.659-80s-87.019 34.655-94.659 80z"/>
                        </svg>
                        </a>
                </li>
            </ul>
        </div>
    </header>
    <!-- header end -->
    <section>
    <!-- container start -->
        <div class="container">
        <!-- slider start -->
		        <div class="slider">
		    <input type="radio" name="slide" id="slide1" checked>
		    <input type="radio" name="slide" id="slide2">
		    <input type="radio" name="slide" id="slide3">
		    <input type="radio" name="slide" id="slide4">
		    <ul id="imgholder" class="imgs">
		        <li><img src="http://localhost/jsp_prj/common/images/2.jpg"></li>
		        <li><img src="http://localhost/jsp_prj/common/images/3.jpg"></li>
		        <li><img src="http://localhost/jsp_prj/common/images/4.jpg"></li>
		        <li><img src="http://localhost/jsp_prj/common/images/5.jpg"></li>
		    </ul>
		    <div class="bullets">
		        <label for="slide1">&nbsp;</label>
		        <label for="slide2">&nbsp;</label>
		        <label for="slide3">&nbsp;</label>
		        <label for="slide4">&nbsp;</label>
		    </div>
		</div>
        <!-- slider end -->
        <!-- bestitem start -->
				<div class="main_bestitem">
				<h1 class="best_title">BEST ITEM</h1>
				<div class= "best_imgs">
					<div class="item">1</div>
					<div class="item">2</div>
					<div class="item">3</div>
					<div class="item">4</div>
				</div> 
				<div class= "best_imgs2">
					<div class="item">5</div>
					<div class="item">6</div>
					<div class="item">7</div>
					<div class="item">8</div>
				</div> 
       	 </div>
        </div>
        <!-- bestitem end -->
    </section>
    <!-- container end -->
    <!-- footer start -->
    <footer>
        <div class="footer-wrap">
            <div class="footer-content">
                <h2>ABOUT SANGHAUI</h2>
                <p>
                    상하의스트릿 공식 온라인스토어는 ㈜쌍용교육센터의 콘텐츠를 위임받아 운영하고 있습니다. <br/>
                    상하의스트릿 공식 온라인 스토어에서 사용하는 인증 마크를 훼손 또는 무단복제하여 사용할 수 없으며, <br/>
                    해당 콘텐츠의 소유권은 SANGHAUI STREET ㈜쌍용교육센터에 있습니다.<br/>
					Copyright © sanghaui street. All rights reserved.
                </p>
            </div>
            <div class="footer-content">
                <h2>CS CENTER</h2>
                <ul>
                    <li>업무시간 10:00 - 17:00</li>
                    <li>점심시간 12:00 - 13:00</li>
                    <li>휴무 토요일,일요일,공휴일</li>
                    <li>현금 등으로 결제시 저희 쇼핑몰이 가입한</li>
                    <li>PG에스크로 구매안전 서비스를 이용하실 수 있습니다</li>
                </ul>
            </div>
            <div class="footer-content">
                <h2>OUR COMPANY</h2>
                <ul>
                    <li>회사명 : (주)쌍용교육센터</li>
                    <li>사업자등록번호 : 2148529296</li>
                    <li>통신판매업 신고 : 제 2021-서울쌍용-3333호</li>
                    <li>주소 : 서울특별시 강남구 테헤란로 132(역삼동) </li>
                    <li>한독약품빌딩 8층 쌍용교육센터</li>
                </ul>
            </div>
        </div>
    </footer>
    <!-- footer end -->
</body>
</html>