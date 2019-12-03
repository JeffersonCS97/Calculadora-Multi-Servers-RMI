import java.rmi.*;

public interface InterfaceOperacoesAvancadas extends Remote {
	public double raizQuadrada(double a) throws RemoteException;

	public double potenciacao(double a, double b) throws RemoteException;

	public float porcentagem(float a, float b) throws RemoteException;

}