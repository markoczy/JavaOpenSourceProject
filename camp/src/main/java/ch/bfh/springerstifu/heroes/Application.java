package ch.bfh.springerstifu.heroes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.bfh.springerstifu.heroes.repository.HeroRepository;
import ch.bfh.springerstifu.heroes.service.HeroService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch.bfh.springerstifu.heroes.model.Hero;
import ch.bfh.springerstifu.heroes.model.Party;
import ch.bfh.springerstifu.heroes.service.PartyService;
import ch.bfh.springerstifu.heroes.config.ServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;

public class Application extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ConfigurableApplicationContext applicationContext = null;

    private static ConfigurableApplicationContext getContext() {
        if (applicationContext == null) {
            // TODO xml bs...

            // Variant 2: Package Scan
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
            context.scan("ch.bfh.springerstifu.heroes");
            applicationContext = context;
            context.refresh();

            // Variant 3: Annotation Config
            // AnnotationConfigApplicationContext context = new
            // AnnotationConfigApplicationContext(
            // ServiceConfiguration.class);
        }
        return applicationContext;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = getContext();
        PartyService partyService = ctx.getBean(PartyService.class);
        Party party = partyService.createParty("Moonstone");

        System.out.println("*** Party: " + party.getName() + "\n");
        for (Hero hero : party.getMembers()) {
            System.out.println(hero);
        }
        ctx.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ConfigurableApplicationContext ctx = getContext();
        PartyService partyService = ctx.getBean(PartyService.class);
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
        out.println("<h3>Number of Heroes with Atk higher than 50: "+ctx.getBean(HeroRepository.class).countByAtkGreaterThan(50)+"</h3>");
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

        // Don't Close context (reused at next GET)
    }
}
