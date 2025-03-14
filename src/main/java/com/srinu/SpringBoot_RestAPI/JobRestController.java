package com.srinu.SpringBoot_RestAPI;

import com.srinu.SpringBoot_RestAPI.model.JobPost;
import com.srinu.SpringBoot_RestAPI.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobPosts")

    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }
    @GetMapping("jobPost/{jobId}")
    public JobPost getJob(@PathVariable("jobId") int jobId){
        return jobService.getJob(jobId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);

        return jobService.getJob(jobPost.getPostId());

    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        jobService.deletePost(postId);
        return "Delted Post";
    }

    @GetMapping("load")
    public String load(){
        jobService.load();
        return "succes";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> serchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.searchByKeyword(keyword);
    }


}
