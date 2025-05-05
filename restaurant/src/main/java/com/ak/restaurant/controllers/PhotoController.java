package com.ak.restaurant.controllers;

import com.ak.restaurant.domain.dtos.PhotoDto;
import com.ak.restaurant.domain.entities.Photo;
import com.ak.restaurant.mappers.PhotoMapper;
import com.ak.restaurant.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/photos")
public class PhotoController {

  private final PhotoService photoService;
  private final PhotoMapper photoMapper;

  @PostMapping
  public PhotoDto uploadPhoto(@RequestParam("file") MultipartFile file) {
    Photo photo = photoService.uploadPhoto(file);
    return photoMapper.toDto(photo);
  }

  @GetMapping("/{id:.+}")
  public ResponseEntity<Resource> getPhoto(@PathVariable String id) {
    return photoService.loadPhotoAsResource(id).map(photo ->
            ResponseEntity.ok()
                .contentType(MediaTypeFactory.getMediaType(photo)
                    .orElse(MediaType.APPLICATION_OCTET_STREAM))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .body(photo))
        .orElse(ResponseEntity.notFound().build());

  }
}
