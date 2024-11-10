package sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "pelicula", schema = "public")
public class Pelicula {
    @Id
    @Column(name = "id_pelicula", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idPelicula")
    private List<Programacion> programacionList;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "idPelicula")
    private List<PeliculaCaracteristica> peliculaCaracteristicaList;

    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;

    @Lob
    @Column(name = "sinopsis")
    private String sinopsis;

    public Pelicula() {}

    public Pelicula(Long idPelicula) {this.idPelicula = idPelicula;}


    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long id) {
        this.idPelicula = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<Programacion> getProgramacionList() {
        return programacionList;
    }

    public void setProgramacionList(List<Programacion> programacionList) {
        this.programacionList = programacionList;
    }

    public List<PeliculaCaracteristica> getPeliculaCaracteristicas() {
        return peliculaCaracteristicaList;
    }

    public void setPeliculaCaracteristicas(List<PeliculaCaracteristica> peliculaCaracteristicas) {
        this.peliculaCaracteristicaList = peliculaCaracteristicaList;
    }
}