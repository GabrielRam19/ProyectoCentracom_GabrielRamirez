package gabriel.proyecto_centracom.controller;
import gabriel.proyecto_centracom.Services.EmployeeService;
import gabriel.proyecto_centracom.models.Employee;
import gabriel.proyecto_centracom.models.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

//clase para renderizar plantillas por metodos get y post
//Creado por gabriel ramirez

@Controller
public class UserController {

    @GetMapping(value = {"/login","/"})
    public String redirectLogin(){
        return "Login";
    }

    //funcion que renderiza el html de registro
    @GetMapping("/Registro")
    public String register(){
        return "Register";
    }
    private final EmployeeService employeeService;

    @Autowired
    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //funcion que deberia recolectar datos del form
    @PostMapping("/Employee")
    public String Employee(@ModelAttribute Employee employee, Model model){
        if(employee.getnovaccines().equals("Seleccione la cantidad")){
            model.addAttribute("error","Error, falta llenar algun campo!");
            return "Register";
        }
        //validacion para saber el tipo de vacuna que se usara para setear el estado del empleado
        //Y tambien la fecha de la segunda dosis
        switch(employee.getVaccine()){
            case "Sinopharm":
                if(Integer.parseInt(employee.getnovaccines())==0){
                    employee.setState("En riesgo");
                }else if(Integer.parseInt(employee.getnovaccines())==1){
                    DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    System.out.println(employee.getDate());
                    LocalDate dateaux=LocalDate.parse(employee.getDate(),formato);
                    employee.setDate2(dateaux.plusWeeks(4));
                    employee.setState("En proceso");
                }else if(Integer.parseInt((employee.getnovaccines()))==2){
                    employee.setDate2(null);
                    employee.setState(("Protegido"));
                }
                break;
            case "AstraZeneca":
                if(Integer.parseInt(employee.getnovaccines())==0){
                    employee.setState("En riesgo");
                }else if(Integer.parseInt(employee.getnovaccines())==1){
                    DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    System.out.println(employee.getDate());
                    LocalDate dateaux=LocalDate.parse(employee.getDate(),formato);
                    employee.setDate2(dateaux.plusWeeks(8));
                    employee.setState("En proceso");
                }else if(Integer.parseInt((employee.getnovaccines()))==2){
                    employee.setDate2(null);
                    employee.setState(("Protegido"));
                }
                break;
            case "Sputnik V":
                if(Integer.parseInt(employee.getnovaccines())==0){
                    employee.setState("En riesgo");
                }else if(Integer.parseInt(employee.getnovaccines())==1){
                    DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    System.out.println(employee.getDate());
                    LocalDate dateaux=LocalDate.parse(employee.getDate(),formato);
                    employee.setDate2(dateaux.plusDays(60));
                    employee.setState("En proceso");
                }else if(Integer.parseInt((employee.getnovaccines()))==2){
                    employee.setDate2(null);
                    employee.setState(("Protegido"));
                }
                break;
            case "Pfizer":
                if(Integer.parseInt(employee.getnovaccines())==0){
                    employee.setState("En riesgo");
                }else if(Integer.parseInt(employee.getnovaccines())==1){
                    DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    System.out.println(employee.getDate());
                    LocalDate dateaux=LocalDate.parse(employee.getDate(),formato);
                    employee.setDate2(dateaux.plusDays(21));
                    employee.setState("En proceso");
                }else if(Integer.parseInt((employee.getnovaccines()))==2){
                    employee.setDate2(null);
                    employee.setState(("Protegido"));
                }
                break;
            case "Moderna":
                if(Integer.parseInt(employee.getnovaccines())==0){
                    employee.setState("En riesgo");
                }else if(Integer.parseInt(employee.getnovaccines())==1){
                    DateTimeFormatter formato= DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    System.out.println(employee.getDate());
                    LocalDate dateaux=LocalDate.parse(employee.getDate(),formato);
                    employee.setDate2(dateaux.plusDays(28));
                    employee.setState("En proceso");
                }else if(Integer.parseInt((employee.getnovaccines()))==2){
                    employee.setDate2(null);
                    employee.setState(("Protegido"));
                }
                break;
            case "Janssen":
                if(Integer.parseInt(employee.getnovaccines())==0){
                    employee.setState("En riesgo");
                }else if(Integer.parseInt(employee.getnovaccines())==1){
                    employee.setDate2(null);
                    employee.setState("Protegido");
                }
                break;
        }
        if(employee.getVaccine().equals("Janssen") && Integer.parseInt(employee.getnovaccines())>1){
            model.addAttribute("error","La vacuna Janssen tiene unicamente una dosis.");
            return "Register";
        }
        try{
            employeeService.guardarEmployee(employee);
            model.addAttribute("mensaje", "Se registro al empleado con exito!");
        }catch(EmployeeService.MiExcepcion e){
            model.addAttribute("error", "Error al guardar el registro");
        }
        return "Register";
    }

    @GetMapping("/Update")
    public String update(){
        return "Update";
    }

    @PostMapping("/uptreg")
    public String Update(@ModelAttribute Update employee,Model model){
        if(employee.getnovaccines().equals("Seleccione la cantidad")){
            model.addAttribute("error","Error, falta llenar algun campo!");
            return "Register";
        }
        if(employee.getId()!=null) {
            switch (employee.getVaccine()) {
                case "Sinopharm":
                    if (Integer.parseInt(employee.getnovaccines()) == 0) {
                        employee.setState("En riesgo");
                    } else if (Integer.parseInt(employee.getnovaccines()) == 1) {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        System.out.println(employee.getDate());
                        LocalDate dateaux = LocalDate.parse(employee.getDate(), formato);
                        employee.setDate2(dateaux.plusWeeks(4));
                        employee.setState("En proceso");
                    } else if (Integer.parseInt((employee.getnovaccines())) == 2) {
                        employee.setDate2(null);
                        employee.setState(("Protegido"));
                    }
                    break;
                case "AstraZeneca":
                    if (Integer.parseInt(employee.getnovaccines()) == 0) {
                        employee.setState("En riesgo");
                    } else if (Integer.parseInt(employee.getnovaccines()) == 1) {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        System.out.println(employee.getDate());
                        LocalDate dateaux = LocalDate.parse(employee.getDate(), formato);
                        employee.setDate2(dateaux.plusWeeks(8));
                        employee.setState("En proceso");
                    } else if (Integer.parseInt((employee.getnovaccines())) == 2) {
                        employee.setDate2(null);
                        employee.setState(("Protegido"));
                    }
                    break;
                case "Sputnik V":
                    if (Integer.parseInt(employee.getnovaccines()) == 0) {
                        employee.setState("En riesgo");
                    } else if (Integer.parseInt(employee.getnovaccines()) == 1) {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        System.out.println(employee.getDate());
                        LocalDate dateaux = LocalDate.parse(employee.getDate(), formato);
                        employee.setDate2(dateaux.plusDays(60));
                        employee.setState("En proceso");
                    } else if (Integer.parseInt((employee.getnovaccines())) == 2) {
                        employee.setDate2(null);
                        employee.setState(("Protegido"));
                    }
                    break;
                case "Pfizer":
                    if (Integer.parseInt(employee.getnovaccines()) == 0) {
                        employee.setState("En riesgo");
                    } else if (Integer.parseInt(employee.getnovaccines()) == 1) {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        System.out.println(employee.getDate());
                        LocalDate dateaux = LocalDate.parse(employee.getDate(), formato);
                        employee.setDate2(dateaux.plusDays(21));
                        employee.setState("En proceso");
                    } else if (Integer.parseInt((employee.getnovaccines())) == 2) {
                        employee.setDate2(null);
                        employee.setState(("Protegido"));
                    }
                    break;
                case "Moderna":
                    if (Integer.parseInt(employee.getnovaccines()) == 0) {
                        employee.setState("En riesgo");
                    } else if (Integer.parseInt(employee.getnovaccines()) == 1) {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        System.out.println(employee.getDate());
                        LocalDate dateaux = LocalDate.parse(employee.getDate(), formato);
                        employee.setDate2(dateaux.plusDays(28));
                        employee.setState("En proceso");
                    } else if (Integer.parseInt((employee.getnovaccines())) == 2) {
                        employee.setDate2(null);
                        employee.setState(("Protegido"));
                    }
                    break;
                case "Janssen":
                    if (Integer.parseInt(employee.getnovaccines()) == 0) {
                        employee.setState("En riesgo");
                    } else if (Integer.parseInt(employee.getnovaccines()) == 1) {
                        employee.setDate2(null);
                        employee.setState("Protegido");
                    }
                    break;
            }
            if(employee.getVaccine().equals("Janssen") && Integer.parseInt(employee.getnovaccines())>1){
                model.addAttribute("error","La vacuna Janssen tiene unicamente una dosis.");
                return "Update";
            }
            try {
                employeeService.actualizarEmpleado(employee.getId(), employee);
                model.addAttribute("mensaje", "Se actualizo el registro con exito!");
            }catch(EmployeeService.MiExcepcion e){
                model.addAttribute("error",e.getMessage());
            }
        }else {
            model.addAttribute("error","Error, el id esta vacio o es invalido!");
        }
        return "Update";
    }

    //funcion que renderiza el html de reporte
    @GetMapping("/Report")
    public String report(Model model){
        List<Employee> employees= employeeService.obtenerEmpleados();
        model.addAttribute("employees", employees);
        return "Reporte";
    }

}
