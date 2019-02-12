package object services {

  sealed trait CustomException extends Exception

  case class InvalidUser() extends CustomException

  case class UserNotStartsWithA() extends CustomException
}
