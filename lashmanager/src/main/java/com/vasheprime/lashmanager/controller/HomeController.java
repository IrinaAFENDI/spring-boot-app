package com.vasheprime.lashmanager.controller;

import com.vasheprime.lashmanager.model.Appointment;
import com.vasheprime.lashmanager.model.Client;
import com.vasheprime.lashmanager.repository.AppointmentRepository;
import com.vasheprime.lashmanager.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;


@Controller
public class HomeController {


    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;


    @GetMapping("/")
    public String home(Model model){

      model.addAttribute("clients", clientRepository.findAll());
      return "home";
    }

    //форма добавления клиента
    @GetMapping("/add-client")
    public String showAddClientsForm(Model model){
       model.addAttribute("client", new Client());
       return "add-client";
    }
    //обработать данные формы
    @PostMapping("/add-client")
    public String addClient(@ModelAttribute Client client){

       clientRepository.save(client);
       return "redirect:/";//направляем на главную страницу
    }


@PostMapping("delete-client/{id}")
    public String deleteClient(@PathVariable Long id){
       clientRepository.deleteById(id);
       return "redirect:/";
}
@GetMapping("appointments")
    public String showAppointments(Model model){
       model.addAttribute("appointments", appointmentRepository.findAll());
       return "appointments";
}

//форма добавления записи
    @GetMapping("/add-appointment")
    public String showAddAppointmentForm(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("appointment", new Appointment());
        return "add-appointment";
    }


    //обработать данные формы

    @PostMapping("/add-appointment")
    public String addAppointment(@ModelAttribute Appointment appointment, @RequestParam Long clientId){
        //находим клиента по ид и связываем записи
       Client client = clientRepository.findById(clientId).orElseThrow(()->
        new IllegalArgumentException("Client not found" + clientId));
       appointment.setClient(client);
       appointmentRepository.save(appointment);
       return "redirect:/appointments";


    }
    @PostMapping("/delete-appointment/{id}")
    public String deleteAppointment(@PathVariable Long id){
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }


}
