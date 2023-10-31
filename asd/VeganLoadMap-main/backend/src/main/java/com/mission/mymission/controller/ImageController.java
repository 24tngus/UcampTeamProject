package com.mission.mymission.controller;

import com.mission.mymission.entity.Image;
import com.mission.mymission.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/images/upload")
    public Long uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        Long save_id = imageRepository.save(image).getId();

        return save_id;
    }

    @GetMapping("/images/download/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(image.get().getData(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}