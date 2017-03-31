package io.github.enriquezrene.akka01

import akka.actor.{Actor, ActorSystem, Props}

// A message with what to do
case class Task(taskName: String)

// Who will do
class Employee extends Actor {
  override def receive: Receive = {
    case Task(taskName) => println(s"I'm working on $taskName")
  }
}


object HelloWorld {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloWorld-App")
    val developer = system.actorOf(Props[Employee], "Rene")
    // Send the task to the developer
    developer ! Task("Write an AKKA Hello World app")
  }

}
