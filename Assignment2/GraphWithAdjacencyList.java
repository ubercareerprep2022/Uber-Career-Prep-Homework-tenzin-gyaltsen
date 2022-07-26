package Assignment2;

import java.util.*;


public class GraphWithAdjacencyList {

    public static class GraphNode {
        public int data;
    
        GraphNode(int data) {
            this.data = data;
        }
    }

    private Map<GraphNode, List<GraphNode>> adjNodes;
    private Map<Integer, GraphNode> GraphNodeIdentifier;

    public GraphWithAdjacencyList(){
        adjNodes = new HashMap<>();
    }

    public void addNode(int key){
        adjNodes.put(new GraphNode(key), new ArrayList<GraphNode>());
        GraphNodeIdentifier.put(key, new GraphNode(key));
    }

    public void removeNode(int key){
        adjNodes.remove(new GraphNode(key));
    }

    public void addEdge(int node1, int node2){
        if(GraphNodeIdentifier.containsKey(node1) && GraphNodeIdentifier.containsKey(node2)){
            adjNodes.get(new GraphNode(node1)).add(new GraphNode(node2));
            adjNodes.get(new GraphNode(node2)).add(new GraphNode(node1));
        }
    }

    public void removeEdge(int node1, int node2){
        if(adjNodes.containsKey(new GraphNode(node1)) && adjNodes.containsKey(new GraphNode(node2))){
            adjNodes.get(new GraphNode(node1)).remove(new GraphNode(node2));
            adjNodes.get(new GraphNode(node2)).remove(new GraphNode(node1));
        }
    }

    public List<GraphNode> getAdjNodes(int key){
        return adjNodes.get(new GraphNode(key));
    }

    public void printAdjList(){
        System.out.println("Adjacency List: ");
        for(GraphNode n : adjNodes.keySet()){
            System.out.println("Node: " + n.data + " ");
            List<GraphNode> edges = adjNodes.get(n);
            for(GraphNode edge : edges){
                System.out.println(edge.data + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println("Start");
        GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
        graph.addNode(1);
        graph.addNode(2);
        graph.addEdge(1, 2);
        graph.printAdjList();
        System.out.println("end");
        System.out.println(graph.getAdjNodes(1));
    }
}


