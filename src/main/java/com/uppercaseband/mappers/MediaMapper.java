package com.uppercaseband.mappers;

import com.uppercaseband.domain.Media;
import com.uppercaseband.model.MediaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
// this mapper is implemented via MapStruct
public interface MediaMapper {

    MediaMapper INSTANCE = Mappers.getMapper(MediaMapper.class);

    @Mapping(source="path", target="url")
    MediaDTO mediaToMediaDTO (Media media);

    @Mapping(source="url", target="path")
    Media mediaDTOToMedia (MediaDTO mediaDTO);
}
