package mockito_sky.mockito_sky;

public class Employee {
    private String nameEmployee;
    private String surnameEmployee;
    private int idEmployee;
    private double salaryEmployee;

    public Employee(int idEmployee, String nameEmployee, double salaryEmployee, String surnameEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.salaryEmployee = salaryEmployee;
        this.surnameEmployee = surnameEmployee;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
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
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", surnameEmployee='" + surnameEmployee + '\'' +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }
}
