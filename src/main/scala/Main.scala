import akka.actor.ActorSystem
import spray.http.{StatusCode, HttpResponse}
import spray.routing.SimpleRoutingApp

/**
 * @author sergio.magnacco  (craftman-dev)
 *       Date: 22/09/13
 *       Time: 19:37
 */
object Main extends App with SimpleRoutingApp with Routes {

  implicit val system: ActorSystem = ActorSystem("api-v3-hotels")

  startServer(interface = "0.0.0.0", port = 8080) {
    routes
  }

  system.registerOnTermination()
}
