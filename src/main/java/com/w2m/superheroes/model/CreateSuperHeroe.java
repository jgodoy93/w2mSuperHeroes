package com.w2m.superheroes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSuperHeroe implements Serializable {

    @Serial
    private static final long serialVersionUID = -223873111497386433L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("comment")
    private String comment;

}
