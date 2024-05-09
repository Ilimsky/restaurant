package com.example.restaurant.services;

import com.example.restaurant.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewService {
    Review saveReview(Review review);
    Page<Review> getAllReviews(Pageable pageable);
    Optional<Review> getReviewsByEstablishmentId(Long establishmentId);
    Optional<Review> getReviewsByUserId(Long userId);

    void deleteById(Long reviewId);
}
