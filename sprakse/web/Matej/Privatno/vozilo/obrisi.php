<?php
include_once "../../konfiguracija.php" ;
if(!isset($_SESSION["o"])){
    header("location: " . $putAPP . "odjava.php");
}

if(!isset($_GET["id"])){
    header("location: " . $putAPP . "odjava.php");
}




$query = $conn->prepare("delete from Vozilo where id=:id");
$query->execute($_GET);
header("location: index.php");