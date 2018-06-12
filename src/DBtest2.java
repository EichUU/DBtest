import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBtest2 {

	public static void main(String[] ar) {
		
		try{			
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String user="scott";
			String password="1111";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 연결");
			
			Connection con = null;
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
			
			Statement stmt;
			ResultSet rs;
			
			stmt=con.createStatement();
			String sql="select * from emp";
			rs=stmt.executeQuery(sql);
			
			ArrayList<Emp> arr=new ArrayList<>();//arraylist를 통해 관리하자!
			ArrayList<Integer> a=new ArrayList<>();
					
			while(rs.next()) {
				Emp emp=new Emp();
				
				emp.setEname(rs.getString("ename"));				
				emp.setSal(rs.getInt("sal"));
				
				a.add(rs.getInt("tot"));
				arr.add(emp);
				
			} //반복을 하면서 emp객체가 14개가 만들어지고 하나씩 arr에 들어간다
			rs.close();
			stmt.close();
			con.close(); // 반드시 순차적으로 닫아주자
			
			for(Emp emp:arr) { //for each 를 이용해 출력하기
				System.out.println(emp.getEname()+" , "+emp.getSal()+" , "+(emp.getSal()+100));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}
}
