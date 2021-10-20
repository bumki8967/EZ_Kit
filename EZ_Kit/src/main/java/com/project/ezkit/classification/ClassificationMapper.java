package com.project.ezkit.classification;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassificationMapper {

	void insertClassification(Classification c);

	Classification selectClassificationByNum(int classification_num);

	List<Classification> selectClassificationAll();

	void updateClassification(Classification c);

	void deleteClassification(int classification_num);

}
