package com.project.ezkit.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

   @Autowired
   private NoticeMapper mapper;
   
   // 공지사항 등록
   public void insertNotice(Notice n) {
      mapper.insertNotice(n);
   }
   
   // 공지사항 수정
   public void updateNotice(Notice n) {
      mapper.updateNotice(n);
   }
   
   // 공지사항 삭제
   public void deleteNotice(int notice_num) {
      mapper.deleteNotice(notice_num);
   }
   
   // 공지사항 전체 출력
   public List selectAllNotice() {
      return mapper.selectAllNotice();
   }
   
   // notice_num으로 공지사항 출력
   public Notice selectNoticeByNum(int notice_num) {
      return mapper.selectNoticeByNum(notice_num);
   }
   
   // 조회수 증가
   public void noticeHits(int notice_num) {
      mapper.noticeHits(notice_num);
   }
   
   public int getNoticeNum() {
      return mapper.getNoticeNum();
   }
   
}