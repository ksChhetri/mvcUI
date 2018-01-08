package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String GET_ALL_STUDENTS="SELECT SNO,SNAME,SADD,BRANCH,FEE FROM STUDENT";
	private static final String GET_STUDENT_BY_NO="SELECT SNO,SNAME,SADD,BRANCH,FEE FROM STUDENT WHERE SNO=?";
	private static final String UPDATE_STUDENT_BY_NO="UPDATE STUDENT SET SNAME=?,SADD=?,BRANCH=?,FEE=? WHERE SNO=?";
	private static final String DELETE_STUDENT_BY_NO="DELETE FROM STUDENT WHERE SNO=?";
	private static final String INSERT_STUDENT="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
	private static final String GET_SNO_BY_SEQUENCE="SELECT STUDENT_SNO_SEQUENCE.nextVal  FROM DUAL";
	private  JdbcTemplate	jt;

	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	
	public List<StudentBO> getAllStudents() {
	    List<StudentBO> listBO=null;
	    listBO=jt.query(GET_ALL_STUDENTS,rs->{
				  List<StudentBO> listStBO=null;
		            listStBO=new ArrayList();
		            StudentBO bo=null;
		            while(rs.next()){
		            	bo=new StudentBO();
		            	bo.setSno(rs.getInt(1));
		            	bo.setSname(rs.getString(2));
		            	bo.setSadd(rs.getString(3));
		            	bo.setSbranch(rs.getString(4));
		            	bo.setSfee(rs.getInt(5));
		            	listStBO.add(bo);
			    }
             return listStBO;
			});
	    return listBO;
	}//method

	@Override
	public StudentBO getStudentByNo(int no) {
		StudentBO bo=null;
		bo=jt.queryForObject(GET_STUDENT_BY_NO,
				             ( rs,index)->{
           StudentBO stBO=null;
           stBO=new StudentBO();
           stBO.setSno(rs.getInt(1));
           stBO.setSname(rs.getString(2));
           stBO.setSadd(rs.getString(3));
           stBO.setSbranch(rs.getString(4));
           stBO.setSfee(rs.getInt(5));
		   return stBO;
		},no);
		return bo;
	}
 @Override
 public int modifyStudentByNo(StudentBO bo) {
	 int count=0;
	 count=jt.update(UPDATE_STUDENT_BY_NO,bo.getSname(),bo.getSadd(),bo.getSbranch(),bo.getSfee(),bo.getSno());
 		return count;
 	}	
 @Override
	public int deleteStudentByNo(StudentBO bo) {
		int count=0;
		count=jt.update(DELETE_STUDENT_BY_NO,bo.getSno());
	 		return count;
	}

 @Override
public int insertStudent(StudentBO bo) {
   int count=0;
   count=jt.update(INSERT_STUDENT, bo.getSno(),bo.getSname(),bo.getSadd(),bo.getSbranch(),bo.getSfee());
   return count;
}
 @Override
public int generateStudentNumber() {
	int sno=0;
	sno=jt.queryForObject(GET_SNO_BY_SEQUENCE, Integer.class);
	return sno;
}
 
}//outer class

/*SQL> create sequence student_sno_sequence start with 1000  increment by 1;
*/