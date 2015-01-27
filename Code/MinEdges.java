/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mst;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Harshit
 */
public class MinEdges 
{
    Sorted srt = Mst.srt;
    ArrayList<Edge> singlelist = new ArrayList<Edge>();
    ArrayList<Edge> sortedlist = new ArrayList<Edge>();
    ArrayList<Edge> timelist = new ArrayList<Edge>();
    ArrayList<ArrayList<Integer>> arrlist = new ArrayList<ArrayList<Integer>>(Mst.V);
    //int mst_length = 0;
        
    public MinEdges(int V)
    {
        for(int i=0;i<V;i++) srt.removeReduntant(i);        
        for(int i=0;i<V;i++) srt.single(i);        
        srt.list_Remove_Duplicate();
        singlelist = srt.sorted();
        Running r = new Running(singlelist);
        System.out.println("\t\t\t\t***********Edges Between Nodes in MST***********");        
        list_Make();
    }
    
    public void list_Make()
    {
        Timer timer = new Timer();
        timer.schedule(new Running(), 1000, 1000);
        //t.start();
        /*synchronized(this)
        {
            try
            {
                notify();
                this.wait(); //Applied wait to the current thread waiting for run function in Thread class to finish
            }
            catch(InterruptedException e) // Catch for the wait function
            {
                e.printStackTrace();
            }
        }*/
    } 
    
    final class Running extends TimerTask
    {    
        ArrayList<Edge> singlelist_thread = new ArrayList<Edge>();
        ArrayList<Integer> recheck = new ArrayList<Integer>();
        ArrayList<Integer> recheck1 = new ArrayList<Integer>();
        ArrayList<Integer> recheck2 = new ArrayList<Integer>();
        ArrayList<Integer> recheck3 = new ArrayList<Integer>();
        ArrayList<Integer> check_a = new ArrayList<Integer>();
        ArrayList<Integer> check_b = new ArrayList<Integer>();
        int i=1,size=0;  
        Thread t;
        
        public Running() {}
        
        public Running(ArrayList<Edge> singlelist)
        {
            singlelist_thread = singlelist;
            size = singlelist_thread.size();
            check_tree();
            //check_tree(singlelist_thread);
        }
                
        public void check_tree()
        {    
            t = new Thread();            
            for (int x=0; x<Mst.V; x++) arrlist.add(new ArrayList<Integer>());
            //ArrayList<Integer> a1 = new ArrayList<Integer>();
            //ArrayList<Integer> b1 = new ArrayList<Integer>();
            //int index = 0;
            synchronized(t)
            {
                try
                {
                    if(t.interrupted())
                    {
                        t.sleep(1000);
                    }
                    else
                    {
                        sortedlist.add(singlelist_thread.get(0));
                        sortedlist.add(singlelist_thread.get(1));
                        add_List(singlelist_thread.get(0));
                        add_List(singlelist_thread.get(1));                

                        for(int z=2; z<size; z++)
                        {                   
                            check_a.clear();
                            check_b.clear();
                            recheck.clear(); 
                            recheck1.clear();
                            int size0 = sortedlist.size();
                            if(size0 == (Mst.V-1)) break;
                            Edge check = singlelist_thread.get(z);                    
                            //System.out.println(size2+"  "+(Mst.V-1));
                            //if(size2 == (Mst.V)) break;                    
                            int a = check.get_a();
                            int b = check.get_b();
                            int size2 = arrlist.get(a).size();
                            int size3 = arrlist.get(b).size();

                            outerloop:
                            while(true)
                            {
                                for(int k=0; k<size2; k++)
                                {
                                    int find = arrlist.get(a).get(k);
                                    check_a.add(find);
                                    boolean presence = find_Val(find,b,check_a);
                                    if(presence == false) break outerloop;                        
                                }

                                for(int h=0; h<size3; h++)
                                {
                                    int find1 = arrlist.get(b).get(h);
                                    check_b.add(find1);
                                    boolean presence1 = find_Val1(find1,a,check_b);
                                    if(presence1 == false) break outerloop;                        
                                }

                                //System.out.println(recheck.size()+"  "+recheck1.size());
                                while(!recheck.isEmpty())
                                {
                                    boolean edge = run_Recheck(b);
                                    if(edge == false) break outerloop;
                                }

                                while(!recheck1.isEmpty())
                                {
                                    boolean edge1 = run_Recheck1(a);
                                    if(edge1 == false) break outerloop;
                                }

                                if(recheck.isEmpty() && recheck1.isEmpty())
                                {
                                    sortedlist.add(check);
                                    add_List(check);
                                    break;
                                }
                            }
                        }
                    }

                        /*for (int x=0; x<size3; x++)
                        {
                            int find1 = arrlist.get(b).get(x);
                            boolean presence1 = find_Val(find1,a,b);
                            if(presence1 == false) break;
                        }*/


                        /*Edge check1 = sortedlist.get(k);

                        if(a == check1.get_a()) a1.add(check1.get_b());
                        else if(a == check1.get_b()) a1.add(check1.get_a());
                        if(b == check1.get_a()) b1.add(check1.get_b());
                        else if(b == check1.get_b()) b1.add(check1.get_a());
                        }

                        if(a1.isEmpty() || b1.isEmpty()) sortedlist.add(check);
                        else
                        {
                            outerloop:
                            for (Integer a11 : a1) 
                            {
                                for (Integer b11 : b1) 
                                {
                                    if (a11 == b11) { c++; break outerloop; } 
                                }
                            } 
                            if(c == 0) sortedlist.add(singlelist_thread.get(j));                    
                        }                                         
                    }*/
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                //}
            }
        }
        
        public boolean run_Recheck(int b)
        {
            int c=0;
            recheck2 = recheck;
            recheck.clear();
            int size43 = recheck2.size();
            outerloop:
            for(int h=0; h<size43; h++)
            {
                int size331 = arrlist.get(recheck2.get(h)).size();
                for(int j=0; j<size331; j++)
                {
                    int find11 = arrlist.get(recheck2.get(h)).get(j);
                    if(check_a.contains(find11)) continue;
                    else
                    {
                        check_a.add(find11);
                        boolean presence2 = find_Val(find11,b,check_a);
                        if(presence2 == false) { c++; break outerloop; }
                    }                    
                }                       
            }
            return c==0;
        }
        
        public boolean run_Recheck1(int a)
        {
            int c1=0;
            recheck3 = recheck1;
            recheck1.clear();
            int size53 = recheck3.size();
            outerloop:
            for(int h=0; h<size53; h++)
            {
                int size332 = arrlist.get(recheck3.get(h)).size();
                for(int j=0; j<size332; j++)
                {
                    int find12 = arrlist.get(recheck3.get(h)).get(j);
                    if(check_b.contains(find12)) continue;
                    else
                    {
                        check_b.add(find12);
                        boolean presence3 = find_Val1(find12,a,check_b);
                        if(presence3 == false) { c1++; break outerloop; }
                    }                   
                }
            }
            return c1==0;
        }
        
        public boolean find_Val(int r, int b, ArrayList<Integer> check_a)
        {
            //new Thread();            
            int c2 = 0;
            int size13 = arrlist.get(r).size();
            for(int u=0; u<size13; u++)
            {
                if(check_a.contains(arrlist.get(r).get(u))) continue;                
                else if(arrlist.get(r).get(u) == b) { c2++; break; }
                else recheck.add(arrlist.get(r).get(u)); 
                /*else 
                { 
                    boolean next = find_Val(arrlist.get(r).get(u),b,r);
                    if(next == false) break;
                    else continue;
                }*/
            }
            return c2==0;
        }
        
        public boolean find_Val1(int r, int b, ArrayList<Integer> check_b)
        {
            //new Thread();
            int c3 = 0;
            int size23 = arrlist.get(r).size();
            for(int u=0; u<size23; u++)
            {
                if(check_b.contains(arrlist.get(r).get(u))) continue;                
                else if(arrlist.get(r).get(u) == b) { c3++; break; }
                else recheck1.add(arrlist.get(r).get(u)); 
                /*else 
                { 
                    boolean next = find_Val(arrlist.get(r).get(u),b,r);
                    if(next == false) break;
                    else continue;
                }*/
            }
            return c3==0;
        }
        
        public void add_List(Edge e)
        {
            int add_a0 = e.get_a();
            int add_b0 = e.get_b();
            //int add_a1 = singlelist_thread.get(1).get_a();
            //int add_b1 = singlelist_thread.get(1).get_b();
            arrlist.get(add_a0).add(add_b0);
            arrlist.get(add_b0).add(add_a0);
            //arrlist.get(add_a1).add(add_b1);
            //arrlist.get(add_b1).add(add_a1);
        }
        
        /*public void stop_Thread()
        {
            t.interrupt();
        }*/
                
        @Override
        public void run()
        {                       
            synchronized(this)
            {
                try
                {
                    t.sleep(1000);
                    timelist = sortedlist;
                    int size1 = timelist.size();
                    System.out.println("\n\t\t\t\t\t\tMST in "+ i +" second/s\n");
                    for(int j=0; j<size1; j++)
                    {
                        Edge e = timelist.get(j);
                        System.out.print("\t"+e.get_a()+" - "+e.get_b()+" :: "+e.get_weight());
                    }
                    System.out.println("\n");                       

                    if(size1 == (Mst.V-1))
                    {
                        System.out.println("\n\t\t\t\t***********MST Completed in "+i+" second/s**********");
                        System.out.println("\n\t\t\t\t\t********Final MST Edges********\n");
                        for(int l=0; l<size1; l++)
                        {
                            Edge e1 = timelist.get(l);
                            System.out.print("\t"+e1.get_a()+" - "+e1.get_b()+" :: "+e1.get_weight());
                        }
                        System.out.println("\n");
                        //System.out.println(arrlist);
                        System.exit(0);
                    }
                    i++;
                    notify();
                    this.wait();
                }
                catch(InterruptedException ie)
                {
                    ie.printStackTrace();
                }
            }
        }
    }
}
