package com.tweteroo.controller;

import com.tweteroo.domain.dto.TweetDto;
import com.tweteroo.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetService tweetService;


  @PostMapping
  public String createTweet (@RequestBody @Valid TweetDto tweetDto) throws NotFoundException {
    log.info("Received tweet request {}", tweetDto.getText());
    tweetService.createTweet(tweetDto);
    return "OK";
  }

}
