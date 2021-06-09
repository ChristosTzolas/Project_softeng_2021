<?php
include 'conn.php';
$conn = OpenCon();

$it_vol_id = &_POST["it_vol_id"];
$date_and_time = &_POST["date_and_time"];
$location = &_POST["location"];
$to_or_from = &_POST["to_or_from"];
$num_seats = &_POST["num_seats"];
$mysql_qry = "INSERT INTO Itinerary(it_vol_id,date_and_time, location, to_or_from, num_seats) values ('$it_vol_id','$date_and_time','$location','$to_or_from','$num_seats') ";
// $result = mysqli_query($conn, $mysql_qry);
// $result = $conn->query($mysql_qry);

if($conn->query($mysql_qry) === TRUE){ //mysqli_num_rows($result)>0
    echo "Insert Successful";
}else {
    echo "Error ".$mysql_qry."<br>".$conn->error;
}

CloseCon($conn);



?>