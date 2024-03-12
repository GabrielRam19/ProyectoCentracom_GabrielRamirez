package gabriel.proyecto_centracom.repository;
import gabriel.proyecto_centracom.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//interfaz necesaria para tener acceso a metodos como save y delete para sql server
@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long> {
    //booleano para saber si un usuario existe en la db por nombre
    boolean existsByName(String Name);
    //Eliminar por Id
    void deleteById(Long Id);
}
