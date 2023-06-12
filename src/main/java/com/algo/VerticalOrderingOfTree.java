package com.lnsk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Node {

    private int value;
    private Node left;
    private Node right;
    private int distance;
    private int level;

    public Node(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setLeft(Node leftNode){
        this.left = leftNode;
    }

    public Node getLeft(){
        return this.left;
    }

    public void setRight(Node rightNode){
        this.right = rightNode;
    }

    public Node getRight(){
        return this.right;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public int getDistance(){
        return this.distance;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

    @Override
    public String toString() {
        return this.value+""; 
    }
}

public class App 
{
	static List<Node> nodesASList = new ArrayList<>();
	
    public static void main( String[] args )
    {
//       Node root = new Node(4);
//       Node lvl1LeftNode = new Node(2);
//       Node lvl1RightNode = new Node(5);
//       root.setLeft(lvl1LeftNode);
//       root.setRight(lvl1RightNode);
//       Node lvl2Left1Node = new Node(1);
//       lvl1LeftNode.setLeft(lvl2Left1Node);
//       Node lvl2Right1Node = new Node(3);
//       lvl1LeftNode.setRight(lvl2Right1Node);
//       
//       
//       Node lvl2Left2Node = new Node(6);
//       lvl1RightNode.setLeft(lvl2Left2Node);
//       Node lvl2Right2Node = new Node(7);
//       lvl1RightNode.setRight(lvl2Right2Node);
//       
//       lvl2Left2Node.setRight(new Node(18));
//       lvl2Right2Node.setRight(new Node(19));
       
       Node root = getBalancedTree("4,2,5,1,3,6,18,19");
       //1,2,3,4,5,6,18,19
       
       System.out.println(root);
       findDIstanceAndLevel(root);
       System.out.println(nodesASList); 
       System.out.println("after findingDiatnace and level tree looks like");
       Comparator<? super Node> comp = (n1, n2) ->{
    	   if(n1.getDistance() < n2.getDistance()) {
    		   return n1.getDistance() - n2.getDistance();
    	   }else if(n1.getDistance() == n2.getDistance()) {
    		   if(n1.getLevel() == n2.getLevel())
    			   return n1.getValue() - n2.getValue();
    		   else
    			   return n1.getLevel() - n2.getLevel();
    	   } else {
    		   return n1.getDistance() - n2.getDistance();
    	   }
       };
       nodesASList.sort(comp);
       
       
       System.out.println(nodesASList); 
    }

    private static Node getBalancedTree(String nodeValues) {
		
    	int[] sortedNodeValues = Arrays.asList(nodeValues.split(",")).stream()
    			.mapToInt(s -> Integer.valueOf(s))
    	.sorted().toArray();
    	
    	Node root = new Node(sortedNodeValues[(sortedNodeValues.length/2)-1]);
    	
    	for(int nodeValue : sortedNodeValues) {
    		if(nodeValue != root.getValue()) {
    			Node newNode = new Node(nodeValue);
        		insertNode(newNode, root);
    		}
    	}
    	return root;
		
	}

	private static void insertNode(Node newNode, Node root) {
		Node currentNode = root;
		while(null != currentNode){
			if(newNode.getValue() < currentNode.getValue()) {
				if(null != currentNode.getLeft()) {
					insertNode(newNode, currentNode.getLeft());
				}else {
					currentNode.setLeft(newNode);
				}
			}
			if(newNode.getValue() > currentNode.getValue()) {
				if(null != currentNode.getRight()) {
					insertNode(newNode, currentNode.getRight());
				}else {
					currentNode.setRight(newNode);
				}
			}
			return;
		}
	}

	

	private static void findDIstanceAndLevel(Node root) {
    	
        Node currentNode = root;
        if(!nodesASList.contains(currentNode)) {
        	nodesASList.add(currentNode);
        }
        while(null != currentNode){
            if(null != currentNode.getLeft()){
                currentNode.getLeft().setDistance(currentNode.getDistance()-1);
                currentNode.getLeft().setLevel(currentNode.getLevel()+1);
                findDIstanceAndLevel(currentNode.getLeft());
            } 
            if(null != currentNode.getRight()){
                currentNode.getRight().setDistance(currentNode.getDistance()+1);
                currentNode.getRight().setLevel(currentNode.getLevel()+1);
                findDIstanceAndLevel(currentNode.getRight());
            } 
            	return;
            
        }
    }
}
