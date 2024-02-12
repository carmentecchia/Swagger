package com.example.Swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController

public class NameController {

    @GetMapping("/getName")
    @Operation(summary = "restituisci nome inserito")
    @ApiResponses( value = {
           @ApiResponse (responseCode = "200", description = "ok"),
            @ApiResponse (responseCode = "400", description = "bad request")
    })
    public String getName(@RequestParam String name) {
        return "Nome: " + name;
    }

    @Operation (summary = "restituisci nome inserito al contrario")
    @PostMapping("/reverseName")
    @ApiResponses( value = {
            @ApiResponse (responseCode = "200", description = "ok"),
            @ApiResponse (responseCode = "400", description = "bad request")
    })
    public String reverseName(@RequestParam String name) {
        StringBuilder reversedName = new StringBuilder(name).reverse();
        return "Nome al contrario: " + reversedName.toString();
    }
}
