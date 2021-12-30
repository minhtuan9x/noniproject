package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CommentPostDTO;
import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.service.CommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentpost")
public class CommentPostAPI {
    @Autowired
    private CommentPostService commentPostService;

    @PostMapping("/{id}/post")
    public CommentPostDTO save(@RequestBody CommentPostDTO commentPostDTO, @PathVariable("id") Long id){
        commentPostService.save(commentPostDTO,id);
        return commentPostDTO;
    }
    @DeleteMapping
    public List<Long> delete(@RequestBody List<Long> ids){
        commentPostService.delete(ids);
        return ids;
    }
}
