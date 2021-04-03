package com.abzgroup.efoymedia.dal.dtos.requestDtos;

import lombok.Data;

import java.util.List;

@Data
public class RequestDTO {
    private List<?> payload;
    private int pageSize;
    private int pageIndex;
}
