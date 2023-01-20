<!DOCTYPE html>
<html>
<head>
<title>Current Hardware</title>
</head>
<body>
<form class="FormClass" action="HardwareWarehouse.php" method="post">
	Product ID:<input type="text" class="productid" name="ProductID"></input><br>
	Product Name:<input type="text" class="productname" name="ProductName"></input><br>
	Product Price:<input type="text" class="productprice" name="ProductPrice"></input><br>
	<button  class="submitbutton" onclick="submitform()">Insert Product</button>
</form>
<script>
	function submitform(){
		if(document.getElementByClassName("productid").value!=""&&document.getElementByClassName("productname").value!=""&&
		document.getElementByClassName("productprice").value!=""){
			document.getElementByClassName("FormClass").submit();
		}else{
			alert("No fields can be blank.");
		}
	}

</script>
<?php
	class HardwareProduct{
		public $id;
		public $name;
		public $price;
		public function __construct($id,$name,$price){
				$this->$id=$id;
				$this->$name=$name;
				$this->$price=$price;
		}
		function getid(){
			return $this->id;
		}
		function setid($newid){
			$this->id=$newid;
		}
		function getname(){
			return $this->name;
		}
		function setname($newname){
			$this->name=$newname;
		}
		function getprice(){
			return $this->price;
		}
		function setprice($newprice){
			$this->price=$newprice;
		}
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
	$hardwareProduct=new HardwareProduct("","","");
	if(isset($_POST["ProductID"])&&$_POST["ProductID"]!=""){
		$hardwareProduct->setid($_POST["ProductID"]);
	}
	if(isset($_POST["ProductName"])&&$_POST["ProductName"]!=""){
		$hardwareProduct->setname($_POST["ProductName"]);
	}
	if(isset($_POST["ProductPrice"])&&$_POST["ProductPrice"]!=""){
		$hardwareProduct->setprice($_POST["ProductPrice"]);
	}
	$id=$hardwareProduct->getid();
	$name=$hardwareProduct->getname();
	$price=$hardwareProduct->getprice();
	$insertinto=mysqli_query($connect, "Insert into hardware(ProductID, ProductName, ProductPrice)values('$id','$name','$price');");
	if($insertinto){
		echo "Data has been entered.";
	}else{
		echo "Data has not been entered.";
	}
	$hardware=mysqli_query($connect, "Select * from hardware");
	$count=0;
	while($row=mysqli_fetch_array($hardware)){
		$hardwareid=$row['ProductID'];
		$count+=1;
		echo '<div>',
		'<p>',"Product ID:",$row['ProductID'],'</p>',
		'<p>',"Product Name:",$row['ProductName'],'</p>',
		'<p>',"Product Price:$",$row['ProductPrice'],'</p>',
		'<button id="'.$count.'" onclick="deleteProduct(this.id)" value="'.$hardwareid.'">',"Delete",'</button>',
		'</div>';
	}
	
?>
<form class="deleteform" action="DeleteHardware.php" method="post" hidden>
	<input type="text" class="deletedproductid" name="deletedProductID"></input><br>
</form>
<script>
	function deleteProduct(clicked_id){
		document.getElementByClassName("deletedproductid").setAttribute("value",document.getElementById(clicked_id).value);
		alert(document.getElementById(clicked_id).value);
		document.getElementByClassName("deleteform").submit();
	}
		
</script>
</body>
</html>