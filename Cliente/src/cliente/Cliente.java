//a
package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author invitado
 */
public class Cliente {
    

    //Logica de un solo cliente
    //Representación del cliente
    Socket cliente;
    //Salida de datos
    ObjectOutputStream salida;
    //Entrada de datos
    ObjectInputStream entrada;
    

public void ejecutarCliente()
    {
        try
        {
            conectarAlServidor();
            obtenerFlujos();
            procesarConexion();
        }catch(IOException ioe){
            //mostrarMensaje("error en la conexion con el cliente");
        }finally{
            cerrarConexion();
        }
    }
public void conectarAlServidor() throws IOException
    {
        //mostrarMensaje("Intentando establecer conexion.....");
        cliente = new Socket("127.0.0.1", 12345);
        //mostrarMensaje("Conectado a: "+cliente.getInetAddress());
    }
public void obtenerFlujos() throws IOException
    {
        salida = new ObjectOutputStream(cliente.getOutputStream());
        //Mandar los flujos
        salida.flush();
        entrada = new ObjectInputStream(cliente.getInputStream());
        //mostrarMensaje("Se obtuvieron los flujos E/S");
    }
public void procesarConexion() throws IOException
    {
        String mensaje = "";
        //campoIntroducir.setEnabled(true);
        do
        {
            try {
                mensaje = (String) entrada.readObject();
                //mostrarMensaje("\n"+mensaje);
            } catch (ClassNotFoundException ex) {
                //mostrarMensaje("error tipo de dato incorrecto");
            }
            
        }while(!mensaje.equals("SERVIDOR>>> TERMINAR"));
    }
    
    public void cerrarConexion()
    {
        //mostrarMensaje("cerrando conexion...");
        try {
            salida.close();
            entrada.close();
            cliente.close();
            //campoIntroducir.setEnabled(false);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void enviarDatos(String mensaje)
    {
        try {
            salida.writeObject("CLIENTE>>> "+mensaje);
            salida.flush();
            //mostrarMensaje("CLIENTE>>> "+mensaje);
        } catch (IOException ex) {
            //mostrarMensaje("Error al mandar datos al servidor");
        }
        
    }
   
}


