package com.duyhien.springDataJPA24d6m.Dto.Response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PageResponse<T> {

    int pageNo;

    int pageSize;

    int totalPage;

    T items;
}
