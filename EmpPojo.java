/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyEmpMgmtApp.pojo;


public class EmpPojo {
    private int empno;
    private String ename;
    private double sal;

    public EmpPojo() {
    }

    public EmpPojo(int empno, String ename, double sal) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public double getSal() {
        return sal;
    }
    

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
    
    

   

    
}
