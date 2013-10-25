<!DOCTYPE HTML>
<html>

<head>
<style>
	.error {color: #FF0000;}
</style>
</head>
<body>
<?php 
	initialise(); 	
	output_page(); 
?>
</body>
</html>

<?php

/**
 *  This is a program that will take two arguments:
 *		- a path to a directory on the hard disk
 *      - a file extension
 *  then search all directories under the specified path for files with that extension 
 *  and print their filenames to the screen.
 *
 *  This task is an practice for appropriate useing both iteration and recursion 
 *
 * @author Lisha
 * @version 4
 */
 
 	// define variables and set to empty values
	$pathErr = $extensionErr = "";
	$path = $extension = "";
 
/**
 * This is a function to prepare the posted form data before loading the page content
 * it also calls to function test_input
 */ 
function initialise(){
	global $pathErr, $extensionErr, $path, $extension;
	
	// define variables and set to empty values
	//$pathErr = $extensionErr = "";
	//$path = $extension = "";

	//if the form is submitted, scan the input data 
	if(isset($_GET['submit'])){	
		$path=$_GET["path"];
		$extension=$_GET["extension"];
		
		//1. check if any of the required fields empty, if yes, set error messages 
		if (empty($path) || empty($extension)){
			if (empty($path)){
				$pathErr = "Directory is required";
			}
			if (empty($extension)){
				$extensionErr = "extension is required";
			}
		}else{
			//2. prepare the input values 			
			$path = test_input($path);
			$extension = test_input($extension);
			
			//3 make sure the input directory for search hasn't got the "/" at the end
			if ($path[strlen($path)-1] == "/" )
			{
				// if it has a "/", take its sub string that removed the last charactor 
				$path = substr($path, 0, -1); 
			}
			
			//4 make sure that the input extension without the "." in front
			if ($extension[0] == "." ){
				// if it has a "." in front, take its sub string that removed the first charactor 
				$extension = substr($extension, 1);
			}
		}
	}
}

/**
 * This is a function for input data validation 
 * it is called by function initialise
 * @param string $data the input data for validation 
 * @return string $data the $data that after validation
 */
function test_input($data)
{
     $data = trim($data);
     $data = stripslashes($data);
     $data = htmlspecialchars($data);
     return $data;
}

/**
 * This is a function to output the page content
 * it also calls to function scan_Dir
 */
function output_page()
{
	global $path;
	global $extension;
	global $pathErr;
	global $extensionErr;

	?>
	<h2>Get files from specified file path and extension</h2>
	<p><span class="error">* required field.</span></p>
	<form method="GET" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
	   Directory: <input type="text" name="path" value="<?php echo $path;?>">
	   <span class="error">* <?php echo $pathErr;?></span>
	   <br><br>
	   Extension: <input type="text" name="extension" value="<?php echo $extension;?>">
	   <span class="error">* <?php echo $extensionErr;?></span>
	   <br><br>
	   <input type="submit" name="submit" value="Submit">
	</form>
	
	
	<?php
	echo '<p>The files in the directory of "'.$path.'" with file type of "'.$extension.'" are:</p>';
	scan_Dir($path, $extension);
}


/**
 * This is the main function that scan the input directory recursivly 
 * it is called by the function output_page
 * it also calls to function outputFileWithSelectedExtension
 *
 * @param string $path	a path for search
 * @param string $ectension the file extension for mathing with
 */
function scan_Dir($path, $extension) {
	//1. get the file name from the path
	//$path_parts['basename'] will return the file name with extension from the function pathinfo(path) 
	$path_parts = pathinfo($path);
	$itemFullName = $path_parts['basename'];

	//ignore . and .. files in directory
	if (($itemFullName==".")  ||  ($itemFullName=="..")){
		return;
	}
	// 2. check whether the item achieved from the path is a file or a directory, 
	if (is_file($path)){	
		//3.1 if it is a file, check if it match the required extension
		outputFileWithSelectedExtension($path, $extension);	
	
	}elseif (is_dir($path)) {	
		//3.2 if it is a directory, open it
		if ($handle = opendir($path)) {
			//if the directory is not empty, go through it one by one, 
			//and call to the function scan_Dir recursivly to scan each of them
			while (false !== ($item = readdir($handle))) {
				//set the new path to include the sub-directory item 
				$newpath = $path."/".$item;
				scan_Dir($newpath, $extension);
			}            
		}
		//close the directory when there is no more items 
		closedir($handle);
	} 
}


/**
 * This is the function to match any files with the given extension 
 * it is called by the function scan_Dir
 *
 * @param string $path	a path for search
 * @param string $ectension the file extension for mathing with
 */
function outputFileWithSelectedExtension($path, $extension){
	//1. get info of the file, check whether it has extension
	$path_parts = pathinfo($path); 
	if (array_key_exists('extension', $path_parts)){
		//2. if the file has an extension, check if it match the required one, output it if yes
		if($extension == $path_parts['extension']){
			echo $path."<br/>";
		}
	}
}

?>




