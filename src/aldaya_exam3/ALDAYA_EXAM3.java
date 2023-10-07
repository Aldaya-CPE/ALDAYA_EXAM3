
package aldaya_exam3;
import java.util.Scanner;

public class ALDAYA_EXAM3{

    private class PriorityArray{
        int priority;
        String data;
        PriorityArray next;
        int printCount = 0;
 
    }
   
    private PriorityArray front;
    
    private void insertion(String item, int priority, int printCount) throws Exception{
        PriorityArray node = new PriorityArray();
        node.data = item;
        node.priority = priority;
        node.printCount = priority;
        node.next= null;
        
        
        if(front == null  || priority <= front.priority){
            node.next = front;
            front = node;
        }
        else{
            PriorityArray temporary = front;
            while (temporary.next != null && temporary.next.priority <= priority){
                temporary = temporary.next;
            }
            node.next = temporary.next;
            temporary.next = node;
        } 
        printCount++;
        if(printCount > 5){
            deletion();
        }
    }   
        
    
    public String deletion() throws Exception{
        
        
        if(front == null){
            throw new Exception("Que is empty");
        }
         String temporary = front.data;
         front = front.next;
         
         return temporary;
         
         
    }
    
    public void display() throws Exception{
        if (front == null){
            throw new Exception("Que is empty");
        }
        PriorityArray temporary = front;
        System.out.println("Pages \t\t Priority");
        
        while(temporary != null){
            System.out.println(temporary.data + " \t\t " + temporary.priority);
            temporary = temporary.next;
        }
        System.out.println("\n");
                
    }
    
    public static void main(String[] args) throws Exception {
           Scanner scan = new Scanner(System.in);
       ALDAYA_EXAM3 list = new ALDAYA_EXAM3 ();
       boolean start =true;
       
       while(start){
           System.out.println("Menu");
           System.out.println("1. Insert");
           System.out.println("2. Display");
           System.out.println("3. Exit");
           int choice = scan.nextInt();
           int printCount = 0;
           int priority = 0;
           String index;
         
           
           switch (choice){
               case 1:
                   System.out.println("Enter Number");
                   index = scan.next();
                   
                   System.out.println("Enter Priority number");
                   priority =scan.nextInt();
                   
                 System.out.println("input Student number");
               
                   list.insertion(index, priority, printCount);
                   if(priority > 5){
                   list.deletion();
                   }
                 
                   break;
               case 2:
                   
                   list.display();
                   break;
               case 3:
                   System.out.println("Exiting program. Goodbye!");
                   System.exit(0);
                   break;
               default:

           }
                   
       }
    }
}


