/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 *
 * @author Jose Carlos
 */
public class HiloCliente extends Thread {
    
    //Atributos
    private JLabel lblConexionCliente;
    private JButton btnConexionCliente;
    private JTextField txtDireccion;
    private JTextField txtPuerto;
    private JTextField txtInsertar;
    private JTextField txtRetirar;
    private JTextField txtConsultar;
    Socket socketCliente;
    boolean salir = false;
    BufferedReader recibir;
    PrintWriter enviar;
    
    //Constructor
    public HiloCliente(
            JLabel lblConexionCliente,
            JButton btnConexionCliente,
            JTextField txtDireccion,
            JTextField txtPuerto,
            JTextField txtInsertar,
            JTextField txtRetirar,
            JTextField txtConsultar            
            ) {
        
                this.lblConexionCliente = lblConexionCliente;
                this.btnConexionCliente = btnConexionCliente;
                this.txtDireccion = txtDireccion;
                this.txtPuerto = txtPuerto;
                this.txtInsertar = txtInsertar;
                this.txtRetirar = txtRetirar;
                this.txtConsultar = txtConsultar;

                try {
                    this.lblConexionCliente = lblConexionCliente;
                    System.out.println("Hilo Cliente creado" + "\n");
                    //Creamos el socketCliente y los conectamos al Servidor
                    socketCliente = new Socket(txtDireccion.getText(), Integer.parseInt(txtPuerto.getText()));
                } catch (Exception ex) {
                    System.out.println("Error de conexión" + ex.getMessage());
                }
    }

    
    //ejecución del hilo h
    public void run() {
        try {
            System.out.println("Conexión con Servidor Ok: " + socketCliente.toString());
            this.lblConexionCliente.setText(". . . . . . . . . . . . . . . . . . . . . conexión ON");
            this.lblConexionCliente.setForeground(Color.decode("#00913f"));
            this.btnConexionCliente.setEnabled(false);
            
            recibir = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            enviar = new PrintWriter(socketCliente.getOutputStream(), true);
        
            
            /*vamos recibiendo desde el servidor el stock actulizado según se añadan o retiren Aguacates*/
            while (!salir) {
                txtConsultar.setText(recibir.readLine());
            }
            
        } catch (Exception ex) {
        } finally {
            try {
                socketCliente.close();
                System.out.println("Puerto de conexión cerrado");
            } catch (Exception ex) {
            }
        }
    }//run
    
    
}
