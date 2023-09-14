package com.uppercaseband.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaDTO { // DTO:  Data Transfer Object

    private String type;

    private String url;
}