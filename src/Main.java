
import java.util.*;
import java.util.regex.*;
public class Main
{
    Pnt firstPnt;
    Pnt nextPnt;
    List <Pnt>listPnt=new ArrayList();
	public static void main(String[] args) {
		String in =args[0];
		String[] massPnt=in.split("/");
		
		
		Main m=new Main();
		m.initPnt(args);
		int listLeng=m.listPnt.size();
		m.firstPnt= m.findFirstPnt(m.listPnt);
		System.out.println(m.firstPnt);
		System.out.println("next point");
		m.delPntFromList(m.listPnt,m.firstPnt);
		
		
		m.nextPnt= m.findNextPnt(m.listPnt,m.firstPnt);
		System.out.println(m.nextPnt);
		System.out.println("next point");
		m.delPntFromList(m.listPnt,m.nextPnt);
		
		for(int i=0;i<listLeng-2;i++){
    		m.nextPnt= m.findNextPnt(m.listPnt,m.nextPnt);
    		System.out.println(m.nextPnt);
    		m.delPntFromList(m.listPnt,m.nextPnt);
    		
    		if(m.listPnt.size()!=0){
    		    System.out.println("next point");
    		}
		}
	
		
		
	}
	void initPnt(String[] args){
	   	String str = "";
	   	Pattern pattern = Pattern.compile("/|,");
    	
    	for(String in:args){
    	    str+=in;
    	}
        String[] coord = pattern.split(str);
        
        for (int i=0;i<coord.length;) {
            double x=Double.parseDouble(coord[i]);
            double y=Double.parseDouble(coord[i+1]);
            listPnt.add(new Pnt(x,y) );
            i=i+2;
            
        }
	   
	}
	Pnt findFirstPnt(List<Pnt> pnt){
	    double minDist=Double.POSITIVE_INFINITY;
	    if(pnt.size()==1){
	        return pnt.get(0);
	    }
	    Pnt firstMinPnt=null;
	    for(int i=0;i<pnt.size();i++){
	        for(int j=0;j<pnt.size();j++){
	            if(i==j){
	                continue;
	            }
	            double res= distance(pnt.get(i),pnt.get(j));
	            if(res<minDist){
	                minDist=res;
	                firstMinPnt=pnt.get(j); 
	            }
	            
	            
	        }
	    }
	    return firstMinPnt;
	}
	Pnt findNextPnt(List<Pnt> pnt,Pnt firstPnt){
	    double minDist=Double.POSITIVE_INFINITY;
	    if(pnt.size()==1){
	        return pnt.get(0);
	    }
	    Pnt nextPnt=null;
	   
        for(int j=0;j<pnt.size();j++){
           
            double res= distance(firstPnt,pnt.get(j));
            //System.out.println("между точками "+firstPnt+" и "+pnt.get(j) +" расстояни "+res);
            if(res<minDist){
                minDist=res;
                nextPnt=pnt.get(j); 
            }
            
            
        }
	    
	    return nextPnt;
	}
	void delPntFromList(List<Pnt> pnt,Pnt firstPnt){
	    for(int i=0;i<pnt.size();i++){
	        if(pnt.get(i)==firstPnt){
	            pnt.remove(i);
	        }
	    }
	}
	public double distance(Pnt p1, Pnt p2){
 
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
 
    }
    void printList(List<Pnt>pnt){
        for(int i=0;i<pnt.size();i++){
	       System.out.println(pnt.get(i));
	    }
    }
}
class Pnt{
    double x;
    double y;
    Pnt(double x,double y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return (int)x+","+(int)y+"";
    }
}
