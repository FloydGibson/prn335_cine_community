package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
public class SesionUsuario implements Serializable {
    @Inject
    FacesContext facesContext;
    Map<String, Locale> idiomas  = new HashMap<>();
    String idiomaSeleccionado;

    @PostConstruct
    public void init() {
        idiomas.put("English", new Locale.Builder().setLanguageTag("en").build());
        idiomas.put("Français", new Locale.Builder().setLanguageTag("fr").build());
        idiomas.put("Español", new Locale.Builder().setLanguageTag("es").build());
    }

    public Map<String, Locale> getIdiomas() {
        return idiomas;
    }

    public String getIdiomaSeleccionado() {
        return idiomaSeleccionado;
    }

    public void setIdiomaSeleccionado(String idiomaSeleccionado) {
        this.idiomaSeleccionado = idiomaSeleccionado;
    }

    public void cambiarIdioma(ValueChangeEvent event) {
        String idioma = event.getNewValue().toString();
        for (Map.Entry<String, Locale> entry : idiomas.entrySet()) {
            if (entry.getKey().equals(idioma)) {
               facesContext.getViewRoot().setLocale(entry.getValue());
            }
        }
    }
}
