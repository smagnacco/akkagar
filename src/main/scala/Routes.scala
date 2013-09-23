/**
 * @author sergio.magnacco  (craftman-dev)
 *       Date: 22/09/13
 *       Time: 23:27
 */
import spray.routing.Directives
import akka.actor.ActorSystem
import akka.util.Timeout
import scala.concurrent.duration._
import org.slf4j.LoggerFactory


trait Routes extends Directives {

  val log = LoggerFactory.getLogger(classOf[Routes])

  implicit val timeout = Timeout(90 seconds)

  implicit val system: ActorSystem

  def routes: spray.routing.Route = {
    pathPrefix("api") {
        PiRoute.routes
    }
  }


}
