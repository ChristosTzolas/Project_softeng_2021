<?php 
include 'conn.php';
$conn = OpenCon();

$it_id = &_POST["it_id"];
$it_vol_id = &_POST["it_vol_id"];
$mysql_qry = "select * from Itinerary where it_id = '$it_id' and it_vol_id = '$it_vol_id';";
// $result = mysqli_query($conn, $mysql_qry);
$result = $conn->query($mysql_qry);

if($result->num_rows>0){ //mysqli_num_rows($result)>0
    $row = mysqli_fetch_assoc($result);
    $it_id = $row["it_id"]
    echo "itinerary exists with id = ".$it_id;
}else {
    echo "itinerary doesn't exist";
}

CloseCon($conn);
?>