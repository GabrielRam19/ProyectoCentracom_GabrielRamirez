package gabriel.proyecto_centracom.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import javax.persistence.Id;

@Entity
public class Update {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String Job;
    private String vaccine;
    private String novaccines;
    private String date;
    private LocalDate date2;
    private String State;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setNovaccines(String novaccines) {
        this.novaccines = novaccines;
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
        return "Update{" +
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
