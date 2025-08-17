package ar.itba.edu.pod.grpc.hazelcast.server;

public class test {
    public static void main(String[] args) {


        String compose = "2230 UNIVERSITY AVENUE";
        String c2 = "460 WEST 149 STREET";
        String n1 = "BROADWAY";
        String n2 = "HENDRIX STREET";
        String espacios = "1234  dsds";
        String[] arrs = {compose, c2, n1, n2, espacios};

        for(String s : arrs){
            System.out.println(s + " -> " + s.replaceFirst("^\\d+\\s+", ""));
        }


    }
}