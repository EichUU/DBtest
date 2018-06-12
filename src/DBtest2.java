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
			System.out.println("����̺� ����");
			
			Connection con = null;
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB ���� ����");
			
			Statement stmt;
			ResultSet rs;
			
			stmt=con.createStatement();
			String sql="select * from emp";
			rs=stmt.executeQuery(sql);
			
			ArrayList<Emp> arr=new ArrayList<>();//arraylist�� ���� ��������!
			ArrayList<Integer> a=new ArrayList<>();
					
			while(rs.next()) {
				Emp emp=new Emp();
				
				emp.setEname(rs.getString("ename"));				
				emp.setSal(rs.getInt("sal"));
				
				a.add(rs.getInt("tot"));
				arr.add(emp);
				
			} //�ݺ��� �ϸ鼭 emp��ü�� 14���� ��������� �ϳ��� arr�� ����
			rs.close();
			stmt.close();
			con.close(); // �ݵ�� ���������� �ݾ�����
			
			for(Emp emp:arr) { //for each �� �̿��� ����ϱ�
				System.out.println(emp.getEname()+" , "+emp.getSal()+" , "+(emp.getSal()+100));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}
}
