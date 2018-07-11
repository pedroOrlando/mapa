/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;
/* valores:
PART = 200
IPSM = 124,49
UNI = 84
CASU = 128,61
PLAN DE S = 619,79+83,98 = 703,77
*/

//pagar plano + 1/2 imposto (27.5% dos planos)

/**
 *
 * @author pedrotty
 */
public class Mapa {
    
    static double part = 200;
    static double ipsm = 124.49;
    static double uni = 84;
    static double casu = 128.61;
    static double plano = 703;
    

    public static void CalculaValor(int qtdPART, int qtdIPSM, int qtdUNI, int qtdCASU, int qtdMESES){
        double totalFer = qtdIPSM*ipsm + qtdUNI*uni + qtdCASU*casu; //total de $ com fernando
        double totalEdu = qtdPART*part; //total de $ com eduardo
        double totalImp = totalFer*0.275;
        double totalPlan = qtdMESES*plano; //total de $ do plano
        double totalGer = totalFer + totalEdu; //total de $ com os 2
        double finalEdu = totalGer/2 - totalPlan - totalImp/2; //total de $ que deve ficar com eduardo depois da divisão e descontando o plano + impostos
        double finalFer = totalGer/2 + totalPlan + totalImp/2; //total de $ que deve ficar com fernando depois da divisão e adicionando o plano + impostos
        
        System.out.println("--> VALOR COM EDUARDO:\n"
                + qtdPART +" Particulares ("+ totalEdu+")\n"
                + "--> VALOR COM FERNANDO:\n"+ qtdIPSM+" IPSM ("+ qtdIPSM*ipsm +"),\n"
                + qtdUNI +" UNIMED ("+ qtdUNI*uni +"),\n"
                + qtdCASU +" CASU ("+ qtdCASU*casu +"),.\n"
                + "Total:" + totalFer + ". Impostos: "+ (int) Math.ceil(totalImp) +" ("+ (int) Math.ceil(totalImp/2) +" pra cada)\n"
                + "--> Total: "+totalGer+ "("+ totalGer/2 +" pra cada)<--\n\n"
                + "--> Valor do plano de saúde: \n"
                + qtdMESES+" mes(es) ("+totalPlan+")\n");
                
        System.out.println("Parte de Eduardo - plano de saúde - impostos: " + ((int) Math.ceil(finalEdu)));
        System.out.println("Parte de Fernando + plano de saúde: " + ((int) Math.ceil(finalFer))+ "\n");
        
        if (finalEdu - totalEdu < 0){ //se o valor que ele deve ficar for menor do que o que tá com ele, ele tem que passar a diferença pra fernando
            System.out.println("Valor a ser  passado pra Fernando: " + ((int) Math.ceil(finalEdu-totalEdu)*-1));
        }
        if (finalEdu - totalEdu > 0){ //se o valor que ele deve ficar for maior do que o que tá com ele, fernando tem que passar a diferença pra ele
            System.out.println("Valor a ser  passado pra Eduardo: " + ((int) Math.ceil(finalEdu-totalEdu)));
        }
            
        System.out.println("Particulares: "+ qtdPART+ "\n"
                + "IPSM: "+ qtdIPSM+ "\n"
                + "UNIMED: "+ qtdUNI+ "\n"
                + "Casu: "+ qtdCASU+ "\n"
                + "Meses do plano de saúde: "+ qtdMESES+ "\n"
                + "");
            
        
    }
    
    public static void main(String[] args) {
        
        
     
    }
    
}
