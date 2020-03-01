package codewithkapil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class onCallList {

private static final int noOfweeks = 52;
 private static   List<Employee> empList = new ArrayList<Employee>();

 //Accepts User inputs.
public static int  getNumberOfEmployees(){


    System.out.println("Enter Number of Employees");
    Scanner scanner = new Scanner(System.in);
    int noOfEmployees = scanner.nextInt();

    for(int i=0;i< noOfEmployees;i++) {
        System.out.println("Enter Name of Employee "+(i+1));
        Scanner scanner1 = new Scanner(System.in);
        if(scanner1.hasNext()) {
            String empName = scanner1.nextLine();
            Employee e = new Employee();
            e.setName(empName);
            empList.add(e);
        }
    }
   return  noOfEmployees;
}

 //Calculates the Weeks list.
public static void calOnCallList(int noOfEmployees){


    for(int i=0;i<empList.size();i++){
        List<LocalDate> weekTobeAddedList = new ArrayList<LocalDate>();

        for(int j=i; j<noOfweeks;j=j+(noOfEmployees)){

            int calendarWeek = j+1;
            LocalDate desiredDate = LocalDate.now()
                    .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
                    .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

            weekTobeAddedList.add(desiredDate);


        }

        empList.get(i).setEmpWeekList(weekTobeAddedList);

    }

}


 public static void main(String args[]){

     int noOfEmployees=getNumberOfEmployees();

     
      if(noOfEmployees>=1 && noOfEmployees<53){

          calOnCallList(noOfEmployees);
       
        //Prints the Schedule.  
        for(Employee e : empList){
              System.out.println("Name of the Employee: "+ e.getName());
              System.out.println("Weeklist: " + e.getEmpWeekList());
          }
      }
      else{

          System.out.println("Enter Number of Employees between 1 and 52");
          
      }
 }

}
