<?php
	$host = "localhost";
	$username = "root";
	$password = "";
	$database = "db_shop";

<<<<<<< HEAD
	$conn = mysqli_connect($host,$username,$password,$database);
	mysqli_query($conn, "SET NAMES 'utf8'");
?>
=======
	$conn = mysqli_connect($host, $username, $password, $database);
	mysqli_query($conn, "SET NAMES 'utf-8'");
	// if ($conn) {
	// 	# code...
	// 	echo "Connect Successfuly....";
	// }else{
	// 	echo "Connect Fail !!!!!!!!";
	// }
?>
>>>>>>> 7f87c3cfeb28e784e5c0e9683551402dbf028001
