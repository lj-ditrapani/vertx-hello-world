package info.ditrapani

import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler

class Server : AbstractVerticle() {
    override fun start() {
        val router = Router.router(vertx)
        router.route("/hello").handler({ routingContext ->
            val response = routingContext.response()
            response.putHeader("content-type", "text/plain")
            response.end("Hello World from Vert.x-Web!")
        })
        router.route("/*").handler(StaticHandler.create())

        val server = vertx.createHttpServer()
    server.websocketHandler({ websocket ->
        println("Connected!")
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
