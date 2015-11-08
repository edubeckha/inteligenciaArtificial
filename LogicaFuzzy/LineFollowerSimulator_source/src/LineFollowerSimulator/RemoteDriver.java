package LineFollowerSimulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import net.sourceforge.jFuzzyLogic.FIS;
 
public class RemoteDriver {
	
    static int port = 4321;
    static String host = "127.0.0.1";
	
    public static void main(String[] args) throws IOException {
        	    	
	FIS fis = FIS.load("robot.fcl", true); // Load from 'FCL' file
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            kkSocket = new Socket(host, port);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host:"  + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + host);
            System.exit(1);
        }
 
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
 
        double sensorEsquerda, sensorDireita;
        // requisicao da posicao do carrinho verificar se é isso com o carrinho
        out.println("r");
        while ((fromServer = in.readLine()) != null) {
        	StringTokenizer st = new StringTokenizer(fromServer);
        	sensorEsquerda = Double.valueOf(st.nextToken());
                out.println("r");
        	sensorDireita = Double.valueOf(st.nextToken());

        	System.out.println("x: " + sensorEsquerda + " y: " + sensorDireita);
        	
                //seta os valores para alterar a posicao do robo.
		fis.setVariable("sensor_left_value", sensorEsquerda);
                fis.setVariable("sensor_right_value", sensorDireita);
                
		fis.evaluate();

		double forcaDireita = fis.getVariable("motor_force_left").getLatestDefuzzifiedValue();
                double forcaEsquerda = fis.getVariable("motor_force_right").getLatestDefuzzifiedValue();
		System.out.println("Força esquerda lida: " + forcaEsquerda);
                System.out.println("Força direita lida: " + forcaDireita);

        	// envio do comando ao motor
        	out.println(forcaEsquerda);
                out.println(forcaDireita);
        	
                //requisicao da posicao do carrinho        	
        	out.println("r");	
        }
 
        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
    }

    static double fixAngle(double angle) {
    	while(angle >= 360.0) {
		angle -= 360.0;
	}
    	while(angle < 0) {
		angle += 360.0;
	}
	return angle;
    }
}
