package com.uppercaseband.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDTO { // DTO:  Data Transfer Object

    private String title;

    private String description;

    @JsonProperty("display_order")
    private int displayOrder;

    private String category;

    @JsonProperty("sub_content")
    private String subContent;

    private MediaDTO media;
}
