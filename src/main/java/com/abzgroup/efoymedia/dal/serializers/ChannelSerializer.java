package com.abzgroup.efoymedia.dal.serializers;

import com.abzgroup.efoymedia.dal.dtos.entitiyDtos.ChannelDTO;
import com.abzgroup.efoymedia.utilities.DeserilizationHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class ChannelSerializer extends StdDeserializer<ChannelDTO> {

        @Autowired
        private DeserilizationHelper deserilizationHelper;

        protected ChannelSerializer(Class<?> vc) {
            super(vc);
        }

        public ChannelSerializer() {
            this(null);
        }

        @SneakyThrows
        @Override
        public ChannelDTO deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            ChannelDTO channelDTO = deserilizationHelper.deserialize(node,new ChannelDTO(),ChannelDTO.class);
            return channelDTO;
        }
}