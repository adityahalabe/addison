package services

import models.{Credentials, User, UserToken}
import scala.concurrent.Future

trait AsyncTokenService {

  protected def authenticate(credentials: Credentials): Future[User]
  protected def issueToken(user: User): Future[UserToken]

  def requestToken(credentials: Credentials): Future[UserToken] =  authenticate(credentials).flatMap(issueToken)
}
