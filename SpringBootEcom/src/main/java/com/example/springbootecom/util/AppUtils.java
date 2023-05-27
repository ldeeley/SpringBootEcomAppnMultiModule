package com.example.springbootecom.util;

import com.example.springbootecom.dto.AlbumDTORequest;
import com.example.springbootecom.dto.AlbumDTOResponse;
import com.example.springbootecom.model.AlbumEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppUtils {


    public static AlbumEntity mapAlbumDTORequestToAlbumEntity(AlbumDTORequest albumDTORequest){
        log.info("AppUtils::mapAlbumDTORequestToAlbumEntity converting {} to AlbumEntity",AppUtils.payloadToJSON(albumDTORequest));
        return AlbumEntity.builder()
                .albumTitle(albumDTORequest.getAlbumTitle())
                .artist(albumDTORequest.getArtist())
                .releaseDate(albumDTORequest.getReleaseDate())
                .price(albumDTORequest.getPrice())
                .albumGenre(albumDTORequest.getAlbumGenre())
                .build();
    }

    public static AlbumDTOResponse mapAlbumEntityToAlbumDTOResponse(AlbumEntity albumEntity){
        return AlbumDTOResponse.builder()
                .albumTitle(albumEntity.getAlbumTitle())
                .artist(albumEntity.getArtist())
                .releaseDate(albumEntity.getReleaseDate())
                .price(albumEntity.getPrice())
                .albumGenre(albumEntity.getAlbumGenre())
                .build();
    }

    public static String payloadToJSON(AlbumDTORequest albumDTORequest){
        return albumDTORequest.toString();
    }

}
