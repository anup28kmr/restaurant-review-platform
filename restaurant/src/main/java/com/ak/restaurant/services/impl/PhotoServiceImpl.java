package com.ak.restaurant.services.impl;

import com.ak.restaurant.domain.entities.Photo;
import com.ak.restaurant.services.PhotoService;
import com.ak.restaurant.services.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

  private final StorageService storageService;

  @Override
  public Photo uploadPhoto(MultipartFile file) {

    String photoId = UUID.randomUUID().toString();
    String url = storageService.store(file, photoId);
    return Photo.builder()
        .url(url)
        .uploadDate(LocalDateTime.now())
        .build();
  }

  @Override
  public Optional<Resource> loadPhotoAsResource(String id) {
    return storageService.loadAsResource(id);
  }
}
