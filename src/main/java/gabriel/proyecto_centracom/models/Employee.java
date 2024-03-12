package gabriel.proyecto_centracom.models;
import javax.persistence.*;

import java.time.LocalDate;

//esta clase es utilizada como modelo de entidad y se usa para ingresar los
//empleados a sql server
@Entity
@Table(name = "Empleado",schema = "dbo")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //se declaran los parametros de la clase empleado
    @Column(nullable = true)
    private Long Id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String Job;
    @Column(nullable = false)
    private String vaccine;
    @Column(nullable = false)
    private String novaccines;
    @Column(nullable = false)
    private String date;
    @Column(nullable = true)
    private LocalDate date2;
    @Column(nullable = false)
    private String State="En Riesgo";


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getnovaccines() {
        return novaccines;
    }

    public void setnovaccines(String noVaccines) {
        this.novaccines = noVaccines;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(LocalDate date2) {
        this.date2 = date2;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", Job='" + Job + '\'' +
                ", vaccine='" + vaccine + '\'' +
                ", novaccines='" + novaccines + '\'' +
                ", date='" + date + '\'' +
                ", date2=" + date2 +
                ", State='" + State + '\'' +
                '}';
    }
}
