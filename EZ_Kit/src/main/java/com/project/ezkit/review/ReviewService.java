package com.project.ezkit.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper mapper;
	
	/* Review 등록 */
	public void insertReview(Review r) {
		mapper.insertReview(r);
	}
	
	/* Review 전체 출력 */
	public List selectAllReview() {
		return mapper.selectAllReview();
	}
	
	public Review selectReviewByNum(int review_num) {
		return mapper.selectReviewByNum(review_num);
	}
	
	/* 상품번호에 따른 Review 출력 */
	public List selectReviewByProductNum(int product_num) {
		return mapper.selectReviewByProductNum(product_num);
	}
	
	/* Review 수정 */
	public void updateReview(Review r) {
		mapper.updateReview(r);
	}
	
	/* Reivew 삭제 */
	public void deleteReview(int review_num) {
		mapper.deleteReview(review_num);
	}
	
}
