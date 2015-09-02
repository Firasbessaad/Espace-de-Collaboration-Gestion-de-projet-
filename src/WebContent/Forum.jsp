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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/form.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
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
                            <i class="n-count animated"><c:out value="${notifications.size() }"></c:out></i>
                            <span>Notification</span>
                        </a>
                    </div>
                    
                   

                    <div class="media-body">
                        <input type="text" class="main-search">
                    </div>
                </div>
            </div>
        </header>
        
        
        <section id="main" class="p-relative" role="main">
            
            <%@include file="./Menu.jsp" %>
        
            <!-- Content -->
            <section id="content" class="container">
            
                <!-- Messages Drawer -->
                <%@include file="./Message.jsp" %>
                
                <!-- Notification Drawer -->
                <%@include file="./Notification.jsp" %>

        
             
        <div class="listview list-container">
                    <div class="media">
                       <center> <h3>Sujet</h3>
                        <div class="pull-left tm-icon">
                        <a data-drawer="taches" class="drawer-toggle" href="#">
                     <i><img src="./img/question.png" width="150" height="50" >
                     <span><strong>Nouveau Sujet</strong></span></i>
                        </a>
                    </div></center>
                        
            <form id="box-reset" class="box-switcher" data-switch="box-login" style="position: absolute;left: 950px;">
                <button class="btn btn-sm m-r-5">Nouveau Sujet</button>
            </form>
           <section id="login">
            <form class="box tile animated" id="box-login" style="position: absolute;left: 250px;top:0px;" action="InserSubject" method="post">
                <h2 class="m-t-0 m-b-15">Ajouter Sujet</h2>
                
                <textarea name="conten" style="height: 200px" type="text" class="login-control m-b-10" placeholder="Ecrire le texte ici..."></textarea>
                <button class="btn btn-sm m-r-5" name="addsujet">Publier</button>
            </form> 
        </section>
                    <img class="media-object pull-left" src="img/profile-pics/1.jpg" alt="" width="45">Non valide<br>
                    <textarea class="form-control overflow" rows="6" placeholder="This is a default Textarea..."></textarea>
                    <form action="forum" method="GET"> 
                        <button class="btn btn-sm m-r-5" name="val">Valider</button>
                    </form>
                    <br><br>
                    <h3>Reponses</h3>
                    </div>
                    <br>
                                          <%int i=0;
            while(request.getAttribute("com"+i)!=null){%>
            <div class="media">
                        <img class="media-object pull-left" src="img/profile-pics/5.jpg" alt="" width="45">
                        <div class="media-body">
            <%String comm = (String) request.getAttribute("com"+i);
            out.println(comm);
            i++;
            %>
                        </div>
                    </div><%}%>
                    <div class="media">
                    <form action="forum" method="GET"> 
                        <textarea class="form-control overflow" rows="3" placeholder="Ajouter un commentaire..." name="newcom"></textarea>    
                        <button class="btn btn-sm m-r-5" name="addcom">Ajouter</button>
                    </form>
                    </div>
                </div>
                
            </section>
        </section>
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script> <!-- jQuery Library -->
        
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        
        <!--  Form Related -->
        <script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        
        <!-- UX -->
        <script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->
        
        <!-- Other -->
        <script src="js/calendar.min.js"></script> <!-- Calendar -->
        <script src="js/feeds.min.js"></script> <!-- News Feeds -->
        
        
        <!-- All JS functions -->
        <script src="js/functions.js"></script>
    </body>
</html>

