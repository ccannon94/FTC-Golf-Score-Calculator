/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftcgolf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author CCannon
 */
public class FTCGolf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File(args[0]));
            ArrayList<Pair> teams = new ArrayList<>();
            String[] teamList = reader.nextLine().split(",");
            for(String team : teamList) {
                teams.add(new Pair(team.trim(), 0));
            }
            while(reader.hasNext()){
                String[] ranks = reader.nextLine().split(",");
                for(int i = 0; i < teams.size(); i++) {
                    boolean found = false;
                    for(int j = 0; j < ranks.length; j++) {
                        if (ranks[j].trim().equals(teams.get(i).getKey())) {
                            teams.set(i, new Pair(teams.get(i).getKey(), ((int)teams.get(i).getValue()) + j));
                            found = true;
                        }
                    }
                    if(!found) {
                        teams.set(i, new Pair(teams.get(i).getKey(), ((int)teams.get(i).getValue()) + ranks.length));
                    }
                }
            }
            for(Pair team : teams) {
                System.out.println(team.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FTCGolf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
