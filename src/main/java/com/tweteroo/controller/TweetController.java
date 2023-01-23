package com.tweteroo.controller;

import com.tweteroo.domain.dto.TweetDto;
import com.tweteroo.domain.model.Tweet;
import com.tweteroo.service.TweetService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetService tweetService;


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String createTweet (@RequestBody @Valid TweetDto tweetDto) throws NotFoundException {
    log.info("Received tweet request {}", tweetDto.getText());
    tweetService.createTweet(tweetDto);
    return "OK";
  }

  @GetMapping("/username/{username}")
  public List<Tweet> findAllByUsername (@RequestParam("username") String username)
      throws NotFoundException {
    log.info("Received find tweets by username request, username {}", username);
    return tweetService.findTweetsByUsername(username);
  }

}
