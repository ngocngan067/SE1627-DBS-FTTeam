<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>TimeLine</title>
        <!-- TẠO ICON TRÊN THANH WEB -->
        <link rel="icon" href=".././images/iconFT.png" type="image/png" sizes="200x138" />
        <!-- LINK BOOTSTRAP 5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <!-- LINK FONT AWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- Box Icons -->
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <!-- UN ICONS -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
        <!-- LINK CSS -->
        <link rel="stylesheet" href=".././css/dentist/DentistRoot.css" />
        <link rel="stylesheet" href=".././css/ScrollBackToTop.css" />
        <link rel="stylesheet" href=".././css/CheckNetworkStatus.css" />
        <link rel="stylesheet" href=".././css/dentist/NavBar.css" />
        <link rel="stylesheet" href=".././css/dentist/TimeLine.css" />
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/CheckNetworkStatus.html"></jsp:include>
        
        <header class="header-background">
            <jsp:include page="../../layouts/dentist/NavBar.jsp"></jsp:include>
        </header>
        
        <section class="schedule__page my-5">
            <div class="container-fluid">
                <div class="shift-schedule">
                    <div class="container-header mb-4">
                        <h1>Timeline</h1>
                        <div class="buttons">
                            <button onclick="changeWeek(-1)">
                                <i class="fa-solid fa-angle-left"></i>
                            </button>

                            <span id="start-date"></span>

                            <span>-</span>

                            <span id="end-date"></span>
                            <button onclick="changeWeek(+1)"><i class="fa-solid fa-angle-right"></i></button>
                        </div>
                    </div>

                    <div class="schedule mb-5 mt-3">
                        <table class="calendar-table" border="1">
                            <tr id="c-h">
                                <th>Slot (Time)</th>
                                <th>Mon</th>
                                <th>Tue</th>
                                <th>Wed</th>
                                <th>Thu</th>
                                <th>Fri</th>
                                <th>Sat</th>
                                <th>Sun</th>
                            </tr>
                            <tr id="yVAxOtLaWr" class="c-1">
                                <td id="Time" class="Time">Slot 1 <span class="time-slot">(9:00 - 9:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>
                            <tr id="2jKy0KkhSo" class="c-2">
                                <td id="Time" class="Time">Slot 2 <span class="time-slot">(9:30 - 10:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>
                            <tr id="E4cIHlnfq2" class="c-3">
                                <td id="Time" class="Time">Slot 3 <span class="time-slot">(10:00 - 10:30)</span> </td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>
                            <tr id="xRnDdJtora" class="c-4">
                                <td id="Time" class="Time">Slot 4 <span class="time-slot">(10:30 - 11:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>
                            <tr id="pP1aF1VZUi" class="c-5">
                                <td id="Time" class="Time">Slot 5 <span class="time-slot">(11:00 - 11:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="bgLxb9lAxf" class="c-6">
                                <td id="Time" class="Time">Slot 6 <span class="time-slot">(11:30 - 12:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="t2125plsQ8" class="c-7">
                                <td id="Time" class="Time">Slot 7 <span class="time-slot">(12:00 - 12:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="KCiI4OVEqV" class="c-8">
                                <td id="Time" class="Time">Slot 8 <span class="time-slot">(12:30 - 13:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="uwYyBL34N4" class="c-9">
                                <td id="Time" class="Time">Slot 9 <span class="time-slot">(13:00 - 13:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="GG0A6gfXKg" class="c-10">
                                <td id="Time" class="Time">Slot 10 <span class="time-slot">(13:30 - 14:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="296uoqx9Dv" class="c-11">
                                <td id="Time" class="Time">Slot 11 <span class="time-slot">(14:00 - 14:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="pemqrC91A4" class="c-12">
                                <td id="Time" class="Time">Slot 12 <span class="time-slot">(14:30 - 15:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="LiLb3564jz" class="c-13">
                                <td id="Time" class="Time">Slot 13 <span class="time-slot">(15:00 - 15:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="oTjkSc9QCI" class="c-14">
                                <td id="Time" class="Time">Slot 14 <span class="time-slot">(15:30 - 16:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="dyNW3IM3IL" class="c-15">
                                <td id="Time" class="Time">Slot 15 <span class="time-slot">(16:00 - 16:30)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>

                            <tr id="Ew5m6XIGHb" class="c-16">
                                <td id="Time" class="Time">Slot 16 <span class="time-slot">(16:30 - 17:00)</span></td>
                                <td id="Mon" class="Mon"></td>
                                <td id="Tue" class="Tue"></td>
                                <td id="Wed" class="Wed"></td>
                                <td id="Thu" class="Thu"></td>
                                <td id="Fri" class="Fri"></td>
                                <td id="Sat" class="Sat"></td>
                                <td id="Sun" class="Sun"></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
            <div id="id01" class="modal">
                <div class="modal-content">
                    <div class="modal-header">
                        <p class="title">Slot Details</p>
                        <span id="close" class="close"><i class="fa-solid fa-xmark"></i></span>
                    </div>
                    <div class="modal-body"></div>
                </div>
            </div>
        </section>
        
        <!-- LINK BOOTSTRAP 5 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
        <!-- J QUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Script  -->
        <script src=".././js/dentist/DentistRoot.js"></script>
        <script src=".././js/dentist/TimeLine.js"></script>
        <script src=".././js/ScrollBackToTop.js"></script>
        <script src=".././js/CheckNetworkStatus.js"></script>
        <script>
            setActiveMenuBar();
            getApiTimeLine(${TIME_LINE});
            renderEvents();
        </script>
    </body>
</html>
