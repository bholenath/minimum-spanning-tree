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
public class Sorted 
{    
    //int a,b;
    //double weight;
    //int count=0;
    ArrayList<ArrayList<Edge>> arrlist = new ArrayList<ArrayList<Edge>>(Mst.V);
    ArrayList<Edge> singlelist = new ArrayList<Edge>();
    //ArrayList<Edge> initial = new ArrayList<Edge>();
        
    public Sorted() 
    {
        for (int i=0; i<Mst.V; i++)
        {
            arrlist.add(new ArrayList<Edge>());
            //arrlist.get(i).add(null);
        }
    }
    
    public void addEdge(Edge e)
    {
        int first_vertex = e.get_a();
        //int second_vertex = e.get_b();
        arrlist.get(first_vertex).add(e);
        //arrlist.get(second_vertex).add(e);
    }   
    
    public void removeReduntant(int v)
    {
        //System.out.println(count);
        //int c = 0;
        int size = arrlist.get(v).size();
        for(int i=size-1; i>=0; i--)
        {
            Edge val = arrlist.get(v).get(i);
            int k = i;
            for(int j=i-1; j>=0; j--)
            {   
                Edge val1 = arrlist.get(v).get(j);
                if(val.get_a() == val1.get_a() && val.get_b() == val1.get_b())
                {
                    if(val.get_weight() > val1.get_weight() || val.get_weight() == val1.get_weight()) 
                    {
                        arrlist.get(v).remove(k);
                        val = val1;
                        k=j;
                        i--;
                    }
                    else { arrlist.get(v).remove(j); i--; }
                }    
            }            
        }
    }
    
    public void single(int v)
    {
        int size = arrlist.get(v).size();
        for(int i=0; i<size; i++) singlelist.add(arrlist.get(v).get(i));
    }
    
    public void list_Remove_Duplicate()
    {
        int size = singlelist.size();
                
        for(int i=size-1; i>=0; i--)
        {
            Edge comp = singlelist.get(i);
            for(int j=i-1; j>=0; j--)    
            {
                Edge comp1 = singlelist.get(j);
                if(comp.get_a() == comp1.get_b() && comp.get_b() == comp1.get_a())
                {
                    if(comp.get_weight() > comp1.get_weight() || comp.get_weight() == comp1.get_weight())
                    {
                        singlelist.remove(i);
                        i--;
                        break;
                    }
                    else { singlelist.remove(j); i--; break; }
                }
            }
        }        
    }

    public ArrayList<Edge> sorted()
    {
        int size = singlelist.size();
        //System.out.println(size);
        int index;
        
        for(int i=0; i<size; i++)
        {
           Edge list = singlelist.get(i);
           Double min = list.get_weight();
           index = i;
           for(int j=i+1; j<size; j++)
           {
               Edge list1 = singlelist.get(j);
               if(list1.get_weight() < min)
               {
                   min = list1.get_weight();
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
    } 
    
}
