package ru.gb.vkr.service;

import org.springframework.stereotype.Service;
import ru.gb.vkr.repository.ServiceRepository;

import java.util.List;

@Service
public class ServiceManager {
    private final ServiceRepository serviceRepository;

    public ServiceManager(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ru.gb.vkr.model.Service> getAllEnabledServices() {
        return serviceRepository.findByEnabled(true);
    }

    public List<ru.gb.vkr.model.Service> getAllDisabledServices() {
        return serviceRepository.findByEnabled(false);
    }

    public List<ru.gb.vkr.model.Service> searchServicesByName(String name) {
        return serviceRepository.findByNameContaining(name);
    }

    public ru.gb.vkr.model.Service getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public ru.gb.vkr.model.Service saveService(ru.gb.vkr.model.Service service) {
        return serviceRepository.save(service);
    }
}


