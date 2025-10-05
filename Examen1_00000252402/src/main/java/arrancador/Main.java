package arrancador;

import java.util.ArrayList;
import java.util.List;
import modelo.ModelVistaFacade;
import modeloNegocio.BINInfo;
import modeloNegocio.ModeloNegocioImp;
import modeloNegocio.NegocioProducto;
import vista.IObserver;
import vista.ModelObserver;
import vista.PantallaPrincipal;

/**
 * Clase principal (Arrancador) donde se configura el modelo de negocio y se
 * arranca el programa. Esta clase se encarga de unir todas las capas para que
 * la comunicación sea correcta.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
public class Main {

    /**
     * Método principal que inicializa y enlaza todos los componentes de la
     * aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        // Se instancia el frame principal del programa
        PantallaPrincipal pantallaPrincipal = PantallaPrincipal.getInstance();

        /* Se instancia el Subject y el observador para configurar que el 
        ModelObserver sea capaz de observar al ModelVistaFacade */
        ModelVistaFacade modeloVista = ModelVistaFacade.getInstance();
        IObserver observer = new ModelObserver();
        modeloVista.addObserver(observer);

        /* Se instancia lo necesario para tener infomación en el ModeloNegocio, 
        como productos para poder selecconar y validar la tarjeta ingresada */
        ModeloNegocioImp modeloNegocio = ModeloNegocioImp.getInstance();

        // Lista de prefijos BIN que contienen la información del banco emisor y la ciudad del emisor
        List<BINInfo> binInfo = new ArrayList<>();
        binInfo.add(new BINInfo("401288", "Banco SOL", "Ciudad de México"));
        binInfo.add(new BINInfo("412345", "Banco Estrella", "Madrid"));
        binInfo.add(new BINInfo("510000", "Banco Global S.A.", "Buenos Aires"));
        binInfo.add(new BINInfo("545041", "Caja del Norte", "Monterrey"));
        binInfo.add(new BINInfo("340001", "AMEX Services", "Nueva York"));
        binInfo.add(new BINInfo("601100", "Banco Descubre", "Bogotá"));
        binInfo.add(new BINInfo("453210", "Banco de Comercio", "Santiago"));
        binInfo.add(new BINInfo("123456", "Banco del Futuro", "Lima"));
        modeloNegocio.setBinInfo(binInfo);

        // Agregando productos
        modeloNegocio.agregarProducto(new NegocioProducto("Camisa negra", 129.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camiseta blanca", 99.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camiseta azul", 99.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Pantalon rojo", 200.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camiseta verde", 99.0));

        // Una vez cargados los datos necesarios para la ejecución se hace visible el frame principal
        pantallaPrincipal.setVisible(true);

    }
}
