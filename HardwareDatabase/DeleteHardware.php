<?php
$id="";
if(isset($_POST['deletedProductID'])&&$_POST['deletedProductID']!=""){
	$id=$_POST['deletedProductID'];
}
$connect=mysqli_connect("localhost", "Batch63User", "Batch632022.","","3306","MySQL");
	if($connect){
		echo "database connected";
	}else{
		echo "connectionfailed";
	}
	$usedatabase=mysqli_query($connect,"use Batch63");
	if($usedatabase){
		echo "Query Success";
	}else{
		echo "Query Failed";
	}
	$deletefrom=mysqli_query($connect, "Delete from hardware where ProductID='$id'");
	if($deletefrom){
		echo "Data has been removed.";
		header("Location: HardwareWarhouse.php");
	}else{
		echo "Data has not been removed.";
	}
?>