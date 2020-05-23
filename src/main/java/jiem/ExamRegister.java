package jiem;

public class ExamRegister  {
	
	CommonDAO dao;
	
	public ExamRegister(CommonDAO dao) {
		this.dao = dao;
	}
	
	public boolean registerExam(Student student, Exam exam)  {
		
		if(examAvailability() && isStudentApplicableForExam(student, exam)) {
			return true;
		}
		return false;
	}
	
	public boolean isStudentApplicableForExam(Student student, Exam exam){
		double dbl = student.getAccountBalance();
		if(exam.getExamPrice() > dbl) {
			return false;
		}
		return true;
	}
	
	
	public boolean examAvailability() {
		if(totalSearBooked() >= 30) {
			return false;
		}
		return true;
	}
	
	public int totalSearBooked() {
		return dao.getTotalSeats();
	}
	
	
	
	
	
}
