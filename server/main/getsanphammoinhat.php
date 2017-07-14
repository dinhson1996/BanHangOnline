<?php
	include "connect.php";
	$mangspmoinhat = array();
	$query = "SELECT * FROM tb_sanpham ORDER BY ID_SANPHAM DESC LIMIT 6";

	$data = mysqli_query($conn,$query);
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangspmoinhat,new Sanphammoinhat(
			$row['id_sanpham'],
			$row['ten_sanpham'],
			$row['gia_sanpham'],
			$row['anh_sanpham'],
			$row['mota_sanpham'],
			$row['id_loaisp']));	
	}
	echo json_encode($mangspmoinhat);

	class Sanphammoinhat{
		function Sanphammoinhat($id_sanpham,$ten_sanpham,$gia_sanpham,$anh_sanpham,$mota_sanpham,$id_loaisp){
			$this->id_sanpham = $id_sanpham;
			$this->ten_sanpham = $ten_sanpham;
			$this->gia_sanpham = $gia_sanpham;
			$this->anh_sanpham = $anh_sanpham;
			$this->mota_sanpham = $mota_sanpham;
			$this->id_loaisp = $id_loaisp;
		}
	}
?>