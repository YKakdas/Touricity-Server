package com.squadro.touricity.controller;

import com.squadro.touricity.database.Database;
import com.squadro.touricity.message.types.data.Dummy;
import com.squadro.touricity.message.types.data.RouteSuggestion;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuggestedRoutesController {
    @RequestMapping(
            value = "/suggestedRoutes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public RouteSuggestion suggestRoutes(
            @RequestBody Dummy dummy,
            @CookieValue(value = "cookie_uuid", defaultValue = "notset") String cookie
    ) {
        return Database.suggestRoutes(dummy);
    }
}
