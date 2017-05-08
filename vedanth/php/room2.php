<?php

$msg = $_GET['light1'];
//$string = $msg." ".$msg1." ".$msg2." ".$msg3;
$string = $msg[1];
echo $msg;
$myfile = fopen("room2.txt", "w") or die("Unable to open file!");
fwrite($myfile, $string);
fclose($myfile);
include "main.php"
?>