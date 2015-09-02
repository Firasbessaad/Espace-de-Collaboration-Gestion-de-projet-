<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
    
<!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/profile-page.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:20:41 GMT -->
<head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">

        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">

        <title>Bienvenu <c:out value="${ nom }" /></title>
            
        <!-- CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/form.css" rel="stylesheet">
        <link href="css/calendar.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/icons.css" rel="stylesheet">
        <link href="css/generics.css" rel="stylesheet"> 
    </head>
    <body id="skin-blur-violate">
        <header id="header" class="media">
            <a href="#" id="menu-toggle"></a> 
            <a class="logo pull-left" href="index-2.html">ENSI</a>
            
            <div class="media-body">
                <div class="media" id="top-menu">
                    <div class="pull-left tm-icon">
                        <a data-drawer="messages" class="drawer-toggle" href="#">
                            <i class="sa-top-message"></i>
                            <i class="n-count animated">0</i>
                            <span>Messages</span>
                        </a>
                    </div>
                    <div class="pull-left tm-icon">
                        <a data-drawer="notifications" class="drawer-toggle" href="#">
                            <i class="sa-top-updates"></i>
                            <i class="n-count animated"><c:out value="${notifications.size() }"></c:out> </i>
                            <span>Notification</span>
                        </a>
                    </div>
                    
                    <div id="weather" class="animated pull-right"></div>

                    

                    <div class="media-body">
                        <input type="text" class="main-search">
                    </div>
                </div>
            </div>
        </header>
        
        <div class="clearfix"></div>
        
        <section id="main" class="p-relative" role="main">
            
           <c:choose>
    <c:when test="${user == 'etudiant'}">
            <%@include file="./Menu.jsp" %>
            </c:when><c:otherwise> <%@include file="./Menu_enseignant.jsp" %></c:otherwise></c:choose>
      
        
            <!-- Content -->
            <section id="content" class="container">
            
                <!-- Messages Drawer -->
                <%@include file="./Message.jsp" %>
                
                <!-- Notification Drawer -->
                <%@include file="./Notification.jsp" %>
                
                <h4 class="page-title"><center>Profil de  <c:out value="${nom}" /></center></h4>
                 
                <div class="block-area">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="tile-light p-5 m-b-15">
                                <div class="cover p-relative">
                                    <img src="img/cover-bg.jpg" class="w-100" alt="">
                                    <img class="profile-pic" src=".<c:out value="${ photo }" />" alt="">
                                    <div class="profile-btn">
                                        <button class="btn btn-alt btn-sm"><i class="icon-bubble"></i> <span>Message</span></button>
                                        <button class="btn btn-alt btn-sm"><i class="icon-user-2"></i> <span>Friend</span></button>
                                    </div>
                                </div>
                                <div class="p-5 m-t-15"><!--about me-->
                                   L'école délivre le diplôme national d'ingénieur en informatique au bout de trois ans aux élèves ingénieurs recrutés après une classe préparatoire. La formation inclut 2 700 heures dont des cours intégrés, des travaux pratiques, des projets et des stages. La formation inclut particulièrement les mathématiques appliquées, l'électronique, les systèmes informatiques et d'informations, les réseaux informatiques, l'architecture, la programmation ainsi que les langues, les sciences de gestion et le droit.

Les ingénieurs en informatique sont formés d'abord en tronc commun de trois semestres puis avec options pendant deux semestres.
Un stage obligatoire de quatre mois fait office de projet de fin d'études d'ingénieur et sanctionne la formation. La formation inclut deux autres stages obligatoires (deux fois six semaines).

                                   
                                </div>
                            </div>
                            
                            <div class="m-b-15 text-center profile-summary">
                                <button class="btn btn-sm">42 Followers</button>
                                <button class="btn btn-sm">69 Followings</button>
                                <button class="btn btn-sm hidden-xs">120 Comments</button>
                                <button class="btn btn-sm hidden-xs">165 Likes</button>
                            </div>
                            
                            
                            </div>
                        </div>
                    </div>
<h1 class="page-title b-0"><center><strong> Bienvenu  </strong></center></h1>
                
           
                    
                    <br/><br/><br/>
                 
            </section>
        </section>
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script> <!-- jQuery Library -->
        
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        
        <!-- UX -->
        <script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->
        
        <!-- Other -->
        <script src="js/calendar.min.js"></script> <!-- Calendar -->
        <script src="js/weather.min.html"></script> <!-- Weather -->
        <script src="js/feeds.min.js"></script> <!-- News Feeds -->
        
        <!-- All JS functions -->
        <script src="js/functions.js"></script>
    </body>

<!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/profile-page.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:21:08 GMT -->
</html>
