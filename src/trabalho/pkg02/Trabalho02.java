package trabalho.pkg02;

import javax.swing.JOptionPane;


public class Trabalho02 {

       /**
       * Check if float and greater than zero
       */
    public static boolean isFloatAndZero(String s){
        try{
            float f = 0;
            f = Float.parseFloat(s);
            if (f>0){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Valor incorreto para o salário base");
                return false;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Valor incorreto para o salário base");
            return false;
        }
    }
      
    /**
    * Check if greater than zero
    */
    public static boolean isGTZ(String s){
        float f = 0;
        f = Float.parseFloat(s);
        if (f>0){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "O valor não é maior que zero");
            return false;
        }
    }
        
    /**
    * Check if is empty
    */
    public static boolean isEmpty(String s){
        if (s.equals("")){
            JOptionPane.showMessageDialog(null, "Não foi informado nenhum valor");
            return true;
        }
        return false;
    }
        
    /**
    * Check if is integer and greater than zero
    */
    public static boolean isIntAndZero(String s){
        try{
            int i = 0;
            i = Integer.parseInt(s);
            if (i>0){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Valor incorreto para a quantidade de filhos");
                return false;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "O valor não é inteiro");
            return false;
        }
    }
  
    public static void main(String[] args) {
        String classes,sbases,qfilhoss = "0";
        float sbase,bf=0,vt,classe,sl,inss,ir,s,va = 472.47f,sb;
        int qfilhos;
        
        boolean isOK = false;
        do{
            sbases = JOptionPane.showInputDialog("Informe o valor do salário base:");
            if(!isEmpty(sbases) && isFloatAndZero(sbases)){
                isOK = true;
            }
        }while(!isOK);
        
        sbase = Float.parseFloat(sbases);
        isOK = false;
        
        
        if(JOptionPane.showConfirmDialog(null,"O funcionário possui filhos?", "Confirmação", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            do{
                qfilhoss = JOptionPane.showInputDialog("Informe a quantidade de filhos: ");
                if(!isEmpty(qfilhoss) && isIntAndZero(qfilhoss)){
                    isOK = true;
                }
            }while(!isOK);
        }
        
        qfilhos = Integer.parseInt(qfilhoss);
        
        do{
            classes = JOptionPane.showInputDialog(null,"Informe a Classe (C1,C2 ou C3)");
        }while(!classes.toLowerCase().equals("c1")&&!classes.toLowerCase().equals("c2")&&!classes.toLowerCase().equals("c3"));      
                
        if(qfilhos<=2 && qfilhos>0){
            bf = 197.14f;
        }
        else if(qfilhos>2){
            bf = 271.29f;
        }
        
        if(sbase<=1039){
            vt = 285.85f;
        }
        else if(sbase<=1546.5){
            vt = 201.43f;
        }
        else if(sbase<=2143.59){
            vt = 185.71f;
        }
        else if(sbase<=3002.17){
            vt = 121.33f;
        }
        else if(sbase<=3702.29){
            vt = 85.18f;
        }
        else{
            vt = 78.41f;
        }
        
        if(classes.equals("c1")){
            classe = 489.7f;
        }
        else if(classes.equals("c2")){
            classe = 731.67f;
        }
        else{
            classe = 1223.31f;
        }
        
        s = sbase + classe;
        
        if(s<=1499.15){
            ir =0;
        }
        else if(s<=2146.75){
            ir = (s*7.5f)/100;
        }
        else if(s<=2995.7){
            ir = (s*15)/100;
        }
        else if(s<=3441.16){
            ir = (s*22)/100;
        }
        else if(s<=4543.11){
            ir = (s*24.5f)/100;
        }
        else {
            ir = (s*28.5f)/100;
        }
        
        if(s<=1417.07){
            inss = (s*8)/100;
        }
        else if(s<=2195.12){
            inss = (s*9)/100;
        }
        else if(s<=3396.11){
            inss = (s*11)/100;
        }
        else {
            inss = (s*14)/100;
        }
        
        sb = s + va + bf + vt;
        sl = s - ir - inss + va + bf + vt; 
        
        float td,tb;
        td = ir + inss;
        tb = va + bf + vt;
        
        JOptionPane.showMessageDialog(null, "I-Salario Bruto: " + sb 
               + "\nII-Desconto aplicado no IR: " + ir
               + "\nIII-Desconto aplicado no INSS: " + inss
               + "\nIV-Total de descontos aplicados: " + td
               + "\nV-Valor do benefício do vale alimentação: " + va
               + "\nVI-Valor do benefício de bonificação por filhos: " + bf
               + "\nVII-Valor do benefício do vale transporte: " + vt
               + "\nVIII-Total dos benefícios aplicados: " + tb
               + "\nIX-Valor da classe: " + classe
               + "\nX-Salário Líquido: "+sl);
}
}