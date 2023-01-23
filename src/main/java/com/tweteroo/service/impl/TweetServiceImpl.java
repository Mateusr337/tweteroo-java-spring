package com.tweteroo.service.impl;

import com.tweteroo.domain.dto.TweetDto;
import com.tweteroo.domain.model.Tweet;
import com.tweteroo.domain.model.User;
import com.tweteroo.mapper.TweetMapper;
import com.tweteroo.repository.TweetRepository;
import com.tweteroo.service.TweetService;
import com.tweteroo.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TweetServiceImpl implements TweetService {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private TweetMapper tweetMapper;

  @Autowired
  private UserService userService;
  public void createTweet (TweetDto tweetDto) throws NotFoundException {
    log.info("Trying create tweet {} ...", tweetDto.getUsername());
    User user = userService.findUserByUsername(tweetDto.getUsername());
    Tweet tweet = tweetMapper.toModel(tweetDto);
    tweet.setAvatar(user.getAvatar());
    tweet = tweetRepository.save(tweet);
    log.info("Created tweet with id {}", tweet.getId());
  }

  public List<Tweet> findTweetsByUsername(String username) throws NotFoundException {
    log.info("Trying find tweets by user's username");
    User user = userService.findUserByUsername(username);
    return tweetRepository.findTweetsByUsername(username);
  }

  public Page<Tweet> findAllTweets(Pageable page) {
//    boolean hasEnoughLength = sizeIsGranderThan(page.get());
//    if (hasEnoughLength) {
      return tweetRepository.findAll(page);
//    }
//    return tweetRepository.findAll();
  }

  private boolean sizeIsGranderThan (int page) {
    long size = tweetRepository.count();
    if (size > page * 10L - 1) {
      return true;
    }
    return false;
  }

}
