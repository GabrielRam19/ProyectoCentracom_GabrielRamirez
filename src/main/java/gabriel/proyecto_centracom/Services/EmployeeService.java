package gabriel.proyecto_centracom.Services;
import gabriel.proyecto_centracom.models.Employee;
import gabriel.proyecto_centracom.models.Update;
import gabriel.proyecto_centracom.repository.EmployeeRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//clase que actua como intermediario entre el controlador y el repositorio
//En esta van los metodos que se usan en el crud
//creado por gabriel ramirez

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //metodo para guardar el registro de un empleado
    @Transactional
    public void guardarEmployee(Employee employee) {
        String nombre=employee.getName();
        if(!employeeRepository.existsByName(nombre)){
            employeeRepository.save(employee);
            System.out.println("Se ingreso el empleado con exito!");
        }else {
            throw new MiExcepcion("El usuario ya existe");
        }
    }

    //lista que recupera todos los registros de la db para usarlos en el front
    public List<Employee> obtenerEmpleados() {
        return employeeRepository.findAll();
    }
    //clase para generar un error si el empleado ya existe
    public class MiExcepcion extends RuntimeException {

        public MiExcepcion(String mensaje) {
            super(mensaje);
        }
    }
    //metodo para eliminar empleados por id de sql
    public void eliminarEmpleado(Long Id){
        employeeRepository.deleteById(Id);
    }

    //metodo para actualizar el registro de un empleado.
    public void actualizarEmpleado(Long Id, Update employee){
        Optional<Employee> empleadoExistente = employeeRepository.findById(Id);
        if (empleadoExistente.isPresent()) {
            String nombre=employee.getName();
            if(!employeeRepository.existsByName(nombre)) {
                Employee empleadoActualizado = empleadoExistente.get();
                empleadoActualizado.setName(employee.getName());
                empleadoActualizado.setJob(employee.getJob());
                empleadoActualizado.setVaccine(employee.getVaccine());
                empleadoActualizado.setnovaccines(employee.getnovaccines());
                empleadoActualizado.setDate(employee.getDate());
                empleadoActualizado.setDate2(employee.getDate2());
                empleadoActualizado.setState(employee.getState());
                employeeRepository.save(empleadoActualizado);
            }else {
                throw new MiExcepcion("El usuario ya existe");
            }
        }else{
            throw new MiExcepcion("No existe ningun registro con ese id");
        }
    }
}
