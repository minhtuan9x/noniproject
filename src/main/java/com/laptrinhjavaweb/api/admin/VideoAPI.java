package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.VideoDTO;
import com.laptrinhjavaweb.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoAPI {
    @Autowired
    private VideoService videoService;
    @GetMapping
    public List<VideoDTO> findAll(){
        return videoService.findAll();
    }
    @PostMapping
    public List<VideoDTO> update(@RequestBody List<VideoDTO> videos){
        return videoService.update(videos);
    }
}
