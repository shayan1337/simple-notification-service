package com.sayan.sns.resolvers

import com.sayan.sns.mongofactory.MongoFactory
import com.sayan.sns.repository.TopicRepository


object Resolver {
  val topicRepository = new TopicRepository(MongoFactory.mongoConnection)
}
