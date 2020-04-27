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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/jforum")
public class jforum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public jforum() {
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
	    List<jforumlist> entries = new ArrayList<jforumlist>();
	    List<jtopiclist> entries1 = new ArrayList<jtopiclist>();
	    List<jforumlist> entries2 = new ArrayList<jforumlist>();


        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from forum" );

            while( rs.next() )
                entries.add( new jforumlist( rs.getInt( "id" ),
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

    c = DriverManager.getConnection( url, username, password );
    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery( "select * from topics" );

    while( rs.next() )
        entries1.add( new jtopiclist( rs.getInt( "id" ),
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
            int id=1;
            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select count(subid) as topics from topics where subid ="+id );

            while( rs.next() )
                entries2.add( new jforumlist( rs.getInt( "topics" )) );
            
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

        request.setAttribute( "entries2", entries2 );
        request.setAttribute( "entries1", entries1 );
        request.setAttribute( "entries", entries );
        request.getRequestDispatcher( "/WEB-INF/jforum.jsp" )
            .forward( request, response );
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	}




