// JavaScript Document
$(document).ready(init);
var allSize = 0;
var allTime = 0;
var timeCount = 0;
var fileSize = 512;

function init()
{
	$("#selectedSize").html("512KB");
	
	$("#testStart").click(function()
	{
		test();
		
		$("#testStart").hide(500);
		$("#testTip").show(500);
	});
	
	$("#testError").click(function()
	{
		$("#progressState").animate({width:"0%"},1500);
		$("#testError").hide(500);
		$("#testStart").show(500); 
	});
	
	$("#testInfo").click(function()
	{
		$("#progressState").animate({width:"0%"},1500);
		$("#fileSelectBar").show(1000);
		$("#fileState").hide(1000);
		
		$("#testInfo").hide(500);
		$("#testStart").show(500);
	});
	
	$("#showResult").mouseenter(function()
	{
		$("#fileState").show(1000);
		$("#fileSelectBar").hide(1000);
	});
	
	$("#showResult").mouseleave (function()
	{
		$("#fileSelectBar").show(1000);
		$("#fileState").hide(1000);
	});
	
	//------------ 文件大小选择 -------------------
	$("#sizeSelect").slider({
		orientation: "vertical",
		range: "min",
		min: 32,
		max: 1024,
		value: 512,
		slide: function( event, ui ) {
			fileSize = ui.value;
			$( "#selectedSize" ).text( ui.value + "KB");
		},
	});
	
	$("#s64btn").click(function()
	{
		fileSize = 64;
		$("#sizeSelect").slider({value: 64});
		$( "#selectedSize" ).text("64KB");
	});
	
	$("#s128btn").click(function()
	{
		fileSize = 128;
		$("#sizeSelect").slider({value: 128});
		$( "#selectedSize" ).text("128KB");
	});
	
	$("#s512btn").click(function()
	{
		fileSize = 512;
		$("#sizeSelect").slider({value: 512});
		$( "#selectedSize" ).text("512KB");
	});
	
	$("#s1024btn").click(function()
	{
		fileSize = 1024;
		$("#sizeSelect").slider({value: 1024});
		$( "#selectedSize" ).text("1024KB");
	});
}

function test()
{
	var timeIn = new Date();

	$.ajax({
		type: 'GET',        
		url: "/dataSend.do",
		data: "fileSize="+fileSize,
		cache: false,
		dataType:"text",
		success: function()
		{
			timeCount++;
			result(timeIn);
		},
		error: function()
		{
			$("#testTip").hide(1000);
			$("#testError").show(1000);
		}
	});
	
	setTimeout(getState(),100);
}

function result(timeIn)
{
	var overtime = new Date() - timeIn;
	
	if(overtime == 0)
		overtime = 1;

	allSize += fileSize;
	allTime += overtime;
	
	$("#testResult").append("第" + timeCount + "次：" + Math.round(fileSize*1000/overtime) + "KB/s<br />");
	$("#avgResult").text(Math.round(allSize*1000/allTime));
	$("#fileSelectBar").hide(1000);
	$("#fileState").show(1000);
	
	$("#testTip").hide(500);
	$("#testInfo").show(500); 
}

function getState()
{
	jQuery.ajax({
		type: 'GET',        
		url: "/state.do?kind=ajaxTest",
		cache: false,
		dataType:"text",
		success: function(data){
			$("#progressState").css({width:data+"%"},1);
			
			if(parseInt(data) < 100)
			{
				setTimeout(getState(),100);
			}
		}
	});
}
