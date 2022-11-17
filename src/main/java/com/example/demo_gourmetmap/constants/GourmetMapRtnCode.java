package com.example.demo_gourmetmap.constants;

public enum GourmetMapRtnCode {

	SUCCESSFUL("200", "Successful"),      //�s�W���\
	UPDATE_SUCCESSFUL ("200","update Successful"), //�ק�
	DELETE_SUCCESSFUL ("200","Delete Successful"),  //�R��
	QUERY_SUCCESSFUL ("200","Query Successful"),   //�d��
	NOT_NULL ("400","Value can not null!!!"),  //��줣�o����
	STORE_NAME_EXISTED("400","store name existed"),  //���W�w�s�b
	STORE_NAME_AND_MEALS_EXISTED("400","store name existed"),  //���W�B�\�I�w�s�b
	NO_DATA("400","no data"); //�d�L��T

	private String code;
	private String message;

	private GourmetMapRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
