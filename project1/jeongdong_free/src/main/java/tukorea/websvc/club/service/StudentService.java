package tukorea.websvc.club.service;

import java.util.ArrayList;

import tukorea.websvc.club.domain.StudentVO;
import tukorea.websvc.club.persistence.StudentDAO;

public class StudentService {
	
	public ArrayList<StudentVO> readStudentList() {
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentVO> studentList = dao.getStudentList();
		return studentList;
	}
	
	public void deleteStudent(String id) {
		StudentDAO dao = new StudentDAO();
		String strId = id;
		dao.delete(strId);
	}
	
	public StudentVO readStudent(String id) {
		StudentDAO dao = new StudentDAO();
		StudentVO student = dao.read(id);
		
		return student;
	}
	
	public StudentVO joinStudent(String id, String password, String username, String snum, String depart, String mobile, String email) {
		
		
		StudentVO studentVO = new StudentVO();
		
		studentVO.setId(id);
		studentVO.setPasswd(password);
		studentVO.setUsername(username);
		studentVO.setSnum(snum);
		studentVO.setDepart(depart);
		studentVO.setMobile(mobile);
		studentVO.setEmail(email);
		
		StudentDAO studentDAO = new StudentDAO();
		studentDAO.join(studentVO);
		
		return studentVO;
	}
	
	public String addStudent(StudentVO studentVO) {
		String message;
		StudentDAO studentDAO = new StudentDAO();
		
		if(studentDAO.add(studentVO)) message = "가입 축하합니다";
		else message = "가입 실패입니다";
		
		return message;
	}
	
	public void updateStudent(String id, String password, String username, String snum, String depart, String mobile, String email) {
		StudentVO studentVO = new StudentVO();
		StudentDAO studentDAO = new StudentDAO();
		
		studentVO.setId(id);
		studentVO.setPasswd(password);
		studentVO.setUsername(username);
		studentVO.setSnum(snum);
		studentVO.setDepart(depart);
		studentVO.setMobile(mobile);
		studentVO.setEmail(email);
		
		studentDAO.update(studentVO);
	}
	
	public String login(String id, String passwd) {
		String result;
		StudentVO studentVO;
		StudentDAO studentDAO = new StudentDAO();
		
		studentVO = studentDAO.read(id);
		if (studentVO.getId().equals(id) && studentVO.getPasswd().equals(passwd)) {
			if(id.equals("admin")) result = "admin";
			else result = "user";
		} else {
			result = "none";
		}
		return result;
	}
}
