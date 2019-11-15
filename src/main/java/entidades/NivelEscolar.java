package entidades;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "NIVEL_ESCOLAR", schema = "PUBLIC", catalog = "PARCIAL2")
public class NivelEscolar {
    private int id;
    private String nivel;
    private Collection<Ciudadano> ciudadanosById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NIVEL", nullable = true, length = 25)
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NivelEscolar that = (NivelEscolar) o;
        return id == that.id &&
                Objects.equals(nivel, that.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nivel);
    }

    @OneToMany(mappedBy = "nivelEscolarByIdNivel")
    public Collection<Ciudadano> getCiudadanosById() {
        return ciudadanosById;
    }

    public void setCiudadanosById(Collection<Ciudadano> ciudadanosById) {
        this.ciudadanosById = ciudadanosById;
    }
}
