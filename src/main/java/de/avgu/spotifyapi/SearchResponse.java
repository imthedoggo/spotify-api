package de.avgu.spotifyapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SearchResponse.SearchResponseBuilder.class)
public class SearchResponse {

    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("artists")
    private Artists artists;

}