package com.sayan.sns.service

import com.sayan.sns.error.Failure
import com.sayan.sns.model.Topic
import com.sayan.sns.repository.TopicRepository

class TopicService(topicRepository: TopicRepository) {
  def save(topic : Topic) : Either[Failure, String] = topicRepository.save(topic)
}
