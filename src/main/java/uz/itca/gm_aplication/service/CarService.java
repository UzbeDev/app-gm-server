package uz.itca.gm_aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.itca.gm_aplication.entity.Car;
import uz.itca.gm_aplication.exceptions.MyExeption;
import uz.itca.gm_aplication.payload.ApiResponse;
import uz.itca.gm_aplication.payload.ReqCar;
import uz.itca.gm_aplication.payload.ResCar;
import uz.itca.gm_aplication.payload.ResPageable;
import uz.itca.gm_aplication.repository.AttachmentRepository;
import uz.itca.gm_aplication.repository.CarRepository;
import uz.itca.gm_aplication.repository.CarTemplateRepository;
import uz.itca.gm_aplication.repository.ColorRepository;

import java.util.stream.Collectors;


@Service
public class CarService {
    @Autowired
    CarTemplateRepository carTemplateRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    CarRepository carRepository;

    public ApiResponse addCar(ReqCar reqCar) {
        Car car = new Car();
        car.setCarTemplate(carTemplateRepository.findById(reqCar.getCarTemplateId()).orElseThrow(() -> new ResourceNotFoundException("getCarTemplates")));
        car.setColor(colorRepository.findById(reqCar.getColorId()).orElseThrow(() -> new ResourceNotFoundException("get car color")));
        car.setPhoto(attachmentRepository.findById(reqCar.getPhotoId()).orElseThrow(() -> new ResourceNotFoundException("get car color")));
        car.setPrice(reqCar.getPrice());
        car.setActive(reqCar.isActive());
        carRepository.save(car);
        return new ApiResponse("Saqlandi", true);

    }

    public ResCar getCar(Car car) {
        return new ResCar(
                car.getId(),
                car.getCarTemplate() == null ? null : car.getCarTemplate().getCarName(),
                car.getCarTemplate() == null ? null : car.getCarTemplate().getPosition(),
                car.getColor(),
                car.getPhoto() == null ? null : car.getPhoto().getId(),
                car.getPrice(),
                car.isActive(),
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/attachment/").path(car.getPhoto().getId().toString()).toUriString()

        );
    }

    public ApiResponse getCarList(Integer page, Integer size) {
        try {
            if (page < 0) {
                throw new MyExeption("Page 0 dan kichik bo'lishi mumkin emas");
            }
            if (size < 1) {
                throw new MyExeption("Size 1 dan kichik bo'lishi mumkin emas");
            }
            //        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC,"price","created_at","ketmon");
            Pageable pageable = PageRequest.of(page, size);
//        Sort sort = Sort.by(Sort.Direction.ASC, "price", "created_at", "ketmon");
//        carRepository.findAll(sort);
            Page<Car> carPage = carRepository.findAll(pageable);
            return new ApiResponse("Mana carlar", true, new ResPageable(
                    page, size, carPage.getTotalPages(), carPage.getTotalElements(), carPage.getContent().stream().map(this::getCar).collect(Collectors.toList())
            ));
        } catch (IllegalArgumentException e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
