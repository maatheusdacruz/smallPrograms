package br.com.supermarket.controller;

import java.io.*;

public class BancoDeDados {
    public BancoDeDados() {
    }

    public void init(){

    }

    public void save(){

    }

    public void readFile(){
        try{
            InputStream is = new FileInputStream("../itens.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
            isr.close();
            is.close();

        }catch (Exception e){
            System.out.println("Erro ao ler o arquivo");
        }
    }
    public void writeFile(){
        try{
            OutputStream os;
            OutputStreamWriter osw;
            BufferedWriter bw;
        }catch (Exception e){
            System.out.println("Erro ao escrever no arquivo");
        }
    }

}
