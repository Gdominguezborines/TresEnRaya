package com.Ganadores;
import java.io.*;

public class FicheroGanadores {

 public void crearArchivoGanadores() {

        File file =new File("Ganadores.txt");

          if(!file.exists()){
                try{
                    file.createNewFile();
                    System.out.println(file.getName()+" Ha sido creado");

                }catch(IOException ex){
                    //ex.printStackTrace();
                    System.out.println("No se a encontrado el archivo");
                }

               }

    }

       public  void escribirArchivoGanadores(){

           String frase="ESto es una prueva ";

               try{
                   FileWriter escritura =new FileWriter("Ganadores.txt",true);

                   for (int i=0; i<frase.length();i++ ) {
                       System.out.println("  ");
                           escritura.write(frase.charAt(i));

                   }
               escritura.close();

               }catch (IOException e){
                   System.out.println("No se a encontrado el archivo");
               }

       }


    public  void leerArchivoGanadores(){

      try {
          FileReader file = new FileReader("Ganadores.txt");
           int c=0;
            while(c!=-1){
               c= file.read();
                char letra=(char)c;

                System.out.print( letra);
            }
            file.close();

      }catch (IOException e){
          System.out.println("No se a encontrado el archivo");
      }

    }



}
