package com.example.restaurant.services;

import com.example.restaurant.entities.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PhotoService {
    Photo saveReview(Photo photo);
    Page<Photo> getAllPhotos(Pageable pageable);
    Optional<Photo> getReviewsByEstablishmentId(Long establishmentId);
    void deleteById(Long photoId);
}
