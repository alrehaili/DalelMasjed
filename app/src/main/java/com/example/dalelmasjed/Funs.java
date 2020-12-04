package com.example.dalelmasjed;

public class Funs {

/*




    public function addComment($MasjedId , $Note)
    {

        $stmt = $this->conn->prepare("INSERT INTO Comment VALUES(null , ? , ?);
        $stmt->bind_param("ss", $MasjedId , $Note ) ;
        $result = $stmt->execute();
        $stmt->close();

        if ($result)
        {
            return true;
        }
        else
        {
        return false;
        }

    }

    public function getComment($MasjedId)
{

    $stmt = $this->conn->prepare("SELECT * from Comment where MasjedId =? ");

    $stmt->bind_param("s", $MasjedId);
    if ($stmt->execute())
     {
        $user= array();
        $result=$stmt->get_result();
        while($row = $result->fetch_assoc()) {
            $user[] = $row;
        }
        $stmt->close();

        return $user;
}
}





 */
}
