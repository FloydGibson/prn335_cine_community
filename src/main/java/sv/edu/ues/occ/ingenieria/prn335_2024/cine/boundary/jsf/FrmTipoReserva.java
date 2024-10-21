package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoReservaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoReserva;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class FrmTipoReserva implements Serializable {
@Inject
TipoReservaBean dataBean;
LazyDataModel<TipoReserva> modelo;

@PostConstruct
    public void inicializar(){
    modelo=new LazyDataModel<TipoReserva>(){
        @Override
        public int count(Map<String, FilterMeta> map) {
            return 0;

        }

        @Override
        public List<TipoReserva> load(int i, int i1, Map<String, SortMeta> map, Map<String, FilterMeta> map1) {
            return List.of();
        }
    };
}

}
