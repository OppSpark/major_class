import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket			socket = null;
		BufferedReader	in = null;
		BufferedWriter 	out = null;
		Scanner			scan = new Scanner(System.in);
		
		try {
			socket = new Socket("cs.ks.ac", 9999);
			System.out.printf("[CLIENT] Client[%s] Connected\n", socket.getInetAddress().getHostName());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String fromServer, toServer;
				System.out.printf("[CLIENT] To Server : ");
				toServer = scan.nextLine();
				out.write(toServer+"\n");
				out.flush();
				if(toServer.equalsIgnoreCase("bye")) break;
				fromServer = in.readLine();
				System.out.printf("[CLIENT] From Server-%s\n", fromServer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				scan.close();
				if(socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.printf("[CLIENT] END.\n");
			}
		
	}

}
