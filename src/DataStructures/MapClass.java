/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Roger
 */
public class MapClass {
    public MapClass(){}
    
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public void put(String i, Integer e){
        map.put(i, new Integer(e));
        System.out.print("Put fet  " + i + " " + e + "\n" );
        System.out.println(map.toString());
        System.out.println("\n");
    }
    
    public int getData(String i){
        System.out.println("\n");
        System.out.print(map.toString() + "S'ha agafat el valor de" + i + " del Map.\n");
        return(map.get(i).intValue());
        
    }
    
    public boolean isEmpty(){
        return(map.isEmpty());
    }
}
