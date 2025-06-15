/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soalan5;

/**
 *
 * @author Hisyam
 */
public class Main {
    public static void main(String[] args) {
        Delivery delivery1 = new Delivery("Ali","Ahmad",4.4);
        Delivery delivery2 = new Delivery("Ah Chong","Fatimah",63.1);
        SpecialDelivery delivery3 = new SpecialDelivery("FSKTM,UM","FK,UM",32.5,true,false);
        SpecialDelivery delivery4 = new SpecialDelivery("Ang","Liew",19.0,true,true);
        
        System.out.println(delivery1.toString());
        System.out.println(delivery2.toString());
        System.out.println(delivery3.toString());
        System.out.println(delivery4.toString());
    }
}

class Delivery{
    String sender;
    String recipient;
    double weightOfPackage;

    public Delivery(String sender, String recipient, double weightOfPackage) {
        this.sender = sender;
        this.recipient = recipient;
        this.weightOfPackage = weightOfPackage;
    }
    
    public double totalCost(){
        double totalCost = -1;
        if(this.weightOfPackage <= 5){
            totalCost = this.weightOfPackage * 2.8;
        }
        else if(this.weightOfPackage > 5 && this.weightOfPackage <= 20){
            totalCost = (this.weightOfPackage - 5)*5.20 + 5*2.80;
        }
        else if (this.weightOfPackage > 20 && this.weightOfPackage <= 50){
            totalCost = (this.weightOfPackage - 20)*7.00 + 15*5.20 + 5*2.80;
        }
        else {
            totalCost = (this.weightOfPackage - 50)*8.60 + 30*7.00 + 15*5.20 + 5*2.80;
        }
        return totalCost;
    }
    
    @Override
    public String toString(){
        return String.format("""
                             Sender: %s
                             Recipient: %s
                             Weight of package: %.2f kg
                             Total shipping cost: RM%.2f
                             """, 
                this.sender,this.recipient,this.weightOfPackage,totalCost());
    }
}
    
    class SpecialDelivery extends Delivery{
        
        boolean weekendDelivery;
        boolean nighttimeDelivery;
        
        public SpecialDelivery(String sender, String recipient, double weightOfPackage, boolean weekendDelivery, boolean nighttimeDelivery) {
            super(sender, recipient, weightOfPackage);
            this.weekendDelivery = weekendDelivery;
            this.nighttimeDelivery = nighttimeDelivery;
        }
        
        @Override
        public double totalCost(){
        double totalCost = -1;
        if(this.weightOfPackage <= 5){
            totalCost = this.weightOfPackage * 2.8;
        }
        else if(this.weightOfPackage > 5 && this.weightOfPackage <= 20){
            totalCost = (this.weightOfPackage - 5)*5.20 + 5*2.80;
        }
        else if (this.weightOfPackage > 20 && this.weightOfPackage <= 50){
            totalCost = (this.weightOfPackage - 20)*7.00 + 15*5.20 + 5*2.80;
        }
        else {
            totalCost = (this.weightOfPackage - 50)*8.60 + 30*7.00 + 15*5.20 + 5*2.80;
        }
        
        if(this.weekendDelivery){
            totalCost += 50;
        }
        
        if(this.nighttimeDelivery){
            totalCost = totalCost * 1.20 ;
        }
        
        return totalCost;
     }
        
        @Override
        public String toString(){
            if(this.weekendDelivery && !this.nighttimeDelivery){
            return super.toString() + 
                    "Weekend Delivery\n";
            }
            else if(!this.weekendDelivery && this.nighttimeDelivery){
            return super.toString() + 
                    "Night Time Delivery\n";
            }
            else{
                return super.toString() +
                        "Weekend Delivery\nNight Time Delivery\n";
            }
                    
        }
    }
