

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

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// Captura o ManagedBean chamado �usuarioMB�
		LoginMB loginMB = (LoginMB) ((HttpServletRequest) request).getSession().getAttribute("loginMB");

		// Verifica se nosso ManagedBean ainda n�o
		// foi instanciado ou caso a
		// vari�vel loggedIn seja false, assim saberemos que
		// o usu�rio n�o est� logado
		if (loginMB == null || !loginMB.isLoggedIn()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			// Redirecionamos o usu�rio imediatamente
			// para a p�gina de login.xhtml
			((HttpServletResponse) response).sendRedirect(contextPath + "/Login.jsf");
		} else {
			// Caso ele esteja logado, apenas deixamos
			// que o fluxo continue
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
