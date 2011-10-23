/*
 * XJConverter - Binary to Decimal and viceversa
 * Bin2Dec developed by Xisco Bosch Matas
 * Dec2Bin developed by Joan Font Rosillo
 */

package xjconverter;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author joanfont & xiscobosch
 */
public class Main {
    public static void main(String[] args){
        int controller = 1;
        Random option = new Random();
        String options[] = {"Binario a Decimal","Decimal a Binario","Salir"};
        int optionsnum = options.length;
        int current = option.nextInt(optionsnum);
        do{
        int response = JOptionPane.showOptionDialog(
                               null                      
                             , "Selecciona una opcion"      
                             , "XJConverter"             
                             , JOptionPane.YES_NO_OPTION
                             , JOptionPane.INFORMATION_MESSAGE
                             , null                    
                             , options                   
                             , options[current]    
                           );
        if(response == 0){ //smth stuff
            String str,substr;
            int bin,count,partial;
            int decimal = 0;
            int i = 0;
            str = JOptionPane.showInputDialog(null,"Introduce un numero en binario: ");
            bin = Integer.parseInt(str);
            count = (str.length());
                do{
                    count--;
                    substr = str.substring(i,i+1);
                    partial = Integer.parseInt(substr);
                    bin = (int) Math.pow(2,count);
                    decimal+=partial*bin;
                    i++;
                }while(count > 0);
                JOptionPane.showMessageDialog(null,str+" en binario, es en decimal "+decimal,
                        "ÉXITO!",
                        JOptionPane.INFORMATION_MESSAGE
                        );
        }else if(response == 1){
            int decimalNumber,decimalNumberToShow;
            String binaryNumber,keyboard;
            keyboard = JOptionPane.showInputDialog(null,"Introduce un numero decimal (entero): ");
            decimalNumber = Integer.parseInt(keyboard);
            decimalNumberToShow = decimalNumber;
            if(decimalNumber <= 0){
                JOptionPane.showMessageDialog(null,"Tienes que entrar un numero positivo",
                        "ERROR!",
                        JOptionPane.ERROR_MESSAGE
                        );
            }else{
                binaryNumber = "";
                while(decimalNumber != 0){
                    if(binaryNumber.length() % 5 == 0){
                        binaryNumber = " " + binaryNumber;
                    }
                    binaryNumber = (decimalNumber % 2) + binaryNumber;
                    decimalNumber /= 2;
                }
                JOptionPane.showMessageDialog(null,decimalNumberToShow+" en decimal, es en binario "+binaryNumber,"ÉXITO!"
                        ,JOptionPane.INFORMATION_MESSAGE);
            }

        }else if(response == 2 || response == -1){
            controller = 0;
            System.exit(0);
        }
        }while(controller != 0);
    }

}

