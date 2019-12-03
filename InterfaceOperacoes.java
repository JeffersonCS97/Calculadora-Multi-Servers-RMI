import java.rmi.*;

public interface InterfaceOperacoes extends Remote {
	public int somar(int a, int b) throws RemoteException;

	public int sub(int a, int b) throws RemoteException;

	public int mult(int a, int b) throws RemoteException;

	public float div(float q, float w) throws RemoteException;

}