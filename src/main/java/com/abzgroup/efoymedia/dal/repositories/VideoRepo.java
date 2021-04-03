package com.abzgroup.efoymedia.dal.repositories;

import com.abzgroup.efoymedia.dal.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, String> {
}
