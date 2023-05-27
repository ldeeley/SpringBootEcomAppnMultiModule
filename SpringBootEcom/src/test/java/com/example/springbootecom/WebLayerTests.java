package com.example.springbootecom;

import com.example.springbootecom.controller.AlbumController;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.service.AlbumService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(AlbumController.class)
class WebLayerTests {

    @MockBean
    private AlbumService albumService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnListOfAlbums() throws Exception {

        when(albumService.findAllAlbums()).thenReturn(List.of(
                new AlbumDTOResponse("Dark Side of the Moon","Pink Floyd", LocalDate.parse("1966-11-07"),19.99,"Rock"),
                new AlbumDTOResponse("Abbey Road","The Beatles",LocalDate.parse("1969-12-08"),19.99,"Rock"),
                new AlbumDTOResponse("Hunky Dory","David Bowie",LocalDate.parse("1969-12-08"),19.99,"Rock")));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/album"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.response.size()", Matchers.is(3)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.response[0].albumTitle").value("Dark Side of the Moon"));
    }

    @Test
    void shouldAddNewAlbum() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"albumID\":\"1\",\"albumTitle\":\"Abbey Road\",\"artist\":\"The Beatles\",\"releaseDate\":\"1966-10-07\",\"price\":\"19.99\",\"albumGenre\":\"Rock\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status",Matchers.is("CREATED")));

    }

    @Test
    void shouldFindSpecificAlbum() throws Exception {

        when(albumService.findAlbumById(2)).thenReturn(new AlbumDTOResponse("Abbey Road","The Beatles",LocalDate.parse("1969-12-08"),19.99,"Rock"));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/album/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response.albumTitle").value("Abbey Road"));

    }

    @Test
    void shouldDeleteAlbumByID() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders.delete("/album/2"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void shouldUpdateAlbumByID() {


    }


    @Test
    void shouldFailAddNewAlbumOnValidation() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"albumTitle\":\"Abbey Road\",\"artist\":\"The Beatles\",\"releaseDate\":\"1966-10-07\",\"price\":\"19.99\",\"albumGenre\":\"Rock\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status",Matchers.is("CREATED")));

    }


    @Test
    void shouldFailCustomAlbumGenreValidation() throws Exception {

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"albumTitle\":\"Abbey Road\",\"artist\":\"The Beatles\",\"releaseDate\":\"1966-10-07\",\"price\":\"19.99\",\"albumGenre\":\"Metal\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
