package ma.atos.ma.atos.bankmanagement.exceptions;

public class SitexExeption extends Exception{
   private String message;

   public SitexExeption(String message){
       super();
       this.message=message;
   }
}
