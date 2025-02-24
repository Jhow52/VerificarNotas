/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package portifolio;

import java.util.Scanner;

/**
 *
 * @author Jhonata
 */
public class Portifolio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int quantidadeAlunos;
        double media;
        
        System.out.println("Qual a media de aprovacao? ");
        media = entrada.nextDouble();
        
        entrada.nextLine(); 
        
        System.out.println("Insira a quantidade de alunos");
        quantidadeAlunos = entrada.nextInt();
        
        entrada.nextLine(); 
        
        String[] alunos = new String[quantidadeAlunos];
        double[] notas = new double[quantidadeAlunos];
        
        for (int i = 0;i < quantidadeAlunos; i++){
            alunos[i] = lerNome(entrada,i);
            notas[i] = lerNumero(entrada,i);
            entrada.nextLine(); 
        }
        
        exibirNotas(alunos,notas);
        verificarAprovacao(alunos, notas, media);
    }
    
    public static void exibirNotas(String[] alunos, double[] notas){
        for (int i = 0;i < alunos.length; i++){
            System.out.println(alunos[i] + ":" + notas[i]);
        }
    }
    
    public static void verificarAprovacao(String[] alunos, double[] notas, double media){
        int aprovados = 0;
        int reprovados = 0;
        
        for(int i = 0; i < alunos.length; i++){
            if(notas[i] < media){
                System.out.println(alunos[i] + " Foi Reprovado com a media: " + notas[i]);
                reprovados++;
            }else{
                System.out.println(alunos[i] + " Foi Aprovado com a media: " + notas[i]);
                aprovados++;
            }
        }
        System.out.println("Total de reprovados: " + reprovados);
        System.out.println("Total de aprovados: " + aprovados);
    }
    
    public static String lerNome(Scanner entrada, int indice){
        String nome;
        while (true){
            System.out.println("Nome de alunos: " + (indice + 1) + ":");
            nome = entrada.nextLine();
            
            // Verificar se o nome é válido (não contém números)
            if (isNomeValido(nome)){
                return nome;
            }else{
                System.out.println("Entrada Invalida. O nome não pode conter números. Tente novamente.");
            }
        }
    }
    
    public static boolean isNomeValido(String nome){
        for(int i = 0; i < nome.length();i++){
            if (Character.isDigit(nome.charAt(i))){
                return false; // Se encontrar um número, retorna falso
            }
        }
        return true;  // Se não encontrar números, retorna verdadeiro
    }
    
    public static double lerNumero(Scanner entrada, int indice){
        String nota;
        double notaa = -1;
        
        while(true){
            System.out.println("Nota do aluno " + (indice + 1) + ":");
            nota = entrada.next();
            
            if(isNumeroValido(nota)){
                notaa = Double.parseDouble(nota);// Converte a String para double
                break;
            }else{
                System.out.println("Entrada Invalida. A nota não pode haver letras");
            } 
        }
        return notaa;
    }
    
    public static boolean isNumeroValido(String nota){
        try{
            Double.parseDouble(nota);// Tenta converter a entrada para um número
                return true;   // Se conseguir converter, é um número
        }catch (NumberFormatException e){
            // Se não conseguir, ocorre uma exceção
            return false;// Não é um número
        }
    }
}
