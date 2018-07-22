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
$(document).ready(function(){
	
	$("#bc").click(function(){
					var time=new Date();
			var year=time.getFullYear();
			var moth=time.getMonth()+1;
			var day=time.getDate();
			var hours=time.getHours();
			var fen=time.getMinutes();
			var miao=time.getSeconds();
		var newtime=year+"年"+moth+"月"+day+"日"+hours+":"+fen+":"+miao;
		//获取订单编号数据
		var bh=document.getElementById("dingdan1").value;
		//获取商品名称
		var mc=document.getElementById("dingdan2").value;
		//获取金额
		var je=document.getElementById("dingdan4").value;
		//获取下拉框select选中的值
			//1.拿到select对象
			var dingdan5=document.getElementById("dingdan5");
			//2.拿到选中项的索引
			var  index=dingdan5.selectedIndex;
			//3.拿到选中options的value
			dingdan5.options[index].value;
			//4.拿到选中项ioptions的ttext
		var gys=dingdan5.options[index].text;
		//获取复选框chaxbox值
		var names=document.getElementsByName("gk");
		var fk=[];
		for(var k in fk){
			if(fk[k].checked){
				 fk.push(names[k].value);
			}
		}
		$.ajax({
			url:"zd",
			dataType:"json",
			async:true,
			type:"POST",
			data:{bh,mc,je,gys,fk,newtime},
			success:function(data){
				alert(data);
			}
		});
	});
});

