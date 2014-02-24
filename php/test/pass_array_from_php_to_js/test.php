


<html>
<head>
<script type="text/javascript" src="javascript.js"> </script>
</head>
<body>
<?php
  $movies[0] = array("Bloodsport", "Kickboxer", "Cyborg", "Timecop", "Universal Soldier", "In Hell", "The Quest");
   $movies[1] = array("ffff", "hhh", "ttt", "Timecop", "Universal Soldier", "In Hell", "The Quest");
  
  $arr = json_encode($movies);
  
  echo '<a onclick="showDiv('.$arr.', \'aaaa\')">show</a><br />';
 // echo "<a onclick='showDiv($arr, \"aaaa\")'>show</a><br />";
?>



</body>
</html> 