package com.abzgroup.efoymedia;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.cmeza.sdgenerator.annotation.SDGenerator;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.HashMap;

//@SDGenerator(
//		entityPackage = "com.abzgroup.efoymedia.dal.model",
//		repositoryPackage = "com.abzgroup.efoymedia.dal.repositories",
//		managerPackage = "com.abzgroup.efoymedia.managers",
//		repositoryPostfix = "Repository",
//		managerPostfix = "Manager",
//		onlyAnnotations = false,
//		debug = false,
//		overwrite = false,
//		additionalExtends = {
//				QuerydslPredicateExecutor.class
//		}
//)

@ComponentScan({"com.abzgroup.efoymedia.controller","com.abzgroup.efoymedia.services",
		"com.abzgroup.efoymedia.config","com.abzgroup.efoymedia.dal",
		"com.abzgroup.efoymedia.exceptions","com.abzgroup.efoymedia.utilities"})
@EntityScan({"com.abzgroup.efoymedia.dal.model"})
@SpringBootApplication
public class EfoymediaApplication {

	public static void main(String[] args) {

		SpringApplication application= new SpringApplication(EfoymediaApplication.class);
		application.setAdditionalProfiles("dev");
		application.run(args);

	}
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper ;
	}
}
