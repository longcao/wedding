package wedding

import org.http4s.HttpService
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server.{ Server, ServerApp }

import scalaz.concurrent.Task

object Main extends ServerApp {

  val helloWorldService = HttpService {
    case GET -> Root =>
      Ok("Hello, world.")
  }

  override def server(args: List[String]): Task[Server] = {
    BlazeBuilder
      .mountService(helloWorldService, "/")
      .start
  }
}
