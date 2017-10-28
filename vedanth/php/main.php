<?php
$f1 = fopen("room1.txt", "r");
$f2 = fopen("room2.txt", "r");
$f3 = fopen("hall.txt", "r");

$room1 = fgets($f1);
$room2 = fgets($f2);
$hall = fgets($f3);
$string = $room1.$room2.$hall;
echo $string;
fclose($f1);
fclose($f2);
fclose($f3);
$myfile = fopen("main.txt", "w") or die("Unable to open file! main.txt");
fwrite($myfile, $string);
fclose($myfile);
?>