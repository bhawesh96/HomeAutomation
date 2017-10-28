<?php 

$host = "localhost";
$db_name = "HomeAutomation";
$user = "root";
$pass = "pass";

$conn = mysqli_connect($host, $user, $pass, $db_name);

// Check connection
if (mysqli_connect_errno())
	echo "Failed to connect to MySQL: " . mysqli_connect_error();

?>
