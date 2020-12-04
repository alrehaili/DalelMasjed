package com.example.dalelmasjed.helper;

public class WebServices {


    public static String URL_GetMasjed = "https://madinahhost2020.com/DalelMasjed/API/GetMasjed.php";
    public static String URL_Addcomment="https://madinahhost2020.com/DalelMasjed/API/AddComment.php";
    public static String URL_Getcomment = "https://madinahhost2020.com/DalelMasjed/API/getcomment.php";
}

// AddComment.php
/*

<?php

require_once 'include/DB_Functions.php';
$db = new DB_Functions();

// json response array
$response = array("error" => FALSE);


if (isset($_POST['MasjedId'])  && isset($_POST['Note']))
{

    // receiving the post params
    $MasjedId= $_POST['MasjedId'];
    $Note=$_POST['Note'];


        $user = $db->addComment($MasjedId  , $Note);
        if ($user)
         {
            // user stored successfully
            $response["error"] = FALSE;
            $response["error_msga"] = "Your Comment Has Been Added";
            echo json_encode($response);
        }
        else {
            // user failed to update
            $response["error"] = TRUE;
            $response["error_msg"] = "There is Error With inserting Your Data !";
            echo json_encode($response);
        }
    }
    else
    {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters is missing!";
    echo json_encode($response);
}
?>



 */



// getcomment.php

/*



<?php
require_once 'include/DB_Functions.php';
$db = new DB_Functions();

// json response array
$response = array("error" => FALSE);

if (isset($_POST['MasjedId']))
{

    // receiving the post params
    $MasjedId= $_POST['MasjedId'];

    // get shops by type
    $comment = $db->getComment($MasjedId);

    if ($comment)
     {
        // use is found
        $response["error"] = FALSE;
        $response["Comment"]= $comment;


        echo json_encode($response);
    } else {
        // user is not found with the credentials
        $response["error"] = TRUE;
        $response["error_msg"] = " Wrong No Comment Yet!";
        echo json_encode($response);
    }
} else {
    // required post params is missing
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameters Post Id is missing!";
    echo json_encode($response);
}

?>




 */