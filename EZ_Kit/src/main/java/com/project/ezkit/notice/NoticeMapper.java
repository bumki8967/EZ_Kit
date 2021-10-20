package com.project.ezkit.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

   // 공지사항 추가
   void insertNotice(Notice n);
   
   // 공지사항 전체 출력
   List selectAllNotice();
   
   
   // notice_num으로 공지사항 출력
   Notice selectNoticeByNum(int notice_num);
   
   
   // 공지사항 수정
   void updateNotice(Notice n);

   
   // 조회수 증가
   void noticeHits(int notice_num);

   
   // 공지사항 삭제
   void deleteNotice(int notice_num);
   
   // 공지사항 글번호
   int getNoticeNum();
}