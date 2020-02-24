trait config {
  akka {
    loglevel = DEBUG
    event-handlers = ["akka.event.slf4j.Slf4jEventHandler"]
  }

  service {
    host = "localhost"
    port = 8080
  }

  db {
    host = "localhost"
    port = 3306
    name = "rest"
    user = "root"
    password = null
  }
}