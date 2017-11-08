<?php

session.start();
echo "<script>alert($_SESSION['name'];)</script>";
include "db.php";

$name = $_POST['name'];
$phone = $_POST['phone'];
$email = $_POST['email'];
$password = $_POST['password'];

 // echo $name . $phone . $email . $password;

$sql = "INSERT INTO signup (name, phone, email, password) VALUES ('$name', '$phone', '$email' ,'$password')";         
// echo $sql;
//this error will occur if user already registered because email is UNIQUE
if(!mysqli_query($conn, $sql))
{
    mysqli_close($conn);
    alert('user already exists');
    echo "<script>window.location.href='http://localhost/ITTLab/HomeAutomation/vedanth/signup.html'</script>";

}
else {
    mysqli_close($conn);
    echo "<script>window.location.href='http://localhost/ITTLab/HomeAutomation/vedanth/login.html'</script>";
}
?>