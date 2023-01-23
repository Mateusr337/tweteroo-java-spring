package com.tweteroo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.domain.model.Tweet;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

  List<Tweet> findTweetsByUsername (String username);

}
