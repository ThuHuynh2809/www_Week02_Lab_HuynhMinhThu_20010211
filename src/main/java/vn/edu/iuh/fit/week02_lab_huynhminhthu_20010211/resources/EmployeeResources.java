package vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.models.Employee;
import vn.edu.iuh.fit.week02_lab_huynhminhthu_20010211.services.EmployeeServices;

import java.util.Optional;


@Path("/employess")
public class EmployeeResources {
    private final EmployeeServices employeeServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeResources(){
        employeeServices = new EmployeeServices();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmployee(@PathParam("id") long id){
        Optional<Employee> optionalEmployee = employeeServices.findById(id);
        if(optionalEmployee.isPresent()){
            return Response.ok(optionalEmployee.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Employee> lst = employeeServices.getAll();
        return Response.ok(lst).build();
    }


    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        employeeServices.insertEmp(employee);
        return Response.ok(employee).build();
    }

    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (employeeServices.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
