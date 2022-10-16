<?php
include_once "../../konfiguracija.php";
if(!isset($_SESSION["o"])){
    header('location:'.$putAPP.'odjava.php');
}
if(!isset($_GET["Id"]) && !isset($_POST["change"])){
    header('location:'.$putAPP.'odjava.php');
}
if(isset($_POST["change"])){
    $query = $conn->prepare("update Vozac set Ime=:Ime, Prezime=:Prezime where Id=:Id;");
    unset($_POST["change"]);
    $query->execute($_POST);
    header("location: index.php");
}else{
    $query = $conn->prepare("select * from Prezime where Id=:Id");
    $query->execute($_GET);
    $result = $query->fetch(PDO::FETCH_OBJ);
}
?>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>

    <?php include_once "../../predlozak/zaglavlje.php"; ?>
</head>
<body>

<?php include_once "../../predlozak/izbornik.php"; ?><br>
<!-- Form for creating new  -->
<div class="grid-container">
    <div class="grid-x" style="justify-content:center;">
        <div class="cell medium-4 large-3">
            <form method="post" action="<?php echo $_SERVER["PHP_SELF"];?>">
                <h4 class="text-center">Promjeni korisnika</h4>
                <label>Ime
                    <input value="<?php echo $result->Ime;?>" type="text"  name="Ime">
                </label>
                <label>Prezime
                    <input value="<?php echo $result->Prezime;?>" type="Text"  name="Prezime" >
                </label>
                <br>
                <input type="hidden" name="Id" value="<?php echo $result->Id ?>" />
                <button type="submit" name="change" class="button">
                    <i class="fas fa-2x fa-plus-square"></i>
                </button>
                <a href="index.php" class="alert button"><i class="fas fa-2x fa-ban"></i></a>
            </form>
        </div>
    </div>
</div>
<?php include_once "../../predlozak/skripte.php"; ?>

<?php include_once "../../predlozak/podnozje.php"; ?>

</body>
</html>