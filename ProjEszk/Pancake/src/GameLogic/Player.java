/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author Hartmann Zsombor
 */
public class Player {
    
    private String name;
    private int points = 0;
    
    Player(String name){
        this.name = name;
    }
    
    public void AddPoint(){
        points++;
    }
    
    public String GetName(){
        return name;
    }
    
    public int GetPoints(){
     return points;   
    }
}
