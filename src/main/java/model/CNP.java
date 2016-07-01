package model;
/**
* O webCadastro é um programa que cadastra funcionários
* de empresas cadastradas no sistema da CEASA-GO 
*
* @author  Vítor Roberto (http://www.linkedin.com/in/SVitorRoberto)
* @version 1.0
* @since   01/07/2016 
* 
*/
public class CNP {
   private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
   private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

   private static int calcularDigito(String str, int[] peso) {
      int soma = 0;
      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
         digito = Integer.parseInt(str.substring(indice,indice+1));
         soma += digito*peso[peso.length-str.length()+indice];
      }
      soma = 11 - soma % 11;
      return soma > 9 ? 0 : soma;
   }
   public boolean tomarDecisao(String str){
	   if(str.length()== 11)
		   return isValidCPF(str);
	   else
		   return isValidCNPJ(str);
   }
   public static boolean isValidCPF(String cpf) {
      if ((cpf==null) || (cpf.length()!=11) || (cpf.equals("00000000000") || cpf.equals("11111111111") ||
    	        cpf.equals("22222222222") || cpf.equals("33333333333") ||
    	        cpf.equals("44444444444") || cpf.equals("55555555555") ||
    	        cpf.equals("66666666666") || cpf.equals("77777777777") ||
    	        cpf.equals("88888888888") || cpf.equals("99999999999"))) return false;

      Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
      Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
      return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
   }

   public static boolean isValidCNPJ(String cnpj) {
      if ((cnpj==null)||(cnpj.length()!=14)) return false;

      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
      Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
      return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
   }

   public static void main(String[] args) {
      System.out.printf("CPF Valido:%s \n", CNP.isValidCPF("11111111111")); 
      System.out.printf("CNPJ Valido:%s \n", CNP.isValidCNPJ("01097494000174")); 
   }
}