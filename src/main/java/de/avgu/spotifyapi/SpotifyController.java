package de.avgu.spotifyapi;

import de.avgu.spotifyapi.dto.Artist;
import de.avgu.spotifyapi.dto.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyController {

    @Autowired
    private SpotifyService spotifyService;

    @PostMapping("/authenticate")
    public String authenticate() {
        return spotifyService.authenticate();
    }

    @GetMapping("/search")
    public SearchResponse search(
        @RequestParam("q") String query,
        @RequestParam("type") String type,
        @RequestParam("limit") Integer limit
    ) {
       return spotifyService.search(query, type, limit);
    }

    @GetMapping("/artists/{id}")
    public Artist getArtist(
        @PathVariable String id
    ) {
        return spotifyService.getArtist(id);
    }

    @GetMapping("/tracks/{id}")
    public Track getTrack(
        @PathVariable String id
    ) {
        return spotifyService.getTrack(id);
    }
}
