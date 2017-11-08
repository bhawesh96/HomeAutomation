<?php 

// echo "Welcome to Home Automation System";
include "db.php";

$sql = "SELECT * FROM status";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) > 0) {
    // output data of each row
    while($row = mysqli_fetch_assoc($result)) {
        echo $row["device1"]."@".$row["device2"]."@".$row["device3"]."@".$row["device4"]."@".$row["door"]."@".$row["fan"]."@".$row["temp"]."@".$row["moisture"]."@".$row["soil"];
    }
} else {
    echo "0 results";
}

 ?>