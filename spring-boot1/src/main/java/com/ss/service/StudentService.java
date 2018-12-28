package com.ss.service;

import java.util.List;
import java.util.Map;

import com.ss.entity.StudentInfo;

public interface StudentService {

	public List<StudentInfo> getStudentInfo();
	
	public void saveStu(StudentInfo stu) throws Exception;
	//批量插入
	public int insertBatchStu(List<StudentInfo>  stus) throws Exception;
	//更新操作
	public int updateStu(Map<String, Object> map) throws Exception;
}
