package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExamsDefsWS {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;
	
	public ExamsDefsWS() {
		conectar();
	}
	
	private void conectar(){
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/universidad", 
					"postgres","123");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		catch(SQLException e){
			e.printStackTrace();
			
		}
	}
	public int addExam(ExamDef exam){
		int result =0;
		if (connection != null) {
			try {
				ps = connection.prepareStatement(
						"INSERT INTO exam (name,description,minimum_corr,duration,exam_take,question_def) "
						+ "VALUES (?,?,?,?,?,?);");
				ps.setString(1, exam.getName());
				ps.setString(2, exam.getDescription());
				ps.setInt(3,exam.getMininumCorr());
				ps.setInt(4,exam.getDuration());
				ps.setString(5, exam.getExamTake());
				ps.setString(6, exam.getQuestionDef());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int editExam(ExamDef exam){
		int result =0;
		if (connection != null) {
			try {
				ps = connection.prepareStatement(
						"UPDATE exam SET name =? , "
						+ "description = ? ,"
						+ "minimun_corr = ? , "
						+ "duration = ? ,"
						+ "exam_take = ? ,"
						+ "question_def"
						+ "WHERE id = ?;");
				ps.setString(1, exam.getName());
				ps.setString(2, exam.getDescription());
				ps.setInt(3,exam.getMininumCorr());
				ps.setInt(4,exam.getDuration());
				ps.setString(5, exam.getExamTake());
				ps.setString(6, exam.getQuestionDef());
				ps.setInt(7,exam.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public int removeExam(int id){
		int result =0;
		if (connection != null) {
			try {
				ps = connection.prepareStatement(
						"DELETE FROM exam WHERE id = ?;");
				ps.setInt(1, id);
				result =ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ExamDef[] getExams(){
		ExamDef [] result = null;
		List<ExamDef> exams = new ArrayList<ExamDef>();
		
		if (connection != null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery(
						"SELECT * FROM exam;");
				while (resultSet.next()) {
					ExamDef exam = new ExamDef(
							resultSet.getInt("id"),
							resultSet.getString("name"),
							resultSet.getString("description"),
							resultSet.getInt("minimum_corr"),
							resultSet.getInt("duration"),
							resultSet.getString("exam_take"),
							resultSet.getString("question_def"));
					exams.add(exam);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return exams.toArray(new ExamDef[exams.size()]);
	}
	
	
	public ExamDef getOneExamDef(int id){
		ExamDef exam = null;
		if(connection!=null){
			try {
				ps = connection.prepareStatement("SELECT * FROM exam WHERE id = ?");
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
				if (resultSet.next()){
					exam = new ExamDef(
							resultSet.getInt("id"),
							resultSet.getString("name"),
							resultSet.getString("description"),
							resultSet.getInt("minimum_corr"),
							resultSet.getInt("duration"),
							resultSet.getString("exam_take"),
							resultSet.getString("question_def"));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
		return exam;
	}
}
