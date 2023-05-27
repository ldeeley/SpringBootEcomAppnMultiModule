package com.example.springbootecom.dto;

import com.example.springbootecom.annotation.AlbumGenreValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumDTORequest {

    @NotNull
    @NotEmpty(message = "Cannot have a blank Album Title")
    private String albumTitle;
    @NotNull
    @NotEmpty(message = "Cannot have a blank Artist")
    private String artist;
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
//    @Past(message = "Date must be in the past")
    private LocalDate releaseDate;
    @Positive(message = "Price can not be zero or less")
    private double price;
    @AlbumGenreValidation
    @NotNull(message = "Can not have a blank albumGenre")
    @NotEmpty(message = "Can not have a empty albumGenre")
    private String albumGenre;
}
