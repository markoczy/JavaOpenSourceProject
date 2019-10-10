package ch.bfh.springerstifu.heroes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.bfh.springerstifu.heroes.model.Hero;
import ch.bfh.springerstifu.heroes.model.Party;
import ch.bfh.springerstifu.heroes.service.PartyService;
import ch.bfh.springerstifu.heroes.spring.ServiceConfiguration;

public class Application extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ApplicationContext applicationContext = null;

    private static ApplicationContext getContext() {
        if (applicationContext == null) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                    ServiceConfiguration.class);
            context.scan("ch.bfh.springerstifu.service.impl");
            applicationContext = context;
        }
        return applicationContext;
    }

    public static void main(String[] args) {
        PartyService partyService = getContext().getBean(PartyService.class);
        Party party = partyService.createParty("Moonstone");

        System.out.println("*** Party: " + party.getName() + "\n");
        for (Hero hero : party.getMembers()) {
            System.out.println(hero);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PartyService partyService = getContext().getBean(PartyService.class);
        Party party = partyService.createParty("Moonstone");
        // Create Content
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Party: " + party.getName() + "</h2>");
        out.println("<ul>");
        for (Hero hero : party.getMembers()) {
            out.println("<li>" + hero + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
}
