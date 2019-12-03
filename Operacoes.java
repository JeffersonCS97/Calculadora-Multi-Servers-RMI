import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Operacoes {
    public static void main(String args[]) {
        // Cria e instala o security manager
        // System.setSecurityManager(new RMISecurityManager() );
        try {
            LocateRegistry.createRegistry(80);
            OperacoesImpl obj = new OperacoesImpl();
            Naming.rebind("ServerRMI", obj);
            System.out.println("Server RMI pronto.");
        } catch (Exception e) {
            System.out.println("Server erro" + e.getMessage());
        }
    }
}
