package com.tweteroo.service;

import com.tweteroo.domain.dto.TweetDto;
import com.tweteroo.domain.model.Tweet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TweetService {

  void createTweet (TweetDto tweetDto) throws NotFoundException;

  List<Tweet> findTweetsByUsername (String username) throws NotFoundException;

  Page<Tweet> findAllTweets (Pageable page);

}
