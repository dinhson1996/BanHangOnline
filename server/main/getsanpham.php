<?php
	include "connect.php";

	$page = $_GET['page'];
	$id_loaisp = $_POST['id_loaisp'];
	$space = 5;
	$limit = ($page - 1) * $space;

	$mangsanpham = array();

	$query = "SELECT * FROM tb_sanpham WHERE id_loaisp = $id_loaisp LIMIT $limit,$space";
	$data = mysqli_query($conn, $query);

	while ($row = mysqli_fetch_assoc($data)) {
		# code...
		array_push($mangsanpham, new Sanpham(
			$row['id_sanpham'],
			$row['ten_sanpham'],
			$row['gia_sanpham'],
			$row['anh_sanpham'],
			$row['mota_sanpham'],
			$row['id_loaisp']));
	}

	echo json_encode($mangsanpham);

	/**
	* 
	*/
	class Sanpham {
		
		function Sanpham($id_sanpham, $ten_sanpham, $gia_sanpham, $anh_sanpham, $mota_sanpham, $id_loaisp){
			# code...
			$this -> id_sanpham = $id_sanpham;
			$this -> ten_sanpham = $ten_sanpham;
			$this -> gia_sanpham = $gia_sanpham;
			$this -> anh_sanpham = $anh_sanpham;
			$this -> mota_sanpham = $mota_sanpham;
			$this -> id_loaisp = $id_loaisp;
			
		}
	}
?>