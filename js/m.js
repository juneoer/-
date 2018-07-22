// JavaScript Document
$(document).ready(function(){
				setInterval(function(){
					var time=new Date();
			var year=time.getFullYear();
			var moth=time.getMonth()+1;
			var day=time.getDate();
			var hours=time.getHours();
			var fen=time.getMinutes();
			var miao=time.getSeconds();
			var newtime=year+"年"+moth+"月"+day+"日"+hours+":"+fen+":"+miao;
			document.getElementById('sj').innerHTML=newtime;
				},1000);
			$("#head :last").click(function(){
				window.location="登录系统页面.html";
			});
			$(".xj").click(function(){
				window.location="添加订单.html";
			});
				$(".sq").click(function(){
					if(confirm("确定删除吗")){
						window.location="#";	
					}else{
						window.location="#";
					}
				});			
	});
