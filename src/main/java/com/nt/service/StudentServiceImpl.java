package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao;

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	

	@Override
	public List<StudentDTO> fetchAllStudents() {
		List<StudentBO> listBO=null;
		final List<StudentDTO> listDTO=new ArrayList();

		//use DAO
		listBO=dao.getAllStudents();
		//Covert listBO to listDTO
		
		listBO.forEach(bo->{
			StudentDTO dto=null;
			dto=new StudentDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method

	@Override
	public StudentDTO fetchStudentByNo(int no) {
        StudentBO bo=null;
        StudentDTO dto=null;
		//use DAO
        bo=dao.getStudentByNo(no);
        //convert BO to DTO
        dto=new StudentDTO();
        BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	@Override
	public String modifyStudentByNo(StudentDTO dto) {
		int count=0;
		StudentBO bo=null;
		//Convert DTO to BO
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		System.out.println(dto.getSno());
		//use DAO
		count=dao.modifyStudentByNo(bo);
		if(count==0)
		  return "User "+dto.getSname()+" Record Updatation failed !";
		else
		  return dto.getSname()+" Record updation succeded !";	
	}
	@Override
	public String deleteStudentByNo(StudentDTO dto) {
		int count=0;
		StudentBO bo=null;
		//Convert DTO to BO
		bo=new StudentBO();
		
		BeanUtils.copyProperties(dto, bo);
		System.out.println(bo);
		//use DAO
		count=dao.deleteStudentByNo(bo);
		if(count==0)
		  return "User "+dto.getSname()+" Deletion failed";
		else
		  return "User "+dto.getSname()+" Deletion succeded";	
	}
	
	@Override
	public String registerStudent(StudentDTO dto) {
		StudentBO bo=null;
		int count=0;
		//Convert DTO to BO
		bo=new StudentBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insertStudent(bo);
		 if(count==0)
		   return "User "+dto.getSname()+"Student Registration failed";
		 else
			 return "User "+dto.getSname()+"Student Registration succeded";		 
	}//method
	
	@Override
	public int fetchStudentNumber() {
		int sno=0;
		//use DAO class
		sno=dao.generateStudentNumber();
		return sno;
	}
	
}//class
