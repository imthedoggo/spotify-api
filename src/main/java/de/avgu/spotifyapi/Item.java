package de.avgu.spotifyapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Item.ItemBuilder.class)
public class Item {

    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;

}
