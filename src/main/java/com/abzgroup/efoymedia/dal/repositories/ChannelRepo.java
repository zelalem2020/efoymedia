package com.abzgroup.efoymedia.dal.repositories;

import com.abzgroup.efoymedia.dal.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository <Channel,String> {
}
