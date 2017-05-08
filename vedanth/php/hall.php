<?php

$msg = $_GET['light1'];
$msg1 = $_GET['light2'];
$msg2 = $_GET['fan'];
$msg3 = $_GET['door'];
//$string = $msg." ".$msg1." ".$msg2." ".$msg3;
$string = $msg[1].$msg1[1].$msg2[1].$msg3[1];
echo $msg.$msg1.$msg2.$msg3;
$myfile = fopen("hall.txt", "w") or die("Unable to open file!");
fwrite($myfile, $string);
fclose($myfile);
include "main.php"
?>