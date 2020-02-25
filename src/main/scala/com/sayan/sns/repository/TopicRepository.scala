package com.sayan.sns.repository

import com.mongodb.MongoException
import com.mongodb.casbah.MongoConnection
import com.mongodb.casbah.commons.{Imports, MongoDBObject}
import com.sayan.sns.error.{Failure, FailureType}
import com.sayan.sns.model.Topic
import utils._


/**
 * Provides DAL for Topic entities for MongoDB database.
 */
class TopicRepository(dbConnection: MongoConnection) {

  def save(topic: Topic): Either[Failure, String] = {

    val topicDao = buildDao(topic)

    try {
      val collection = dbConnection(Utils.DATABASE_NAME)(Utils.TOPIC_TABLE_NAME)
      collection.save(topicDao)
      Right(topicDao.get("_id").toString)
    } catch {
      case e: MongoException =>
      Left(databaseError(e))
    }

  }

  private def buildDao(topic: Topic): Imports.DBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "name" -> topic.name
    builder.result
  }

  protected def databaseError(e: MongoException) =
    Failure("%d: %s".format(e.getCode, e.getMessage), FailureType.DatabaseFailure)
}