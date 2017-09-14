package wedding

import org.http4s.dsl._
import org.http4s.HttpService
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server.staticcontent._
import org.http4s.server.{ Server, ServerApp }
import org.http4s.twirl._

import fs2.Task

object Main extends ServerApp {

  val webService = HttpService {
    case GET -> Root                    => Ok(html.index())
    case GET -> Root / "groomsmen"      => Ok(html.groomsmen())
  }

  val cache = MemoryCache()

  val assetService = resourceService(ResourceService.Config(
    basePath = "/assets",
    pathPrefix = "/assets",
    cacheStrategy = cache))

  val webJarService = resourceService(ResourceService.Config(
    basePath = "/META-INF/resources/webjars",
    pathPrefix = "/assets",
    cacheStrategy = cache))

  override def server(args: List[String]): Task[Server] = {
    BlazeBuilder
      .bindHttp(5000, "0.0.0.0")
      .mountService(webService, "/")
      .mountService(assetService)
      .mountService(webJarService)
      .start
  }
}
