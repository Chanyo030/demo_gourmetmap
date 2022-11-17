package com.example.demo_gourmetmap.constants;

public enum GourmetMapRtnCode {

	SUCCESSFUL("200", "Successful"),      //新增成功
	UPDATE_SUCCESSFUL ("200","update Successful"), //修改
	DELETE_SUCCESSFUL ("200","Delete Successful"),  //刪除
	QUERY_SUCCESSFUL ("200","Query Successful"),   //查詢
	NOT_NULL ("400","Value can not null!!!"),  //欄位不得為空
	STORE_NAME_EXISTED("400","store name existed"),  //店名已存在
	STORE_NAME_AND_MEALS_EXISTED("400","store name existed"),  //店名、餐點已存在
	NO_DATA("400","no data"); //查無資訊

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
