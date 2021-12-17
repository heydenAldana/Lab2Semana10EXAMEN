package examenlab10p2_heydenalfonsoaldanavarela_22111098;

/**
 *
 * @author heyde
 */
public class Personaje 
{
    private char tipo;
    private String nombre;
    private double vida, ataque;

    public Personaje(char tipo, String nombre, double vida, double ataque) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }
    
    
}
