package services.simple.impl

import models.{Credentials, UserToken}
import services.impl.{AutheticationService, TokenService}
import services.simple.SimpleAsyncTokenService
import cats.data.EitherT
import cats.implicits._
import javax.inject.Inject

import scala.concurrent.Future

class SimpleAsyncTokenServiceImpl @Inject()(autheticationService: AutheticationService,
                                            tokenService : TokenService) extends SimpleAsyncTokenService{
  override def requestToken(credentials: Credentials): Future[UserToken] = {

    val eventualToken = autheticationService.authenticate(credentials).flatMap(tokenService.issueToken)
    eventualToken.value.flatMap(mayBeToken => mayBeToken match {
      case Right(token) => Future(token)
      case Left(e)      => Future.failed[UserToken](e)
    })
  }
}
