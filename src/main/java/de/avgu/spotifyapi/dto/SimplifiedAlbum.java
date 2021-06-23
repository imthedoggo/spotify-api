package de.avgu.spotifyapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SimplifiedAlbum.SimplifiedAlbumBuilder.class)
public class SimplifiedAlbum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;

}
