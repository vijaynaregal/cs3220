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


@WebServlet("/jcreatetopic")
public class jcreatetopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public jcreatetopic() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<jforumlist> entries2 = new ArrayList<jforumlist>();
        Connection c = null;

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

        request.setAttribute( "entries2", entries2 );
		
		request.getRequestDispatcher( "/WEB-INF/jcreatetopic.jsp" )
        .forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu06?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "cs3220stu06";
            String password = "bI.*X*!.";
    		Integer subid = Integer.valueOf(request.getParameter("id"));

            String sql = "insert into topics (topic, author, date, content, subid) values (?, ?, now(), ?, ?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, request.getParameter( "topic" ) );
            pstmt.setString( 2, request.getParameter( "author" ) );
            pstmt.setString( 3, request.getParameter( "content" ));
            pstmt.setInt( 4, subid);
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
		Integer subid = Integer.valueOf(request.getParameter("id"));
        response.sendRedirect( "jdisplaytopic?id="+subid );
    }

	}