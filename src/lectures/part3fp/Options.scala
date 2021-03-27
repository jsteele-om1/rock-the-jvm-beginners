package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // unsafe APIs
  def unsafeMethod(): String = null
//  val result = Some(unsafeMethod()) // this is wrong - might be getting some with null which breaks the point - Some should always have a value inside
  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "a valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod())) // this is how to work with unsafe API's

  //Design unsafe API's
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("a valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functinos on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE - option could be null creating a nullpointerexception - breaks the point of the option

    // favorits
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehensions
  val config: Map[String, String] = Map(
    "host" -> "176.45.32.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  /*
  * if (h != null)
  *   if (p != null)
  *     return Connection.apply(h, p)
  * return null
  * */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  connectionStatus.foreach(println)

  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  val connectionStatusForComprehension = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect



}
