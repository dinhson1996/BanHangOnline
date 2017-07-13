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
		function Sanphammoinhat($id,$tensp,$giasp,$hinhanhsp,$motasp,$idsanpham){
			$this->id=$id;
			$this->tensp=$tensp;
			$this->giasp=$giasp;
			$this->hinhanhsp=$hinhanhsp;
			$this->motasp=$motasp;
			$this->idsanpham=$idsanpham;
		}
	}
?>