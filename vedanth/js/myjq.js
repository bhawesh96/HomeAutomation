$(document).ready(function(){
	window.a = '';
	window.b = '';
	window.c = '';
	window.init = '';
	getVals();

function device1on() {
	$('.device1img').attr('src','images/bulboff.png');
	$(".device1but").val("a0");
	$(".device1but").text("ON");
}

function device1off() {
	$('.device1img').attr('src','images/bulbon.png');
	$(".device1but").text("OFF");
	$(".device1but").val("a1");
}

function device2on() {
	$('.device2img').attr('src','images/bulboff.png');
	$(".device2but").val("b0");
	$(".device2but").text("ON");
}

function device2off() {
	$('.device2img').attr('src','images/bulbon.png');
	$(".device2but").text("OFF");
	$(".device2but").val("b1");
}

function device3on() {
	$('.device3img').attr('src','images/bulboff.png');
	$(".device3but").val("c0");
	$(".device3but").text("ON");
}

function device3off() {
	$('.device3img').attr('src','images/bulbon.png');
	$(".device3but").text("OFF");
	$(".device3but").val("c1");
}

function device4on() {
	$('.device4img').attr('src','images/bulboff.png');
	$(".device4but").val("d0");
	$(".device4but").text("ON");
}

function device4off() {
	$('.device4img').attr('src','images/bulbon.png');
	$(".device4but").text("OFF");
	$(".device4but").val("d1");
}

function doorclose() {
	$('.doorimg').attr('src','images/doorclose.png');
	$(".doorbut").text("OPEN");
	$(".doorbut").val("e0");
}

function dooropen() {
	$('.doorimg').attr('src','images/dooropen.png');
	$(".doorbut").text("CLOSE");
	$(".doorbut").val("e1");
}

function fanon() {
	$('.fanimg').attr('src','images/fanon.gif');
	$(".fanbut").text("OFF");
	$(".fanbut").val("f1");
}

function fanoff() {
	$('.fanimg').attr('src','images/fanoff.png');
	$(".fanbut").text("ON");
	$(".fanbut").val("f0");
	
}

	function getVals() {
 	$.get('php/init.php', {}, function(data){
		console.log(data);
		init = data.split("@")
		console.log(init);
	 	if(init[0] == 'a1') device1off();
	 	if(init[1] == 'b1')	device2off();
	 	if(init[2] == 'c1') device3off();
	 	if(init[3] == 'd1') device4off();
	 	if(init[4] == 'e1') dooropen();
	 	if(init[5] == 'f1') fanon();
	 	$(".tempdata").text(init[6]);
	 	$(".moisturedata").text(init[7]);
	 	if(init[8]=='0')
	 		$(".soildata").text("Dry");
	 	else if(init[8]=='1')
		 	$(".soildata").text("Fine");
	 	else if(init[8]=='2')
	 		$(".soildata").text("Too wet");
	});
 }

			
		$('.device1but').click(function(){
 			if($('.device1img').attr('src')=='images/bulbon.png')
			{
				device1on();	
			}
		else if($('.device1img').attr('src')=='images/bulboff.png')
			{
			 	device1off();
			}
	});

		$('.device2but').click(function(){
 			if($('.device2img').attr('src')=='images/bulbon.png')
			{
				device2on();
				
			}
		else if($('.device2img').attr('src')=='images/bulboff.png')
			{
			 	device2off();
			}
	});

		$('.device3but').click(function(){
 			if($('.device3img').attr('src')=='images/bulbon.png')
			{
				device3on();
			}
		else if($('.device3img').attr('src')=='images/bulboff.png')
			{
			 	device3off();
			}
	});

		$('.device4but').click(function(){
 			if($('.device4img').attr('src')=='images/bulbon.png')
			{
				device4on();
			}
		else if($('.device4img').attr('src')=='images/bulboff.png')
			{
			 	device4off();
			}
	});

		$('.doorbut').click(function(){
 			if($('.doorimg').attr('src')=='images/dooropen.png')
			{
				doorclose();
				
			}
		else if($('.doorimg').attr('src')=='images/doorclose.png')
			{
			 	dooropen();
			}
	});


$('.fanbut').click(function(){
 			if($('.fanimg').attr('src')=='images/fanoff.png')
			{
				fanon();
			}
		else if($('.fanimg').attr('src')=='images/fanon.gif')
			{
			 	fanoff();
			}
	});

$('.tempbut').click(function(){
 		// 	jQuery.get('php/temp.txt', function(data) {
 		// 		$(".tempdata").text(data);
			// });
			getVals();
	});

$('.moisturebut').click(function(){
 		// 	jQuery.get('php/moisture.txt', function(data) {
 		// 		$(".moisturedata").text(data);
			// });
			getVals();
	});
$('.soilbut').click(function(){
 		// 	jQuery.get('php/soil.txt', function(data) {
 		// 		if(data='0')
 		// 		$(".soildata").text("Dry");
 		// 		else if(data='1')
 		// 		$(".soildata").text("Fine");
 		// 		else if(data='2')
 		// 		$(".soildata").text("Too wet");
			// });
			getVals();
	});

$('.reset').click(function(){
		device1on();device2on();device3on();device4on();doorclose();fanoff();	
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
				console.log(data);
			 	});

		$.get('php/room2.php', { light1:r2light2}, function(data){
				console.log(data);
			 	});

  	 	$.get('php/hall.php', { light1:halllight1, light2:halllight2, fan : fan, door : door}, function(data){
  	 			console.log(data);
			 	});

		
});

    });

