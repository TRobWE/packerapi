package io.threestacks.packerapi.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @RequestMapping("/")
    public String stuff(){
        return "Yo Momma";
    }

    @RequestMapping("/agendas")
    public List <Agenda> getAllAgendas(){
        return agendaService.getAllAgendas();
    }

    @RequestMapping("/agendas/{id}")
    public Agenda getAgenda(@PathVariable long id){
        return agendaService.getAgenda(id);
    }

    @RequestMapping(value ="/useragendas/{userId}")
    public List <Agenda> getUserAgendas(@PathVariable long userId){
        return agendaService.getUserAgendas(userId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/agendas")
    public Agenda addAgenda(@RequestBody Agenda agenda){
        Agenda newAgenda = agendaService.addAgenda(agenda);
        return newAgenda;
    }

    @RequestMapping(method= RequestMethod.PUT, value="/agendas/{id}")
    public Agenda updateAgenda(@RequestBody Agenda agenda, @PathVariable long id){
        Agenda updatedAgenda = agendaService.updateAgenda(id, agenda);
        return updatedAgenda;
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/agendas/{id}")
    public void deleteAgenda(@PathVariable long id){
        agendaService.deleteAgenda(id);
    }
}
