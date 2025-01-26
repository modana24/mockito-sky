package mockito_sky.mockito_sky;

public class Employee {
    private String nameEmployee;
    private String surnameEmployee;
    private int departmentEmployee;
    private double salaryEmployee;

    public Employee(int departmentEmployee, String nameEmployee, String surnameEmployee, double salaryEmployee) {
        this.departmentEmployee = departmentEmployee;
        this.nameEmployee = nameEmployee;
        this.surnameEmployee = surnameEmployee;
        this.salaryEmployee = salaryEmployee;

    }

    public int getDepartmentEmployee() {
        return departmentEmployee;
    }

    public void setDepartmentEmployee(int departmentEmployee) {
        this.departmentEmployee = departmentEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double salaryEmployee) {
        this.salaryEmployee = salaryEmployee;
    }

    public String getSurnameEmployee() {
        return surnameEmployee;
    }

    public void setSurnameEmployee(String surnameEmployee) {
        this.surnameEmployee = surnameEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + departmentEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", surnameEmployee='" + surnameEmployee + '\'' +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }

    public String getFullName() {
        return nameEmployee + surnameEmployee;
    }
}
