/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcompliie2;

import Tablas.TablaSimbolos;
import ManejoDeArchivos.Mover;
import ejemplo1jflexcompi1.Lexico;
import ejemplo1jflexcompi1.Sintactico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import static java.lang.System.out;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Dary Castillo
 */
public class ElCompliIE21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, Exception {
        
              
    Scanner lee =new Scanner(System.in);      
    int op=0;
    System.out.println(" 1. Refrescar Archivos\n 2. Analizar txt");
    op=lee.nextInt();

    switch(op)
    {
        case 1:
             generarSintactico();
             generarLexico();
            break;
        case 2:
                  Reader reader = new BufferedReader(new FileReader("D:/Documentos/NetBeansProjects/ElCompliIE2.1/src/elcompliie2/entrada.txt"));
                  Lexico lexer =new Lexico(reader);//se genera el analisis lexico
                  Sintactico par=new Sintactico(lexer);//una que el analisis lexico este correcto se le pasa al analisis sintactico
                  par.parse();   
                 break;
        case 3:
            break;
    
    }
       

        
        // FIN DEL MAIN
    }
    
    //metodos para genererar los analizadores lexico y sintactico
        public static void generarLexico()//genera el archivo Lexer.java indicandole la ubicacion del lex.flex
{
            File file= new File("D:/Documentos/NetBeansProjects/ElCompliIE2.1/src/Lexico/lex.flex");
        jflex.Main.generate(file);
}
     
 public static void generarSintactico() throws IOException, Exception{//genere la clase parser.java y sym.java, ademas las mueve a al paquete correspondiente
    String[] asintactico = {"-parser", "Sintactico", "D:/Documentos/NetBeansProjects/ElCompliIE2.1/src/Sintactico/parser.cup"};
        java_cup.Main.main(asintactico);
       // Thread.sleep(500);
       new Mover().mover("D:/Documentos/NetBeansProjects/ElCompliIE2.1/Sintactico.java", "D:/Documentos/NetBeansProjects/ElCompliIE2.1/src/Sintactico/Sintactico.java");
       new Mover().mover("D:/Documentos/NetBeansProjects/ElCompliIE2.1/sym.java", "D:/Documentos/NetBeansProjects/ElCompliIE2.1/src/Sintactico/sym.java");
 }
 
// public static void Visual()
// {
// Visual a=new Visual();
//a.setVisible(true);
//a.setLocationRelativeTo(null);
// }
    
    
    
}
