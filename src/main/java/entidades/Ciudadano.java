package entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Ciudadano {
    private int id;
    private String nombre;
    private String sector;
    private Integer idNivel;
    private String latitud;
    private String longitud;
    private NivelEscolar nivelEscolarByIdNivel;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "SECTOR", nullable = true, length = 100)
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    

    @Basic
    @Column(name = "LATITUD", nullable = true, length = 50)
    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @Basic
    @Column(name = "LONGITUD", nullable = true, length = 50)
    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudadano ciudadano = (Ciudadano) o;
        return id == ciudadano.id &&
                Objects.equals(nombre, ciudadano.nombre) &&
                Objects.equals(sector, ciudadano.sector) &&
                Objects.equals(idNivel, ciudadano.idNivel) &&
                Objects.equals(latitud, ciudadano.latitud) &&
                Objects.equals(longitud, ciudadano.longitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, sector, idNivel, latitud, longitud);
    }

    @ManyToOne
    @JoinColumn(name = "ID_NIVEL", referencedColumnName = "ID")
    public NivelEscolar getNivelEscolarByIdNivel() {
        return nivelEscolarByIdNivel;
    }

    public void setNivelEscolarByIdNivel(NivelEscolar nivelEscolarByIdNivel) {
        this.nivelEscolarByIdNivel = nivelEscolarByIdNivel;
    }
}
