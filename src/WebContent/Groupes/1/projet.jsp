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
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/animate.min.css" rel="stylesheet">
        <link href="./css/font-awesome.min.css" rel="stylesheet">
        <link href="./css/form.css" rel="stylesheet">
        <link href="./css/calendar.css" rel="stylesheet">
        <link href="./css/style.css" rel="stylesheet">
        <link href="./css/icons.css" rel="stylesheet">
        <link href="./css/generics.css" rel="stylesheet"> 
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/form.css" rel="stylesheet">
        <link href="./css/style.css" rel="stylesheet">
        <link href="./css/animate.css" rel="stylesheet">
        <link href="./css/generics.css" rel="stylesheet">
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/animate.min.css" rel="stylesheet">
        <link href="./css/font-awesome.min.css" rel="stylesheet">
        <link href="./css/form.css" rel="stylesheet">
        <link href="./css/calendar.css" rel="stylesheet">
        <link href="./css/file-manager.css" rel="stylesheet">
        <link href="./css/style.css" rel="stylesheet">
        <link href="./css/icons.css" rel="stylesheet">
        <link href="./css/generics.css" rel="stylesheet"> 
         <link rel="stylesheet" href="http://www.firepad.io/examples/codemirror/lib/codemirror.css" />
  <link rel="stylesheet" href="./css/firepad.css" />
  <link rel="stylesheet" href="http://www.firepad.io/examples/firepad-userlist.css" />
  <link rel="stylesheet" href="./css/demo.css" />
  <link href="http://www.firepad.io/images/favicon.ico" rel="shortcut icon" />
   
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
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
                            <i class="n-count animated">5</i>
                            <span>Messages</span>
                        </a>
                    </div>
                    <div class="pull-left tm-icon">
                        <a data-drawer="notifications" class="drawer-toggle" href="#">
                            <i class="sa-top-updates"></i>
                            <i class="n-count animated">9</i>
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
            
            <%@include file="../../Menu.jsp" %>
        
            <!-- Content -->
            <section id="content" class="container">
            
                <!-- Messages Drawer -->
                <%@include file="../../Message.jsp" %>
                
                <!-- Notification Drawer -->
                <%@include file="../../Notification.jsp" %>






<h4 class="page-title">FILE MANAGER</h4>


                                
                <div id="fileManager"></div>
                
                
                
                   
                <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=413180765374622";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
  <div id="top">
    <div id="top-bg-tile">
      <div id="top-content">
        
        
        </div>
       <div id="firepad-container">
          <div id="firepad-userlist"></div>
          <div id="firepad"></div>
        </div></div></div>
        
        
       
  <script src="https://cdn.firebase.com/v0/firebase.js"></script>
  <script src="http://www.firepad.io/examples/codemirror/lib/codemirror.js"></script>
  <script src="http://www.firepad.io/examples/firepad.js"></script>
  <script src="js/firepad-userlist.js"></script>
  <script src="http://www.firepad.io/js/jquery-1.9.1.min.js"></script>
 <script type="text/javascript" src="js/demo.js"></script>
  
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-39969708-1']);
  _gaq.push(['_setDomainName', 'firepad.io']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>

<script type="text/javascript">
    function displayPads() {
      $('#my-pads-list').toggle();
    }
</script>
                
                
                
                
                
                
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
        <script src="js/feeds.min.js"></script> <!-- News Feeds -->
        <script src="js/file-manager/elfinder.min.js"></script> <!-- File Manager -->
        
        
        <!-- All JS functions -->
        <script src="js/functions.js"></script>
<!-- 
        <script type="text/javascript">
            $(document).ready(function() {
                 $('#fileManager').elfinder({
                      resizable: false,
                      url : 'https://intense-fire-2283.firebaseio.com/demo',  // connector URL (REQUIRED)
                      uiOptions : {
                      toolbar : [
                              ['back', 'forward', 'home', 'reload'],
                              ['mkdir', 'mkfile', 'upload'],
                              ['view', 'sort'],
                              ['search']
                      ]},
                      height: 500
                 });
                 
                 $('.elfinder-cwd-wrapper, .elfinder-navbar').niceScroll();
            });
        </script>-->
    </body>

<!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/file-manager.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:20:41 GMT -->
</html>
