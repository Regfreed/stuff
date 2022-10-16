<?php
session_start();
include_once "funkcija.php";
$nazivAPP="Logistika prijevoza";

switch($_SERVER["HTTP_HOST"]){
    case "localhost":
        $putAPP="/Matej/";
        $conn = new PDO("mysql:host=localhost;dbname=Baza1", "matej", "pavic");
        $conn->exec("set names utf8");
        break;
    case "":
        $putAPP="/Matej/";


        break;
}


