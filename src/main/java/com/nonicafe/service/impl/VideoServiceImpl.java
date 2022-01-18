package com.nonicafe.service.impl;

import com.nonicafe.constant.VideoConstant;
import com.nonicafe.converter.VideoConverter;
import com.nonicafe.dto.AbstractDTO;
import com.nonicafe.dto.VideoDTO;
import com.nonicafe.entity.VideoEntity;
import com.nonicafe.repository.VideoRepository;
import com.nonicafe.service.VideoService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoConverter videoConverter;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AbstractDTO<VideoDTO> findAll(Integer page) {
        AbstractDTO<VideoDTO> videoDTOS = new AbstractDTO<>();
        Page<VideoEntity> videoEntityPage = videoRepository.findAll(new PageRequest(page-1,9));
        videoDTOS.setTotalPage(videoEntityPage.getTotalPages());
        videoDTOS.setPage(page);
        videoDTOS.setListResult(videoEntityPage.getContent().stream().map(item->videoConverter.toVideoDTO(item)).collect(Collectors.toList()));
        return videoDTOS;
    }

    @Override
    public List<VideoDTO> findAll() {
        return videoRepository.findAll().stream().map(item->videoConverter.toVideoDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<VideoDTO> findTop6() {
        List<VideoDTO> videoDTOS = new ArrayList<>();
        videoRepository.findTop6ByOrderByCreatedDateDesc().forEach(item -> {
            VideoDTO videoDTO = videoConverter.toVideoDTO(item);
            videoDTOS.add(videoDTO);
        });
        return videoDTOS;
    }

    @Override
    @Transactional
    public List<VideoDTO> update() {
        List<VideoEntity> videoEntities = new ArrayList<>();
        try {
            videoRepository.deleteAll();
            String res = restTemplate.getForObject(VideoConstant.URL, String.class);
            if (!StringUtils.isEmpty(res)) {
                JSONObject jsonObject = new JSONObject(res);
                for (Object o : jsonObject.getJSONArray("items")) {
                    VideoEntity videoEntity = convertByJson(new JSONObject(o.toString()));
                    if (videoEntity != null) {
                        videoEntities.add(videoEntity);
                    }
                }
                String nextPageToken = null;
                try {nextPageToken = jsonObject.getString("nextPageToken");} catch (Exception ignored) {}
                while (!Objects.isNull(nextPageToken)) {
                    String resLoop = restTemplate.getForObject(VideoConstant.URL + nextPageToken, String.class);
                    if (!StringUtils.isEmpty(resLoop)) {
                        JSONObject jsonObjectLoop = new JSONObject(res);
                        try {nextPageToken = jsonObjectLoop.getString("nextPageToken");} catch (Exception ignored) {}
                        for (Object o : jsonObjectLoop.getJSONArray("items")) {
                            VideoEntity videoEntity = convertByJson(new JSONObject(o.toString()));
                            if (videoEntity != null) {
                                videoEntities.add(videoEntity);
                            }
                        }
                    }
                }
            }
            videoRepository.save(videoEntities);
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public VideoEntity convertByJson(JSONObject oJson) {
        VideoEntity videoEntity = new VideoEntity();
        try {
            videoEntity.setLink(oJson.getJSONObject("id").getString("videoId"));
            videoEntity.setTitle(oJson.getJSONObject("snippet").getString("title"));
            videoEntity.setThumbnail(oJson.getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("medium").getString("url"));
            return videoEntity;
        } catch (Exception e) {
            return null;
        }
    }
}
