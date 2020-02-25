package com.sayan.sns.repository

import com.sayan.sns.model.Topic

import utils._

import com.mongodb.casbah.MongoConnection
import com.mongodb.casbah.commons.{Imports, MongoDBObject}


/**
 * Provides DAL for Topic entities for MongoDB database.
 */
class TopicRepository(dbConnection: MongoConnection) {

  def save(topic: Topic) = {
    val topicDao = buildDao(topic)
    val collection = dbConnection(Utils.DATABASE_NAME)(Utils.TOPIC_TABLE_NAME)
    collection.save(topicDao)
  }

  private def buildDao(topic: Topic): Imports.DBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "name" -> topic.name
    builder.result
  }

}