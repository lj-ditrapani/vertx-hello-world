package info.ditrapani

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler
import io.vertx.core.http.ServerWebSocket

class Server : AbstractVerticle() {
    val webSockets = mutableListOf<ServerWebSocket>()

    override fun start() {
        val router = Router.router(vertx)
        router.route("/hello").handler({ routingContext ->
            val response = routingContext.response()
            response.putHeader("content-type", "text/plain")
            response.end("Hello World from Vert.x-Web!")
            println("hello request")
            println(webSockets.size)
            webSockets.forEach({ ws -> ws.writeTextMessage("Update!") })
        })
        router.route("/*").handler(StaticHandler.create())

        val server = vertx.createHttpServer()
    server.websocketHandler({ webSocket ->
        println("Connected!")
        webSocket.writeTextMessage("Welcome over WebSocket")
        webSockets.add(webSocket)
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
