<?php
	include "connect.php";

	$json = $_POST['json'];
	$data = json_decode($json, true);

	foreach ($data as $value) {
		# code...
		$id_donhang = $value['id_donhang'];
		$id_sanpham = $value['id_sanpham'];
		$ten_sanpham = $value['ten_sanpham'];
		$gia_sanpham = $value['gia_sanpham'];
		$soluong_sanpham = $value['soluong_sanpham'];

		$query = "INSERT INTO tb_chitietdonhang (id_chitiet, id_donhang, id_sanpham, ten_sanpham, gia_sanpham, soluong_sanpham) VALUES (null, '$id_donhang', '$id_sanpham', '$ten_sanpham', '$gia_sanpham', '$soluong_sanpham')";

		$Dta = mysqli_query($conn, $query);
	}
	if ($Dta) {
		# code...
		echo "1";
	}else{
		echo "0";
	}
?>