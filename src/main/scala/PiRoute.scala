/**
 * @author sergio.magnacco  (craftman-dev)
 *       Date: 22/09/13
 *       Time: 23:25
 */

import spray.routing.Directives

import akka.actor._
import org.slf4j.LoggerFactory


object PiRoute extends Directives {

  val log = LoggerFactory.getLogger(this.getClass)

  // create the result listener, which will print the result and shutdown the system
  //val listener = system.actorOf(Props[Listener], name = "listener")

  def routes(implicit system: ActorSystem) = {
    implicit val executionContext = system.dispatcher

    get {
    path("pi") {
          parameterMap { queryParams =>
            complete {
              Pi.calculate(queryParams.get("workers").getOrElse("4").toInt,queryParams.get("elements").getOrElse("10000").toInt, queryParams.get("messages").getOrElse("10000").toInt)
              "QUe los pario, che"
            }
          }
      }
    }

  }
}
