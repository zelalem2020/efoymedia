package com.abzgroup.efoymedia.dal.dtos.responseDtos;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private boolean status;
    private List<?> payload;
    private int pageSize = 10;
    private int pageIndex = 1;
    private String message;
}
