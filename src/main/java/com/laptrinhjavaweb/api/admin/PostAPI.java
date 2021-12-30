package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.PostDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/post")
public class PostAPI {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> findAll(@RequestParam(required = false) Map<String,String> params){
        PostDTO postDTO = new PostDTO();
        return postService.findAll(postDTO);
    }
    @PostMapping
    public PostDTO save(@RequestBody(required = false) PostDTO postDTO){
        return postService.save(postDTO);
    }
    @DeleteMapping
    public List<Long> delete(@RequestBody List<Long> ids){
        return postService.delete(ids);
    }
    @GetMapping("/{id}")
    public PostDTO getOne(@PathVariable("id") Long id){
        return postService.findOne(id);
    }
}
