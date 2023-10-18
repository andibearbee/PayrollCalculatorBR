package com.pluralsight;
import java.io.*;
import java.util.*;
public class PayrollCalcBR {
    public static void main(String[] args) {
        Scanner fileNameScanner = new Scanner(System.in);
                System.out.println("What is the name of the file you want to read/process?");
                String currentFileName = fileNameScanner.next();
                System.out.println("What file do you want to create please include a .csv extension?");
                String newFileName = fileNameScanner.next();
                try
                {
// create a FileReader object connected to the File
                    FileReader fileReader = new FileReader("src/main/resources/" + currentFileName);
// create a BufferedReader to manage input stream
                    BufferedReader employeeReader = new BufferedReader(fileReader);
                    FileWriter fileWriter = new FileWriter("src/main/resources/" + newFileName);
                    BufferedWriter bufWriter = new BufferedWriter(fileWriter);

                    String input;
// read until there is no more data
                    while((input = employeeReader.readLine()) != null) {
                        String [] employeeInfo = input.split("\\|");
                        int employeeID = Integer.parseInt(employeeInfo[0]);
                        String employeeName = employeeInfo[1];
                        double employeeHours = Double.parseDouble(employeeInfo[2]);
                        double employeeWage = Double.parseDouble(employeeInfo[3]);
                        Employee employee = new Employee(employeeID, employeeName, employeeHours, employeeWage);
                        bufWriter.write (employee.getEmployeeId() + "|"+ employee.getName() + "|" + employee.getGrossPay() + "\n");
                    }
// close the stream and release the resources
                    employeeReader.close();
                    bufWriter.close();
                }
                catch(IOException e) {
// display stack trace if there was an error
                    e.printStackTrace();
                }
    }
}
