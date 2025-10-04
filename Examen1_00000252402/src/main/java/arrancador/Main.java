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

    public static void main(String[] args) {
        PantallaPrincipal pantallaPrincipal = PantallaPrincipal.getInstance();

        ModelVistaFacade modeloVista = ModelVistaFacade.getInstance();
        IObserver observer = new ModelObserver();

        modeloVista.addObserver(observer);

        ModeloNegocioImp modeloNegocio = ModeloNegocioImp.getInstance();

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

        modeloNegocio.agregarProducto(new NegocioProducto("Camisa negra", 99.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camisa blanca", 99.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camisa azul", 99.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camisa roja", 99.0));
        modeloNegocio.agregarProducto(new NegocioProducto("Camisa verde", 99.0));
        pantallaPrincipal.setVisible(true);

    }
}
