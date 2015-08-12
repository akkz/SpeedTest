// JavaScript Document
$(document).ready(init);

function init()
{
	var fileSize = 512;
	//$("#testTip").hide();
	//$("#testError").hide();
	//$("#testInfo").hide();
	$("#selectedSize").html("512KB");
	
	$("#testStart").click(function()
	{
		//$("#fileSelectBar").hide(1500);
		//$("#progressBar").animate({width:"100%",1500});
		test(fileSize);
		$("#testStart").hide(1500);
		$("#testTip").show(1500);
	});
	
	$("#testError").click(function()
	{
		$("#testError").hide(1500);
		$("#testStart").show(1500);
	});
	
	$("#testInfo").click(function() 
	{
		$("#testInfo").hide(1500);
		$("#testStart").show(1500);
	});
	
	//-------------------------------
	$("#sizeSelect").slider({
		orientation: "vertical",
		range: "min",
		min: 0,
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

function test(fileSize)
{
	var timeIn = new Date();

	$.ajax({
		type: 'GET',        
		url: "/dataSend.do",
		data: "fileSize="+fileSize,
		cache: false,
		success: function(){result(fileSize,timeIn)}
	});
	
	getState();
}

function result(fileSize,timeIn)
{
	var overtime = new Date() - timeIn;
	
	if(overtime == 0)
		overtime = 1; 
	
	alert("测速结果为：" + Math.round(fileSize*1000/overtime) + "KB/s");
	
	$("#testTip").hide(1500);
	$("#testInfo").show(1500);
}

function getState()
{
	jQuery.ajax({
		type: 'GET',        
		url: "/state.do",
		cache: false,
		success: function(data){
			$("#progressState").animate({width:data+"%"},100);
			
			if(parseInt(data) < 100)
			{
				getState();
			}
		}
	});
}
