package com.sayan.sns.mongofactory

import com.mongodb.casbah.MongoConnection
import com.sayan.sns.config.Configuration

object MongoFactory {
  lazy val mongoConnection = MongoConnection(Configuration.dbHost)
}
