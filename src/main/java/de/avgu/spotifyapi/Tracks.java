package de.avgu.spotifyapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Tracks.TracksBuilder.class)
public class Tracks {

    @JsonProperty("items")
    private ArrayList<Item> items;

    @JsonProperty("limit")
    private Integer limit;

}
