<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<base href="<%=basePath%>">
	<title>Kanrisha - A Premium HTML5 Responsive Admin Template</title>
	<!--[if lt IE 9]>
		<script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<script src="Javascript/Flot/excanvas.js"></script>
	<![endif]-->
	<!-- The Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Oswald|Droid+Sans:400,700" rel="stylesheet" />
	<!-- The Main CSS File -->
	<link rel="stylesheet" href="CSS/style.css" />
    <link rel="stylesheet" href="CSS/akkz.css" />
	<!-- jQuery -->
	<script src="Javascript/jQuery/jquery-1.7.2.min.js"></script>
	<!-- Flot -->
	<script src="Javascript/Flot/jquery.flot.js"></script>
	<script src="Javascript/Flot/jquery.flot.resize.js"></script>
	<script src="Javascript/Flot/jquery.flot.pie.js"></script>
	<!-- DataTables -->
	<script src="Javascript/DataTables/jquery.dataTables.min.js"></script>
	<!-- ColResizable -->
	<script src="Javascript/ColResizable/colResizable-1.3.js"></script>
	<!-- jQuryUI -->
	<script src="Javascript/jQueryUI/jquery-ui-1.8.21.min.js"></script>
	<!-- Uniform -->
	<script src="Javascript/Uniform/jquery.uniform.js"></script>
	<!-- Tipsy -->
	<script src="Javascript/Tipsy/jquery.tipsy.js"></script>
	<!-- Elastic -->
	<script src="Javascript/Elastic/jquery.elastic.js"></script>
	<!-- ColorPicker -->
	<script src="Javascript/ColorPicker/colorpicker.js"></script>
	<!-- SuperTextarea -->
	<script src="Javascript/SuperTextarea/jquery.supertextarea.min.js"></script>
	<!-- UISpinner -->
	<script src="Javascript/UISpinner/ui.spinner.js"></script>
	<!-- MaskedInput -->
	<script src="Javascript/MaskedInput/jquery.maskedinput-1.3.js"></script>
	<!-- ClEditor -->
	<script src="Javascript/ClEditor/jquery.cleditor.js"></script>
	<!-- Full Calendar -->
	<script src="Javascript/FullCalendar/fullcalendar.js"></script>
	<!-- Color Box -->
	<script src="Javascript/ColorBox/jquery.colorbox.js"></script>
	<!-- Kanrisha Script -->
	<script src="Javascript/kanrisha.js"></script>
	<!-- Akkz Script -->
	<script src="Javascript/akkz.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>

	<header class="main_header">
		<div class="wrapper">

		</div>
	</header>



	<div class="wrapper contents_wrapper">
		<div class="contents">
			<div class="grid_wrapper">

				<div class="g_6 contents_header">
                    <div class="logo">
                        <a href="#" title="Kanrisha Home">
                            <img src="Images/kanrisha_logo.png" alt="kanrisha_logo" />
                        </a>
                    </div>				
            	</div>
				<div class="g_6 contents_options">
					
				</div>

                <div class="g_6 contents_options">
                    <nav class="top_buttons">
                        <ul>
                            <li class="big_button">
                                <div class="out_border">
                                    <div class="button_wrapper">
                                        <div class="in_border">
                                            <a href="#" title="Analytics" class="the_button">
                                                <span class="i_32_statistic"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="big_button">
                                <div class="big_count">
                                    <span>7</span>
                                </div>
                                <div class="out_border">
                                    <div class="button_wrapper">
                                        <div class="in_border">
                                            <a href="#" title="Support" class="the_button">
                                                <span class="i_32_support"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="big_button">
                                <div class="out_border">
                                    <div class="button_wrapper">
                                        <div class="in_border">
                                            <a href="#" title="Delivery" class="the_button">
                                                <span class="i_32_delivery"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="big_button">
                                <div class="out_border">
                                    <div class="button_wrapper">
                                        <div class="in_border">
                                            <a href="#" title="Earning" class="the_button">
                                                <span class="i_32_dollar"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </nav>
                </div>
            
            
				<div class="g_12 separator"><span></span></div>

				<!-- Charts -->
				<div class="g_12">
				
					<div class="widget_header">
						<h4 class="widget_header_title wwIcon i_16_charts">传输测速</h4>
					</div>
					<div class="widget_contents noPadding">
                    	<div class="line_grid">
                            <div id="fileSelectBar" class="g_3">
                                <div class="g_6">
                                    <div id="s64btn" class="simple_buttons bdC">
                                        <div>64&nbsp;KB</div>
                                    </div>
                                    <div id="s128btn" class="simple_buttons bdC">
                                        <div>128KB</div>
                                    </div>
                                    <div id="s512btn" class="simple_buttons bdC">
                                        <div>512KB</div>
                                    </div>
                                    <div id="s1024btn" class="simple_buttons bdC">
                                        <div>&nbsp;1&nbsp;MB</div>
                                    </div>
                                </div>
                                <div class="g_6">
                                    <div id="sizeSelect" class="slider scBlue sVertical ui-slider ui-slider-vertical ui-widget ui-widget-content ui-corner-all">
                                        <div class="ui-slider-range ui-widget-header ui-slider-range-min" style="height: 0%;"></div>
                                        <a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="bottom: 0%;"></a>
                                    </div>
                                </div>                        
							</div>
                            
                            <div id="progressBar" class="g_9">
                            	<div class="g_12">
                                    <div class="line_grid">
                                        <div class="progress scBlue ui-progressbar ui-widget ui-widget-content ui-corner-all" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="1">
                                            <div id="progressState" class="ui-progressbar-value ui-widget-header ui-corner-left" style="width: 0%;"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="g_12">
                                	<div class="g_2"></div>
                                    <div class="g_8">
                                    	<span class="label">文件大小：<span id="selectedSize"></span></span>
                                        <div id="testStart" class="success">
                                        	开始测试
                                        </div>
                                        <div id="testTip" class="alert hidden">
											测试中，请勿刷新！
                                        </div>
                                        <div id="testError" class="error hidden">
											传输失败，请检查网络状态或减小测试数据！
                                        </div>
                                        <div id="testInfo" class="info hidden">
											测试成功，点击重新测试！
                                        </div>
                                    </div>
                                    <div class="g_2"></div>
                                </div>
							</div>
                        </div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<footer>
		<div class="wrapper">
			<span class="copyright">
				&copy; Copyright &copy; 2013.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
			</span>
		</div>
	</footer>
</body>
</html>