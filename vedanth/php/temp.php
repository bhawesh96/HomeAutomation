<?php  
$file = "temp.txt";
$handle = fopen($file,'w+');

//coming from PYTHON code
$msg = $_GET['temperature'];

$string = $msg;
echo $msg;
fwrite($handle,$string);
fclose($handle);
include "db.php";

$sql = "UPDATE status SET temp='".$msg."'";

if (mysqli_query($conn, $sql)) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . mysqli_error($conn);
}
?>