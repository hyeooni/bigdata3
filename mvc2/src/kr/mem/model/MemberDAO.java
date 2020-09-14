package kr.mem.model;
import java.sql.*;
//JDBC -> myBatis �� �ٲ��� ��
import java.util.ArrayList;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//�����ε�		�� �����̳�? VVV���������� ���� �ϱ� ���ؼ�. complie�� �� �����ϸ� ���ŷο��� ����.  �����ϴ� �������� class�� �޸𸮸� �÷���.
	// �ʱ�ȭ��
	//		��ü���� �� �� �� ó���� ���� �� �� ���� ��.
	//		����̹� �� ���� �ε��ϸ� ��.
	static {
		try {					// DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnect() {
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user="hr";
		String password="hr";
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public int memberInsert( MemberVO vo ) {
		conn=getConnect();
		//MyBatis
		String SQL="insert into tblMem values(seq_num.nextval,?,?,?,?,?)";
		int cnt=-1;//-1(����)
		try {
			ps=conn.prepareStatement(SQL);		//�Ķ���Ͱ� �ִ� sql.�̿ϼ���. �̿ϼ� sql�� ������ ������ precompile.  ,?,?,?,?,?�� compile����� �ƴ�
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPhone());
			ps.setString(3, vo.getAddr());
			ps.setDouble(4, vo.getLat());
			ps.setDouble(5, vo.getLng());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	public ArrayList<MemberVO> memberAllList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		conn=getConnect();
		String SQL="select*from tblMem order by num desc";
		try {
			ps=conn.prepareStatement(SQL);
			rs=ps.executeQuery();	//rs�� ������ Ŀ��
			while(rs.next()) {
				int num = rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				double lat=rs.getDouble("lat");
				double lng=rs.getDouble("lng");
				MemberVO vo = new MemberVO(num,name,phone,addr,lat,lng);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	public int memberDelete(int num) {
		conn=getConnect();
		String SQL="delete from tblMem where num=?";
		int cnt=-1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt=ps.executeUpdate();	// 1
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	public void dbClose() {
		//��ü�� ������� ��쿡��  close
		try {
		if(rs!=null) rs.close();
		if(rs!=null) ps.close();
		if(rs!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO memberContent(int num) {
		MemberVO vo=null;
		conn=getConnect();
		String SQL="select * from tblMem where num=?";
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs=ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				double lat=rs.getDouble("lat");
				double lng=rs.getDouble("lng");
				vo = new MemberVO(num,name,phone,addr,lat,lng);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return vo;
	}
	public int memberUpdate(MemberVO vo) {
		conn=getConnect();
		String SQL="update tblMem set phone=?, addr=? where num=?";
		int cnt=-1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setString(1, vo.getPhone());
			ps.setString(2, vo.getAddr());
			ps.setInt(3, vo.getNum());
			cnt=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
}
