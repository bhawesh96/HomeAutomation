<?php

include "db.php";

$email = $_POST['email'];
$enteredPassword = $_POST['password'];
$password = "";
$sql = "SELECT * FROM signup WHERE email = '{$email}'";
$result = mysqli_query($conn, $sql);

if(mysqli_num_rows($result) > 0) {
     while($row = mysqli_fetch_assoc($result)) {
        $password = $row['password'];
    }
    if($password == $enteredPassword) {
    	mysqli_close($conn);
    	echo "<script>window.location.href='http://localhost/ITTLab/HomeAutomation/vedanth/index.html'</script>";
    }
    else {
    	mysqli_close($conn);
    	echo "<script>alert('incorrectss password')</script>";
    	echo "<script>window.location.href='http://localhost/ITTLab/HomeAutomation/vedanth/login.html'</script>";
    }
  }
  else {
    	mysqli_close($conn);
    	echo "<script>alert('incorrect password')</script>";
    	echo "<script>window.location.href='http://localhost/ITTLab/HomeAutomation/vedanth/login.html'</script>";
    }
?>