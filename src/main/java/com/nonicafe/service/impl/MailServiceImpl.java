package com.nonicafe.service.impl;

import com.nonicafe.dto.CommentPostDTO;
import com.nonicafe.dto.CommentProductDTO;
import com.nonicafe.entity.ContactEntity;
import com.nonicafe.entity.PostEntity;
import com.nonicafe.entity.ProductContactEntity;
import com.nonicafe.entity.ProductEntity;
import com.nonicafe.repository.PostRepository;
import com.nonicafe.repository.ProductRepository;
import com.nonicafe.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Date;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DecimalFormat decimalFormat;


    @Override
    public void sentMailCommentPost(CommentPostDTO commentPostDTO, Long postId) {
        PostEntity postEntity = postRepository.findOne(postId);
        simpleMailMessage.setSubject("Bình luận mới trong: " + postEntity.getTitle());
        String text = "Bài viết: " + postEntity.getTitle() + "\n" +
                "Tên: " + "\n" + commentPostDTO.getName() + "\n" +
                "Số điện thoại: " + commentPostDTO.getPhone() + "\n" +
                "Email: " + commentPostDTO.getEmail() + "\n" +
                "Nội dung bình luận: " + commentPostDTO.getMain();
        simpleMailMessage.setText(text);
        simpleMailMessage.setSentDate(new Date());
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sentMailCommentProduct(CommentProductDTO commentProductDTO, Long productId) {
        ProductEntity productEntity = productRepository.findOne(productId);
        simpleMailMessage.setSubject("Bình luận mới trong sản phẩm: " + productEntity.getName());
        String text = "Tên sản phẩm: " + productEntity.getName() + "\n" +
                "Tên: " + "\n" + commentProductDTO.getName() + "\n" +
                "Số điện thoại: " + commentProductDTO.getPhone() + "\n" +
                "Email: " + commentProductDTO.getEmail() + "\n" +
                "Nội dung bình luận: " + commentProductDTO.getMain();
        simpleMailMessage.setText(text);
        simpleMailMessage.setSentDate(new Date());
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public void sentMailContact(ContactEntity contactEntity) {
        simpleMailMessage.setSubject("Đơn Hàng Mới Chưa Xử Lí !!!");
        StringBuilder detailProduct = new StringBuilder();
        int total = 0;
        for (ProductContactEntity item : contactEntity.getProductContactEntities()) {
            String detail = String.format("%-40s%-10s%-20s",
                    item.getProductEntity().getName(), "x" + item.getQuantity(), decimalFormat.format((long) item.getProductEntity().getPrice() * item.getQuantity()));
            total += item.getProductEntity().getPrice() * item.getQuantity();
            detailProduct.append(detail).append("\n");
        }
        detailProduct.append("==============================").append("\n");

        StringBuilder text = new StringBuilder()
                .append("Ngày Nhận Đơn: ").append(contactEntity.getCreatedDate()).append("\n")
                .append("Tên Khách Hàng: ").append(contactEntity.getName()).append("\n")
                .append("Số Điện Thoại: ").append(contactEntity.getPhone()).append("\n")
                .append("Email: ").append(contactEntity.getEmail()).append("\n")
                .append("Địa Chỉ: ").append(contactEntity.getAddress()).append("\n")
                .append("--------------------------------------------------").append("\n")
                .append("Đơn Hàng Bao Gồm: ").append("\n")
                .append(String.format("%-40s%-10s%-20s", "Tên SP", "SL", "Tạm Tính")).append("\n")
                .append("==============================").append("\n")
                .append(detailProduct)
                .append("Tổng đơn hàng: ").append(decimalFormat.format(total)).append(" VND");
        simpleMailMessage.setText(text.toString());
        javaMailSender.send(simpleMailMessage);
    }
}
