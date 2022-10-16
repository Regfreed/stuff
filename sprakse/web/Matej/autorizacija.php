<?php
if(!isset($_POST["userName"])){
    exit;
}

if($_POST["userName"]===""){
    header("location: login.php");
    exit;
}

if(($_POST["userName"]==="matej" && $_POST["pass"]==="pavic")
){
    //pusti dalje
    session_start();
    $_SESSION["o"]= $_POST["userName"];
    header("location: Privatno/kontrolnaPloca.php");
}else{
    header("location: login.php");
}