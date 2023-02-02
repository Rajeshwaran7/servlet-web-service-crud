package com.ty.studentapp.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.studentapp.dao.Student;

public class StudentDatabaseOperation {
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String URL ="jdbc:mysql://localhost:3306/practice";
	private static final String USER="root";
	private static final String PASSWORD="tiger";
	
	public Student byId(int id2) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			    String query="SELECT * FROM student WHERE sId=?";
				pstm=con.prepareStatement(query);
		       pstm.setInt(1, id2);
				rs=pstm.executeQuery();

				if(rs.next())
				{

					Student s=new Student();
					int id=rs.getInt(1);
					String name=rs.getString(2);
					double marks=rs.getDouble(3);
					String emailid=rs.getString(4);
					String password=rs.getString(5);

					s.setsId(id);
					s.setName(name);
					s.setMarks(marks);
					s.setEmailId(emailid);
					s.setPwd(password);
				    return s;	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		  return null;
		

	}
	public boolean insertRow(Student stu)
	{
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			Class.forName(DRIVER);
			
			try {
				con=DriverManager.getConnection(URL, USER, PASSWORD);
				String query ="INSERT INTO student VALUES(?,?,?,?,?)";
				pstm=con.prepareStatement(query);
				pstm.setInt(1, stu.getsId());
				pstm.setString(2, stu.getName());
				pstm.setDouble(3, stu.getMarks());
				pstm.setString(4, stu.getEmailId());
				pstm.setString(5, stu.getPwd());
				int rowAffected =pstm.executeUpdate();
				if(rowAffected !=0)
				{
					return true;
				}
				else 
				{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm !=null)
			{
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
		
	}
	public Student logIn(String email, String pwd) {
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			String query="SELECT * FROM student WHERE emailId =? and pwd=?";
				pstm=con.prepareStatement(query);
				pstm.setString(1, email);
				pstm.setString(2, pwd);
				rs=pstm.executeQuery();
				if(rs.next())
				{
					Student s=new Student();
					
					int id=rs.getInt(1);
					String name=rs.getString(2);
					double marks=rs.getDouble(3);
					String emailid=rs.getString(4);
					String password=rs.getString(5);

					s.setsId(id);
					s.setName(name);
					s.setMarks(marks);
					s.setEmailId(emailid);
					s.setPwd(password);
      				return s;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	

		// TODO Auto-generated method stub
		
	}
	public boolean updatePassword(String email, String pwd) {
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			String query="Update student SET pwd = ? WHERE emailId = ?";
				pstm=con.prepareStatement(query);
				pstm.setString(1, pwd);
				pstm.setString(2, email);
               int rowAffected = pstm.executeUpdate();
				if(rowAffected != 0)
				{
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}	

		
		return false;
	}
	public List<Student> searchOnMarks(double m1, double m2) {
		List<Student> ss=new ArrayList<Student>();
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			String query="SELECT * FROM student WHERE marks BETWEEN ? AND ?";
				pstm=con.prepareStatement(query);
				pstm.setDouble(1, m1);
				pstm.setDouble(2, m2);
				rs=pstm.executeQuery();
			     while(rs.next())
				{
			    	 Student s =new Student();
					
					int id=rs.getInt(1);
					String name=rs.getString(2);
					double marks=rs.getDouble(3);
					String emailid=rs.getString(4);
					String password=rs.getString(5);


					s.setsId(id);
					s.setName(name);
					s.setMarks(marks);
					s.setEmailId(emailid);
					s.setPwd(password);
					  ss.add(s);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return ss;
	

		// TODO Auto-generated method stub
		
	}
	public ArrayList<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> ss=new ArrayList<Student>();
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			String query="SELECT * FROM student";
				pstm=con.prepareStatement(query);
				rs=pstm.executeQuery();
			     while(rs.next())
				{
			    	 Student s =new Student();
					
					int id=rs.getInt(1);
					String name=rs.getString(2);
					double marks=rs.getDouble(3);
					String emailid=rs.getString(4);
					String password=rs.getString(5);

					s.setsId(id);
					s.setName(name);
					s.setMarks(marks);
					s.setEmailId(emailid);
					s.setPwd(password);
					  ss.add(s);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return (ArrayList<Student>) ss;

	}
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			Class.forName(DRIVER);
			
			try {
				con=DriverManager.getConnection(URL, USER, PASSWORD);
				
				String query ="DELETE FROM student WHERE sId=?";
				pstm=con.prepareStatement(query);
				pstm.setInt(1, id);
			
				int rowAffected =pstm.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm !=null)
			{
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		

		
	}
	public Student getStudent(int id) {
		Connection con=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			    String query="SELECT * FROM student WHERE sId=?";
				pstm=con.prepareStatement(query);
		       pstm.setInt(1, id);
				rs=pstm.executeQuery();

				if(rs.next())
				{

					Student s=new Student();
					int id1=rs.getInt(1);
					String name=rs.getString(2);
					double marks=rs.getDouble(3);
					String emailid=rs.getString(4);
					String password=rs.getString(5);

					s.setsId(id);
					s.setName(name);
					s.setMarks(marks);
					s.setEmailId(emailid);
					s.setPwd(password);
				    return s;	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		  return null;
		

	}
		public boolean updateData(int sid, String name, double marks, String email ) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			Class.forName(DRIVER);
			try {
				con=DriverManager.getConnection(URL,USER,PASSWORD);
			    String query="UPDATE student SET name=?,marks=?,emailId=? WHERE sId =?";
				pstm=con.prepareStatement(query);
				pstm.setString(1, name);
				pstm.setDouble(2, marks);
				pstm.setString(3, email);
				pstm.setInt(4, sid);
				
				int rowAffected =pstm.executeUpdate();
				
				return rowAffected != 0;
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pstm !=null)
				{
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return false;	

	}

}
