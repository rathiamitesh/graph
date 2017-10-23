package map;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;



class node
{
	private int id;
	private String name;

	public node(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

class undirectedgraph
{
	private Map<node, ArrayList<node>> newmap = new HashMap<node, ArrayList<node>>();
public void addnode(node n)
{        ArrayList<node> al= new ArrayList<node>();
newmap.put(n,al);}
public void addNeighbour(node a, node b)
{  ArrayList<node> k = new ArrayList<node>();
	k=newmap.get(a);
	k.add(b);
	newmap.put(a, k);
	k=newmap.get(b);
	k.add(a);
	newmap.put(b, k);
}
public void addNeighbourList(node a, List<node> nList)
{
	ArrayList<node> k,w = new ArrayList<node>();
	k=newmap.get(a);
	for(node q:k)
	{	w=newmap.get(q);
		w.add(a);
		newmap.put(q, w);
	}
	k.addAll(nList);
	newmap.put(a, k);
}
public void getneghboursOfNode(node n)
{ArrayList<node> k = new ArrayList<node>();
k=newmap.get(n);
for(node a:k)
{            System.out.println("the name of the neighbouring node is " + a.getName());
			System.out.println("the id of the neighbouring node is " + a.getId());
}
}
public void deleteNeighbour(node p, node n)
{ArrayList<node> k = new ArrayList<node>();
k=newmap.get(p);
k.remove(n);
newmap.put(p, k);
k=newmap.get(n);
k.remove(p);
newmap.put(n, k);
}
}
class directedgraph
{
	private Map<node, ArrayList<node>> inneigh = new HashMap<node, ArrayList<node>>();
	private Map<node, ArrayList<node>> outneigh = new HashMap<node, ArrayList<node>>();
	public void addnode(node n)
	{        ArrayList<node> al= new ArrayList<node>();
	inneigh.put(n,al);
	outneigh.put(n, al);
	}
	public void addNeighbourfromatob(node a, node b)
	{  ArrayList<node> k,l = new ArrayList<node>();
	k=outneigh.get(a);
	k.add(b);
	outneigh.put(a, k);
		l=inneigh.get(b);
		l.add(a);
		inneigh.put(b, l);
		
		}
	public void addNeighbourListfromaout(node a, List<node> nList)
	{
		ArrayList<node> k,w = new ArrayList<node>();
		k=outneigh.get(a);
		for(node q:k)
		{	w=inneigh.get(q);
			w.add(a);
			inneigh.put(q, w);
		}
		k.addAll(nList);
		outneigh.put(a, k);
	}
	public void getneghboursOfNode(node n)
	{ArrayList<node> k,l= new ArrayList<node>();
	k=outneigh.get(n);
	int i=1;
	for(node h:k)
	{            System.out.println(i+" the name of the outgoing neighbouring node from "+n.getName() +" is " + h.getName());
				i++;
				//System.out.println("the id of the outgoing neighbouring node is " + a.getId());
	}
	l=inneigh.get(n);
	
	for(node o:l)
	{            System.out.println("the name of the incoming neighbouring node is  " + o.getName());
				//System.out.println("the id of the incoming neighbouring node is  " + a.getId());
	}
	}
	public void deleteNeighbourfromatob(node p, node n)
	{ArrayList<node> k = new ArrayList<node>();
	k=outneigh.get(p);
	k.remove(n);
	outneigh.put(p, k);
	k=inneigh.get(n);
	k.remove(p);
	inneigh.put(n, k);
	}
}

class labelleddiectedrgraph 
{ 
private Map<node, ArrayList<edges>> fullmap = new HashMap<node, ArrayList<edges>>();
public void addnode(node n)
{        ArrayList<edges> al= new ArrayList<edges>();
fullmap.put(n,al);

}
public void addNeighbourfromatob(node a, node b, String name)
{  ArrayList<edges> alledge = new ArrayList<edges>();
alledge=fullmap.get(a);
edges v=new edges(b,name);
alledge.add(v);
fullmap.put(a, alledge);
}
public void addNeighbourListfromaout(node a, List<edges> nList)
{
	ArrayList<edges> alledge = new ArrayList<edges>();
	alledge=fullmap.get(a);
	alledge.addAll(nList);
	fullmap.put(a, alledge);
}
public void deleteNeighbourfromatob(node p, edges n)
{ArrayList<edges> k = new ArrayList<edges>();
k=fullmap.get(p);
k.remove(n);
fullmap.put(p, k);
}
public void getneghboursOfNode(node n)
{ArrayList<edges> k= new ArrayList<edges>();
k=fullmap.get(n);
int i=1;
for(edges h:k)
{            System.out.println(i+" the name of the outgoing neighbouring node from "+n.getName() +" is " + h.getOne().getName()+" and the name of the connecting edge is "+h.nameofedge);
			i++;
			//System.out.println("the id of the outgoing neighbouring node is " + a.getId());
}
}
}

class edges
{
	node one;
	String nameofedge;

	public node getOne() {
		return one;
	}
	public void setOne(node one) {
		this.one = one;
	}
		public String getNameofedge() {
		return nameofedge;
	}
	public void setNameofedge(String nameofedge) {
		this.nameofedge = nameofedge;
	}
	public edges(node one, String nameofedge) {
		this.one = one;
		this.nameofedge = nameofedge;
	}
}

class map
{
	public static void main(String[] args)
	{
		node a= new node(1,"random");
		node b= new node(2,"fun");
		node c= new node(5,"hey");
		node d= new node(25,"wow");
		undirectedgraph graph= new undirectedgraph();
		graph.addnode(a);
		graph.addnode(b);
		graph.addnode(c);
		graph.addNeighbour(c,a);
		graph.addNeighbour(a, b);
		graph.getneghboursOfNode(a);
		graph.getneghboursOfNode(c);

		
	}

}