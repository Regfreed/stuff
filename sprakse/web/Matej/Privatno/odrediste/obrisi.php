<?php
include_once "../../konfiguracija.php" ;
if(!isset($_SESSION["o"])){
    header("location: " . $putAPP . "logout.php");
}

if(!isset($_GET["id"])){
    header("location: " . $putAPP . "logout.php");
}




$query = $conn->prepare("delete from Odredište where id=:id");
$query->execute($_GET);
header("location: index.php");