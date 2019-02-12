package actors

import actors.SimpleActor.GetToken
import akka.actor.Actor
import javax.inject.Inject
import models.Credentials
import services.simple.SimpleAsyncTokenService

object SimpleActor {
  case class GetToken(username: String, password: String)
}

class SimpleActor @Inject()(simpleAsyncTokenService: SimpleAsyncTokenService) extends Actor{

  override def receive: Receive = {
    case GetToken(userName,password) => simpleAsyncTokenService.requestToken(Credentials(userName,password))
  }
}
