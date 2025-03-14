package com.srinu.SpringBoot_RestAPI.repo;

import com.srinu.SpringBoot_RestAPI.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}


// ArrayList to store JobPost objects




// method to return all JobPosts
//public List<JobPost> getAllJobs() {
//    return jobs;
//}

// method to save a job post object into arrayList
//public void addJob(JobPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//
//}
//public JobPost getJob(int jobId){
//    for(var job:jobs){
//        if(job.getPostId()==jobId)
//            return job;
//    }
//    return null;
//}
//
//
//public void updateJob(JobPost jobPost) {
//
//    for(var jobPost1 :jobs){
//        if(jobPost1.getPostId()==jobPost.getPostId()){
//            jobPost1.setPostProfile(jobPost.getPostProfile());
//            jobPost1.setPostDesc(jobPost.getPostDesc());
//            jobPost1.setReqExperience(jobPost.getReqExperience());
//            jobPost1.setPostTechStack(jobPost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//
//    for(var job:jobs){
//        if(job.getPostId()==postId){
//            jobs.remove(job);
//        }
//    }
//}