<!DOCTYPE HTML>
<html>
    <!-- Bootstrap -->
    <link href="../includes/bootstrap-3.0.1-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <style>
                .error {color: #FF0000;}
        </style>
        <script src="../includes/js/sortingTable/sorttable.js"></script>
</head>
<body>
<div class="container">
        <div class="page-header">
                <h1>Get files from specified file path and extension</h1>
        </div><!-- end of page-header -->
<?php
        /**
         * This is a program that will take two arguments:
* - a path to a directory on the hard disk
         * - a file extension
         * then search all directories under the specified path for files with that extension
         * and print their filenames to the screen.
         *
         * This task is an practice for appropriate useing both iteration and recursion
         *
         * @author Lisha
         * @version 4
         */
 
         // define variables and set to empty values
        $path = $extension = "";
        $err = array("pathErr"=>"", "extensionErr"=>"");
        $matchedFiles = array();  // this will be an array of array("filename"=>"", "path"=>"", "filesize"=>"", "dateModified"=>""));

        //prepare data
        initialise($err, $path, $extension);         
        
        //out put the user input form for the required info (directory and extension)
        outputUserInputForm($path, $extension, $err, $matchedFiles);
                
        //process the user input
        scanDirectory($path, $extension, $matchedFiles);
        
        //dispaly the matched files in a table
        displayMatchedFiles($matchedFiles);        
?>
</div><!-- end of container -->
</body>
</html>

<?php

/**
* This is a function to output the page content
* it also calls to functions scanDirectory, htmlForm, and displayMatchedFiles
*/
function outputUserInputForm(&$path, &$extension, &$err, &$matchedFiles)
{
       // global $path, $extension, $err, $matchedFiles;        
        
        $method = "GET";
        $action = htmlspecialchars($_SERVER["PHP_SELF"]);

        //prepare the form fields for user input
        $formFields = array();
        $formFields[] = array("labelText"=>"Directory", "type"=>"text", "name"=>"path", "id"=>"path", "value"=>$path, "class"=>"error", "errMessage"=>$err["pathErr"]);
        $formFields[] = array("labelText"=>"Extension", "type"=>"text", "name"=>"extension", "id"=>"extension", "value"=>$extension, "class"=>"error", "errMessage"=>$err["extensionErr"]);
        
        //prepare the page content - call to the hemlForm function to display the form section
        //$content = '<h2>Get files from specified file path and extension</h2>';

        $content = htmlForm($method, $action, $formFields);
        
        //output the content
        echo $content;

}

/**
* This is the function that output the form section
* it is called by the function outputUserInputForm
*
* @param string $method        the method that used for post the form
* @param string $action        where the form post to
* @param string $formFields         the array that contains all the form fields data
* @return string $form         the html form data
*/
function htmlForm($method, $action, $formFields){
        $form = '<form method="'.$method.'" action="'.$action.'" class="well form-horizontal" role="form">'."\n";
        
                $form .= '<p><span class="error">* required field.</span></p>';
        foreach ($formFields as $formField){
                $form .= '<div class="form-group">';
                $form .= '<label for="'.$formField["name"].'" class="col-sm-2 control-label">'.$formField["labelText"].'</label>'."\n";
                $form .= '<div class="col-sm-10"><input type="'.$formField["type"].'" name="'.$formField["name"].'" id="'.$formField["id"].'" value="'.$formField["value"].'" /><span class="'.$formField["class"].'" > * '.$formField["errMessage"].'</span></div>'."\n";
                $form .= '</div>';
        }        
        
        $form .= '<div class="form-group">';
        $form .= '<div class="col-sm-offset-2 col-sm-10"><input class="btn btn-primary" type="submit" name="submit" value="Submit"></div>'."\n";
        $form .= '</div>';
        $form .= '</form>';
        $form .= '<br/><br/>';
        return $form;        
}



/**
* This is the main function that scan the input directory recursivly
* it is called by the function outputUserInputForm
* it also calls to function outputFileWithSelectedExtension
*
* @param string $path        a path for search
* @param string $ectension the file extension for mathing with
*/
function scanDirectory($path, $extension, &$matchedFiles) {
        //1. get the file name from the path
        //$pathParts['basename'] will return the file name with extension from the function pathinfo(path)
        $pathParts = pathinfo($path);
        $itemFullName = $pathParts['basename'];

        //ignore . and .. files in directory
        if (($itemFullName==".") || ($itemFullName=="..")){
                //echo "dotOrDotDot";
                return;
        }
        // 2. check whether the item achieved from the path is a file or a directory,
        if (is_file($path)){        
                //3.1 if it is a file, check if it match the required extension
                //outputFileWithSelectedExtension($path, $extension);        
                
                getFilesWithSelectedExtension($path, $extension, $matchedFiles);
        
        }elseif (is_dir($path)) {        
                
                //3.2 if it is a directory, open it
                if ($handle = opendir($path)) {
                        //if the directory is not empty, go through it one by one,
                        //and call to the function scanDirectory recursivly to scan each of them
                        while (false !== ($item = readdir($handle))) {
                                //set the new path to include the sub-directory item
                                $newpath = $path."/".$item;
                                scanDirectory($newpath, $extension, $matchedFiles );
                        }
                }
                //close the directory when there is no more items
                closedir($handle);
                
        }
}

/**
* This is the function to collect all files with the specified extension within the specified path
* it is called by the function scanDirectory
*
* @param string $path        a path for search
* @param string $ectension the file extension for mathing with
* @return array $matchedFiles an array for the matched files
*/
function getFilesWithSelectedExtension($path, $extension, &$matchedFiles){
        //global $matchedFiles;
        //1. get info of the file, check whether it has extension
        $pathParts = pathinfo($path);
        if (array_key_exists('extension', $pathParts)){
                //2. if the file has an extension, check if it match the required one, collect it into the array if yes
                if($extension == $pathParts['extension']){
                        //if matched, collect the required file info, stores them in an array
                        $fileName = $pathParts['filename'];
                        $filePath = $pathParts['dirname'];
                        $fileSize = filesize($path);
                        $fileDate = date("m/d/Y", filemtime($path));

                        $matchedFiles[] = array("filename"=>$fileName, "path"=>$filePath, "filesize"=>$fileSize, "dateModified"=>$fileDate);
                }
        }
        

}


/**
* This is the function to match any files with the given extension
* it is called by the function scanDirectory
*
* @param string $path        a path for search
* @param string $ectension the file extension for mathing with
*/
function outputFileWithSelectedExtension($path, $extension){
        //1. get info of the file, check whether it has extension
        $pathParts = pathinfo($path);
        if (array_key_exists('extension', $pathParts)){
                //2. if the file has an extension, check if it match the required one, output it if yes
                if($extension == $pathParts['extension']){
                        echo $path."<br/>";
                }
        }
}

/**
* This is a function to prepare the posted form data before loading the page content
* it also calls to function prepareInput
*/
function initialise(&$err, &$path, &$extension){
       // global $err, $path, $extension;
        
        //if the form is submitted, scan the input data
        if(isset($_GET['submit'])){        
                $path=@$_GET["path"];
                $extension=@$_GET["extension"];
                
                //1. check if any of the required fields empty, if yes, set error messages
                if (empty($path) || empty($extension)){
                        if (empty($path)){
                                $err["pathErr"] = "Directory is required";
                        }
                        if (empty($extension)){
                                $err["extensionErr"] = "extension is required";
                        }
                }else{
                        //2. prepare the input values khhh                        
                        $path = prepareInput($path);
                        $extension = prepareInput($extension);
                        
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
function prepareInput($data)
{
     $data = trim($data);
     $data = stripslashes($data);
     $data = htmlspecialchars($data);
     return $data;
}

/**
* This is a function for output the matched files in a table
* it is called by function outputUserInputForm
* @param array $matchedFiles list of matched files with file info
*
*/
function displayMatchedFiles($matchedFiles){

        $output = '<div class="panel panel-default">';        
        $output .= '<div class="panel-heading">The files under the directory with the matching extension are:</div>';

        $output .= '<table class="table sortable">';
        $output .= '<tr>';
        $output .= '<th>File Name</th>';
        $output .= '<th>File Path</th>';
        $output .= '<th>File Size in Bytes</th>';
        $output .= '<th>File Last Modify Date</th>';
        $output .= '</tr>';
        
        foreach ($matchedFiles as $matchedFile){
                $output .= '<tr>';
                $output .= '<td>'.$matchedFile["filename"].'</td>';
                $output .= '<td>'.$matchedFile["path"].'</td>';
                $output .= '<td>'.$matchedFile["filesize"].'</td>';
                $output .= '<td>'.$matchedFile["dateModified"].'</td>';
                $output .= '</tr>';        
        }
        $output .= '</table>';        
        $output .= '</div>';
        echo $output;
}



/**
 * Sort a 2 dimensional array 
 * 
 * @param 	array        				$array      		The array to sort.
 * @param	 	string|array 			$key        		The index(es) to sort the array on.
 * 
 * @return 	array 					The sorted array.
 */
function msort($array, $key) {
	if (is_array($array) && count($array) > 0) {
	        if (!empty($key)) {
	        	$mapping = array();
	        	
	        	// 1. get the sorting fields into a new array with its initial array key, 
            		foreach ($array as $k => $v) {
                                $mapping[$k] = $v[$key];
	           	 }
	           	 
	           	 // 2. sort the array against the required sorting field
	           	 asort($mapping);
	           	 
	           	 // 3. rearrange the initial array with the sorted order of keys
	            	$sorted = array();
	           	 foreach ($mapping as $k => $v) {
	               		 $sorted[] = $array[$k];
	          	 }
	           	 return $sorted;
		}
   	}
  	return $array;
}


$sortedfiles =  msort($matchedFiles, 'filesize');

var_dump($sortedfiles);




?>