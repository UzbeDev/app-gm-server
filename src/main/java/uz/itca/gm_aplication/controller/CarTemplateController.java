package uz.itca.gm_aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.itca.gm_aplication.entity.CarTemplate;
import uz.itca.gm_aplication.payload.ApiResponse;
import uz.itca.gm_aplication.payload.ReqCarTemplate;
import uz.itca.gm_aplication.repository.CarTemplateRepository;
import uz.itca.gm_aplication.service.CarTemplateService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/carTemplate")
public class CarTemplateController {
    @Autowired
    CarTemplateService carTemplateService;
    @Autowired
    CarTemplateRepository carTemplateRepository;

    @PostMapping
    public HttpEntity<?> addCarTemplate(@RequestBody ReqCarTemplate reqCarTemplate) {
        ApiResponse apiResponse = carTemplateService.addCarTemplate(reqCarTemplate);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCarTemplate(@PathVariable UUID id) {
        CarTemplate carTemplate = carTemplateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("asd"));
        return ResponseEntity.ok(carTemplateService.getCarTemplate(carTemplate));
    }


    @GetMapping
    public HttpEntity<?> getCarTemplateList() {
        return ResponseEntity.ok(carTemplateService.getCarTemplates());
    }

    @PutMapping
    public HttpEntity<?> editCarTemplate(@Valid @RequestBody ReqCarTemplate reqCarTemplate) {
        ApiResponse apiResponse = carTemplateService.editCarTemplate(reqCarTemplate.getId(), reqCarTemplate);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }
}
