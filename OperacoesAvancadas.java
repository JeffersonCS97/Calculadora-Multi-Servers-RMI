import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class OperacoesAvancadas {
    public static void main(String args[]) {
        // Cria e instala o security manager
        // System.setSecurityManager(new RMISecurityManager() );
        try {
            LocateRegistry.createRegistry(1099);
            OperacoesAvancadasImpl obj = new OperacoesAvancadasImpl();
            Naming.rebind("ServerAvancadoRMI", obj);
            System.out.println("Server Avançado RMI pronto.");
        } catch (Exception e) {
            System.out.println("Server erro" + e.getMessage());
        }
    }
}
