<?php
	include "connect.php";
	$ten_khachhang = $_POST['ten_khachhang']; //"admin";
	$sodienthoai_khachhang = $_POST['sodienthoai_khachhang']; //"0972297198";
	$email_khachhang = $_POST['email_khachhang']; //"admin@gmail.com";
	if (strlen($ten_khachhang) > 0 && strlen($sodienthoai_khachhang) > 0 && strlen($email_khachhang) > 0) {
		# code...
		$query = "INSERT INTO tb_donhang(id_donhang, ten_khachhang, sodienthoai_khachhang, email_khachhang) VALUES (null, '$ten_khachhang', '$sodienthoai_khachhang', '$email_khachhang
		')"; 
		if (mysqli_query($conn, $query)) {
			# code...
			$id_donhang = $conn ->insert_id;
			echo $id_donhang;
		}else{
			echo "Thêm dơn hàng thất bại";
		}
	}else{
		echo "Bạn  hãy kiểm tra lại các dữ liệu";
	}
?>