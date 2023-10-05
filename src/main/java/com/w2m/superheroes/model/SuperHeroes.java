package com.w2m.superheroes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuperHeroes implements Serializable {

    @Serial
    private static final long serialVersionUID = -3525180765467251716L;

    @JsonProperty("data")
    @Valid
    private List<SuperHeroe> data = null;

}
