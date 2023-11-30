
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author leovi
 */
public class GUIServidor extends JFrame
{
    JTextField campoIntroducir;
    JTextArea areaPantalla;
    JScrollPane barras;
    
    public GUIServidor()
    {
        setTitle("Server -chat");
        setSize(350,470);
        creaGui();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void creaGui()
    {
     campoIntroducir = new JTextField();
     areaPantalla = new JTextArea(25, 20);
     barras = new JScrollPane(areaPantalla);
     
     campoIntroducir.setEnabled(false);
     add(campoIntroducir, BorderLayout.SOUTH);
     add(barras, BorderLayout.CENTER);
     
     ManejaEvento ev = new ManejaEvento();
     campoIntroducir.addActionListener(ev);
    }
    
    /**
     * método que muestra en el area de texto lo que mandan por parámetro
     * @param mensaje 
     */
    public void mostrarMensaje(String mensaje)
    {
        areaPantalla.append(mensaje);
    }
    
    /**
     * método que recibe un boolean y con base en él 
     * habilita o deshabilita el campo de texto
     * @param dato 
     */
    public void habiliarCampo(boolean dato)
    {
        campoIntroducir.setEnabled(dato);
    }
    
    public void limpiarCampo()
    {
        campoIntroducir.setText("");
    }
    
    class ManejaEvento implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("le di enter"+e.getActionCommand());
            LogicaServidor.actuar(e.getActionCommand());
        }
        
    }
    
}
