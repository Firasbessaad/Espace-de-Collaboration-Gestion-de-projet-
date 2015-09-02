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
                            <span>Notifications</span>
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



<c:choose>
    <c:when test="${user == 'etudiant'}">
    <h1 class="page-title b-0"><center><strong> Allons-y ! </strong></center></h1>
<section id="login">

<form class="box tile animated active" id="box-projet" action="Projet" method="post">
               
                
                <!-- Selectionner un Projet -->
                
                <div class="select-container"> <!-- Hack to hide scrollbars -->
                <h3 class="block-title">Selectionner un Projet</h3>
                <c:forEach var="projet" items="${ projets }">
                <div class="block attrs">
                <div class="block-title">
                                <strong >Proposé par: </strong><br>
                                <img alt="<c:out value="${ projet.enseignant }" />" src="<c:out value="${ projet.photo_enseignant }" />" width="50" height="50">
                                <br><strong ><c:out value="${ projet.enseignant }" /></strong>
                            <br><input type="submit" value="<c:out value="${ projet.nom }" />" name="p<c:out value="${ projet.id }" />" class="btn btn-alt m-r-5"><br></div>
               </div>
                             </c:forEach>        
                </div>
                
                
               <!--   <div class="block-area" id="select">
                    <h3 class="block-title">Selectionner un Projet</h3>
                    
                    
                    <select class="form-control input-lg m-b-10">
                        <option>projet 1</option>
                        <option>projet 2</option>
                        <option>projet 3</option>
                    </select>
                </div>-->
                <br><c:choose><c:when test="${ projets.size()==1 }"><span  class="label label-warning"><c:out value="${ Message }"></c:out></span></c:when><c:otherwise><a class="box-switcher" data-switch="box-exgoupe" href="#"><span class="btn btn-sm">Construir un nouveau projet</span></a></c:otherwise></c:choose>
               
            </form>
            
      
            
            <!-- Choisir un Groupe -->
            <form class="box animated tile" id="box-exgoupe" action="Espace" method="Post">
                <c:choose>
    <c:when test="${ projets.size()==1 }">
      <img src="./img/appartientgroupe.gif" width="50" height="50" ><h5><c:out value="${ Message }"></c:out></h5><br> 
    </c:when> <c:otherwise>
                <div class="block-area" id="select">
                
                    <h3 class="block-title">Choisir un Groupe<c:out value="${ idgroupe }" /> </h3>
                    
                    
                    <select class="form-control input-lg m-b-10" name="groupe">
                    <c:forEach var="groupe" items="${ groupes }">
                       <option value="<c:out value="${ groupe.id }" />"><c:out value="${ groupe.id }" /></option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="valider" name="nvprojet" class="btn btn-sm"><br>
                </div>
                <h3 class="block-title">Nouveau Groupe?</h3><br>
                <small><a class="box-switcher" data-switch="box-nvgoupe" href="#">Construir un nouveau Groupe</a></small>
                <small><a class="box-switcher" data-switch="box-suggestion" href="#">Suggestion de Groupe</a></small>
             </c:otherwise></c:choose>
            </form>
            
            
            <!-- Suggestion de groupe -->
            
            <div class="box animated tile" id="box-suggestion" >
            <c:forEach var="sugesGroupe" items="${ sugesGroupes }">
            <form action="Espace" method="Post" >
             <div class="media">
                        
                        
                            <div class="block attrs">
                                
                                
                                <br><strong>Proposé par: <c:out value="${ sugesGroupe.idmember0}" /> <c:out value="${ titi }" /></strong>
                                <input type="submit" class="btn btn-sm" name="a<c:out value="${ sugesGroupe.id }" />" value="accepter">
        <input type="submit" class="btn btn-sm" name="r<c:out value="${ sugesGroupe.id }" />" value="Refuser">
                            </div>
                            
                        <div class="media-body">
                        <div class="block attrs">
                              
                            </div>
                       
                            
                            <div class="block attrs">
                               
                            </div>
                            
                            <div class="list-options">
                            
                            
                            
                            
                            
        
   
                            
                            
                                
                            </div>
                        </div>
                    </div><hr>
            
            </form></c:forEach>
            <br><c:choose>
    <c:when test="${ Message == 'Vous etes deja engagé' }">
      <img src="./img/appartientgroupe.gif" width="50" height="50" ><h5><c:out value="${ Message }"></c:out></h5><br> 
    </c:when>
    <c:otherwise>
    <c:out value="${ Message }"></c:out><br>
    <h3 class="block-title">Nouveau Groupe?</h3><br>
      <small><a class="box-switcher" data-switch="box-nvgoupe" href="#">Construir un nouveau Groupe</a></small>  
    </c:otherwise>
                            </c:choose>
            </div>
            
            
            
            
            
            
           <!-- nouveau groupe -->
           <form class="box animated tile" id="box-nvgoupe" action="Espace" method="Post">
            <c:choose>
    <c:when test="${ Message == 'Vous etes deja engagé' }">
      <img src="./img/appartientgroupe.gif" width="50" height="50" ><h5><c:out value="${ Message }"></c:out></h5><br> 
    </c:when> <c:otherwise>
     
   
                            
                    <h2 class="m-t-0 m-b-15">Choisir vos colleague</h2>
                
                    
                    <div class="input_fields_wrap">

    
    <div><input type="text" name="member0" value="<c:out value="${ login }" />"class="login-control m-b-10" placeholder="<c:out value="${ login }" />"></div><button class="ajt">Ajouter un autre membre</button>

                  </div>
                  <br><br>
                <input type="submit" value="valider" class="btn btn-sm" name="nvgroupe"><br>
                <a class="box-switcher" data-switch="box-exgoupe" href="#">Choisir un groupe existant</a>
                 <a class="box-switcher" data-switch="box-projet" href="#"><i class="icon left">&#61909;</i>Selectionner un Projet</a>
            </c:otherwise></c:choose>
             </form> 

 </section>    </c:when><c:otherwise><h1 class="page-title b-0"><center><strong> Allons-y ! </strong></center></h1>
 
 
 <div class="select-container"> <!-- Hack to hide scrollbars -->
                <center><h3 class="block-title">Selectionner un Projet</h3>
                <table class="table table-bordered table-hover tile">
                            <thead>
                                <tr>
                                    <th>Groupe 1</th>
                                    <th>Groupe 2</th>
                                    <th>Groupe 3</th>
                                    <th>Groupe 4</th>
                                    
                                </tr>
 
 </thead>
                            <tbody><tr>
                <c:forEach var="projet" items="${ projets }"><td>
                <div class="block attrs">
                
                <div class="block-title">
                                <strong >Groupe de  </strong><br>
                                 <img alt="<c:out value="${ projet.memeber0 }" />" src="<c:out value="${ projet.photomemeber0}" />" width="50" height="50">
                         <c:out value="${ projet.memeber0 }" /><br>
                         <img alt="<c:out value="${ projet.memeber1 }" />" src="<c:out value="${ projet.photomemeber1}" />" width="50" height="50">
                         <c:out value="${ projet.memeber1 }" /><br><c:choose>
    <c:when test="${projet.memeber2 != ''}">
                         <img alt="<c:out value="${ projet.memeber2 }" />" src="<c:out value="${ projet.photomemeber2}" />" width="50" height="50">
                         <c:out value="${ projet.memeber2 }" />
                         </c:when><c:otherwise></c:otherwise></c:choose> </div>
               </div>
               
               
               
               
                <div class="block attrs">
                        
                            
                                   
                                
                               
                      
                            </div>
               
               
               
                             </td></c:forEach></tr> </tbody></table> </center>      
                </div>
 
 
 
 
 
 
 
 
 
 </c:otherwise></c:choose>              
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
        <!--  Form Related -->
        <script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        <!-- All JS functions -->
        <script src="js/functions.js"></script>
         <script src="js/newfiled.js"></script>
    </body>

<!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/profile-page.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:21:08 GMT -->
</html>


