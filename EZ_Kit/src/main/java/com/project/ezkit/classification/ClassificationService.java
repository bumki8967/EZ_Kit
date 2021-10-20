package com.project.ezkit.classification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {

	@Autowired
	private ClassificationMapper mapper;

	public void insertClassification(Classification c) {
		mapper.insertClassification(c);
	}

	public Classification selectClassificationByNum(int classification_num) {
		return mapper.selectClassificationByNum(classification_num);
	}

	public List<Classification> selectClassificationAll() {
		return mapper.selectClassificationAll();
	}

	public void updateClassification(Classification c) {
		mapper.updateClassification(c);
	}

	public void deleteClassification(int classification_num) {
		mapper.deleteClassification(classification_num);
	}

}
