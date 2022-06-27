package uz.itca.gm_aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.itca.gm_aplication.entity.Client;
import uz.itca.gm_aplication.entity.Contact;
import uz.itca.gm_aplication.payload.ApiResponse;
import uz.itca.gm_aplication.payload.ReqClient;
import uz.itca.gm_aplication.payload.ResPageable;
import uz.itca.gm_aplication.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ApiResponse editClient(ReqClient reqClient) {
        try {
            Optional<Client> optionalClient = clientRepository.findById(reqClient.getId());
            if (optionalClient.isPresent()) {
                if (!clientRepository.findByPassportSerialEqualsIgnoreCaseAndPassportNumberAndPersonTypeAndIdNot(reqClient.getPassportSerial(), reqClient.getPassportNumber(), reqClient.getPersonType(), reqClient.getId()).isPresent()) {
                    Client client = optionalClient.get();
                    client.setFirstName(reqClient.getFirstName());
                    client.setLastName(reqClient.getLastName());
                    client.setMiddleName(reqClient.getMiddleName());
                    client.setTin(reqClient.getTin());
                    client.setPassportSerial(reqClient.getPassportSerial());
                    client.setPassportNumber(reqClient.getPassportNumber());
                    client.setBirthDate(reqClient.getBirthDate());
                    client.setGender(reqClient.getGender());
                    client.setPersonType(reqClient.getPersonType());
                    client.setCompanyName(reqClient.getCompanyName());
                    client.setLicenceNumber(reqClient.getLicenceNumber());
                    client.setLicenceExpire(reqClient.getLicenceExpire());
                    clientRepository.save(client);
                    return new ApiResponse("Edited client", true);
                }
                return new ApiResponse("Such client already exist", false);
            }
            return new ApiResponse("Such not found", false);
        } catch (Exception e) {
            return new ApiResponse("Xatolik", false);
        }
    }


    public ResPageable getClients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Client> clientPage = clientRepository.findAll(pageable);
        ResPageable resPageable = new ResPageable();
        resPageable.setPage(page);
        resPageable.setSize(size);
        resPageable.setTotalElements(clientPage.getTotalElements());
        resPageable.setTotalPages(clientPage.getTotalPages());
        resPageable.setObject(clientPage.getContent());
        return resPageable;
    }
}
