<!-- Sidebar -->
            <aside id="sidebar">
                
                <!-- Sidbar Widgets -->
                <div class="side-widgets overflow">
                    <!-- Profile Menu -->
                    <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                        <a href="#" data-toggle="dropdown">
                            <img class="profile-pic animated" src=".<c:out value="${ photo }" />" alt="">
                        </a>
                        <ul class="dropdown-menu profile-menu">
                            <li><a href="#"><span class="btn btn-sm">My Profile</span></a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="#"><span class="btn btn-sm">Messages</span></a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><a href="#"><span class="btn btn-sm">Settings</span></a> <i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                            <li><form action="Logout" method="post"><input type="submit" value="Sign Out" class="btn btn-sm"></form><i class="icon left">&#61903;</i><i class="icon right">&#61815;</i></li>
                        </ul>
                        <h4 class="m-0"><c:out value="${ nom }" /></h4>
                        <c:out value="${ mail }" />
                    </div>
                    
                    <!-- Calendar -->
                    <div class="s-widget m-b-25">
                        <div id="sidebar-calendar"></div>
                    </div>
                    
                    <!-- Feeds -->
                    
                    
                    <!-- Projects -->
                    
                </div>
                
                <!-- Side Menu -->
               <form action="Menu" method="post">
                <ul class="list-unstyled side-menu">
                    <li>
                        <a>
                          <img src="./img/Accueil.png" ><span class="menu-item"><input type="submit" class="btn btn-sm" value="Accueil" name="accueil"></span>
                       </a>
                    </li>
                    <br><li> 
                        <a>
                            <img src="./img/profil.jpg"><span class="menu-item"><input type="submit" class="btn btn-sm" value="Profil" name="profil"></span>
                       </a>
                    </li>
                    <br><li> 
                        <a>
                            <img src="./img/demande_Encadrement.png"><span class="menu-item"><input type="submit" class="btn btn-sm" value="Liste des demandes" name="demande"></span>
                       </a>
                    </li> <br><li> 
                        <a>
                            <img src="./img/espace.png"><span class="menu-item"><input type="submit" class="btn btn-sm" value="Espace" name="espace"></span>
                       </a>
                    </li>
                   
                     
                </ul>
                </form>
            </aside>