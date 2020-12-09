package com.doan.student.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImageController {
    @PostMapping("/image/upload")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile[] files ){
        Path path= Paths.get("upload/");
        try{
            for (int i=0; i< files.length; i++) {
                InputStream inputStream = files[i].getInputStream();
                Files.copy(inputStream, path.resolve(files[i].getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            }
             }
        catch (Exception e){
            e.printStackTrace();
        }
   return new ResponseEntity<Object>( "true", HttpStatus.OK );
    }

    @GetMapping("/image/get/{photo}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photo") String photo){

        try{
            Path filename = Paths.get("upload", photo);
            byte[] buffer = Files.readAllBytes(filename);
            ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
            return ResponseEntity.ok().contentLength(buffer.length)
                    .contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);

        }
        catch ( Exception e){

        }
        return ResponseEntity.badRequest().build();
    }
}
