<?php
	/**
	* 
	*/
	include "connect.php";

	$query = "SELECT * FROM tb_loaisp";
	$data = mysqli_query($conn, $query);
	$array_loaisp = array();

	while ($row = mysqli_fetch_assoc($data)) {
		# code...
		array_push($array_loaisp, new Loaisp(
			$row['id_loaisp'],
			$row['ten_loaisp'],
			$row['anh_loaisp'])
		);
	}

	echo json_encode($array_loaisp);

	class Loaisp {
		
		function Loaisp($id_loaisp, $ten_loaisp, $anh_loaisp){
			# code...
			$this -> id_loaisp = $id_loaisp;
			$this -> ten_loaisp = $ten_loaisp;
			$this -> anh_loaisp = $anh_loaisp;
		}
	}
?>