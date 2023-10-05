package com.w2m.superheroes.controller;

import com.w2m.superheroes.model.SuperHeroe;
import com.w2m.superheroes.model.SuperHeroes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SuperHeroesController {

    @Operation(operationId = "createSuperHeroe", summary = "Creación de super heroe.", tags = {
            "superheroe" }, responses = { @ApiResponse(responseCode = "201", description = "Created", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SuperHeroe.class)) }) })
    @RequestMapping(method = RequestMethod.POST, value = "/superheroe", produces = { "application/json" }, consumes = {
            "application/json" })
    public ResponseEntity<SuperHeroe> createSuperHeroe(
            @Parameter(name = "SuperHeroe", description = "requets", required = true) @Valid @RequestBody SuperHeroe superHeroe);

    @Operation(operationId = "deleteSuperHeroe", summary = "Eliminación de superHeroe.", tags = {
            "superheroe" }, responses = { @ApiResponse(responseCode = "200", description = "Ok") })
    @RequestMapping(method = RequestMethod.DELETE, value = "/superheroe/{id}")
    ResponseEntity<Void> deleteSuperHeroe(
            @Parameter(name = "id", description = "id del superheroe", required = true) @PathVariable("id") String id);

    @Operation(operationId = "findAllSuperheroes", summary = "Busca todos los superheroes del registro.", tags = {
            "superheroe" }, responses = { @ApiResponse(responseCode = "200", description = "", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SuperHeroes.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/superheroes", produces = { "application/json" })
    ResponseEntity<SuperHeroes> findAllSuperheroes();

    @Operation(operationId = "findAllSuperheroesBySearchCriteria", summary = "Busca todos los superheroes del registro.", tags = {
            "superheroe" }, responses = { @ApiResponse(responseCode = "200", description = "", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SuperHeroes.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/superheroes/{search}", produces = { "application/json" })
    ResponseEntity<SuperHeroes> findAllSuperheroesBySearchCriteria(
            @Parameter(name = "search", description = "Nombre del superheroe", required = true) @PathVariable("search") String search);

    @Operation(operationId = "findSuperheroeById", summary = "Busca un super heroe dentro del registro.", tags = {
            "superheroe" }, responses = { @ApiResponse(responseCode = "200", description = "", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SuperHeroe.class)) }) })
    @RequestMapping(method = RequestMethod.GET, value = "/superheroe/{id}", produces = { "application/json" })
    ResponseEntity<SuperHeroe> findSuperheroeById(
            @Parameter(name = "id", description = "id del superheroe", required = true) @PathVariable("id") String id);

    @Operation(operationId = "modifySuperHeroe", summary = "Modificación de superHeroe.", tags = {
            "superheroe" }, responses = { @ApiResponse(responseCode = "200", description = "Ok", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SuperHeroe.class)) }) })
    @RequestMapping(method = RequestMethod.PUT, value = "/superheroe", produces = { "application/json" }, consumes = {
            "application/json" })
    ResponseEntity<SuperHeroe> modifySuperHeroe(
            @Parameter(name = "SuperHeroe", description = "requets", required = true) @Valid @RequestBody SuperHeroe superHeroe);

}

