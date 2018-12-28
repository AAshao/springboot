package com.ss.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.entity.StudentInfo;
import com.ss.mapper.StudentDao;
import com.ss.service.StudentService;
@Service
public class StudentInfoImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<StudentInfo> getStudentInfo() {
		try {
			return studentDao.queryStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	@Transactional(rollbackFor=Exception.class ,value="txManager")
	public void saveStu(StudentInfo stu) throws Exception {
		try {
		 int i=	studentDao.insertStudent(stu);
		 int m=1/0;
		 System.out.println(i);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	@Override
	public int insertBatchStu(List<StudentInfo> stus) throws Exception {
		try {
			studentDao.insertBatchStu(stus);
		} catch (Exception e) {
			throw new Exception(e.getMessage(),e);
		}
		return 0;
	}
	@Override
	@Transactional("txManager")
	public int updateStu(Map<String, Object> map) throws Exception {
		try {
			studentDao.updateStu(map);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		return 0;
	}

}
