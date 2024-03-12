package gabriel.proyecto_centracom.controller;
import gabriel.proyecto_centracom.Services.EmployeeService;
import gabriel.proyecto_centracom.models.Employee;
import gabriel.proyecto_centracom.models.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Eliminar")
public class apiController {

    @Autowired
    private EmployeeService employeeService;

    @DeleteMapping("/{Id}")
    public void EliminarEmpleado(@PathVariable Long Id){
        employeeService.eliminarEmpleado(Id);
    }

    @PutMapping("/update")
    public String employeeUpdate(@PathVariable Long Id, @ModelAttribute Update employee){
        employeeService.actualizarEmpleado(Id,employee);
        return "redirect:/Update";
    }
}
