package com.planbgenius

import akka.actor.Actor
import akka.event.Logging

class PlanBGeniusDb extends Actor {

  var msgs = List[String]()

  val log = Logging(context.system, this)

  override def receive = {
    case "print" => {
      log.info(msgs.toString())
    }
    case msg:String => {
      log.info("received message: {} ", msg)
      msgs = msg :: msgs
    }
    case o => {
      log.info("received unknown message: {}", o)
    }
  }
}
