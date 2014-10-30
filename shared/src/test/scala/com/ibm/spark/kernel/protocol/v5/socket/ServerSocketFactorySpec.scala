package com.ibm.spark.kernel.protocol.v5.socket

import org.scalatest.{FunSpec, Matchers}

class ServerServerSocketFactorySpec extends FunSpec with Matchers {
  describe("ServerSocketFactory"){
    describe("HeartbeatConnection"){
    	it("should be composed of transport ip and heartbeat port"){
        val config: SocketConfig = SocketConfig(-1,-1,8000,-1, -1, "<STRING-IP>", "<STRING-TRANSPORT>","<STRING-SCHEME>","<STRING-KEY>")
        val factory: ServerSocketFactory = ServerSocketFactory(config)
        factory.HeartbeatConnection.toString should be ("<STRING-TRANSPORT>://<STRING-IP>:8000")
    	}
    }
  }
}