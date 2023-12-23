import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Computation {
	private class ServerThread extends Thread{
		private Socket 		socket;
		private String		name;
		
		
		public ServerThread(Socket sock, String n) {
			socket = sock;	name = n;
			
		}
		private String compute(String AS, String oper, String BS) {
			int		A, B;
			float	result=0;
			A = Integer.parseInt(AS);
			B = Integer.parseInt(BS);
			
			switch (oper) {
			case "+":
				result = A + B;
				break;
			case "-":
				result = A - B;
				break;
			case "/":
				if(B == 0) return "Divide by ZERO";
				result = (float)A / B;
				break;
			case "x":
				result = A * B;
				break;
			default:
				break;
			}
			
			return (oper.equals("/")) ? String.format("%.3f", result) : String.format("%d", (int)result);
		}
		public void run() {
			BufferedReader	in = null;
			BufferedWriter 	out = null;
			
			try {
				System.out.printf("[SERVER] From Client[%s] Connected\n", socket.getInetAddress().getHostName());
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				while(true) {
					String fromClient, toClient = null, exp[], op1, oper, op2;
					fromClient = in.readLine();
					exp = fromClient.split("\\s+");
					if(fromClient.equalsIgnoreCase("bye")) break;
					if(exp[0].equalsIgnoreCase("compute")) {
						op1 = exp[1]; oper=exp[2]; op2 = exp[3];
						toClient = String.format("%s %s %s = %s",op1,oper,op2,compute(op1, oper, op2));
					}
					System.out.printf("[SERVER] From Client-%s\n", fromClient);
//					System.out.printf("[SERVER] To Client : ");
//					toClient = scan.nextLine();
					out.write(toClient+"\n");
					out.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
					try {
						in.close();
						out.close();
						if(socket != null) socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.printf("[SERVER] END.\n");
			}
		}
	}
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			Computation		mainThread = new Computation();
			serverSocket = new ServerSocket(9999);
			System.out.printf("[SERVER] Waiting for Connection...\n");
			while(true) {
			ServerThread server = mainThread.new ServerThread(serverSocket.accept(), "서버");
			server.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(serverSocket != null)	serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}

}
