<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html><!--[if IE 9 ]><html class="ie9"><![endif]-->    <!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/profile-page.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:20:41 GMT --><head>        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />        <meta name="format-detection" content="telephone=no">        <meta charset="UTF-8">        <meta name="description" content="Violate Responsive Admin Template">        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">        <title>Bienvenu <c:out value="${ nom }" /></title>                    <!-- CSS -->        <link href="css/bootstrap.min.css" rel="stylesheet">        <link href="css/animate.min.css" rel="stylesheet">        <link href="css/font-awesome.min.css" rel="stylesheet">        <link href="css/form.css" rel="stylesheet">        <link href="css/calendar.css" rel="stylesheet">        <link href="css/style.css" rel="stylesheet">        <link href="css/icons.css" rel="stylesheet">        <link href="css/generics.css" rel="stylesheet">         <link href="css/bootstrap.min.css" rel="stylesheet">        <link href="css/form.css" rel="stylesheet">        <link href="css/style.css" rel="stylesheet">        <link href="css/animate.css" rel="stylesheet">        <link href="css/generics.css" rel="stylesheet">        <link href="css/bootstrap.min.css" rel="stylesheet">        <link href="css/animate.min.css" rel="stylesheet">        <link href="css/font-awesome.min.css" rel="stylesheet">        <link href="css/form.css" rel="stylesheet">        <link href="css/calendar.css" rel="stylesheet">        <link href="css/file-manager.css" rel="stylesheet">        <link href="css/style.css" rel="stylesheet">        <link href="css/icons.css" rel="stylesheet">        <link href="css/generics.css" rel="stylesheet">          <link rel="stylesheet" href="http://www.firepad.io/examples/codemirror/lib/codemirror.css" />  <link rel="stylesheet" href="css/firepad.css" />  <link rel="stylesheet" href="http://www.firepad.io/examples/firepad-userlist.css" />  <link rel="stylesheet" href="css/demo.css" />  <link href="http://www.firepad.io/images/favicon.ico" rel="shortcut icon" />   <script src="js/firepad-userlist.js"></script>  <link rel="stylesheet" href="css/firepad-userlist.css" />         <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  <script src="//code.jquery.com/jquery-1.10.2.js"></script>  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>  <link rel="stylesheet" href="/resources/demos/style.css">    <!-Firebase --><script src="https://cdn.firebase.com/js/client/2.0.2/firebase.js"></script><!-- CodeMirror and its JavaScript mode file --><script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/4.5.0/codemirror.js"></script><script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/4.5.0/mode/clike/clike.js"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/4.5.0/codemirror.css" /><!-- Firepad --><link rel="stylesheet" href="https://cdn.firebase.com/libs/firepad/1.1.0/firepad.css" /><script src="https://cdn.firebase.com/libs/firepad/1.1.0/firepad.min.js"></script><title>login.java</title><style>html { height: 100%; }body { margin: 0; height: 100%; position: relative; }/* Height / width / positioning can be customized for your use case. For demo purposes, we make firepad fill the entire browser. */#firepad-container {width: 100%;height: 100%;}</style>            </head>    <body id="skin-blur-violate">        <header id="header" class="media">            <a href="#" id="menu-toggle"></a>             <a class="logo pull-left" href="index-2.html">ENSI</a>                        <div class="media-body">                <div class="media" id="top-menu">                    <div class="pull-left tm-icon">                        <a data-drawer="messages" class="drawer-toggle" href="#">                            <i class="sa-top-message"></i>                            <i class="n-count animated">5</i>                            <span>Messages</span>                        </a>                    </div>                    <div class="pull-left tm-icon">                        <a data-drawer="notifications" class="drawer-toggle" href="#">                            <i class="sa-top-updates"></i>                            <i class="n-count animated"><c:out value="${notifications.size() }"></c:out></i>                            <span>Notifications</span>                        </a>                    </div>                                        <div id="weather" class="animated pull-right"></div>                    <div id="time" class="pull-right">                        <span id="hours"></span>                        :                        <span id="min"></span>                        :                        <span id="sec"></span>                    </div>                    <div class="media-body">                        <input type="text" class="main-search">                    </div>                </div>            </div>        </header>                <div class="clearfix"></div>                <section id="main" class="p-relative" role="main">                        <%@include file="../../Menu.jsp" %>                    <!-- Content -->            <section id="content" class="container">                            <!-- Messages Drawer -->                <%@include file="../../Message.jsp" %>                                <!-- Notification Drawer -->                <%@include file="../../Notification.jsp" %><h4 class="page-title">FILE MANAGER</h4>               <div id="firepad-container"><form action=""><input type="submit" value="Sauvgarder" name="Sauvgarder" class="btn btn-sm" style="margin-left: 25px; margin-top: 25px; margin-right: 15px; width:115px;"><br><input type="submit" value="Charger" name="Charger" class="btn btn-sm"style="margin-left: 25px; margin-top: 25px; margin-right: 15px; width:115px;" ></form></div><script>function init() { var firepadRef = new Firebase('https://intense-fire-2283.firebaseio.com/compte/p21/login');var codeMirror = CodeMirror(document.getElementById('firepad-container'), {lineNumbers: true,mode: 'java'}); var firepad = Firepad.fromCodeMirror(firepadRef, codeMirror, { defaultText: 'Commencer votre code en java'});}/* Helper to get hash from end of URL or generate a random one. */function getExampleRef() {var ref = new Firebase('https://firepad.firebaseio-demo.com');var hash = window.location.hash.replace(/#/g, '');if (hash) {ref = ref.child(hash);} else {ref = ref.push(); window.location = window.location + '#' + ref.key(); }if (typeof console !== 'undefined')console.log('Firebase data: ', ref.toString());return ref;}init(); </script>                                                            </section>        </section>                <!-- Javascript Libraries -->        <!-- jQuery -->        <script src="js/jquery.min.js"></script> <!-- jQuery Library -->        <script src="js/jquery-ui.min.js"></script> <!-- jQuery UI -->                <!-- Bootstrap -->        <script src="js/bootstrap.min.js"></script>                          <!-- UX -->        <script src="js/scroll.min.js"></script> <!-- Custom Scrollbar -->                <!-- Other -->        <script src="js/calendar.min.js"></script> <!-- Calendar -->        <script src="js/feeds.min.js"></script> <!-- News Feeds -->        <script src="js/file-manager/elfinder.min.js"></script> <!-- File Manager -->                        <!-- All JS functions -->        <script src="js/functions.js"></script><!--         <script type="text/javascript">            $(document).ready(function() {                 $('#fileManager').elfinder({                      resizable: false,                      url : 'https://intense-fire-2283.firebaseio.com/demo',  // connector URL (REQUIRED)                      uiOptions : {                      toolbar : [                              ['back', 'forward', 'home', 'reload'],                              ['mkdir', 'mkfile', 'upload'],                              ['view', 'sort'],                              ['search']                      ]},                      height: 500                 });                                  $('.elfinder-cwd-wrapper, .elfinder-navbar').niceScroll();            });        </script>-->    </body><!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/file-manager.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:20:41 GMT --></html>