package org.gradle;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {

	private final String DRIVER = "com.mysql.jdbc.Driver";


	private java.sql.Connection getConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			try {
				return DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> list() {
		List<Employee> lista = new ArrayList<Employee>();
		try {
			PreparedStatement st = getConnection().prepareStatement("SELECT * from emp_details ORDER BY emp_id ASC");
			ResultSet rs = st.executeQuery();

			if (rs.next())
				lista.add(new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getString("emp_email"),rs.getString("emp_gender"),rs.getString("emp_address")));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void limpaProcessamentoByUser(String usuario){
		System.out.println("clean controle_processamento");
		try {
			PreparedStatement st = getConnection().prepareStatement("delete from safe_bd.controle_processamento where usuario=?");
			st.setString(1, usuario);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void limpaConsolidado(String cnpj){
		System.out.println("clean relatorio_consolidado022015");
		try {
			PreparedStatement st = getConnection().prepareStatement("delete from consolidado.relatorio_consolidado022015 where cnpj=?");
			st.setString(1, cnpj);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void limpaRelatorios(String arquivo){
		System.out.println("clean relatorios");
		try {
			PreparedStatement st = getConnection().prepareStatement("delete  from safe_bd.relatorios where relatorio like '%"+arquivo+"%'");
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void limpaRegistrosC100(String cnpj){
		System.out.println("clean registroc100022015");
		try {
			PreparedStatement st = getConnection().prepareStatement("delete  from icms_"+cnpj+".registroc100022015");
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void limpaRegistros0200(String cnpj){
		System.out.println("clean registro0200022015");
		try {
			PreparedStatement st = getConnection().prepareStatement("delete  from icms_"+cnpj+".registro0200022015");
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public int selectCount(String query,String parameter,String log){
		System.out.println("get info from "+log);
		try {
			PreparedStatement st = getConnection().prepareStatement("select count(*) as count "+query+" ?");
			st.setString(1,parameter);
			ResultSet rs = st.executeQuery();

			if (rs.next())
				return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public int relatorio(String arq) {
		System.out.println("get info from relatorios");
		try {
			PreparedStatement st = getConnection().prepareStatement("select count(*) as count from safe_bd.relatorios where relatorio like '%"+arq+"%'");
			ResultSet rs = st.executeQuery();

			if (rs.next())
				return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String registroC(String dt,String cnpj) {
		System.out.println("get info from registroc100022015");
		try {
			PreparedStatement st = getConnection().prepareStatement("select linha  from icms_"+cnpj+ ".registroc100022015 where dt_doc=?");
			st.setString(1,dt);
			ResultSet rs = st.executeQuery();

			if (rs.next())
				return rs.getString("linha");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}


	
	public int registro0205(String cnpj) {
		System.out.println("get info from registro0205022015");
		try {
			PreparedStatement st = getConnection().prepareStatement("select count(*) as count  from icms_"+cnpj+ ".registro0205022015");
			ResultSet rs = st.executeQuery();

			if (rs.next())
				return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
