package com.planbgenius

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class PlanBGeniusDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {

  implicit val system = ActorSystem()

  describe("given a message") {
    it("should prepend a string to list") {

      val actorRef = TestActorRef(new PlanBGeniusDb)

      actorRef ! "first message"
      actorRef ! "second message"

      val akkademyDb = actorRef.underlyingActor
      akkademyDb.msgs.head should equal("second message")
      akkademyDb.msgs.head should not equal("first message")
    }
  }
}
