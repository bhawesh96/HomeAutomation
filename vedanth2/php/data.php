<?php  

$handle = fopen("moisture.txt",'w+');
$handle1 = fopen("temp.txt",'w+');

//coming from PYTHON code
$msg = $_GET['moisture'];
$msg1 = $_GET['temperature'];

$string = $msg.$msg1;
echo $string;
fwrite($handle,$msg);
fwrite($handle1,$msg1);
fclose($handle);
fclose($handle1);


?>