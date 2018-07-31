package awa.com.awatutorials.model;

import java.util.Arrays;

public class EmployeeDetail {
    private int empId;



    private boolean isPermanent;
    private EmpAddress empAddress;
    private long [] empContactNumbers;
    private String role;
    private String empName;

  /*  public EmployeeDetail(int empId, String empName, boolean isPermanent, EmpAddress empAddress, String[] empContactNumbers, String role) {
        this.empId = empId;
        this.empName = empName;
        this.isPermanent = isPermanent;
        this.empAddress = empAddress;
        this.empContactNumbers = empContactNumbers;
        this.role = role;
    }*/
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public void setEmpAddress(EmpAddress empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpContactNumbers(long[] empContactNumbers) {
        this.empContactNumbers = empContactNumbers;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public EmpAddress getEmpAddress() {
        return empAddress;
    }

    public long[] getEmpContactNumbers() {
        return empContactNumbers;
    }

    public String getRole() {
        return role;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("***** Employee Details *****\n");
        sb.append("ID="+getEmpId()+"\n");
        sb.append("Name="+getEmpName()+"\n");
        sb.append("Permanent="+isPermanent()+"\n");
        sb.append("Role="+getRole()+"\n");
        sb.append("Phone Numbers="+ Arrays.toString(getEmpContactNumbers())+"\n");
        sb.append("Address="+getEmpAddress());
        sb.append("\n*****************************");

        return sb.toString();
    }

}
