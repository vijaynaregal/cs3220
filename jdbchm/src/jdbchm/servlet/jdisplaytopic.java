package jdbchm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/jdisplaytopic")
public class jdisplaytopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public jdisplaytopic() {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<jtopiclist> entries = new ArrayList<jtopiclist>();
		List<jsubtopiclist> entries1 = new ArrayList<jsubtopiclist>();
	    List<jforumlist> entries2 = new ArrayList<jforumlist>();
	    List<jtopiclist> entries3 = new ArrayList<jtopiclist>();

        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";
    		Integer subid = Integer.valueOf(request.getParameter("id"));


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from topics where subid="+subid );

            while( rs.next() )
                entries.add( new jtopiclist( rs.getInt( "id" ),
                    rs.getString( "topic" ), rs.getString( "author" ),
                    rs.getTimestamp( "date" ),rs.getString("content"),rs.getInt("subid") ) );

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
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM tp");
            

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
        
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";
    		Integer id = Integer.valueOf(request.getParameter("id"));

            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from forum where id="+id );

            while( rs.next() )
                entries2.add( new jforumlist( rs.getInt( "id" ),
                    rs.getString( "forum" ), rs.getInt( "topics" ), rs.getInt( "subid" ) ) );

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
    		Integer subid = 1;


            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select count(id) as replies from tp where id ="+subid );

            while( rs.next() )
                entries3.add( new jtopiclist(rs.getInt("replies") ) );

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
        
        request.setAttribute( "entries3", entries3 );
        request.setAttribute( "entries2", entries2 );
        request.setAttribute( "entries1", entries1 );
        request.setAttribute( "entries", entries );
        request.getRequestDispatcher( "/WEB-INF/jdisplaytopic.jsp" )
            .forward( request, response );
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}