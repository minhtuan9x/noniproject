package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CommentPostDTO;
import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.service.CommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentpost")
public class CommentPostAPI {
    @Autowired
    private CommentPostService commentPostService;

    @PostMapping("/{id}/post")
    public ResponseEntity<CommentPostDTO> save(@RequestBody CommentPostDTO commentPostDTO, @PathVariable("id") Long id) {
        return commentPostService.save(commentPostDTO, id) ? new ResponseEntity<>(commentPostDTO, HttpStatus.OK) : new ResponseEntity<>(commentPostDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping
    public List<Long> delete(@RequestBody List<Long> ids) {
        commentPostService.delete(ids);
        return ids;
    }
}
