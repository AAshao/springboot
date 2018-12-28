package com.ss.mapper;

import java.util.List;
import java.util.Map;

import com.ss.entity.StudentInfo;

public interface StudentDao {

	public List<StudentInfo> queryStudents();
	//单条插入
	public int insertStudent(StudentInfo stu);
	//批量插入
	public int insertBatchStu(List<StudentInfo>  stus);
	
	//更新操作
	public int updateStu(Map<String, Object> map);
}
