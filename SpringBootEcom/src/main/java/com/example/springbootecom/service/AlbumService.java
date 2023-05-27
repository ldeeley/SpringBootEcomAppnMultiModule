package com.example.springbootecom.service;

import com.example.springbootecom.dto.AlbumDTORequest;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.exception.AlbumNotFoundException;
import com.example.springbootecom.exception.AlbumServiceBusinessException;
import com.example.springbootecom.model.AlbumEntity;
import com.example.springbootecom.repository.AlbumRepository;
import com.example.springbootecom.util.AppUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class AlbumService {


    private AlbumRepository albumRepository;

//    save Album to DB
    public AlbumDTOResponse addNewAlbum(AlbumDTORequest albumDTORequest){
        AlbumEntity albumEntity;
        log.info("AlbumService::addNewAlbum execution started");
        try {
            albumEntity = albumRepository.save(AppUtils.mapAlbumDTORequestToAlbumEntity(albumDTORequest));
            log.info("AlbumService::addNewAlbum execution ended");
            return AppUtils.mapAlbumEntityToAlbumDTOResponse(albumEntity);
        }
        catch (Exception e)
        {
            log.error("AlbumService::addNewAlbum exception occurs while persisting Album");
            throw new AlbumServiceBusinessException("Exception raised in addNewAlbum method" + albumDTORequest.toString());
        }

    }

//    return All Albums in DB
    public List<AlbumDTOResponse> findAllAlbums(){
        ArrayList<AlbumEntity> albumEntityList = new ArrayList<>();
        log.info("AlbumService::findAllAlbums execution started");
        try {
            albumRepository.findAll().forEach(albumEntityList::add);
            log.info("AlbumService::findAllAlbums execution ended");
            return albumEntityList.stream().map(AppUtils::mapAlbumEntityToAlbumDTOResponse).collect(Collectors.toList());
        }
        catch (Exception e)
        {
            log.error("AlbumService::findAllAlbums exception occurs while calling findAllAlbums");
            throw new AlbumServiceBusinessException("Exception raised in findAllAlbums method ");
        }

    }

//    find an Album by ID - or else Null (handle this later)
    public AlbumDTOResponse findAlbumById(Integer albumId){
        log.info("AlbumService::findAlbumById execution started");
        AlbumEntity albumEntity = albumRepository.findById(albumId).orElseThrow(()->new AlbumNotFoundException("No such Album with AlbumId "+albumId));
        log.info("AlbumService::findAlbumById execution ended");
        return AppUtils.mapAlbumEntityToAlbumDTOResponse(albumEntity);
    }

    public void deleteAlbumById(Integer albumId){
        try {
            log.info("AlbumService::deleteAlbumById execution started");
            albumRepository.deleteById(albumId);
            log.info("AlbumService::deleteAlbumById execution ended");
        }
        catch (Exception e)
        {
            log.error("AlbumService::deleteAlbumById exception occurs while calling deleteAlbumById");
            throw new AlbumServiceBusinessException("Exception raised in deleteAlbumById method ");
        }
    }

    public AlbumDTOResponse updateAlbum(Integer albumId, AlbumDTORequest albumDTORequest){
        AlbumEntity albumEntity;
        try {
            albumEntity = albumRepository.save(AppUtils.mapAlbumDTORequestToAlbumEntity(albumDTORequest));
            return AppUtils.mapAlbumEntityToAlbumDTOResponse(albumEntity);
        } catch (Exception e)
        {
            log.error("AlbumService::updateAlbum exception occurs while calling updateAlbum");
            throw new AlbumServiceBusinessException("Exception raised in updateAlbum method ");
        }

    }

}
