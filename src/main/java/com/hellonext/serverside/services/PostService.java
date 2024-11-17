package com.hellonext.serverside.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellonext.serverside.domains.Post;
import com.hellonext.serverside.repositories.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public String findById(Long id) {
        JSONObject jsonResult = new JSONObject();
        Optional<Post> postOpt = postRepository.findById(id);
        if(postOpt.isPresent()) {
            Post post = postOpt.get();
            jsonResult.put("status", "ok");
            jsonResult.put("post", post.toJson());
        }
        else {
            jsonResult.put("status", "not_found");
            jsonResult.put("post", "");
        }
        return jsonResult.toString();
    }

    public String findAll() {
        JSONObject jsonResult = new JSONObject();
        List<Post> postList = postRepository.findAll();
        if(postList.size() > 0) {
            jsonResult.put("status", "ok");
            ArrayList<JSONObject> postJsonArr = new ArrayList<JSONObject>();
            for(Post post : postList) {
                postJsonArr.add(post.toJson());
            }
            jsonResult.put("postList", postJsonArr);
        }
        else {
            jsonResult.put("status", "not_found");
            jsonResult.put("postList", "[]");
        }
        return jsonResult.toString();
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
