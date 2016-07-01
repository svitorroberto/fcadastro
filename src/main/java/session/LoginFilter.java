package session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managedBean.LoginMB;

/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class LoginFilter implements Filter {

	public void destroy() {
		

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Captura o ManagedBean chamado “usuarioMB”
		LoginMB loginMB = (LoginMB) ((HttpServletRequest) request).getSession().getAttribute("loginMB");

		// Verifica se nosso ManagedBean ainda não
		// foi instanciado ou caso a
		// variável loggedIn seja false, assim saberemos que
		// o usuário não está logado
		if (loginMB == null || !loginMB.isLoggedIn()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			// Redirecionamos o usuário imediatamente
			// para a página de login.xhtml
			((HttpServletResponse) response).sendRedirect(contextPath + "/Login.jsf");
		} else {
			// Caso ele esteja logado, apenas deixamos
			// que o fluxo continue
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
