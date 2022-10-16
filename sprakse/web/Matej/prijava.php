<?php include_once "konfiguracija.php" ?>
<!doctype html>
<html>
<head>
    <?php include_once "Predlozak/zaglavlje.php" ?>
</head>

<body>
<?php include_once "Predlozak/izbornik.php" ?>


<form class="callout text-center"  class="small-4 cell" action="autorizacija.php" method="post">
    <h2>Prijavi se</h2>
    <div class="floated-label-wrapper">
        <label for="userName">Full name</label>
        <input type="text" id="userName" name="userName" placeholder="matej">
    </div>

    <div class="floated-label-wrapper">
        <label for="pass">Password</label>
        <input type="password" id="pass" name="pass" placeholder="pavic">
    </div>
    <input class="button expanded" type="submit" value="Sign up">
</form>

<?php include_once "Predlozak/podnozje.php" ?>
<?php include_once "Predlozak/skripte.php" ?>
</body>



</html>