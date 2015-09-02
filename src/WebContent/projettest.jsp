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
        
       
        
        
      <!--    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">-->
         <link rel="stylesheet" href="css/tabs.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
        
        
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
                            <span>Updates</span>
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
            
            <%@include file="./Menu.jsp" %>
        
            <!-- Content -->
            <section id="content" class="container">
            
                <!-- Messages Drawer -->
                <%@include file="./Message.jsp" %>
                
                <!-- Notification Drawer -->
                <%@include file="./Notification.jsp" %>
                
                <h4 class="page-title"><center>Espace de travail->Projet<c:out value="${sessionScope.idprojet}" /></center></h4>
               
          
                 <div id="tabs">
  <ul>
    <li><a href="#tabs-1"><span class="btn btn-sm">Exporter le projet</span></a></li>
    <li><a href="#tabs-2"><span class="btn btn-sm">Rapport</span></a></li>
    <li><a href="#tabs-3"><span class="btn btn-sm">Liste de fichiers</span></a></li>
   
  </ul>
  
  <!-- tab1 -->
  <div id="tabs-1"><div class="block-title">
  
                    
                    <h3 class="block-title">Telecharger</h3>
                    
                    <br><a href="#" download=""><input type="image" src="./img/zip.png" name="telecharger"  ></a>
                    
                    </div>
  
  
               
  </div>
  
  <!-- tab2 -->
  <div id="tabs-2"><div class="block-title">
  <h5>Rapport</h5><br>
                <a href="/Pcd2test/projet.jsp"><br>
                <img alt="Microsoft_Word_2013" src="./img/Logo_Microsoft_Word_2013.png"></a>
  </div></div>
  
  <!-- tab3 -->
  <div id="tabs-3">
  <h5>Fichiers</h5>
  
  
  
   <form  action="Fichier" method="get">
  
 
 <table class="table table-bordered table-hover tile">
                            <thead>
                                <tr>
                                    <th>Nom du fichier</th>
                                    <th>Date de modification</th>
                                    <th>Contributeur</th>
                                    <th>Visibilité</th>
                                    <th>Supprimer</th>
                                </tr>
 
 </thead>
                            <tbody>
 
 
 
 
  <c:forEach var="fichier" items="${ fichiers }">
  
  
  
  
   <tr>
       <td>
       
       <input type="submit" value="<c:out value="${ fichier.NOMFICHIER }" />" name="f<c:out value="${ fichier.IDFICHIER }" />" class="btn btn-xs btn-alt m-r-5" >
       
       </td>
       <td><c:out value="${ fichier.DATEMODIF }" /></td>
       <td><c:out value="${ fichier.ID_MEMBRE }" /></td>
       <td><div class="switch-on switch-animate" style=""><c:out value="${ fichier.VISIBILITÉ }" /><input type="checkbox" checked="checked"></div><div class="switch-on switch-animate" style="">Membres & encadreur<input type="checkbox"></div><div class="switch-on switch-animate" style="">Public<input type="checkbox"></div></td>
       <td><input type="submit" value="Supprimer" name="Sf<c:out value="${ fichier.IDFICHIER }" />" class="btn btn-sm" ></td>
   </tr>
   
  
   
  
  
  </c:forEach>
   </tbody>
   
  </table>
  
  </form>
  <div class="col-md-4 form-group">
  <form class="form-validation"  role="form" action="Projet" method="get">
  <input type="text" name="nvfichier"  placeholder="nom de fichier ici ..." class="input-sm validate[required] form-control"  >
  <input type="submit" value="Nouveau fichier" name="nouveaufichier" class="btn btn-sm">
   </form>
    
  
 
  
  
  
  </div>
  </div>
</div>                
                
        </div>        
                 
                    <br/><br/><br/>
                 
            </section>
        </section>
        
        <!-- Javascript Libraries -->
        <!-- jQuery -->
        <script src="js/jquery.min.js"></script> <!-- jQuery Library -->
        <script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->
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
        
        <script type="text/javascript">
            $(document).ready(function(){
                /* Tag Select */
                (function(){
                    /* Limited */
                    $(".tag-select-limited").chosen({
                        max_selected_options: 5
                    });
                    
                    /* Overflow */
                    $('.overflow').niceScroll();
                })();
                
                /* Input Masking - you can include your own way */
                (function(){
                    $('.mask-date').mask('00/00/0000');
                    $('.mask-time').mask('00:00:00');
                    $('.mask-date_time').mask('00/00/0000 00:00:00');
                    $('.mask-cep').mask('00000-000');
                    $('.mask-phone').mask('0000-0000');
                    $('.mask-phone_with_ddd').mask('(00) 0000-0000');
                    $('.mask-phone_us').mask('(000) 000-0000');
                    $('.mask-mixed').mask('AAA 000-S0S');
                    $('.mask-cpf').mask('000.000.000-00', {reverse: true});
                    $('.mask-money').mask('000.000.000.000.000,00', {reverse: true});
                    $('.mask-money2').mask("#.##0,00", {reverse: true, maxlength: false});
                    $('.mask-ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {translation: {'Z': {pattern: /[0-9]/, optional: true}}});
                    $('.mask-ip_address').mask('099.099.099.099');
                    $('.mask-percent').mask('##0,00%', {reverse: true});
                    $('.mask-credit_card').mask('0000 0000 0000 0000');
                })();
                
                /* Spinners */
                (function(){
                    //Basic
                    $('.spinner-1').spinedit();
                    
                    //Set Value
                    $('.spinner-2').spinedit('setValue', 100);
                    
                    //Set Minimum                    
                    $('.spinner-3').spinedit('setMinimum', -10);
                    
                    //Set Maximum                    
                    $('.spinner-4').spinedit('setMaxmum', 100);
                    
                    //Set Step
                    $('.spinner-5').spinedit('setStep', 10);
                    
                    //Set Number Of Decimals
                    $('.spinner-6').spinedit('setNumberOfDecimals', 2);
                })();
            });
        </script>
        <script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
        <script src="js/validation/validationEngine.min.js"></script> <!-- jQuery Form Validation Library - requirred with above js -->
        <script src="js/select.min.js"></script> <!-- Custom Select -->
        <script src="js/chosen.min.js"></script> <!-- Custom Multi Select -->
        <script src="js/datetimepicker.min.js"></script> <!-- Date & Time Picker -->
        <script src="js/colorpicker.min.js"></script> <!-- Color Picker -->
        <script src="js/icheck.js"></script> <!-- Custom Checkbox + Radio -->
        <script src="js/autosize.min.js"></script> <!-- Textare autosize -->
        <script src="js/toggler.min.js"></script> <!-- Toggler -->
        <script src="js/input-mask.min.js"></script> <!-- Input Mask -->
        <script src="js/spinner.min.js"></script> <!-- Spinner -->
        <script src="js/slider.min.js"></script> <!-- Input Slider -->
        <script src="js/fileupload.min.js"></script> <!-- File Upload -->
    </body>

<!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/profile-page.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:21:08 GMT -->
</html>
                