/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mst;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Harshit
 */
public class Mst {
    static int V,E;
    static Edge e;
    static Sorted srt;
    static MinEdges me;
    static ArrayList<Edge> arrlist;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        try
        {
            URL url = new URL("http://algs4.cs.princeton.edu/43mst/tinyEWG.txt");
            URLConnection site = url.openConnection();
            InputStream is     = site.getInputStream();
            //File f = new File(new BufferedReader(new InputStreamReader(url.openStream())));       
            Scanner sc = new Scanner(new BufferedInputStream(is));
            V = sc.nextInt();
            E = sc.nextInt();
            System.out.println("\t\t\t\t\tNo. of Vertices in the network : "+V);
            System.out.println("\n\t\t\t\t\t No. of Edges in the network : "+E+"\n");
            srt = new Sorted();
            //e = new Edge(V);
            //arrlist = new ArrayList<ArrayList<Edge>>(V);
            while(sc.hasNext())
            {            
                int a = sc.nextInt();
                int b = sc.nextInt();            
                double weight = sc.nextDouble();
                e = new Edge(a,b,weight);
                srt.addEdge(e);            
            }        
        
            me = new MinEdges(V);
            //arrlist = srt.sorted();
        
            /*for(Edge loop : arrlist)
            {
                System.out.println(loop.get_a()+" - "+loop.get_b()+" :: "+loop.get_weight());
            }*/
        
        }        
        catch(FileNotFoundException foe)
        {
            foe.printStackTrace();
        }        
    }    
}