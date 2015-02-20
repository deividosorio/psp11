package edu.uniandes.ecos.psp11.controlador;

import edu.uniandes.ecos.psp11.modelo.CalculatorRelativeSize;
import edu.uniandes.ecos.psp11.modelo.ClassName;
import edu.uniandes.ecos.psp11.vista.MainView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Clase que representa el controlador de la aplicación 
 * que comunica la interface con el mundo
 * @author deividosorio
 * @version 15/02/2015
 */
public class App extends HttpServlet
{
    public static void main ( String[] args )
    {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MainView.showHome(req,resp);
        MainView.showResults(req,resp,0,0,0,0,0);       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
                
        try {
            MainView.showHome(req,resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo que recibe información de las clases y retorna los valores de 
     * los rangos calculados, la información se recibe con la estructura 
     * de LOC,numberMethods separados por guiones cada clase
     * @param req de Input
     * @param resp de inpunt
     * @throws IOException para validación de error de IO
     */
    public void consoleInput(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException {
        String strPuntos = req.getParameter("clases");

        String[] arrStrPuntos = strPuntos.split("-");
        String[] arrStrPunto;
        ClassName newClass;
        ArrayList<ClassName> ListClass = new ArrayList<ClassName>();

        for (String _strPunto : arrStrPuntos) {
            try {
                arrStrPunto = _strPunto.split(",");
                newClass = new ClassName(Double.parseDouble(arrStrPunto[0]),
                        Integer.parseInt(arrStrPunto[1]));
                ListClass.add(newClass);
                
            }catch(NumberFormatException ex){
                MainView.showResults(req, resp,0,0,0,0,0);
            }
        }

        CalculatorRelativeSize calc = new CalculatorRelativeSize(ListClass);
        
        MainView.showResults(req, resp, calc.getRangeAntiVS(),calc.getRangeAntiS(),
        calc.getRangeAntiM(), calc.getRangeAntiL(), calc.getRangeAntiVL());
    }

}
