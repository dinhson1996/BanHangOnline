<?php
	$host = "localhost";
	$username = "root";
	$password = "";
	$database = "db_shop";

	$conn = mysqli_connect($host, $username, $password, $database);
	mysqli_query($conn, "SET NAMES 'utf-8'");
	// if ($conn) {
	// 	# code...
	// 	echo "Connect Successfuly....";
	// }else{
	// 	echo "Connect Fail !!!!!!!!";
	// }
?>