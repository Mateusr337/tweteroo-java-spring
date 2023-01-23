package com.tweteroo.service;

import com.tweteroo.domain.dto.TweetDto;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface TweetService {

  Void createTweet (TweetDto tweetDto) throws NotFoundException;

}
