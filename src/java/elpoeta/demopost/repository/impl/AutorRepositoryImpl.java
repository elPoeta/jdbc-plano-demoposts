
package elpoeta.demopost.repository.impl;

import elpoeta.demopost.conexion.Conexion;
import elpoeta.demopost.domain.Autor;

import java.util.List;
import elpoeta.demopost.repository.CrudRepository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elpoeta
 */
public class AutorRepositoryImpl implements CrudRepository<Autor, Integer>{
    private static AutorRepositoryImpl INSTANCE = null;
    private final static String SQL_AUTORES_SELECT = "SELECT * FROM autor;";
    private final static String SQL_AUTOR_SELECT = "SELECT * FROM autor WHERE id = ?;";
    
    private AutorRepositoryImpl() throws ClassNotFoundException,
    IOException, SQLException {
}
    public static AutorRepositoryImpl getInstance() throws ClassNotFoundException,
	IOException, SQLException {
		if (INSTANCE == null) {
			INSTANCE = new AutorRepositoryImpl();
		}
		return INSTANCE;
	}
    @Override
    public Autor buscarPorId(Integer id) throws ClassNotFoundException, IOException, SQLException {
         Autor autor = null;
		Connection conexion = null;
		PreparedStatement ptsmt = null;
		ResultSet rs = null;
		try {
		conexion = Conexion.getInstance().getConnection();
		ptsmt = conexion.prepareStatement(SQL_AUTOR_SELECT);
		ptsmt.setInt(1, id);
		rs = ptsmt.executeQuery();
		
		if(rs.next()) {
		    try {
		        autor = new Autor();
		        autor.setId(rs.getInt("id"));
		        autor.setNombre(rs.getString("nombre"));
		     
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		}
		} finally {
		try {
		    rs.close();
		} finally {
		    try {
		        ptsmt.close();
		    } finally {
		        conexion.close();
		    }
		}
		}
		return autor;

    }

    @Override
    public List<Autor> buscarTodos() throws ClassNotFoundException, IOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Autor obj) throws ClassNotFoundException, IOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Autor obj) throws ClassNotFoundException, IOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrar(Integer id) throws ClassNotFoundException, IOException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
