package cliente;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.ALLBITS;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author invitado
 */
public class GUICliente extends JFrame{
   
    Cliente usuarioApp;
    JLabel lNom, lImagenMenu, EnunPN,uno,dos,tres,cuatro,cinco,lR1, lR2, lR3,
            lR4, lEnunP;
    JTextField jtPresen,NPregunta,jR1, jR2, jR3, jR4,jRespuesta;
    JPanel pGeneral, pMenu, pCExamen;
    JMenuBar barra;
    JMenuItem inicio, crearExamen, verExamenes, verInformes, realizarExamen;
    JButton jbGuardarP, jbTerminarCE, jbCancelar,jbObtener;
    JTextArea textArea;
    JScrollPane scrollPane;
    int num_pregunta= 0;

   
    
    public void GUIMiniProyecto3()
    {
        setTitle("Examenes Conectados");
        setSize(580,500);
        //Metodo de la GUI principal
        crearGUIP();
        usuarioApp = new Cliente();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    
    
    //No modificar esta, ya funciona bien x,D
    public void crearGUIPresen()
    {
        
        lNom = new JLabel("<html><div style='text-align: center;'>"
                          +"<html>Bienvenido a Examenes Conectados<br>"
                          +"tu plataforma para hacer examenes <br>"
                          +"en grupos!!</div></html>");
        
        lImagenMenu = new JLabel();
        lImagenMenu.setSize(20, 30);
        lImagenMenu.setIcon(new ImageIcon("src/Images/Image1.png"));
        lImagenMenu.setHorizontalAlignment(JLabel.CENTER);
        
        //Panel con Grid con el fin de organizar el texto y la imagen de la presentacion
        pGeneral = new JPanel(new GridLayout(2,1));
        
              
        lNom.setHorizontalAlignment(SwingConstants.CENTER);
        
        Font forte = new Font("Comic Sans", Font.BOLD, 25);
        lNom.setFont(forte);
        lNom.setForeground(Color.RED);
                     
        //ubicacion de los elementos de la presentacion del programa
        pGeneral.add(lNom);
        pGeneral.add(lImagenMenu);
        pGeneral.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3)));
        
        //Organizar ventana
        add(pGeneral, BorderLayout.CENTER); 
        //add(barra, BorderLayout.NORTH);
              
        /**Metodo que usa un ActionLstener con el fin de dar 5 segs a la GUI de presentacion
         * se llama al metodo dipose() para cerrar la GUI, e instantaneamente iniciar la otra
         * que coniene el programa en su totalidad
         */ 
        Timer CuentaAtras = new Timer(3000, (ActionEvent e) -> {
            dispose();
            crearGUIP();
        });
        
        CuentaAtras.start();            
    }
    
    //Esta como tal ya es la GUI principal del programa
    public void crearGUIP()
    {
        
        //Panel Menu
        barra = new JMenuBar();
        verExamenes = new JMenuItem("Ver Examenes");
        verExamenes.setHorizontalAlignment(JMenuItem.CENTER);
        verInformes = new JMenuItem("Ver informes");
        verInformes.setHorizontalAlignment(JMenuItem.CENTER);
        realizarExamen = new JMenuItem("Realizar Examen");
        realizarExamen.setHorizontalAlignment(JMenuItem.CENTER);
        
      
        barra.add(verExamenes);
        barra.add(verInformes);
        barra.add(realizarExamen);
        setJMenuBar(barra);
        
        
                        
        ClaseManejadoraEventos ev = new ClaseManejadoraEventos();
        //inicio.addActionListener(ev);
        verExamenes.addActionListener(ev);
        verInformes.addActionListener(ev);
        realizarExamen.addActionListener(ev);
        
     
    }
    
    public void crearGUI2(){
        panelNomExamen();
        num_pregunta++;
        //Paneles Para Crear Examanes
        JPanel JPregRes,JEnunciadoN,JEnunciado,JRespuestas, jpbotones;
        //Panel Enunciado-Pregunta
        JPregRes = new JPanel(new BorderLayout());
            //Panel Enunciado Norte
            JEnunciadoN= new JPanel(new BorderLayout());
            //Panel Enunciado Text
            JEnunciado= new JPanel(new BorderLayout());
            //Panel Respuestas
            JRespuestas = new JPanel(new GridLayout(5,2,2,2));
        //Panel Botones
        jpbotones = new JPanel();
        jpbotones.setLayout(new BoxLayout(jpbotones, BoxLayout.Y_AXIS));
        //Atributos Panel Enunciado
        EnunPN = new JLabel("Enunciado Pregunta N°: ");
        
        NPregunta= new JTextField();
        NPregunta.setText(Integer.toString(num_pregunta));
        
        textArea = new JTextArea(2, 10); // 5 filas, 20 columnas

        // Agregar el JTextArea a un JScrollPane para permitir el desplazamiento
        scrollPane = new JScrollPane(textArea);
        
        //lEnunP = new JLabel("Aqui se supone que va la pregunta"); //EDITAR
        /**
         * Aqui se supone es donde van los JLabel de las preguntas "uno que contenga el numero y
         * otro que contenga como tal la pregunta con el fin de quede bien organizado"
         */
        uno = new JLabel("A ");
        dos = new JLabel("B ");
        tres = new JLabel("C ");
        cuatro = new JLabel("D ");
        cinco = new JLabel("Correcta");
        //JTextField  para las respuestas "Estos son los que hacen el return"
        jR1 = new JTextField("", ALLBITS); //EDITAR
        jR2 = new JTextField("",ALLBITS); //EDITAR
        jR3 = new JTextField("",ALLBITS); //EDITAR
        jR4 = new JTextField("",ALLBITS);
        jRespuesta = new JTextField("",ALLBITS);//EDITAR
        
        //JButton
        jbGuardarP = new JButton("<html>Guardar"
                               + "Pregunta<br>");
        jbGuardarP.setPreferredSize(new Dimension(50,50));
        
        jbTerminarCE = new JButton("<html>Terminar"
                                 + "Examen<br>");
        jbTerminarCE.setPreferredSize(new Dimension(60,70));
        
        Font forte = new Font("Comic Sans", Font.ROMAN_BASELINE, 20);
        //pCExamen = new JPanel(new GridLayout(1,2));
        
        //Añadir Elementos Panel Enunciado-Respuestas
            //Panel Enunciado Norte
            JEnunciadoN.add(EnunPN,BorderLayout.CENTER);
            JEnunciadoN.add(NPregunta,BorderLayout.EAST);
            //Panel Enunciado
            JEnunciado.add(JEnunciadoN,BorderLayout.NORTH);
            JEnunciado.add(scrollPane,BorderLayout.CENTER);
            //Panel Respuestas
            JRespuestas.add(uno);JRespuestas.add(jR1);
            JRespuestas.add(dos); JRespuestas.add(jR2);
            JRespuestas.add(tres); JRespuestas.add(jR3);
            JRespuestas.add(cuatro);JRespuestas.add(jR4);
            JRespuestas.add(cinco);JRespuestas.add(jRespuesta);
        JPregRes.add(JEnunciado,BorderLayout.NORTH);
        JPregRes.add(JRespuestas,BorderLayout.CENTER);
        
        jpbotones.add(Box.createVerticalStrut(160));
        jpbotones.add(jbGuardarP);
        jpbotones.add(jbTerminarCE);
         
        add(JPregRes, BorderLayout.CENTER);
        add(jpbotones, BorderLayout.EAST);
        revalidate();
        ClaseManejadoraEventos eva = new ClaseManejadoraEventos();
        jbGuardarP.addActionListener(eva);
        
    }
    public void panelNomExamen(){
        // Crear un cuadro de diálogo para obtener el nombre del examen y el tiempo
    JTextField nombreExamenField = new JTextField();
    JTextField tiempoExamenField = new JTextField();

    Object[] message = {
            "Nombre del examen:", nombreExamenField,
            "Tiempo de examen:", tiempoExamenField
    };

    int option = JOptionPane.showConfirmDialog(null, message, "Nombre-Tiempo del examen", JOptionPane.OK_CANCEL_OPTION);

    if (option == JOptionPane.OK_OPTION) {
        //nombreExamen = nombreExamenField.getText();
        //tiempoExamen = tiempoExamenField.getText();
  

        // Aquí puedes utilizar los valores obtenidos (nombreExamen y tiempoExamen)
        // para lo que necesites en tu aplicación.
    }
    

        
    }
    
    public void crearGUI3(){
        
    }
    //public String getNomExam(){
        //return nombreExamen;
    //}
    //public String getTiempoExam(){
        //return tiempoExamen;
    //}
    public String getNumPregunta(){
        return Integer.toString(num_pregunta);
    }
    public String getEnunciado(){
        return textArea.getText();
    }
    public String getR1(){
        return jR1.getText() ;
    }
    public String getR2(){
        return jR2.getText();
    }
    public String getR3(){
        return jR3.getText();
    }
    public String getR4(){
        return jR4.getText();
    }
    public String getCorrecta(){
        return jRespuesta.getText();
    }
    public void borrarTextos(){
        textArea.setText("");
        jR1.setText("");
        jR2.setText("");
        jR3.setText("");
        jR4.setText("");
        jRespuesta.setText("");
    }
    
    public void nombreUsuarios()
    {
        JOptionPane mensajeEmergente;
        mensajeEmergente = new JOptionPane();
        mensajeEmergente.showInputDialog(null, "Nombre del usuario", "Examenes conectados", JOptionPane.QUESTION_MESSAGE);
   
       if (mensajeEmergente.YES_OPTION == 0)
               {
                   crearGUI5();
               }
       if (mensajeEmergente.CANCEL_OPTION == 0)
       {
           
       }
    
    }
    public void crearGUI5(){
        
        
        //JLabel para las respuestas "Estos son los que hacen el return"
        JPanel jppregYenun,jpbotones,jpEstado,jpListPregn, jpEste;
        JDialog jdConexion;
        JCheckBox uno,dos,tres,cuat;
        jppregYenun = new JPanel(new GridLayout(6,1));
        jppregYenun.setBorder(new EmptyBorder(10,10,10,10));
        jpbotones = new JPanel(new GridLayout(1,3,5,5));
        jpbotones.setBorder(new EmptyBorder(10,10,10,10));
        jpEste = new JPanel(new GridLayout(2,1));
        jpEste.setPreferredSize(new Dimension(150,100));
        jpEstado = new JPanel();
        jpListPregn = new JPanel();
        
        //Dialog de conexion de los usuarios
        barraConexion();
        
        lR1 = new JLabel("R1"); //EDITAR 
        lR2 = new JLabel("R2"); //EDITAR
        lR3 = new JLabel("R3"); //EDITAR
        lR4 = new JLabel("R4"); //EDITAR
        
     
        
        
        jbGuardarP = new JButton("<html>Guardar"
                               + "Pregunta<br>");
        jbGuardarP.setPreferredSize(new Dimension(50,50));
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setPreferredSize(new Dimension(50,50));
        
        jbTerminarCE = new JButton("<html>Terminar"
                                 + "Examen<br>");
        jbTerminarCE.setPreferredSize(new Dimension(50,50));
        

        Font forte = new Font("Comic Sans", Font.ROMAN_BASELINE, 20);
        pCExamen = new JPanel(new GridLayout(1,2));
        JTextField NPregunta = new JTextField("");
        JLabel EnunPN = new JLabel("Enunciado Pregunta N°: " + NPregunta.getText());
        lEnunP = new JLabel("Aqui se supone que va la pregunta"); //EDITAR
        
        //jpEste design
        jpEstado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE,2),"Estado"));
        jpListPregn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED,2),"Listado Preguntas"));
        
        //Lista desplegable EDITAR
        String[] NumPreguntas = {"1","2","3","4","5","6","7","8"};
        JComboBox<String> ElegirPregunta = new JComboBox<>(NumPreguntas);
        
        jbObtener = new JButton("Obtener"); //Añadir el Listener
        
        /**
         * Aqui se supone es donde van los JLabel de las preguntas "uno que contenga el numero y
         * otro que contenga como tal la pregunta con el fin de quede bien organizado"
         */
        //pd 1: Se usa los .getText() para evitar meter un JLabel dentro de un JLabel "Lanza una excepcion"
        uno = new JCheckBox("1. " + lR1.getText());
        dos = new JCheckBox("2. " + lR2.getText());
        tres = new JCheckBox("3. " + lR3.getText());
        cuat = new JCheckBox("4. " + lR4.getText());
        
        
        
        jppregYenun.add(EnunPN);
        jppregYenun.add(lEnunP); 
        jppregYenun.add(uno);
        jppregYenun.add(dos); 
        jppregYenun.add(tres); 
        jppregYenun.add(cuat);
        
        jpEste.add(jpListPregn);
        jpEste.add(jpEstado);
               
        jpListPregn.add(ElegirPregunta,BorderLayout.WEST);
        jpListPregn.add(jbObtener, BorderLayout.EAST);
        
        jpbotones.add(jbCancelar); //Hace que la pregunta seleccionada sea desseleccionada
        jpbotones.add(jbGuardarP); //Guarda la respuesta del estudiante
        jpbotones.add(jbTerminarCE); //Hace que el examen termine
         

        add(jppregYenun, BorderLayout.CENTER);
        add(jpEste, BorderLayout.EAST);
        add(jpbotones, BorderLayout.SOUTH);
        revalidate();
        
        
    }
    public void barraConexion()
        {
            JFrame jfConexion;
            JTextArea textArea;
              jfConexion = new JFrame("Conexion Usuarios");
              jfConexion.setSize(320,320);
              jfConexion.setLocation(1044, 200);
              jfConexion.setVisible(true);
              //Area para saber los usuarios conectados
             
              textArea = new JTextArea();
              textArea.setEditable(false);
              textArea.setName("Usuarios");
              jfConexion.add(textArea);
    
            
        }
    
    //Clase manejadora de Eventos
    class ClaseManejadoraEventos implements ActionListener
    {
        
            @Override
            public void actionPerformed(ActionEvent e)
            {      

              
                if (e.getSource() == realizarExamen)
                {
                    //crearExamen.setEnabled(false);
                    nombreUsuarios();
                    //Conecto el servidor
                    usuarioApp.ejecutarCliente();
                    //ServidorProfesor.ejecutarServidor();
                }
                if (e.getSource()== jbGuardarP)
                {
                    //control.GuardarPreguntas();
                    num_pregunta++;
                    NPregunta.setText(Integer.toString(num_pregunta));
                    borrarTextos();
                }
            }
    }
    // Mostrar un mensaje de error si no se conecta el usuario debidamente 

public void mostrarMensaje(String mensaje){

textArea.append (mensaje);
}

    public static void main(String[] args) {
        GUICliente usuarioCliente = new GUICliente();
        usuarioCliente.GUIMiniProyecto3();

    }
}


