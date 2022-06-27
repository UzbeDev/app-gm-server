package uz.itca.gm_aplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.itca.gm_aplication.entity.Car;
import uz.itca.gm_aplication.payload.ApiResponse;
import uz.itca.gm_aplication.payload.ReqCar;
import uz.itca.gm_aplication.repository.CarRepository;
import uz.itca.gm_aplication.service.CarService;

import java.util.UUID;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService carService;
    @Autowired
    CarRepository carRepository;

    @PostMapping
    public HttpEntity<?> addCar(@RequestBody ReqCar reqCar) {
        ApiResponse apiResponse = carService.addCar(reqCar);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCar(@PathVariable UUID id) {
        Car byId = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("asd"));
        return ResponseEntity.ok(carService.getCar(byId));
    }


    @GetMapping
    public HttpEntity<?> getCarList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return ResponseEntity.ok(carService.getCarList(page, size));
    }

    @GetMapping("/byColor")
    public HttpEntity<?> getCarByColorAndCarNameAndPosition(
            @RequestParam(value = "carNameId", defaultValue = "0") Integer carNameId,
            @RequestParam(value = "positionId", defaultValue = "0") Integer positionId,
            @RequestParam(value = "colorId", defaultValue = "0") Integer colorId) {
        return ResponseEntity.ok(carService.getCar(carRepository.findByColorIdAndCarTemplate_CarName_IdAndCarTemplate_Position_Id(colorId, carNameId, positionId)));
    }


}
