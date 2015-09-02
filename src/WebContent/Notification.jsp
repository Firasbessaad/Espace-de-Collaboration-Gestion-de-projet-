<div id="notifications" class="tile drawer animated">
                    <div class="listview narrow">
                        <div class="media">
                            <a href="#">Notification Settings</a>
                            <span class="drawer-close">&times;</span>
                        </div>
                        <div class="overflow" style="height: 254px">
                        <c:forEach var="notification" items="${ notifications }">
                            <div class="media"><a class="t-overflow" href="<c:out value="${ notification.CONTENU }" />">
                                <div class="pull-left">
                                    <img width="40" src="<c:out value="${ notification.IMAGE }" />" alt="">
                                </div>
                                <div class="media-body">
                                    <small class="text-muted"><c:out value="${ notification.SENDER }" /> - <c:out value="${ notification.DATEENVOI }" /></small><br>
                                    <c:out value="${ notification.LIEN }" />
                                </div>
                           </a> </div>
                           </c:forEach> 
                        </div>
                        <div class="media text-center whiter l-100">
                            <a href="#"><small>VIEW ALL</small></a>
                        </div>
                    </div>
                </div>