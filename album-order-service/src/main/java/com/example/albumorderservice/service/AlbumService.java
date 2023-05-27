package com.example.albumorderservice.service;

import com.example.albumorderservice.dto.AlbumDTORequest;
import com.example.albumorderservice.dto.AlbumDTOResponse;
import com.example.albumorderservice.dto.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlbumService {

    private final static String BASE_URL="http://localhost:8080/";
    @Autowired
    public RestTemplate restTemplate;

    public ServiceResponse<AlbumDTOResponse> addNewAlbumToDatabase(AlbumDTORequest albumDTORequest){
        return restTemplate.postForObject(BASE_URL+"/album",albumDTORequest,ServiceResponse.class);
    }

    public ServiceResponse<List<AlbumDTOResponse>> getAllAlbums(){
        return restTemplate.getForObject(BASE_URL+"/album",ServiceResponse.class);
    }

    public ServiceResponse<AlbumDTOResponse> getAlbumById(Integer albumId){
        return restTemplate.getForObject(BASE_URL+"/album/"+albumId,ServiceResponse.class);
    }

    public ServiceResponse<AlbumDTOResponse> updateAlbumById(AlbumDTORequest albumDTORequest,Integer albumId){
        restTemplate.put(BASE_URL+"/album/"+albumId,albumDTORequest);
        return getAlbumById(albumId);
    }

    public void  deleteAlbumById(Integer albumId){
        restTemplate.delete(BASE_URL+"/album/"+albumId);
    }




}
