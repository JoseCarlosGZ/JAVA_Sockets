package servidor;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 * @author Jose Carlos
 */
public class HiloServidor extends Thread {
    //Atributos
    private javax.swing.JLabel lblConexionServidor;
    private javax.swing.JButton btnConexionServidor;
    private JTextField txtPuerto;
    private JTextField txtConsultar;
    private JTextField txtStock;
    private ServerSocket ss;
    Socket socketServidor;
    boolean salir = false;
    BufferedReader recibir;
    PrintWriter enviar;
    private int stock;
    
    //Constructor
    public HiloServidor(
            JLabel lblConexionServidor,
            JButton btnConexionServidor,
            JTextField txtPuerto,
            JTextField txtConsultar,
            JTextField txtStock
            ) {
        
                this.lblConexionServidor = lblConexionServidor;
                this.btnConexionServidor = btnConexionServidor;
                this.txtPuerto = txtPuerto;
                this.txtConsultar = txtConsultar;
                this.txtStock = txtStock;

                try {
                    this.lblConexionServidor = lblConexionServidor;
                    System.out.println("Hilo Servidor creado" + "\n");
                    ss = new ServerSocket (Integer.parseInt(txtPuerto.getText()));
                }
                catch (Exception ex){
                    System.out.println("Error de conexión"+ ex.getMessage());
                }
    }
    
    
    //ejecución del hilo h
    public void run() {
        try {
            this.lblConexionServidor.setText(". . . . . . . . Esperando conexión Cliente");
            this.lblConexionServidor.setForeground(Color.decode("#cc8400"));
            this.btnConexionServidor.setEnabled(false);
            //Leemos el Stock de aguacates que ha introducido el usuario a priori
            stock = Integer.parseInt(txtStock.getText());
            this.txtConsultar.setText(String.valueOf(stock));
            
            socketServidor = ss.accept();
            System.out.println("Conexión con Cliente Ok: " + socketServidor.toString() + "\n");
            this.lblConexionServidor.setText(". . . . . . . . . . . . . . . . . . . . . conexión ON");
            this.lblConexionServidor.setForeground(Color.decode("#00913f"));
            
            
            recibir = new BufferedReader(new InputStreamReader(socketServidor.getInputStream()));
            enviar = new PrintWriter(socketServidor.getOutputStream(), true);
            /*Enviamos el stock de aguacates justo después de conectar Cliente-Servidor, a posteriori
            iremos enviando los stocks actualizados con el bucle según las peticiones del Cliente*/
            enviar.println(String.valueOf(stock));
            
            while (!salir) {
                String modificación_stock_recibida = recibir.readLine();
                System.out.println("El stock ha sido modificado en: " + modificación_stock_recibida + " Aguacates");
                //Casteamos el texto recibido a entero para modificar la variable que almacena el stock
                stock += Integer.parseInt(modificación_stock_recibida);
                //Actualizamos el stock en la APP del servidor
                txtConsultar.setText(String.valueOf(stock));
                //Envía de vuelta el stock actualizado
                enviar.println(String.valueOf(stock));
            }
            
        } catch (Exception ex) {
        }finally {
            try {
                socketServidor.close();
                ss.close(); 
                System.out.println("Puerto de conexión cerrado");
            } catch(Exception ex ) {}
        }
    }//run
    
    
    //Método Consultar
    public void consultar() {
        try {
            this.txtConsultar.setText(String.valueOf(stock));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conecte primero SERVIDOR-CLIENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    

    
}
