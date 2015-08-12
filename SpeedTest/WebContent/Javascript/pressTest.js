// JavaScript Document
$(document).ready(init);
var fileSize = 1;
var testState = false;
var realtime;

function init()
{
	$("#testStart").click(function()
	{
		test();
		
		$("#fileSelectDiv").hide(1000);
		$("#testStart").hide(500);
		$("#testTip").show(500);
	});
	
	$("#testError").click(function()
	{
		$("#fileSelectDiv").show(1000);
		$("#speedStateDiv").hide(1000);
		
		$("#testError").hide(500);
		$("#testStart").show(500); 
	});
	
	$("#testInfo").click(function()
	{
		$("#fileSelectDiv").show(1000);
		$("#speedStateDiv").hide(1000);
		
		$("#testInfo").hide(500);
		$("#testStart").show(500);
	});
	
	//------------ 文件大小选择 -------------------
	$("#sizeSelect").slider({
		range: "min",
		value: 1,
		min: 1,
		max: 10, 
		slide: function( event, ui ) {
			fileSize = ui.value;
			$( "#selectedSize" ).text( ui.value + "MB");
		}
	});
	
	//绘图
	realtime = $.plot($("#speedState"), [[[0, 0]]],
		{
			colors: ["#00AADD"],
			series: {
				lines: {
						show: true,
						lineWidth: 2,
						fill: 0.65,
					   },
				points: {show: false},
				shadowSize: 2,
			},
			grid: {
				show: true,
				borderWidth: 0,
				tickColor: "#d2d2d2",
				labelMargin: 12,
			},
			legend: {
				show: false,
			},
		}	
	);
	
}

function test()
{
	testState = true;
	$("#testResult").text("");
	$("#speedStateDiv").show(1000);
	var timeIn = new Date();

	$.ajax({
		type: 'GET',        
		url: "/pressTest.do",
		data: "fileSize="+fileSize,
		cache: false,
		dataType:"text",
		success: function()
		{
			result(timeIn);
			testState = false;
			$("#testTip").hide(1000);
			$("#testInfo").show(1000);
		},
		error: function()
		{
			$("#testTip").hide(1000);
			$("#testError").show(1000);
			testState = false;
		}
	});
	
	setTimeout("getState()",3000);
} 

function getState()
{
	jQuery.ajax({
		type: 'GET',        
		url: "/state.do?kind=pressTestState",
		cache: false,
		dataType:"json",
		success: function(data){
			realtime.setData(data);
			realtime.setupGrid() ; 
			realtime.draw();
			//$("#testResult").text(data);
			if(testState)
			{
				setTimeout("getState()",1000);
			}
		}
	});
}

function result(timeIn)
{
	var overtime = new Date() - timeIn;
	
	if(overtime == 0)
		overtime = 1;

	$("#testResult").text("平均速度：" + Math.round(fileSize*1024*1000/overtime) + "KB/s");
}
