package com.main.project.web;

import com.main.project.entity.Customers;
import com.main.project.entity.OrderDetails;
import com.main.project.service.CustomerService;
import com.main.project.service.MapValidationErrorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer/v1")
@CrossOrigin
public class CustomerResource {

    private final CustomerService customerService;
    private final MapValidationErrorService mapValidationErrorService;

    public CustomerResource(CustomerService customerService, MapValidationErrorService mapValidationErrorService) {
        this.customerService = customerService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewCustomer(@Valid @RequestBody Customers customer, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Customers customer1 = customerService.saveOrUpdateCustomer(customer);
        return new ResponseEntity<Customers>(customer1, HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable(value = "customerId") String customerId) {

        Customers customer = customerService.findCustomerByIdentifier(customerId);

        return new ResponseEntity<Customers>(customer, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Customers> getAllCustomer(){
        return customerService.findAllCustomer();
    }

    @DeleteMapping("/{productIdentifier}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "productIdentifier") String id){
        customerService.deleteProjectByIdentifier(id);
        return new ResponseEntity<String>("Customer with ID: '"+id+"' was deleted", HttpStatus.OK);
    }

}
