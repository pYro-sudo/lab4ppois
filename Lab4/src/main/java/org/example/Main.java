package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("Welcome!\nEnter the number of operation\n1 - bozo sort\n2 - merge sort\n3 - graph operations");
            int choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    Vector<Double> vector = new Vector<>();
                    System.out.println("Enter the size of array");
                    int size = new Scanner(System.in).nextInt();
                    for(int i=0;i<size;++i){
                        Double number= new Scanner(System.in).nextDouble();
                        vector.add(number);
                    }
                    BozoSort bozoSort = new BozoSort();
                    bozoSort.setArray(vector);
                    bozoSort.BozoSort();
                    break;
                case 2:
                    System.out.println("Enter the size of array");
                    int sizeMerge = new Scanner(System.in).nextInt();
                    double arr[] = new double[sizeMerge];
                    for(int i=0;i<sizeMerge;++i){
                        double number= new Scanner(System.in).nextDouble();
                        arr[i] = number;
                    }
                    MergeSort mergeSort = new MergeSort();
                    mergeSort.setArr(arr);
                    mergeSort.MergeSort();
                    break;
                case 3:
                    graphOperations();
                    break;
                default:
                    System.out.println("Could not comprehend");
                    break;
            }
        }
        catch (Exception e){
            System.out.println("The exception is:");
            e.printStackTrace();
            return;
        }
    }

    public static void graphOperations(){
        Graph graph = null;
        Object object = null;
        try{
            while(true){
                System.out.println("enter the operation\n0 - exit\n1 - check if the vertex exists\n2 - check if the edge exists\n" +
                        "3 - get amount of vertices\n4 - get amount of edges\n5 - get the degree of vertex" +
                        "\n6 - get the degree of edge\n7 - add a vertex\n8 - add an edge\n9 - remove the vertex" +
                        "\n10 - remove the edge\n11 - reverse the iterator\n12 - set the type of values");
                int choice = new Scanner(System.in).nextInt();
                switch (choice){
                    case 0:
                        return;
                    case 1:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("enter the name of vertex");
                            System.out.println(graph.getIterator().findVertex(new Scanner(System.in).nextLine()) == null);
                        }
                        break;
                    case 2:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("enter the name of edge");
                            System.out.println(graph.getIterator().findEdge(new Scanner(System.in).nextLine()) == null);
                        }
                        break;
                    case 3:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println(graph.amountOfVertices());
                        }
                        break;
                    case 4:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println(graph.amountOfEdges());
                        }
                        break;
                    case 5:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("enter the name of vertex");
                            Vertex vertex = graph.getIterator().findVertex(new Scanner(System.in).nextLine());
                            System.out.println(vertex == null ? -1 : vertex.getDegree());
                        }
                        break;
                    case 6:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("enter the name of edge");
                            Edge edge = graph.getIterator().findEdge(new Scanner(System.in).nextLine());
                            if(edge == null){
                                System.out.println(-1);
                            }
                            edge.getEdgeDegree();
                        }
                        break;
                    case 7:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("Enter the name");
                            String vertexName = new Scanner(System.in).nextLine();
                            System.out.println("Enter the value");
                            Object value = new Object();
                            if(object instanceof Integer){
                                value = new Scanner(System.in).nextInt();
                            }
                            if(object instanceof Double){
                                value = new Scanner(System.in).nextDouble();
                            }
                            if(object instanceof Float){
                                value = new Scanner(System.in).nextFloat();
                            }
                            if(object instanceof Byte){
                                value = new Scanner(System.in).nextByte();
                            }
                            if(object instanceof Boolean){
                                value = new Scanner(System.in).nextBoolean();
                            }
                            if(object instanceof Character){
                                value = new Scanner(System.in).nextLine().charAt(0);
                            }
                            if(object instanceof String){
                                value = new Scanner(System.in).nextLine();
                            }
                            if(object instanceof Long){
                                value = new Scanner(System.in).nextLong();
                            }
                            graph.getIterator().addItem(vertexName, value);
                        }
                        break;
                    case 8:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("Enter the name of the first vertex");
                            String vertexName1 = new Scanner(System.in).nextLine();
                            System.out.println("Enter the value");
                            Object value1 = new Object();
                            if(object instanceof Integer){
                                value1 = new Scanner(System.in).nextInt();
                            }
                            if(object instanceof Double){
                                value1 = new Scanner(System.in).nextDouble();
                            }
                            if(object instanceof Float){
                                value1 = new Scanner(System.in).nextFloat();
                            }
                            if(object instanceof Byte){
                                value1 = new Scanner(System.in).nextByte();
                            }
                            if(object instanceof Boolean){
                                value1 = new Scanner(System.in).nextBoolean();
                            }
                            if(object instanceof Character){
                                value1 = new Scanner(System.in).nextLine().charAt(0);
                            }
                            if(object instanceof String){
                                value1 = new Scanner(System.in).nextLine();
                            }
                            if(object instanceof Long){
                                value1 = new Scanner(System.in).nextLong();
                            }
                            System.out.println("Enter the name of the second vertex");
                            String vertexName2 = new Scanner(System.in).nextLine();
                            System.out.println("Enter the value");
                            Object value2 = new Object();
                            if(object instanceof Integer){
                                value2 = new Scanner(System.in).nextInt();
                            }
                            if(object instanceof Double){
                                value2 = new Scanner(System.in).nextDouble();
                            }
                            if(object instanceof Float){
                                value2 = new Scanner(System.in).nextFloat();
                            }
                            if(object instanceof Byte){
                                value2 = new Scanner(System.in).nextByte();
                            }
                            if(object instanceof Boolean){
                                value2 = new Scanner(System.in).nextBoolean();
                            }
                            if(object instanceof Character){
                                value2 = new Scanner(System.in).nextLine().charAt(0);
                            }
                            if(object instanceof String){
                                value2 = new Scanner(System.in).nextLine();
                            }
                            if(object instanceof Long){
                                value2 = new Scanner(System.in).nextLong();
                            }
                            System.out.println("enter the name of the edge");
                            graph.getIterator().addEdge(new Scanner(System.in).nextLine(),new Vertex(vertexName1,value1,0),new Vertex(vertexName2,value2,0));
                        }
                        break;
                    case 9:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("enter the name of vertex");
                            graph.getIterator().deleteVertex(new Scanner(System.in).nextLine());
                        }
                        break;
                    case 10:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            System.out.println("enter the name of edge");
                            graph.getIterator().deleteEdge(new Scanner(System.in).nextLine());
                        }
                        break;
                    case 11:
                        if(graph == null){
                            throw new NullPointerException("the type is not defined");
                        }
                        else{
                            graph.getIterator().reverseEdgeList();
                            graph.getIterator().reverseVertexList();
                        }
                        break;
                    case 12:
                        System.out.println("enter the type\n1 - int\n2 - double\n3 - float\n4 - byte\n5 - boolean\n" +
                                "6 - character\n7 - string\n8 - long");
                        int type = new Scanner(System.in).nextInt();
                        switch (type){
                            case 1:
                                graph = new Graph<Integer>();
                                object = new Integer(1);
                                graph.setIterator(new Iterator<Integer>(new ArrayList<Vertex<Integer>>(),new ArrayList<Edge<Integer>>()));
                                break;
                            case 2:
                                graph = new Graph<Double>();
                                object = new Double(8.1);
                                graph.setIterator(new Iterator<Double>(new ArrayList<Vertex<Double>>(),new ArrayList<Edge<Double>>()));
                                break;
                            case 3:
                                graph = new Graph<Float>();
                                object = new Float(1.9);
                                graph.setIterator(new Iterator<Float>(new ArrayList<Vertex<Float>>(),new ArrayList<Edge<Float>>()));
                                break;
                            case 4:
                                graph = new Graph<Byte>();
                                object = new Byte("jk");
                                graph.setIterator(new Iterator<Byte>(new ArrayList<Vertex<Byte>>(),new ArrayList<Edge<Byte>>()));
                                break;
                            case 5:
                                graph = new Graph<Boolean>();
                                object = new Boolean(false);
                                graph.setIterator(new Iterator<Boolean>(new ArrayList<Vertex<Boolean>>(),new ArrayList<Edge<Boolean>>()));
                                break;
                            case 6:
                                graph = new Graph<Character>();
                                object = new Character('q');
                                graph.setIterator(new Iterator<Character>(new ArrayList<Vertex<Character>>(),new ArrayList<Edge<Character>>()));
                                break;
                            case 7:
                                graph = new Graph<String>();
                                object = new String("wdf");
                                graph.setIterator(new Iterator<String>(new ArrayList<Vertex<String>>(),new ArrayList<Edge<String>>()));
                                break;
                            case 8:
                                graph = new Graph<Long>();
                                object = new Long(1L);
                                graph.setIterator(new Iterator<Long>(new ArrayList<Vertex<Long>>(),new ArrayList<Edge<Long>>()));
                                break;
                            default:
                                System.out.println("could not comprehend");
                                break;
                        }
                        break;
                    default:
                        System.out.println("could not comprehend");
                        break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
    }
}