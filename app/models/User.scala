package models

/**
  * Created by deepak.
  */
case class User(userId: String) {
  def isStartsWithA : Boolean = userId.startsWith("A")
}

