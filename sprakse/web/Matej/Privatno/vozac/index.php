<?php include_once "../../konfiguracija.php" ?>

<!doctype html>
<html>
<head>
    <?php include_once "../../Predlozak/zaglavlje.php" ?>
</head>

<body>
<?php include_once "../../Predlozak/izbornik.php" ?>

<?php
$query =  $conn->prepare("select * from Vozac ;");
$query->execute();
$result = $query->fetchAll(PDO::FETCH_OBJ);
?>

<div class="grid-container">
    <h3>Vozač</h3><hr>
    <a href="novi.php" class="button"><i class="fas fa-plus-square"></i></a>
    <div class="grid-x grid-margin-x">
        <table class="unstriped">
            <thead>
            <tr style="color:#000000;">
                <th>Ime</th>
                <th>prezime</th>

            </tr>
            </thead>
            <tbody>
            <?php foreach($result as $row): ?>
                <tr>
                    <td><?php echo $row->Ime; ?></td>
                    <td><?php echo $row->Prezime; ?></td>
                    <td>
                        <a onclick="return confirm('Jeste li sigurni brisati= -><?php echo $row->Ime; ?>?')" href="obrisi.php?id=<?php echo $row->Id; ?>">
                            Obrisi
                        </a>
                        <a href="izmjena.php?Id=<?php echo $row->Id; ?>">Izmjena</a>
                    </td>
                </tr>
            <?php endforeach; ?>
            </tbody>
        </table>
    </div>
</div>

<?php include_once "../../Predlozak/podnozje.php" ?>
<?php include_once "../../Predlozak/skripte.php" ?>
</body>



</html>