<div class="top-bar">
    <div class="top-bar-left">
        <ul class="dropdown menu" data-dropdown-menu>
            <?php
            stavkaIzbornika($putAPP,"index.php","<i class=\"fas fa-2x fa-home\"></i>");
            stavkaIzbornika($putAPP,"onama.php","O nama");
            stavkaIzbornika($putAPP,"kontakt.php","Kontakt");

            if(isset($_SESSION["o"])):
                stavkaIzbornika($putAPP,"Privatno/kontrolnaPloca.php","Kontrolna Ploča");
                ?>
                <li>
                    <a href="#"><i class="fas  fa-edit"></i></a>
                    <ul class="menu vertical">
                        <li><a href="<?php echo $putAPP.'Privatno/odrediste/index.php'?>">Odrediste</a></li>
                        <li><a href="<?php echo $putAPP.'Privatno/teret/index.php'?>">Teret</a></li>
                        <li><a href="<?php echo $putAPP.'Privatno/vozac/index.php'?>">Vozač</a></li>
                        <li><a href="<?php echo $putAPP.'Privatno/vozilo/index.php'?>">Vozilo</a></li>
                    </ul>
                </li>
            <?php endif; ?>
        </ul>

    </div>
    <div class="top-bar-right">
        <div class="top-bar-right">
            <ul class="menu">
                <?php
                if(isset($_SESSION["o"]))
                {
                    echo "<li><a href='$putAPP/odjava.php'>Odjava</a></li>";
                }
                else
                {
                    echo "<li><a href='$putAPP/prijava.php'>Prijava</li>";
                }
                ?>
            </ul>
        </div>

    </div>
</div>
