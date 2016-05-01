package dBManagement.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dBManagement.GetVotes;



public class GetV implements GetVotes{

	String SQL_DRV = "org.hsqldb.jdbcDriver";
	String SQL_URL = "jdbc:hsqldb:hsql://localhost/";
	@Override
	public List<Object[]> countAllVotes() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Connection con = null;
		
		List<Object[]> votos=new ArrayList<>();
		
		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT v.elemento_votable_id, COUNT(v.id) votos FROM voto v GROUP BY v.elemento_votable_id");
			rs = ps.executeQuery();
			
			ps = con.prepareStatement("SELECT v.descripcion FROM votable_option v where id = ?");
			
			while (rs.next()) {
				
				
				
				ps.setLong(1, rs.getLong(1));
				rs2=ps.executeQuery();
				
				while (rs2.next()) {
				
					Object[] v=new Object[2];
					v[0]=rs2.getString(1);
					v[1]=rs.getLong(2);
					votos.add(v);
				}
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return votos;
	}
	@Override
	public List<Object[]> findAllPollingStations() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		Connection con = null;
		
		List<Object[]> stations=new ArrayList<>();
		

		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT DISTINCT v.colegio_id, COUNT(v.id) FROM voto v GROUP By v.colegio_id");
			rs = ps.executeQuery();
			
			ps = con.prepareStatement("SELECT v.codigo FROM electoral_college v where id = ?");
			
			while (rs.next()) {
				ps.setString(1, rs.getString(1));
				rs2=ps.executeQuery();
				
				while (rs2.next()) {
				Object[] v=new Object[2];
				v[0]=rs2.getString(1);
				v[1]=rs.getLong(2);
				stations.add(v);
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stations;
	}
	@Override
	public List<Object[]> findVotersByPollingStationAndParty() {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		Connection con = null;
		
		List<Object[]> votos=new ArrayList<>();
		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT  v.colegio_id, v.elemento_votable_id, COUNT(v.id) FROM voto v GROUP By v.colegio_id,v.elemento_votable_id ORDER BY v.colegio_id");
			rs = ps.executeQuery();
			
			ps = con.prepareStatement("SELECT v.codigo FROM electoral_college v where id = ?");
			
			
			
			while (rs.next()) {
				ps.setString(1, rs.getString(1));
				rs2=ps.executeQuery();
				
                rs2.next(); //colegio
                
                ps1 = con.prepareStatement("SELECT v.descripcion FROM votable_option v where id = ?");
                
                ps1.setLong(1, rs.getLong(2));
				rs3=ps1.executeQuery();
				rs3.next();
				
				Object[] v=new Object[3];
				v[0]=rs2.getInt(1);
				v[1]=rs3.getString(1);
				v[2]=rs.getLong(3);
				votos.add(v);
                
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return votos;
	}
	@Override
	public List<Object[]> findVotesByPollingStationAndParty(Integer sc) {
		PreparedStatement ps = null;
		PreparedStatement psID = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		Connection con = null;
		
		List<Object[]> stations=new ArrayList<>();
		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT  v.elemento_votable_id, COUNT(v.id) FROM voto v  WHERE v.colegio_id=? GROUP By v.elemento_votable_id");
			
			
			//buscar id de colegio
			psID = con.prepareStatement("SELECT v.id FROM electoral_college v where codigo = ?");
			psID.setInt(1, sc);
			rs = psID.executeQuery();
			rs.next();
			
			Integer idCol=rs.getInt(1);
			
			
			ps.setInt(1, idCol);
			
			rs=ps.executeQuery();
			
			ps = con.prepareStatement("SELECT v.descripcion FROM votable_option v where id = ?");
			
			while (rs.next()) {
				
				ps.setLong(1, rs.getLong(1));
				rs2=ps.executeQuery();
				
				while (rs2.next()) {
				Object[] v=new Object[2];
				v[0]=rs2.getString(1);
				v[1]=rs.getLong(2);
				stations.add(v);
				}
			}
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stations;
	}
	@Override
	public List<Object[]> findStationCodes() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		Connection con = null;
		
		List<Object[]> stations=new ArrayList<>();
		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT DISTINCT v.colegio_id FROM voto v");
			
			rs = ps.executeQuery();
			
			ps = con.prepareStatement("SELECT v.codigo FROM electoral_college v where id = ?");
			
			while (rs.next()) {
				ps.setString(1, rs.getString(1));
				rs2=ps.executeQuery();
				
				while (rs2.next()) {
					Object[] v=new Object[1];
					v[0]=rs2.getString(1);
					stations.add(v);
				}
			}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stations;
	}
	@Override
	public List<String> findPartidos() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Connection con = null;
		
		List<String> stations=new ArrayList<>();
		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT DISTINCT v.nombre FROM votable_option v");
			
			rs=ps.executeQuery();
			
			
			while (rs.next()) {
				
				//v[c]=rs.getString(1);
				//c++;
				stations.add(rs.getString(1));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		return stations;
	}
	@Override
	public List<Object[]> findVotespartido(String sc) {
		PreparedStatement ps = null;
		PreparedStatement psidParti = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		
		List<Object[]> stations=new ArrayList<>();
		try {
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "sa", "");
			ps = con.prepareStatement("SELECT  v.colegio_id, COUNT(v.id) FROM voto v  WHERE v.elemento_votable_id=? GROUP By v.colegio_id");
			
			
			psidParti = con.prepareStatement("SELECT v.id FROM votable_option v where nombre = ?");
			psidParti.setString(1, sc);
			
			rs=psidParti.executeQuery();
			
			rs.next();
			
			int idPar=rs.getInt(1);
			
			ps.setLong(1, idPar);
			rs1=ps.executeQuery();
			
			
			ps = con.prepareStatement("SELECT v.codigo FROM electoral_college v where id = ?");
			while(rs1.next()){
				ps.setInt(1, rs1.getInt(1));
				rs2=ps.executeQuery();
				rs2.next();
				
				Object[] v=new Object[2];
				v[0]=rs2.getInt(1);
				v[1]=rs1.getInt(2);
				stations.add(v);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stations;
	}
	
	
	
	
	
}
