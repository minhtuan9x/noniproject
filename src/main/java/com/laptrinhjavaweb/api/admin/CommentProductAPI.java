package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CommentProductDTO;
import com.laptrinhjavaweb.service.CommentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/commentproduct")
public class CommentProductAPI {
    @Autowired
    private CommentProductService commentProductService;

    @PostMapping("/{id}/product")
    public CommentProductDTO save(@RequestBody CommentProductDTO commentProductDTO, @PathVariable("id") Long id){
        commentProductService.save(commentProductDTO,id);
        return commentProductDTO;
    }
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id){
        commentProductService.delete(id);
        return id;
    }
}
