<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        <link rel="icon" type="image/png" sizes="200x138" href=".././images/iconFT.png">
        <!-- LINK FONTAWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.1.1/css/all.css">
        <!-- LINK BOOTSTRAP -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- LINK CSS -->
        <link href=".././css/admin/AdminRoot.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/ScrollBackToTop.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/NavBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/MenuBar.css" rel="stylesheet" type="text/css"/>
        <link href=".././css/admin/Dashboard.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="../../layouts/ScrollBackToTop.html"></jsp:include>
        <jsp:include page="../../layouts/admin/MenuBar.jsp"></jsp:include>
        
        <div class="body-main">
            <jsp:include page="../../layouts/admin/NavBar.jsp"></jsp:include>
            
            <!-- Card Main -->
            <div class="card-main">
                
                <div class="card-box">
                    <div class="card-box__content">
                        <div class="content-numbers counter">${TOTAL_VIEWER}</div>
                        <div class="content-name">Daily Views</div>
                    </div>
                    <div class="card-box__icon">
                        <i class="fa-solid fa-eye"></i>
                    </div>
                </div>
                
                <div class="card-box">
                    <div class="card-box__content">
                        <div class="content-numbers counter">${TOTAL_BOOKING}</div>
                        <div class="content-name">Booking</div>
                    </div>
                    <div class="card-box__icon">
                        <i class="fa-solid fa-calendar-days"></i>
                    </div>
                </div>
                
                <div class="card-box">
                    <div class="card-box__content">
                        <div class="content-numbers counter">${TOTAL_FEEDBACK}</div>
                        <div class="content-name">FeedBack</div>
                    </div>
                    <div class="card-box__icon">
                        <i class="fa-solid fa-comments"></i>
                    </div>
                </div>
                
                <div class="card-box">
                    <div class="card-box__content">
                        <div class="content-numbers counter">${TOTAL_USER}</div>
                        <div class="content-name">Customers</div>
                    </div>
                    <div class="card-box__icon">
                        <i class="fa-solid fa-users"></i>
                    </div>
                </div>
                
            </div>
            
            <!-- Add Charts -->
            <div class="graph-chart">
                <div class="chart-box">
                    <canvas id="ChartCustomer"></canvas>
                </div>
            </div>
        </div>
            
        <!-- JQUERY -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Chart -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
        <!-- Counter-Up -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Counter-Up/1.0.0/jquery.counterup.js"></script>
        <!-- Script -->
        <script src=".././js/admin/AdminRoot.js"></script>
        <script src=".././js/admin/Dashboard.js"></script>
        <script src=".././js/admin/NavBar.js"></script>
        <script>
            const chartCustomer = document.getElementById("ChartCustomer").getContext("2d");
            const MONTHS = [
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
            ];

            var myChart = new Chart(chartCustomer, {
                type: "line",
                data: {
                    labels: MONTHS,
                    datasets: [
                        {
                            label: "Customers",
                            data: ${STATISTIC_ACCOUNT},
                            fill: false,
                            borderColor: "rgb(75, 192, 192)",
                            tension: 0.1
                        }
                    ]
                },
                options: {
                    response: true
                }
            });
        </script>
    </body>
</html>
