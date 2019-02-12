package services.impl

import java.util.Calendar
import cats.data.EitherT
import cats.implicits._
import models.{User, UserToken}
import services._

import scala.concurrent.Future

class TokenService {

  private def getTimeInFormat = Calendar.getInstance().getTime.toString

  def issueToken(user: User): EitherT[Future,CustomException,UserToken] = {
    user match {
      case u if u.isStartsWithA => EitherT.rightT[Future,CustomException](UserToken(s"${u.userId}_${getTimeInFormat}"))
      case _ => EitherT.leftT[Future,UserToken](UserNotStartsWithA())
    }
  }
}
