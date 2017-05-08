$(document).ready(function(){
	window.a = '';
	window.b = '';
	window.c = '';
			
		$('.device1but').click(function(){
 			if($('.device1img').attr('src')=='images/bulbon.png')
			{
				$('.device1img').attr('src','images/bulboff.png');
				$(".device1but").val("a0");
				$(".device1but").text("ON");
				//a ='a0';
				
			}
		else if($('.device1img').attr('src')=='images/bulboff.png')
			{
			 	$('.device1img').attr('src','images/bulbon.png');
			 	$(".device1but").text("OFF");
			 	$(".device1but").val("a1");
			 	//a = 'a1';
				
			}
	});

		$('.device2but').click(function(){
 			if($('.device2img').attr('src')=='images/bulbon.png')
			{
				$('.device2img').attr('src','images/bulboff.png');
				$(".device2but").val("b0");
				$(".device2but").text("ON");
				//b = 'b0';
				
			}
		else if($('.device2img').attr('src')=='images/bulboff.png')
			{
			 	$('.device2img').attr('src','images/bulbon.png');
			 	$(".device2but").val("b1");
			 	$(".device2but").text("OFF");
			 	//b = 'b1';
			 	
			}
	});

		$('.device3but').click(function(){
 			if($('.device3img').attr('src')=='images/bulbon.png')
			{
				$('.device3img').attr('src','images/bulboff.png');
				$(".device3but").val("c0");
				$(".device3but").text("ON");
				//b = 'b0';
				
			}
		else if($('.device3img').attr('src')=='images/bulboff.png')
			{
			 	$('.device3img').attr('src','images/bulbon.png');
			 	$(".device3but").val("c1");
			 	$(".device3but").text("OFF");
			 	//b = 'b1';
			 	
			}
	});

		$('.device4but').click(function(){
 			if($('.device4img').attr('src')=='images/bulbon.png')
			{
				$('.device4img').attr('src','images/bulboff.png');
				$(".device4but").val("d0");
				$(".device4but").text("ON");
				//b = 'b0';
				
			}
		else if($('.device4img').attr('src')=='images/bulboff.png')
			{
			 	$('.device4img').attr('src','images/bulbon.png');
			 	$(".device4but").val("d1");
			 	$(".device4but").text("OFF");
			 	//b = 'b1';
			 	
			}
	});

		$('.doorbut').click(function(){
 			if($('.doorimg').attr('src')=='images/dooropen.png')
			{
				$('.doorimg').attr('src','images/doorclose.png');
				$(".doorbut").text("OPEN");
				$(".doorbut").val("e0");
				
			}
		else if($('.doorimg').attr('src')=='images/doorclose.png')
			{
			 	$('.doorimg').attr('src','images/dooropen.png');
			 	$(".doorbut").text("CLOSE");
			 	$(".doorbut").val("e1");
				
			}
	});


$('.fanbut').click(function(){
 			if($('.fanimg').attr('src')=='images/fanoff.png')
			{
				$('.fanimg').attr('src','images/fanon.gif');
				$(".fanbut").text("OFF");
				$(".fanbut").val("f1");
				
			}
		else if($('.fanimg').attr('src')=='images/fanon.gif')
			{
			 	$('.fanimg').attr('src','images/fanoff.png');
			 	$(".fanbut").text("ON");
			 	$(".fanbut").val("f0");
			 	
			}
	});

$('.tempbut').click(function(){
 			jQuery.get('php/temp.txt', function(data) {
 				$(".tempdata").text(data);
			});
	});

$('.moisturebut').click(function(){
 			jQuery.get('php/moisture.txt', function(data) {
 				$(".moisturedata").text(data);
			});
	});
$('.soilbut').click(function(){
 			jQuery.get('php/soil.txt', function(data) {
 				if(data='0')
 				$(".soildata").text("Dry");
 				else if(data='1')
 				$(".soildata").text("Fine");
 				else if(data='2')
 				$(".soildata").text("Too wet");
			});
	});

$('.reset').click(function(){
		$(".device1but").val("a0");
		$('.device1img').attr('src','images/bulboff.png');
		$(".device1but").text("ON");
		$(".device2but").val("b0");
		$('.device2img').attr('src','images/bulboff.png');
		$(".device2but").text("ON");
		$(".device3but").val("c0");
		$('.device3img').attr('src','images/bulboff.png');
		$(".device3but").text("ON");
		$(".device4utt").val("d0");
		$('.device4img').attr('src','images/bulboff.png');
		$(".device4but").text("ON");
		$(".doorbut").val("e0");
		$('.doorimg').attr('src','images/doorclose.png');
		$(".doorbut").text("OPEN");
		$(".fanbut").val("f0"); 		
		$('.fanimg').attr('src','images/fanoff.png');
		$(".fanbut").text("ON");
 			
	});


$(document).click(function() {
	

		var r1light1 = $(".device1but").val();
		var r2light2 = $(".device2but").val();
		var halllight1 = $(".device3but").val();
		var halllight2 = $(".device4but").val();
		var door = $(".doorbut").val();
		var fan = $(".fanbut").val();
		$('.data2').text(r1light1+r2light2+halllight1+halllight2+door+fan);
  	 	$.get('php/room1.php', { light1:r1light1}, function(data){

			 	});

		$.get('php/room2.php', { light1:r2light2}, function(data){

			 	});

  	 	$.get('php/hall.php', { light1:halllight1, light2:halllight2, fan : fan, door : door}, function(data){

			 	});

		
});

    });

