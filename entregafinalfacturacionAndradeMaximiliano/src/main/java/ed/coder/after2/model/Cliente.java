package ed.coder.after2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description= "ID único del cliente", example = "1", accessMode = Schema.AccessMode.READ_ONLY )
    private Long id;

    @Schema(description = "Nombre del cliente", example = "Pablo Rodriguez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String nombre;

    @Schema(description = "Dirección de cliente", example ="Calle Amo a Java 2525", requiredMode = Schema.RequiredMode.REQUIRED)
    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @Schema(description = "Lista de ventas asociadas al cliente", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private List<Venta> ventas;

    // Getters y Setters


    public Long getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
