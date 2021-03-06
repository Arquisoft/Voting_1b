package es.uniovi.asw.DBUpdate.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.DBUpdate.Insert;
import es.uniovi.asw.DBUpdate.Votante;
import es.uniovi.asw.reportWriter.impl.WReportP;

/**
 * Clase para interactuar con la base de datosaaa
 *
 */
public class InsertP implements Insert {
	
	private static String DRIVER_HSQLDB = "org.hsqldb.jdbcDriver";
	private static String URL_HSQLDB = "jdbc:hsqldb:hsql://localhost";
	private static String USER_HSQLDB = "sa";
	private static String PASS_HSQLDB = "";

	@SuppressWarnings("unused")
	private static String DRIVER_POSTGRESQL = "org.postgresql.Driver";
	@SuppressWarnings("unused")
	private static String URL_POSTGRESQL = "jdbc:postgresql://ec2-54-235-85-65.compute-1.amazonaws.com:5432/ddhkb9n4tp9rvn?sslmode=require";
	@SuppressWarnings("unused")
	private static String USER_POSTGRESQL = "fdrqudzzijmogt";
	@SuppressWarnings("unused")
	private static String PASS_POSTGRESQL = "65bvhXlALUam3hYiighVQw4NQ-";

	private static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static String URL_MYSQL = "jdbc:mysql://127.0.0.1/censuses_1b";
	private static String USER_MYSQL = "travis";
	private static String PASS_MYSQL = "";

	private static Connection con;

	public void conectar () {
		if(System.getenv().get("TRAVIS") == null){
			conectarse(DRIVER_HSQLDB, URL_HSQLDB, USER_HSQLDB, PASS_HSQLDB);
		}
		else{
			conectarse(DRIVER_MYSQL, URL_MYSQL, USER_MYSQL, PASS_MYSQL);
			
		}
	}

	/**
	 * Método para establecer una conexión con la BD
	 */
	protected void conectarse(String driver, String url, String user, String pass) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e){
			throw new RuntimeException("No se ha podido cargar el driver.", e);
		}
		try {
			con = DriverManager.getConnection(url, user, pass);
			if(driver.equals(DRIVER_MYSQL)){
				con.prepareStatement("CREATE TABLE IF NOT EXISTS USUARIOS ( id INT AUTO_INCREMENT PRIMARY KEY,"
						+ " name VARCHAR(30), ename  VARCHAR(50), nif varchar(10), codigo_colegio_id"
						+ " BIGINT, pass varchar(256), admin boolean, UNIQUE(nif), UNIQUE(ename) );").executeUpdate();
				//TODO  cambiar varchar(20) por Long
			}
		} catch (SQLException e) {
			throw new RuntimeException("No se ha podido establecer la conexión.", e);
		}		
	}

	/**
	 * Método para desconectarse de la BD
	 */
	public void desconectar() {
		if (con != null) 
			try { 
				con.close();
			} catch(SQLException e) {};
	}

	public void insert(Votante v){
		String insertar="insert into USUARIOS(name, ename, nif, codigo_colegio_id, pass,admin) values (?,?,?,?,?,?)";
		PreparedStatement insercion = null;
		try {			
			insercion= con.prepareStatement(insertar);
			insercion.setString(1, v.getNombre());
			insercion.setString(2,v.getMail() );
			insercion.setString(3,v.getNif());
			insercion.setLong(4, Long.valueOf(v.getCodigoColegio()));
			insercion.setString(5, v.getContrasena());
			insercion.setBoolean(6, false);
			insercion.executeUpdate();			
		} catch (SQLException e) {
			WReportP r = new WReportP();
			if(e.getSQLState().equals("08001")){
				try {
					r.writeReport("No se puede conectar a la base de datos.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSQLState().equals("23505")){
				try {
					r.writeReport("Ya existe el registro en la base de datos.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				try {
					r.writeReport("Error desconocido en la BD "+e.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		finally {
			try {
				insercion.close();
			} catch (SQLException e) {
				WReportP rw = new WReportP();
				try {
					rw.writeReport("Error desconocido en la BD "+e.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}


	}
	
	public int  deleteAll () {		
		int n = 0;
		String sentencia = "delete from USUARIOS";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sentencia);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n;

	}

	public boolean exists (String nif) {		
		String sentencia = "select * from USUARIOS where nif = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sentencia);
			ps.setString(1, nif);
			rs = ps.executeQuery();
			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;		
	}
	
	public Votante select (String nif) {		
		String sentencia = "select * from USUARIOS where nif = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sentencia);
			ps.setString(1, nif);
			rs = ps.executeQuery();
			if (rs.next())
				return new Votante (rs.getNString("NAME"), rs.getNString("ENAME"), 
						rs.getNString("NIF"), rs.getLong("codigo_colegio_id")+"");
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;		
	}
	
	public int count () {		
		String sentencia = "select count(*) from USUARIOS";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sentencia);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;		
	}

}
