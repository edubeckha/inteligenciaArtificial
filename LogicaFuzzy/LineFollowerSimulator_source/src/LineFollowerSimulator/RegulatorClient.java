/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LineFollowerSimulator;

import static LineFollowerSimulator.RemoteDriver.host;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author tiago
 */
public class RegulatorClient implements Runnable {

  private volatile double p = 0.42187;
  private volatile double i = 0.09375;
  private volatile double d = 2.36718;

  private Socket socket;
  private PrintWriter out;
  private BufferedReader in;
  
  private final String host;
  private final int port;
  
  public RegulatorClient(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public void run() {
// ********************Versão original*********************************
/*
    listenSocket(this.host, this.port);
	while (socket.isConnected()) {
      try {
        String line = in.readLine();
        String[] params = line.split(" ");
        double position = Double.parseDouble(params[0]);
        double sumLinePositions = Double.parseDouble(params[1]);
        double previousLinePosition = Double.parseDouble(params[2]);
        double drive = p * position + 
                i * sumLinePositions + d * (position - previousLinePosition);
        out.println(drive);
      } catch (IOException ex) {
        Logger.getLogger(RegulatorClient.class.getName()).log(Level.SEVERE, null, ex);
        break;
      }
    }*/
// ***********************************************************************
    

    listenSocket(this.host, this.port);
	while (socket.isConnected()) {
      try {        
        FIS fis = FIS.load("robot.fcl", true);
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
 
        double sensorEsquerda, sensorDireita;
        // requisicao da posicao do carrinho verificar se é isso com o carrinho        
        while ((fromServer = in.readLine()) != null) {
        	StringTokenizer st = new StringTokenizer(fromServer);
                System.out.println(st.nextToken());
        	/*sensorEsquerda = Double.valueOf(st.nextToken());
                
        	sensorDireita = Double.valueOf(st.nextToken());

        	System.out.println("x: " + sensorEsquerda + " y: " + sensorDireita);*/
        	
                //seta os valores para alterar a posicao do robo.
		/*fis.setVariable("sensor_left_value", 0.35);
                fis.setVariable("sensor_right_value", 0.35);
                
		fis.evaluate();

		double forcaDireita = fis.getVariable("motor_force_left").getLatestDefuzzifiedValue();
                double forcaEsquerda = fis.getVariable("motor_force_right").getLatestDefuzzifiedValue();
		System.out.println("Força esquerda lida: " + forcaEsquerda);
                System.out.println("Força direita lida: " + forcaDireita);
                            */
        	// envio do comando ao motor
        	out.println(0.2);
                out.println(0.2);
        	
                //requisicao da posicao do carrinho        	
        	
        }
 
        out.close();
        in.close();
        stdIn.close();
        
        
        double drive = 0; // computar usando fazzy
        
        //out.println(drive);
      } catch (IOException ex) {
        Logger.getLogger(RegulatorClient.class.getName()).log(Level.SEVERE, null, ex);
        break;
      }
    }
  }

  public void listenSocket(String host, int port) {
    try {
      socket = new Socket(host, port);
      out = new PrintWriter(socket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      System.out.println("Connected on " + host + ":" + port);
    } catch (UnknownHostException e) {
      System.out.println("Unknown host: " + host);
      System.exit(1);
    } catch (IOException e) {
      System.out.println("No I/O");
      System.exit(1);
    }
  }

  void finish() {
    try {
      if (socket != null) 
        socket.close();
    } catch (IOException ex) {
      Logger.getLogger(RegulatorClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
