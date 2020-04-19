package info.ditrapani

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.core.http.ServerWebSocket
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler

class Server : AbstractVerticle() {
    val webSockets = mutableListOf<ServerWebSocket>()
    var helloCount: Int = 0

    override fun start() {
        val router = Router.router(vertx)
        router.route("/hello").handler({ routingContext ->
            helloCount += 1
            val response = routingContext.response()
            response.putHeader("content-type", "text/plain")
            response.end("Hello from Vert.x!  Count is $helloCount.")
            println("Received hello request.  Count: $helloCount")
            webSockets.forEach({ ws -> ws.writeTextMessage("$helloCount") })
        })
        router.route("/*").handler(StaticHandler.create())

        val server = vertx.createHttpServer()
        server.websocketHandler({ webSocket ->
            webSockets.add(webSocket)
            println("New web socket connection.  Total count: ${webSockets.size}.")
        })
        server.requestHandler(router)
        server.listen(44770)
    }
}

class Main {
    fun greeting(): String = "Hello world!"
}

fun main(args: Array<String>) {
    println(Main().greeting())
    Vertx.vertx().deployVerticle(Server())
}
