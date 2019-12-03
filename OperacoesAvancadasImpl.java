import java.rmi.*;
import java.rmi.server.*;

public class OperacoesAvancadasImpl extends UnicastRemoteObject implements InterfaceOperacoesAvancadas {

    public OperacoesAvancadasImpl() throws RemoteException {
        super();
    }

    public double raizQuadrada(double a) throws RemoteException {
        return Math.sqrt(a);
    }

    public double potenciacao(double a, double b) throws RemoteException {
        return (Math.pow(a, b));
    }

    public float porcentagem(float a, float b) throws RemoteException {
        return (b * a) / 100;
    }
}
