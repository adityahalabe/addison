package models

/**
  * Created by deepak.
  */
case class Credentials(username: String, password: String){
  def userNameInUpperCase = username.toUpperCase
}

