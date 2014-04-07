// JavaScript Document
$(document).ready(init);


var timeC;

function init()
{
	timeC = new speedCount();
	
	var rNum;
	
	$("#t64start").click(function()
	{
		timeC.timeStart = new Date();
		timeC.fileSize = 64;
		
		rNum = parseInt(Math.random()*1000+1);
		$("#testImgDiv").delay(50).show(500);
		$("#testImg").html("<img src=\"http://cdn.akkz.net/test/64KB.bmp?id=" + rNum + "\" height=\"100px\" width=\"30px\" onload=\"timeC.getSpeed();\">");
		$("#progressBar").hide(500);
		$("#progressing").show(500);
	});
	
	$("#t128start").click(function()
	{
		timeC.timeStart = new Date();
		timeC.fileSize = 128;
		
		rNum = parseInt(Math.random()*1000+1);
		$("#testImgDiv").delay(100).show(500);
		$("#testImg").html("<img src=\"http://cdn.akkz.net/test/128KB.bmp?id=" + rNum + "\" height=\"100px\" width=\"30px\" onload=\"timeC.getSpeed();\">");
		$("#progressBar").hide(500);
		$("#progressing").show(500);
	});
	
	$("#t512start").click(function()
	{
		timeC.timeStart = new Date();
		timeC.fileSize = 512;
		
		rNum = parseInt(Math.random()*1000+1);
		$("#testImgDiv").delay(500).show(500);
		$("#testImg").html("<img src=\"http://cdn.akkz.net/test/512KB.bmp?id=" + rNum + "\" height=\"100px\" width=\"30px\" onload=\"timeC.getSpeed();\">");
		$("#progressBar").hide(500);
		$("#progressing").show(500);
	});
	
	$("#t1024start").click(function()
	{
		timeC.timeStart = new Date();
		timeC.fileSize = 1024;
		
		rNum = parseInt(Math.random()*1000+1);
		$("#testImgDiv").delay(1000).show(500);
		$("#testImg").html("<img src=\"http://cdn.akkz.net/test/1MB.bmp?id=" + rNum + "\" height=\"100px\" width=\"30px\" onload=\"timeC.getSpeed();\">");
		$("#progressBar").hide(500);
		$("#progressing").show(500);
	});
}

var speedCount = function()
{
	this.timeStart = null;
	this.timeEnd = null;
	this.fileSize = 1;
	this.timeCount = 0;
	this.allTime = 0;
	this.allSize = 0;
	
	this.getSpeed = function()
	{
		timeC.timeEnd = new Date();
		timeC.allTime += timeC.timeEnd - timeC.timeStart;
		timeC.allSize += timeC.fileSize;
		
		$("#testResult").append("第" + ++timeC.timeCount + "次：" + Math.round(timeC.fileSize*1000/(timeC.timeEnd - timeC.timeStart)) + "KB/s<br />");
		$("#avgResult").text(Math.round(timeC.allSize*1000/timeC.allTime));
		
		$("#testImgDiv").hide();
		$("#progressing").hide(500);
		$("#progressBar").show(500);
	}
}
