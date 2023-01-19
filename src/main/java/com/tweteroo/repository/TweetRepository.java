package com.tweteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.domain.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> { }
