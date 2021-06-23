package de.avgu.spotifyapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Artist.ArtistBuilder.class)
public class Artist {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("popularity")
    private int popularity;
    @JsonProperty("genres")
    private ArrayList<String> genres;

}
