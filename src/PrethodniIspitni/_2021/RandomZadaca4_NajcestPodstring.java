package PrethodniIspitni._2021;

import dataStructures.CBHT;

import java.io.*;

public class RandomZadaca4_NajcestPodstring {
    public static void main (String[] args) throws IOException {
        CBHT<String,Integer> tabela = new CBHT<String,Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().trim();
        int maxPojavuvanja=0;
        String kluc="";
        String podString4e;
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<word.length()+1;j++){
                podString4e=word.substring(i, j);
//                System.out.println(podString4e);
                if(tabela.search(podString4e)==null){
                    tabela.insert(podString4e, 1);
                }
                else {
                    tabela.search(podString4e).element.value+=1;
                    if (tabela.search(podString4e).element.value>maxPojavuvanja){
                        maxPojavuvanja=tabela.search(podString4e).element.value;
                        kluc=podString4e;
                    } else if (tabela.search(podString4e).element.value==maxPojavuvanja) {
                        if(podString4e.length()>kluc.length()){
                            kluc=podString4e;
                        }
                        else if(podString4e.length()==kluc.length()&&Character.compare(podString4e.charAt(0), kluc.charAt(0))<0) {
                            kluc = podString4e;
                        }
                    }
                }
            }

        }
        if (maxPojavuvanja==0)
            System.out.println(word);
        else
            System.out.println(kluc);
        /*
         *
         * Vashiot kod tuka....
         *
         */


    }
}
