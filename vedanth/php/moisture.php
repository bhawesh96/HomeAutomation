<?php  
$file = "moisture.txt";
$handle = fopen($file,'w+');

//coming from PYTHON code
$msg = $_GET['moisture'];

$string = $msg;
echo $msg;
fwrite($handle,$string);
fclose($handle);


?>