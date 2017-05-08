<?php  
$file = "soil.txt";
$handle = fopen($file,'w+');

//coming from PYTHON code
$msg = $_GET['soildata'];

$string = $msg;
echo $msg;
fwrite($handle,$string);
fclose($handle);


?>