import java.rmi.*;
import java.rmi.server.*;

public class OperacoesImpl extends UnicastRemoteObject implements InterfaceOperacoes {

    public OperacoesImpl() throws RemoteException {
        super();
    }

    public int somar(int a, int b) throws RemoteException {
        return a + b;
    }

    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    public int mult(int a, int b) throws RemoteException {
        return a * b;
    }

    public float div(float q, float w) throws RemoteException {
        return (q / w);
    }
}
