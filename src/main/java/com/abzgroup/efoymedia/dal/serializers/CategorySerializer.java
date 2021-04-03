package com.abzgroup.efoymedia.dal.serializers;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.CategoryDTO;
import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.utilities.DeserilizationHelper;
import com.abzgroup.efoymedia.utilities.SingleMapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CategorySerializer extends StdDeserializer<CategoryDTO> {

    @Autowired
    private DeserilizationHelper deserilizationHelper;

    protected CategorySerializer (Class<?> vc) {
        super(vc);
    }

    public CategorySerializer() {
        this(null);
    }

    @SneakyThrows
    @Override
    public CategoryDTO deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        CategoryDTO categoryDTO  = deserilizationHelper.deserialize(node,new CategoryDTO(),CategoryDTO.class);
        return categoryDTO;
    }
}