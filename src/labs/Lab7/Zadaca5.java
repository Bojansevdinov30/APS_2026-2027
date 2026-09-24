package labs.Lab7;

import dataStructures.OBHT;

import java.io.*;

public class Zadaca5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        OBHT<String,String>tabela=new OBHT<>(2*N);

        for(int i=0;i<N;i++)
        {
            String line=br.readLine();
            String[] pom=line.split(" ");
            //prvo gi vnesuvame na ang pa na mk deka mozeme da search samo po key a ne i po value
            tabela.insert(pom[1],pom[0]);
        }
        //System.out.println(tabela);

        String line=br.readLine();



        while(line!=null && !line.equals("KRAJ"))
        {
            int index=tabela.search(line);

            if(index!=-1){
                System.out.println(tabela.getBucket(index).value);
                line = br.readLine();
            }
            else{
                System.out.println("/");
                line = br.readLine();
            }
        }
    }

}
