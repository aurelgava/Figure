/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figure.control;

/**
 *
 * @author aurel
 */
public class Tacka2D {
    public String oznaka;
    public double x,y;
    
    public Tacka2D(String oznaka, double x, double y){
        this.oznaka = oznaka;
        this.x = x;
        this.y = y;
    }

    public Tacka2D() {
    
    }
    
    public String toString(){
        return this.oznaka + "(" + this.x + "," + this.y + ")";
    }

    double rastojanje(Tacka2D t) {
        // Math.hypot(a,b) = Math.sqrt(Math.pow(a,2) + Math.pow(b,2))
        return Math.hypot(this.x - t.x, this.y - t.y);
        
    }

    Tacka2D najbliza(Tacka2D[] nizTacaka) {
        Tacka2D naj = nizTacaka[0];
        for(Tacka2D t : nizTacaka){
            if(this.rastojanje(t) < this.rastojanje(naj)){
                naj = t;
            }
        }
        return naj;
    }
    
}

