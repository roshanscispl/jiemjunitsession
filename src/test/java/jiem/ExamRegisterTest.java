package jiem;

import static org.junit.jupiter.api.Assertions.*;

import javax.jws.soap.InitParam;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ExamRegisterTest {

	@Mock
	CommonDAO dao;

	@Mock
	Student student = new Student();

	@Mock
	Exam exam = new Exam();

	@InjectMocks
	ExamRegister examReg = new ExamRegister(dao);

	@Test
	public void should_return_exam_availability_false_if_booking_more_then_30() {

		try {
			when(dao.getTotalSeats()).thenReturn(31);
			assertFalse(examReg.registerExam(student,exam));
			reset(dao);
			assertFalse(examReg.registerExam(student,exam));
			
			verify(dao, atMost(3)).getTotalSeats();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void should_return_exam_availability_true_if_booking_less_then_29() {

		try {
			when(student.getAccountBalance()).thenReturn(200.00);
			when(exam.getExamPrice()).thenReturn(200.00);
			when(dao.getTotalSeats()).thenReturn(29);
			assertTrue(examReg.registerExam(student,exam));
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void should_return_exception_when_student_account_less_then_0() {
		try {		
			when(student.getAccountBalance()).thenReturn(200.00);
			when(exam.getExamPrice()).thenReturn(200.00);
			when(dao.getTotalSeats()).thenReturn(29);
			assertTrue(examReg.registerExam(student,exam));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
