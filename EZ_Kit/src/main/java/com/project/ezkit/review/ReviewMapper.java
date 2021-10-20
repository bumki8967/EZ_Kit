package com.project.ezkit.review;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReviewMapper {

	void insertReview(Review r);
	
	List selectAllReview();
	
	List selectReviewByProductNum(int product_num);
	
	void updateReview(Review r);
	
	void deleteReview(int review_num);
	
	Review selectReviewByNum(int review_num);
	
}
