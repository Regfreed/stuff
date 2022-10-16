<?php

/* 3 param string, no return value, active color */
function stavkaIzbornika($putAPP, $stranica, $oznaka){
    ?>
    <li<?php
    if ($putAPP . $stranica == $_SERVER["PHP_SELF"]){
        echo " class=\"active\"";
    }
    ?>><a href="<?php echo $putAPP . $stranica; ?>"><?php echo $oznaka;  ?></i></a></li>
    <?php
}