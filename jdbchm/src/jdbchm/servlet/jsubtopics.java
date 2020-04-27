package jdbchm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsubtopics")
public class jsubtopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public jsubtopics() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<jtopiclist> entries = new ArrayList<jtopiclist>();
		List<jsubtopiclist> entries1 = new ArrayList<jsubtopiclist>();
        Connection c = null;
		Integer id = Integer.valueOf(request.getParameter("id"));

       
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM topics WHERE id=" + id );
            
            while( rs.next() ) 
                entries.add( new jtopiclist( rs.getInt( "id" ),
                    rs.getString( "topic" ), rs.getString( "author" ),
                    rs.getTimestamp( "date" ),rs.getString("content"),rs.getInt( "subid" ) ) );



            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
        
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM tp WHERE id=" + id);
            

           while( rs1.next() )
                entries1.add( new jsubtopiclist( rs1.getInt( "id" ),
                    rs1.getString( "name" ), rs1.getString( "message" ),
                    rs1.getTimestamp( "date" ) ) );

            c.close();
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }

        request.setAttribute( "entries", entries );
        request.setAttribute( "entries1", entries1 );
        request.getRequestDispatcher( "/WEB-INF/jsubtopics.jsp" )
            .forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
	            String username = "cs3220stu06";
	            String password = "bI.*X*!.";

	    		String id = String.valueOf(request.getParameter("id").toString());
System.out.println(id);
	            String sql = "insert into tp (id, name,message,date) values (?, ?, ?, now())";
	            c = DriverManager.getConnection( url, username, password );
	            PreparedStatement pstmt = c.prepareStatement( sql );
	            pstmt.setString( 1, id);
	            pstmt.setString( 2, request.getParameter( "name" ) );
	            pstmt.setString( 3, request.getParameter( "message" ));
	            pstmt.executeUpdate();
	            c.close();
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	        }
    		String id = String.valueOf(request.getParameter("id").toString());

	        response.sendRedirect( "jsubtopics?id="+id );
	    }

		}
