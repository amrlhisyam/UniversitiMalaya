/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingrevisions;

/**
 *
 * @author Hisyam
 */
public class Telephone {
    private String areaCode;
    private int number;
    private static int numberOfTelephoneObject = 0;
    
    public Telephone(String areaCode,int number){
        this.areaCode =areaCode;
        this.number =number;
        numberOfTelephoneObject++;
    }

    public String getAreaCode() { // acessore
        return areaCode;
    }

    public void setAreaCode(String areaCode) { //mutator
        this.areaCode = areaCode;
    }

    public int getNumber() { //acessore
        return number;
    }

    public void setNumber(int number) { //mutator
        this.number = number;
    }
    
    public String makeFullNumber(){
        String str = this.getAreaCode() + "-" + this.getNumber();
        return str;
    }


    public static void main(String[] args) {
        Telephone[] telArray = new Telephone[5];
        int number = 79676300;
        
        for(int i=0;i<5;i++){
            telArray[i]=new Telephone("03",number++);
        }
        
        for(int i=0;i<numberOfTelephoneObject;i++){
            String str = telArray[i].makeFullNumber();
            System.out.println(str);
        }
    }

}
