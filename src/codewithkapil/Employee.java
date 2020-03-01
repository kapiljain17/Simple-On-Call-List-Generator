package codewithkapil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {


  String name;

  List<LocalDate> empWeekList = new ArrayList<LocalDate>();

  public List<LocalDate> getEmpWeekList() {
    return empWeekList;
  }

  public void setEmpWeekList(List<LocalDate> empWeekList) {
    this.empWeekList = empWeekList;
  }

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name=name;

  }


}
