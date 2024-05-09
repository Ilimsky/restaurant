package com.example.restaurant.services;

import com.example.restaurant.entities.Photo;
import com.example.restaurant.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService{

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo saveReview(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Page<Photo> getAllPhotos(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }

    @Override
    public Optional<Photo> getReviewsByEstablishmentId(Long establishmentId) {
        return photoRepository.findById(establishmentId);
    }

    @Override
    public void deleteById(Long photoId) {
        photoRepository.deleteById(photoId);
    }
}
