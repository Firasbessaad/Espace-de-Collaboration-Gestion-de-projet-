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
            
            <%@include file="./Menu.jsp" %>
        
            <!-- Content -->
            <section id="content" class="container">
            
                <!-- Messages Drawer -->
                <%@include file="./Message.jsp" %>
                
                <!-- Notification Drawer -->
                <%@include file="./Notification.jsp" %>





<h1 class="page-title b-0"><center><strong> Calendrier </strong><div class="pull-left tm-icon">
                        <a data-drawer="taches" class="drawer-toggle" href="#">
                     <i><img src="./img/icon128.png" width="50" height="50" >
                     <span><strong>Voir taches</strong></span></i>
                        </a>
                    </div>
                    <div class="pull-left tm-icon">
                        <a data-drawer="statistique" class="drawer-toggle" href="#">
                     <i><img src="./img/statistiques.png" width="50" height="50" >
                     <span><strong>Voir les statistiques</strong></span></i>
                        </a>
                    </div>
                    </center></h1>
<div class="block-area">
<div id="statistique" class="tile drawer animated">
<!--  <div class="col-md-4">
                            
                            <div class="tile">
                                <h2 class="tile-title">Server Process</h2>
                                <div class="tile-config dropdown">
                                    <a data-toggle="dropdown" href="#" class="tile-menu"></a>
                                    <ul class="dropdown-menu pull-right text-right">
                                        <li><a href="#">Refresh</a></li>
                                        <li><a href="#">Settings</a></li>
                                    </ul>
                                </div>

                                <div class="p-t-10 p-r-5 p-b-5">
                                    <div id="dynamic-chart" style="height: 200px; padding: 0px; position: relative;"><canvas id="tuto" width="500" height="100" style="border: 1px solid;"></canvas>
    <script language="javascript">
      var canvas = document.getElementById('tuto');
      var ctx = canvas.getContext('2d');
      
      ctx.beginPath();
      ctx.moveTo(0, 20);
      ctx.bezierCurveTo(canvas.width/3, 10*canvas.height, canvas.width/3, 0, canvas.width, 20);
      ctx.stroke();
    </script></div>
                                </div>

                            </div>
                            
                            
                               
                        <br><br>
                        
                        </div>--></div>

                    <div id="taches" class="tile drawer animated">
                    <div class="listview narrow">
                        <div class="media">
                            <center> <a href="#">Taches</a></center>
                            <span class="drawer-close">×</span>
                        </div>
                         <div class="overflow" style="height: 254px; overflow: hidden; outline: none;" tabindex="5002">
                            <div class="media">
      <table class="table table-bordered table-hover tile">
                            <thead>
                                <tr>
                                    <th>Nom du tache</th>
                                    <th>Date de debut</th>
                                    <th>Date de fin</th>
                                    <th>Marquer finie</th>
                                    
                                </tr>
 
 </thead>
                            <tbody>   
                             <c:forEach items="${taches}" var="item">
                            <tr>
                             
                            <c:choose>
    <c:when test="${item.finie}"></c:when><c:otherwise><c:choose><c:when test="${item.ID_member==login}">
       <td><c:out value="${ item.titre }" /></td>
       <td><c:out value="${ item.debut.annee }" />/<c:out value="${item.debut.mois}" />/<c:out value="${item.debut.jour}" /></td>
        <td><c:out value="${item.fin.annee}"/>/<c:out value="${item.fin.mois}" />/<c:out value="${item.fin.jour}" /></td>
        <td><form action="Calendrier" method="get"><center><input type="submit" name="<c:out value="${ item.id }" />" value="finie" class="btn btn-info btn-sm"></center></form></td>
        <td></td></c:when></c:choose></c:otherwise></c:choose>
        </tr>
   
  
   
  
  
  </c:forEach>
   </tbody>
  </table></div> </div></div></div>     
                </div>
                
                <div class="col-md-8 clearfix">
                    
                    <div id="calendar" class="p-relative p-10 m-b-20">
                        <!-- Calendar Views -->
                        <ul class="calendar-actions list-inline clearfix">
                            <li class="p-r-0">
                                <a data-view="month" href="#" class="tooltips" title="Month">
                                    <i class="sa-list-month"></i>
                                </a>
                            </li>
                            <li class="p-r-0">
                                <a data-view="agendaWeek" href="#" class="tooltips" title="Week">
                                    <i class="sa-list-week"></i>
                                </a>
                            </li>
                            <li class="p-r-0">
                                <a data-view="agendaDay" href="#" class="tooltips" title="Day">
                                    <i class="sa-list-day"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">

                        <section id="login">

             

<form class="box tile animated active"  action="Calendrier" method="Post">
                    <h2 class="m-t-0 m-b-15">Ajouter une tache</h2>
                
                   

   
  <label>Titre de la tache</label><input type="text" name="tache1" class="login-control m-b-10" placeholder="ecrire le titre de la tache ici ..."><label>Date de debut de la tache</label><input type="text" class="input-sm form-control mask-date" placeholder="01/01/2015" maxlength="10" autocomplete="on" name="datedebut_tache1"><label>Date de fin de la tache</label><input type="text" class="input-sm form-control mask-date" placeholder="01/01/2015" maxlength="10" autocomplete="on" name="datefin_tache1"><label>Titre de la tache dependante</label><input type="text" class="login-control m-b-10" placeholder="nom de la tache dont elle depend" name="tachedepend">
 
            
                
                  <br><br>
                <input type="submit" value="valider" class="btn btn-sm" ><br>
                 </form>   
               </section>
             </div></section>
                    
                

                <!-- Add event -->
                <div class="modal fade" id="addNew-event">
                     <div class="modal-dialog">
                          <div class="modal-content">
                               <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Add an Event</h4>
                               </div>
                               <div class="modal-body">
                                    <form class="form-validation" role="form">
                                         <div class="form-group">
                                              <label for="eventName">Event Name</label>
                                              <input type="text" class="input-sm form-control validate[required]" id="eventName" placeholder="...">
                                         </div>
                                         
                                         <input type="hidden" id="getStart" />
                                         <input type="hidden" id="getEnd" />
                                    </form>
                               </div>
                               
                               <div class="modal-footer">
                                    <input type="submit" class="btn btn-info btn-sm" id="addEvent" value="Add Event">
                                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">Close</button>
                               </div>
                          </div>
                     </div>
                </div>
                
                <!-- Modal Resize alert -->
                <div class="modal fade" id="editEvent">
                     <div class="modal-dialog">
                          <div class="modal-content">
                               <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Edit Event</h4>
                               </div>
                               <div class="modal-body">
                                    <div id="eventInfo"></div>
                               </div>
                               
                               <div class="modal-footer"><form action="Calendrier" method="get"><input id="info" type="hidden" name="info"><input type="submit" class="btn btn-info btn-sm"> </form>
                                    
                </div>
                                    <button type="button" class="btn btn-info btn-sm" id="editCancel" data-dismiss="modal">Cancel</button>
                                    
                               </div>
                          </div>
                     </div>
                </div>
               
              
                <br/><br/>
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
        
        <!--  Form Related -->
        <script src="js/validation/validate.min.js"></script> <!-- jQuery Form Validation Library -->
        <script src="js/validation/validationEngine.min.js"></script> <!-- jQuery Form Validation Library - requirred with above js -->
        
        <!-- Other -->
        <script src="js/calendar.min.js"></script> <!-- Calendar -->
        <script src="js/feeds.min.js"></script> <!-- News Feeds -->
        
        
        <!-- All JS functions -->
        <script src="js/functions.js"></script>
        <script src="js/newtache.js"></script>
         <script type="text/javascript">
            $(document).ready(function() {
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth();
                var y = date.getFullYear();
                var test = false;
                var myArray = [
<c:forEach items="${taches}" var="item">
            {title: "${item.titre}",start: new Date("${item.debut.annee}", "${item.debut.mois}", "${item.debut.jour}"),end: new Date("${item.fin.annee}", "${item.fin.mois}", "${item.fin.jour}"),<c:choose>
            <c:when test="${item.editable == 'true'}"> editable: true ,</c:when>
            <c:otherwise> editable: false ,</c:otherwise></c:choose>selectable: "${item.editable}", color: "${item.couleur}", rendering: 'background'},
</c:forEach>
        ];
                
                var events = [{title: ' Hangout with friends non editable' ,start: new Date(y, m, 1),end: new Date(y, m, 5), color: '#1e90ff', rendering: 'background', editable: test},{
                	title: 'test2 non editable',
                	start: '2015-04-24',
					end: '2015-05-28',
					overlap: false,
					rendering: 'background',
					color: '#ff9f89'
					, editable: false
				},
				{
					title: 'Meeting editable non selectable',
					start: '2015-04-13T11:00:00',
					color: '#257e4a',
					editable: true,
					selectable: false
				},
				{
					title: 'Conference editable non selectable',
					start: '2015-02-18',
					end: '2015-04-20',
					color: '#257e4a',
					editable: true,
					selectable: false
				}
];
                
                
                $('#calendar').fullCalendar({

                    header: {
                         center: 'title',
                         left: 'prev, next',
                         right: ''
                    },

                    selectable: false,
                    selectHelper: false,
                    
                    events: myArray,
                     
                    
                     
                    eventResize: function(event,dayDelta,minuteDelta,revertFunc) {
                        $('#editEvent').modal('show');

                        var info =
                            "La date de fin de la tache :" + event.title + ",a été déplacée [" +
                            dayDelta + "] days and " +
                            minuteDelta + " minutes."
                        ;
                        
                        $('#eventInfo').html(info);
                        
                        document.getElementById('info').value= info;
                        $('#editEvent #editCancel').click(function(){
                             revertFunc();
                        }) 
                    }
                }
                );
               
                $('body').on('click', '#addEvent', function(){
                     var eventForm =  $(this).closest('.modal').find('.form-validation');
                     eventForm.validationEngine('validate');
                     
                     if (!(eventForm).find('.formErrorContent')[0]) {
                          
                          //Event Name
                          var eventName = $('#eventName').val();

                          //Render Event
                          $('#calendar').fullCalendar('renderEvent',{
                               title: eventName,
                               start: $('#getStart').val(),
                               end:  $('#getEnd').val(),
                               allDay: true,
                          },true ); //Stick the event
                          
                          $('#addNew-event form')[0].reset()
                          $('#addNew-event').modal('hide');
                     } 
                });   
            });    
            
            //Calendar views
            $('body').on('click', '.calendar-actions > li > a', function(e){
                e.preventDefault();
                var dataView = $(this).attr('data-view');
                $('#calendar').fullCalendar('changeView', dataView);
                
                //Custom scrollbar
                var overflowRegular, overflowInvisible = false;
                overflowRegular = $('.overflow').niceScroll();     
            });                    
            
       </script>
      
    </body>

<!-- Mirrored from 192.185.228.226/projects/sa/1-0-3/calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 28 Jan 2015 09:20:41 GMT -->
</html>

