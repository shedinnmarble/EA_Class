package cs544.exercise8_2;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.transaction.SystemException;


import org.hibernate.SessionFactory;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {

	private SessionFactory sf;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO implement actual session in view filter code
		org.hibernate.Transaction tx = null;
		try {
			tx=sf.getCurrentSession().beginTransaction();
			// pass the request along the filter chain
			//System.out.println("receiving request");
			chain.doFilter(request, response);
			//System.out.println("sending response");
			tx.commit();
		} catch (RuntimeException ex) {
			
			try {
				ex.printStackTrace();
				tx.rollback();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				System.out.println("could not rool back");
				e.printStackTrace();
			}
			throw ex;
		}
		

	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
}
