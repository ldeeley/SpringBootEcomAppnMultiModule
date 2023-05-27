package com.example.springbootecom.controller;

import com.example.springbootecom.dto.AlbumDTORequest;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.dto.ServiceResponse;
import com.example.springbootecom.service.AlbumService;
import com.example.springbootecom.util.AppUtils;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/album")
public class AlbumController {
    
    private AlbumService albumService;

    @Operation(summary = "Retrieve Album by Id")
    @GetMapping("/{id}")
    public ServiceResponse<AlbumDTOResponse> findAlbumById(@PathVariable Integer id){
        log.info("AlbumController:: findAlbumById called {}", id);
        AlbumDTOResponse albumDTOResponse = albumService.findAlbumById(id);
        return new ServiceResponse<>(HttpStatus.OK,albumDTOResponse);
    }

    @Operation(summary = "Save an Album to the database")
    @PostMapping
    public ServiceResponse<AlbumDTOResponse> saveAlbumById(@RequestBody @Valid AlbumDTORequest albumDTORequest){
        log.info("AlbumController:: saveAlbumById : {}", AppUtils.payloadToJSON(albumDTORequest));
        AlbumDTOResponse newAlbumDTOResponse = albumService.addNewAlbum(albumDTORequest);
        return new ServiceResponse<>(HttpStatus.CREATED,newAlbumDTOResponse);
    }

    @Operation(summary = "Get all Albums from the database")
    @GetMapping()
    public ServiceResponse<List<AlbumDTOResponse>> findAllAlbums(){
        log.info("AlbumController:: findAllAlbums called...");
        List<AlbumDTOResponse> albumlist = albumService.findAllAlbums();
        return new ServiceResponse<>(HttpStatus.OK,albumlist);
    }

    @Operation(summary = "Delete Album with id from the database")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlbumById(@PathVariable Integer id){
        log.info("AlbumController:: deleteAlbumById called...{}",id);
        albumService.deleteAlbumById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Update Album with Id")
    @PutMapping("/{id}")
    public ServiceResponse<AlbumDTOResponse> updateAlbumById(@PathVariable Integer id, @RequestBody  @Valid AlbumDTORequest albumDTORequest){
        log.info("AlbumController:: updateAlbumById : {}", AppUtils.payloadToJSON(albumDTORequest));
        AlbumDTOResponse albumDTOResponse = albumService.updateAlbum(id,albumDTORequest);
        return new ServiceResponse<>(HttpStatus.OK,albumDTOResponse);
    }

}
