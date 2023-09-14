package com.uppercaseband.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Media {

    @Id
    private String id;	//removed "database leakage" here from RDBMS design

    private MediaType type;

    private String path;
}
