/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenlab10p2_heydenalfonsoaldanavarela_22111098;

import java.util.Random;

/**
 *
 * @author heyde
 */
public class Carro 
{
    private String tipo;
    private double velocidad;
    private int pderrape;
    private String nombre;
    private int metrosextrasalto;
    private int ataque, pataqueextra, vida, vidasextra;

    private Random rand;
    
    
    public Carro(String tipo, double velocidad, int pderrape, String nombre, int metrosextrasalto, int ataque, int pataqueextra, int vida, int vidasextra) 
    {
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.pderrape = pderrape;
        this.nombre = nombre;
        
        // Salto extra por tipo
        if(this.tipo.equals("Salto"))
            this.metrosextrasalto = metrosextrasalto;
        else
            this.metrosextrasalto = 0;
        
        // Para el carrito malvado
        if(this.tipo.equals("Malvado"))
            this.ataque = ataqueMalvado();
        else    
            this.ataque = ataque;
        
        // Ataque extra por tipo
        if(this.tipo.equals("Ataque"))
            this.pataqueextra = pataqueextra;
        else
            this.pataqueextra = 0;
        
        // Para el carrito malvado
        if(this.tipo.equals("Malvado"))
            this.vida = vidaMalvado();
        else    
            this.vida = vida;
        
        // vidas extra por tipo
        if(this.tipo.equals("Belicos"))
            this.vidasextra = ranVidasExtra();
        else
            this.vidasextra = 0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getPderrape() {
        return pderrape;
    }

    public void setPderrape(int pderrape) {
        this.pderrape = pderrape;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMetrosextrasalto() {
        return metrosextrasalto;
    }

    public void setMetrosextrasalto(int metrosextrasalto) {
        this.metrosextrasalto = metrosextrasalto;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPataqueextra() {
        return pataqueextra;
    }

    public void setPataqueextra(int pataqueextra) {
        this.pataqueextra = pataqueextra;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidasextra() {
        return vidasextra;
    }

    public void setVidasextra(int vidasextra) {
        this.vidasextra = vidasextra;
    }
    
    private int ataqueMalvado()
    {
        rand = new Random();
        int ataque = rand.nextInt(400) + 300;
        return ataque;
    }
    
    private int vidaMalvado()
    {
        rand = new Random();
        int vida = rand.nextInt(4000) + 1000;
        return vida;
    }
    
    private int ranVidasExtra()
    {
        rand = new Random();
        int vidas = rand.nextInt(99);
        return vidas;
    }
}
