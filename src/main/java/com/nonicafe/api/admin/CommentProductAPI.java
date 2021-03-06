package com.nonicafe.api.admin;

import com.nonicafe.dto.CommentProductDTO;
import com.nonicafe.service.CommentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/commentproduct")
public class CommentProductAPI {
    @Autowired
    private CommentProductService commentProductService;


    @PostMapping("/{id}/product")
    public ResponseEntity<CommentProductDTO> save(@RequestBody CommentProductDTO commentProductDTO, @PathVariable("id") Long id) {
        return commentProductService.save(commentProductDTO, id)?new ResponseEntity<>(commentProductDTO, HttpStatus.OK):new ResponseEntity<>(commentProductDTO, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {
        commentProductService.delete(id);
        return id;
    }
}
