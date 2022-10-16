<?php include_once "../../konfiguracija.php" ;
if(!isset($_SESSION["o"])){
header('location:'.$putAPP.'odjava.php');
}
if(isset($_POST["add"])){
    $query = $conn->prepare("insert into Odredište(Naziv, Adresa) values
                            (:Naziv, :Adresa)");
    unset($_POST["add"]);
    $query->execute($_POST);
    header("location: index.php");
}
?>
<!doctype html>
<html>
<head>
    <?php include_once "../../Predlozak/zaglavlje.php" ?>
</head>

<body>
<?php include_once "../../Predlozak/izbornik.php" ?>

<div class="grid-container">
    <div class="grid-x" style="justify-content:center;">
        <div class="cell medium-4 large-3">
            <form method="post" action="<?php echo $_SERVER["PHP_SELF"];?>">
                <h4 class="text-center">Novo odredište</h4>
                <label>Naziv
                    <input type="text"  name="Naziv">
                </label>
                <label>Adresa
                    <input type="text" name="Adresa" >
                </label>
                <br>
                <button type="submit" name="add" class="button">
                    <i class="fas fa-2x fa-plus-square"></i>
                </button>
                <a href="index.php" class="alert button"><i class="fas fa-2x fa-ban"></i></a>
            </form>
        </div>
    </div>
</div>

<?php include_once "../../Predlozak/podnozje.php" ?>
<?php include_once "../../Predlozak/skripte.php" ?>
</body>



</html>
