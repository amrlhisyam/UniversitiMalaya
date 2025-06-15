/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan2;

/**
 *
 * @author Hisyam
 */
public class c {
    public static void main(String[] args) {
        Playable [] instruments = new Playable[2];
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        instruments[0] = guitar;
        instruments[1] = piano;
        
        for(Playable x : instruments){
            x.play();
        }
    }
}

interface Playable{
    void play();
}

class Guitar implements Playable{

    @Override
    public void play() {
        System.out.println("Strumming the guitar!");
    }
    
}

class Piano implements Playable{

    @Override
    public void play() {
        System.out.println("Playing the piano!");
    }

}