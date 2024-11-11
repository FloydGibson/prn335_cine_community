package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;


import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import java.io.IOException;
import java.io.Serializable;

@Named
@ViewScoped
public class FrmMenu implements Serializable {
    @Inject
    FacesContext facesContext;

    DefaultMenuModel model;
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        DefaultSubMenu tipos = DefaultSubMenu.builder()
                .label("Tipos")
                .expanded(true)
                .build();
        DefaultMenuItem TipoSala = DefaultMenuItem.builder()
                .value("Sala")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoSala.jsf')}")
                .build()
                ;
        DefaultMenuItem TipoReserva = DefaultMenuItem.builder()
                .value("Reserva")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoReserva.jsf')}")
                .build()
                ;
        DefaultMenuItem TipoProducto = DefaultMenuItem.builder()
                .value("Producto")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoProducto.jsf')}")
                .build()
                ;
        DefaultMenuItem TipoAsiento = DefaultMenuItem.builder()
                .value("Asiento")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoAsiento.jsf')}")
                .build()
                ;
        DefaultMenuItem TipoPelicula = DefaultMenuItem.builder()
                .value("Pelicula")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoPelicula.jsf')}")
                .build()
                ;
        DefaultMenuItem TipoPago = DefaultMenuItem.builder()
                .value("Pago")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoPago.jsf')}")
                .build()
                ;

        tipos.getElements().add(TipoSala);
        tipos.getElements().add(TipoReserva);
        tipos.getElements().add(TipoProducto);
        tipos.getElements().add(TipoAsiento);
        tipos.getElements().add(TipoPelicula);
        tipos.getElements().add(TipoPago);

        DefaultSubMenu cine = DefaultSubMenu.builder()
                .label("Cine")
                .expanded(true)
                .build();
        DefaultMenuItem Pelicula = DefaultMenuItem.builder()
                .value("Pelicula")
                .ajax(true)
                .command("#{frmMenu.navegar('Pelicula.jsf')}")
                .build()
                ;
        DefaultMenuItem Sala = DefaultMenuItem.builder()
                .value("Sala")
                .ajax(true)
                .command("#{frmMenu.navegar('Sala.jsf')}")
                .build()
                ;
        cine.getElements().add(Pelicula);
        cine.getElements().add(Sala);

        model.getElements().add(tipos);
        model.getElements().add(cine);
    }

    public void navegar(String formulario) throws IOException {
        facesContext.getExternalContext().redirect(formulario);
    }

    public DefaultMenuModel getModel() {
        return model;
    }
}
