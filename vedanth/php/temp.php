<?php  
$file = "temp.txt";
$handle = fopen($file,'w+');

//coming from PYTHON code
$msg = $_GET['temperature'];

$string = $msg;
echo $msg;
fwrite($handle,$string);
fclose($handle);


?>