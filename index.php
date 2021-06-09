<?php
include 'conn.php';
$conn = OpenCon();
echo "Connected Successfully";
CloseCon($conn);
?>