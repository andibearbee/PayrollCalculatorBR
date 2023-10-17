package com.pluralsight;
import java.io.*;
public class PayrollCalcBR {
    public static void main(String[] args) {
                try
                {
// create a FileReader object connected to the File
                    FileReader fileReader = new FileReader("src/main/resources/employees.csv");
// create a BufferedReader to manage input stream
                    BufferedReader employeeReader = new BufferedReader(fileReader);
                    String input;
// read until there is no more data
                    while((input = employeeReader.readLine()) != null) {
                        String [] employeeInfo = input.split("\\|");
                        int employeeID = Integer.parseInt(employeeInfo[0]);
                        String employeeName = employeeInfo[1];
                        double employeeHours = Double.parseDouble(employeeInfo[2]);
                        double employeeWage = Double.parseDouble(employeeInfo[3]);
                        Employee employee = new Employee(employeeID, employeeName, employeeHours, employeeWage);
                        System.out.printf(employee.getEmployeeId() +" " + employee.getName() + " " + employee.getGrossPay() + " " +  "\n" + "\n");
                    }
// close the stream and release the resources
                    employeeReader.close();
                }
                catch(IOException e) {
// display stack trace if there was an error
                    e.printStackTrace();
                }
    }
}
