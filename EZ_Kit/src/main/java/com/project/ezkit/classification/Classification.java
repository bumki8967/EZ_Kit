package com.project.ezkit.classification;

public class Classification {

	private int classification_num;
	private String classification_name;

	public Classification() {
		super();
	}

	public Classification(int classification_num, String classification_name) {
		super();
		this.classification_num = classification_num;
		this.classification_name = classification_name;
	}

	public int getClassification_num() {
		return classification_num;
	}

	public void setClassification_num(int classification_num) {
		this.classification_num = classification_num;
	}

	public String getClassification_name() {
		return classification_name;
	}

	public void setClassification_name(String classification_name) {
		this.classification_name = classification_name;
	}

	@Override
	public String toString() {
		return "Classification [classification_num=" + classification_num + ", classification_name="
				+ classification_name + "]";
	}

}
