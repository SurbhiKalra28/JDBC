package org.example;


public class SqlQueries {
    public final static String GetEmployeByID="select * from employees where employeeNumber=? ";
    public final static String GetEmployeBySalalry= "select * from employees wheresalary = ?";
    public final static String GetClientByID="select * from clients where ClientID=? ";

}