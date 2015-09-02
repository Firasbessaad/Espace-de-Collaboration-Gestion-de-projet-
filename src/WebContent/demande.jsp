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
                
                <h4 class="page-title"><center>Accueil <c:out value="${sessionScope.idgroupe}" /></center></h4>
                 
                <div class="block-area">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="tile-light p-5 m-b-15">
                                <div class="cover p-relative">
                                    <img src="img/ensi.jpg" class="w-100" alt="">
                                    <img class="profile-pic" src=".<c:out value="${ photo }" />" alt="">
                                    <div class="profile-btn">
                                        <button class="btn btn-alt btn-sm"><i class="icon-bubble"></i> <span>Message</span></button>
                                        <button class="btn btn-alt btn-sm"><i class="icon-user-2"></i> <span>Friend</span></button>
                                    </div>
                                </div>
                                <div class="p-5 m-t-15"><!--about me-->
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eget risus rhoncus, cursus purus vitae, venenatis eros. Phasellus at tincidunt risus. Integer sed massa fermentum, feugiat arcu quis, ultrices nisi. Quisque commodo nisi scelerisque, tempus diam ac, dignissim tellus. Mauris adipiscing elit tortor, dignissim auctor diam mollis sed. Nulla eu dui non velit accumsan scelerisque eget et felis.
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
<h1 class="page-title b-0"><center><strong> Liste des etudiant demandant un encadrement </strong></center></h1>
                
                <div class="listview list-container">
                    <header class="listview-header media">
                        <input type="checkbox" class="pull-left list-parent-check" value="">
                            
                        <ul class="list-inline pull-right m-t-5 m-b-0">
                            <li class="pagin-value hidden-xs">35-70</li>
                            <li>
                                <a href="#" title="Previous" class="tooltips">
                                    <i class="sa-list-back"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="Next" class="tooltips">
                                    <i class="sa-list-forwad"></i>
                                </a>
                            </li>
                        </ul>
                        
                        <ul class="list-inline list-mass-actions pull-left">
                            
                            <li>
                                <a href="#" title="Refresh" class="tooltips">
                                    <i class="sa-list-refresh"></i>
                                </a>
                            </li>
                            <li class="show-on" style="display: none;">
                                <a href="#" title="Move" class="tooltips">
                                    <i class="sa-list-move"></i>
                                </a>
                            </li>
                            <li class="show-on" style="display: none;">
                                <a href="#" title="Delete" class="tooltips">
                                    <i class="sa-list-delete"></i>
                                </a>
                            </li>
                        </ul>

                        <input class="input-sm col-md-4 pull-right message-search" type="text" placeholder="Search....">
                        
                        <div class="clearfix"></div>
                    </header>
            <center> <form action="Demande" method="get">
        <div class="block-title">     <label class="block-title">Nouvelle proposition:</label>
             <textarea name="proposition" Class="form-control overflow" rows="4" cols="120" placeholder="This is a default Textarea..." tabindex="5003" style="overflow: hidden; outline: none;"></textarea>
             <br><label class="block-title">Type de proposition</label><select class="form-control input-lg m-b-10" name="typeProposition">
             <option value="pcd">Projet de Conception et developpement</option>
             <option value="pdt">Projet d'été</option>
             </select>
             
             
             <div class="col-md-4 m-b-15">
                            <p>Nombre de groupe </p>
                         
                        
                                <input type="text" name="nbg" class="form-control input-sm spinner-1 spinedit noSelect">
                        <br><input type="submit" value="Soumettre" name="soumettre" class="btn btn-sm">
                        </div>
                        
             
              
             </div>
           
             
             
             </form></center><hr>
                   <c:forEach var="demande" items="${ demandes }">
        <form action="${pageContext.request.contextPath}/Demande" method="post">                     
                    <div class="media">
                        <input type="checkbox" class="pull-left list-check" value="">
                        
                            <div class="block attrs">
                        
                            
                                   
                                <br><strong><c:out value="${ demande.nom }" /></strong><br>
                               
                    <img alt="<c:out value="${ demande.memeber0 }" />" src="<c:out value="${ demande.photomemeber0}" />" width="50" height="50">
                         <c:out value="${ demande.memeber0 }" /><br>
                         <img alt="<c:out value="${ demande.memeber1 }" />" src="<c:out value="${ demande.photomemeber1}" />" width="50" height="50">
                         <c:out value="${ demande.memeber1 }" /><br><c:choose>
    <c:when test="${demande.memeber2 != ''}">
                         <img alt="<c:out value="${ demande.memeber2 }" />" src="<c:out value="${ demande.photomemeber2}" />" width="50" height="50">
                         <c:out value="${ demande.memeber2 }" />
                         </c:when><c:otherwise></c:otherwise></c:choose>     
                            </div>
                            
                        <div class="media-body">
                        
                            
                            
                            <br><br><br>
                            <div class="list-options">
                            
                   <input type="submit" class="btn btn-sm" name="<c:out value="${ demande.id }" />" value="Accepter">
                   <input type="submit" class="btn btn-sm" name="<c:out value="${ demande.id }" />" value="Refuser">       
                            
                            
                      
                            </div>
                        </div>
                    </div><hr>
                    </form></c:forEach>
                    
                    
                    
                    
                    
                    
                    <div class="media text-center">
                        <ul class="pagination">
                            <li><a href="#"><i class="fa fa-angle-left"></i></a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            
                            <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                        </ul>
                    </div>
                </div>
                    
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
