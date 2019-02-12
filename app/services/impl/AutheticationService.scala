package services.impl

import models.{Credentials, User}
import services._

import scala.concurrent.Future
import cats.data.EitherT
import cats.implicits._


class AutheticationService {

  def authenticate(credentials: Credentials): EitherT[Future,CustomException,User] = {
    credentials match {
      case c if c.userNameInUpperCase == c.password => EitherT.rightT[Future,CustomException](User(c.username))
      case _ => EitherT.leftT[Future,User](InvalidUser())
    }
  }
}
