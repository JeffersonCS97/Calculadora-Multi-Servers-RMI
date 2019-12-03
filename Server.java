import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server implements Runnable {

	public Socket cliente;

	private static List<Socket> listaDeClientes = new ArrayList<Socket>();

	public Server(Socket cliente) {
		this.cliente = cliente;
	}

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(12345);

		System.out.println("Aguardando conexao do cliente...");

		while (true) {
			Socket cliente = serverSocket.accept();

			listaDeClientes.add(cliente);

			Server tratamento = new Server(cliente);
			Thread t = new Thread(tratamento);

			t.start();
		}
	}

	public void run() {

		try {
			System.out.println("Obtendo a solicitação principal...");
			DataInputStream inFromClient = new DataInputStream(cliente.getInputStream());
			int primeiro = inFromClient.readInt();
			int segundo = inFromClient.readInt();
			String operacaoSelecionada = inFromClient.readUTF();

			if ("adi".equals(operacaoSelecionada)) {
				InterfaceOperacoes obj = (InterfaceOperacoes) Naming.lookup("rmi://localhost/ServerRMI");
				int resultado = obj.somar(primeiro, segundo);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Integer.toString(resultado));
			} else

			if ("sub".equals(operacaoSelecionada)) {
				InterfaceOperacoes obj = (InterfaceOperacoes) Naming.lookup("rmi://localhost/ServerRMI");
				int resultado = obj.sub(primeiro, segundo);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Integer.toString(resultado));
			} else

			if ("mul".equals(operacaoSelecionada)) {
				InterfaceOperacoes obj = (InterfaceOperacoes) Naming.lookup("rmi://localhost/ServerRMI");
				int resultado = obj.mult(primeiro, segundo);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Integer.toString(resultado));
			} else

			if ("div".equals(operacaoSelecionada)) {
				InterfaceOperacoes obj = (InterfaceOperacoes) Naming.lookup("rmi://localhost/ServerRMI");
				float resultado = obj.div(primeiro, segundo);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Float.toString(resultado));
			} else

			if ("por".equals(operacaoSelecionada)) {
				InterfaceOperacoesAvancadas obj = (InterfaceOperacoesAvancadas) Naming
						.lookup("rmi://localhost/ServerAvancadoRMI");
				float resultado = obj.porcentagem(primeiro, segundo);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Float.toString(resultado));
			} else

			if ("rad".equals(operacaoSelecionada)) {
				InterfaceOperacoesAvancadas obj = (InterfaceOperacoesAvancadas) Naming
						.lookup("rmi://localhost/ServerAvancadoRMI");
				double resultado = obj.raizQuadrada(primeiro);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Double.toString(resultado));
			} else

			if ("pot".equals(operacaoSelecionada)) {
				InterfaceOperacoesAvancadas obj = (InterfaceOperacoesAvancadas) Naming
						.lookup("rmi://localhost/ServerAvancadoRMI");
				double resultado = obj.potenciacao(primeiro, segundo);
				DataOutputStream outFromClient = new DataOutputStream(cliente.getOutputStream());
				outFromClient.writeUTF(Double.toString(resultado));
			}

			if (inFromClient.readInt() == 0) {
				this.cliente.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
