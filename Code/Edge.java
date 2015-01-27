/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mst;

import java.util.ArrayList;

/**
 *
 * @author Harshit
 */
public class Edge 
{
    int a,b;
    double weight; 
    //ArrayList<ArrayList<Edge>> arrlist = new ArrayList<ArrayList<Edge>>();
    //ArrayList<Edge> singlelist = new ArrayList<Edge>();
    //ArrayList<Edge> initial = new ArrayList<Edge>();
    //Edge e;
    
    public Edge() {}
    
    /*public Edge(int V)
    {
        for(int l=0;l<V;l++) arrlist.add(initial);
        //arrlist.get(3).set(0,e);
        //for(int l=0;l<V;l++) System.out.println(arrlist.get(l).size());
    }*/
           
    public Edge(int v, int w, double weight)
    {        
        this.a = v;
        this.b = w;
        this.weight = weight;
    }
    
    public Integer get_a() 
    {
        return a;
    }
    
    public Integer get_b() 
    {
        return b;
    }
     
    public Double get_weight()
    {
        return weight;
    }
    
    /*public void addEdge(Edge e)
    {        
        //for(int l=0;l<Mst.V;l++) arrlist.add(initial);
        //System.out.println(arrlist);
        //for(int l=0;l<Mst.V;l++) System.out.println(arrlist.get(l).size());
        //int size1 = arrlist.get(a).size();
        //int size2 = arrlist.get(b).size();
        //System.out.println(size1);
        arrlist.get(a).add(e);
        arrlist.get(b).add(e);
    }
    
    public void removeDuplicate(int v)
    {
        int size = arrlist.get(v).size();
        System.out.println(v+"  "+size);
        for(int i=size-1; i>=0; i--)
        {
            Edge val = arrlist.get(v).get(i);
            if(val.a > val.b) arrlist.get(v).remove(val);            
        }
        removeReduntant(v);
    }
    
    public void removeReduntant(int v)
    {
        int size = arrlist.get(v).size();
        for(int i=size-1; i>=0; i--)
        {
            Edge val = arrlist.get(v).get(i);
            for(int j=size-1;j>0;j--)
            {                
                Edge val1 = arrlist.get(v).get(j);
                if(val.a == val1.a && val.b == val1.b)
                {
                    if(val.weight > val1.weight || val.weight == val1.weight) arrlist.get(v).remove(val);
                    else arrlist.get(v).remove(val1);
                }    
            }            
        }
    }
    
    public void single(int v)
    {
        int size = arrlist.get(v).size();
        for(int i=0; i<size; i++)
        {
            singlelist.add(arrlist.get(v).get(i));
        }
    }
    
    public ArrayList<Edge> sorted()
    {
        int size = singlelist.size();
        int index;
        
        for(int i=0; i<size; i++)
        {
           Double min = singlelist.get(i).weight;
           index = i;
           for(int j=i+1;j<size;j++)
           {
               if(singlelist.get(j).weight < min)
               {
                   min = singlelist.get(j).weight;
                   index = j;
               }
           }
           if(index!=i)
           {
               Edge temp = singlelist.get(i);
               singlelist.set(i, singlelist.get(index));
               singlelist.set(index, temp);
           }
        }
        return singlelist;
    } */  
    
    /*public static void main(String args[])
    {
        Edge e = new Edge(Mst.V);
    }*/
}
