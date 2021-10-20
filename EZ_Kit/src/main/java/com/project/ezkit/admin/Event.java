package com.project.ezkit.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Event {

   private List<MultipartFile> banner_img;

   public Event() {
      super();
   }

   public Event(List<MultipartFile> banner_img) {
      super();
      this.banner_img = banner_img;
   }

   public List<MultipartFile> getBanner_img() {
      return banner_img;
   }

   public void setBanner_img(List<MultipartFile> banner_img) {
      this.banner_img = banner_img;
   }

   @Override
   public String toString() {
      return "Event [banner_img=" + banner_img + "]";
   }

}