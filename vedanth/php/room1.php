<?php

$msg = $_GET['light1'];
//$string = $msg." ".$msg1." ".$msg2." ".$msg3;
$string = $msg[1];
echo $msg;
$myfile = fopen("room1.txt", "w") or die("Unable to open file Room1.txt!");
fwrite($myfile, $string);
fclose($myfile);
include "main.php";
include "db.php";

$sql = "UPDATE status SET device1='".$msg."'";

if (mysqli_query($conn, $sql)) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . mysqli_error($conn);
}

?>