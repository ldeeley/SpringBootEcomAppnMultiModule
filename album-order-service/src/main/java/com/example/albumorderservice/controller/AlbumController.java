package com.example.albumorderservice.controller;

import com.example.albumorderservice.dto.AlbumDTORequest;
import com.example.albumorderservice.dto.AlbumDTOResponse;
import com.example.albumorderservice.dto.ServiceResponse;
import com.example.albumorderservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album-service")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/addNewAlbum")
    public ServiceResponse<AlbumDTOResponse> addNewAlbum(@RequestBody AlbumDTORequest albumDTORequest){
        return albumService.addNewAlbumToDatabase(albumDTORequest);
    }

    @GetMapping("/getAlbums")
    public ServiceResponse<List<AlbumDTOResponse>> getAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/getAlbum/{albumId}")
    public ServiceResponse<AlbumDTOResponse> getAlbum(@PathVariable Integer albumId){
        return albumService.getAlbumById(albumId);
    }

    @PutMapping("/updateAlbum/{albumId}")
    public ServiceResponse<AlbumDTOResponse> updateAlbumById(AlbumDTORequest albumDTORequest,@PathVariable Integer albumId) {
        return albumService.updateAlbumById(albumDTORequest, albumId);
    }

    @DeleteMapping("/deleteAlbum/{albumId}")
    public void deleteAlbumById(@PathVariable Integer albumId){
        albumService.deleteAlbumById(albumId);
    }

}
