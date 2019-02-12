package controllers

import actors.SimpleActor
import actors.SimpleActor.GetToken
import akka.actor.{ActorSystem, Props}
import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class TokenController@Inject() (system: ActorSystem,
                                cc:ControllerComponents) extends AbstractController(cc) {


  def getToken() = Action.async {
    val simpleActor = system.actorOf(Props[SimpleActor], name = "simpleActor")

    simpleActor !  GetToken("","")
  }

}
