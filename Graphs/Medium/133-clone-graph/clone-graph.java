/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Integer, Node> visited = new HashMap<>();
        return cloneGraphHelper(node,visited);
    }

    public Node cloneGraphHelper(Node node, Map<Integer, Node> visited) {
        if(visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>());
        visited.put(node.val, newNode);
        List<Node> children = node.neighbors;
        if(children != null) {
            for(int i=0; i<children.size(); i++) {
                Node childNode = children.get(i);
                Node newChildNode = cloneGraphHelper(childNode,visited);
                newNode.neighbors.add(newChildNode);
            }
        }

        return newNode;
    }
}