package wedding

import org.http4s.HttpService
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server.{ Server, ServerApp }

import scalaz.concurrent.Task

object Main extends ServerApp {

  val helloWorldService = HttpService {
    case GET -> Root =>
      Ok("WE GETTING MARRIED 10/14/2017\n\nIT'S LIT")
  }

  override def server(args: List[String]): Task[Server] = {
    BlazeBuilder
      .bindHttp(5000, "0.0.0.0")
      .mountService(helloWorldService, "/")
      .start
  }
}
