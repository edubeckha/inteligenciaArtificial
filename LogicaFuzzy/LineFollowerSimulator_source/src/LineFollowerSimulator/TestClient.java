/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LineFollowerSimulator;
/**
 *
 * @author tiago
 */
public class TestClient {

    public static void main(String[] args) {
        final RegulatorClient client = new RegulatorClient("localhost", 4321);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                client.run();
                client.finish();
                
                
            }
        }));
        new Thread(client).start();
    }
}
