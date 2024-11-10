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
    //EL COMENTARIO, ES VIEW SCOPED PORQUE NO DESARROLLAMOS UN MECANISMO DE LOGIN, ESTO DEBERÍA SER UN SESSION SCOPED

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

        DefaultMenuItem item = DefaultMenuItem.builder()
                .value("Tipo Sala")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoSala.jsf')}")
                .build();
        DefaultMenuItem item2 = DefaultMenuItem.builder()
                .value("Tipo Asiento")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoAsiento.jsf')}")
                .build();
        DefaultMenuItem item3 = DefaultMenuItem.builder()
                .value("Tipo Producto")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoProducto.jsf')}")
                .build();
        DefaultMenuItem item4 = DefaultMenuItem.builder()
                .value("Tipo Pago")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoPago.jsf')}")
                .build();
        DefaultMenuItem item5 = DefaultMenuItem.builder()
                .value("Tipo Pelicula")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoPelicula.jsf')}")
                .build();
        DefaultMenuItem item6 = DefaultMenuItem.builder()
                .value("Tipo Reserva")
                .ajax(true)
                .command("#{frmMenu.navegar('TipoReserva.jsf')}")
                .build();
        DefaultSubMenu cine = DefaultSubMenu.builder()
                .label("Cine")
                .expanded(true)
                .build();
        DefaultMenuItem item7 = DefaultMenuItem.builder()
                .value("Pelicula")
                .ajax(true)
                .command("#{frmMenu.navegar('Pelicula.jsf')}")
                .build();
        DefaultMenuItem item8 = DefaultMenuItem.builder()
                .value("Sala")
                .ajax(true)
                .command("#{frmMenu.navegar('Sala.jsf')}")
                .build();
        DefaultMenuItem item9 = DefaultMenuItem.builder()
                .value("Sucursal")
                .ajax(true)
                .command("#{frmMenu.navegar('Sucursal.jsf')}")
                .build();

        tipos.getElements().add(item);
        tipos.getElements().add(item2);
        tipos.getElements().add(item3);
        tipos.getElements().add(item4);
        tipos.getElements().add(item5);
        tipos.getElements().add(item6);
        cine.getElements().add(item7);
        cine.getElements().add(item8);
        cine.getElements().add(item9);
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