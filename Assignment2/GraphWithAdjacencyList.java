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
        GraphNodeIdentifier = new HashMap<>();
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
            for(GraphNode node : adjNodes.keySet()){
                if(node.data == node1){
                    adjNodes.get(node).add(new GraphNode(node2));
                }
                if(node.data == node2){
                    adjNodes.get(node).add(new GraphNode(node1));
                }
            }
        }
    }

    public void removeEdge(int node1, int node2){
        if(GraphNodeIdentifier.containsKey(node1) && GraphNodeIdentifier.containsKey(node2)){
            Set<GraphNode> kSet = adjNodes.keySet();
            for(GraphNode node : kSet){
                if(node.data == node1){
                    List<GraphNode> edges = adjNodes.get(node);
                    GraphNode rNode = new GraphNode(-1);
                    for(GraphNode edge : edges){
                        if(edge.data == node2){
                            rNode = edge;
                        }
                    }
                    adjNodes.get(node).remove(rNode);
                }
                if(node.data == node2){
                    List<GraphNode> edges = adjNodes.get(node);
                    GraphNode rNode = new GraphNode(-1);
                    for(GraphNode edge : edges){
                        if(edge.data == node1){
                            rNode = edge;
                        }
                    }
                    adjNodes.get(node).remove(rNode);
                }
            }
        }
    }

    public List<GraphNode> getAdjNodes(int key){
        for(GraphNode n : adjNodes.keySet()){
            if(n.data == key){
                return adjNodes.get(n);
            }
        }
        return null;
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

    public void DFS(int key){
        Stack<Integer> aGraphNodes = new Stack<>();
        for(GraphNode n : adjNodes.keySet()){
            if(n.data == key){
                System.out.print(n.data + " ");
                for(GraphNode edge : adjNodes.get(n)){
                    aGraphNodes.add(edge.data);
                }
            }
        }

        Iterator<Integer> iT = aGraphNodes.iterator();
        while(iT.hasNext()){
            Integer curData = aGraphNodes.pop();
            System.out.print(curData + " ");
            for(GraphNode n : returnEdgeList(curData)){
                if(!aGraphNodes.contains(n.data)){
                    aGraphNodes.add(n.data);
                }
            }
        }
        System.out.println();
    }

    public List<GraphNode> returnEdgeList(int key){
        for(GraphNode n : adjNodes.keySet()){
            if(n.data == key){
                return adjNodes.get(n);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        GraphWithAdjacencyList graph = new GraphWithAdjacencyList();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.printAdjList();
        graph.DFS(1);
    }
}


