import java.io.Serializable;

public class Cliente implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String email;
    private String telefono;

    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\n\tCliente: " +
                "\nNombre: " + nombre +
                "\nTelefono: " + telefono +
                "\nEmail: " + email;
    }
}
