package io.threestacks.packerapi.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Service
public class AgendaService extends JdbcDaoSupport {


    private AgendaRepository agendaRepository;
    @Autowired
    DataSource dataSource;
    String sql;
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
        System.out.println(spring.datasource.url);
        System.out.println();
    }

    public List<Agenda> getAllAgendas(){
        List<Agenda> agendas = new ArrayList<>();
        agendaRepository.findAll().forEach(agendas::add);
        return agendas;
    }

    public List<Agenda> getUserAgendas(long userId){
        List<Agenda> agendas = new ArrayList<>();
        agendaRepository.findByUserId(userId).forEach(agendas::add);
        return agendas;
    }

    public Agenda getAgenda(long id) {
        return agendaRepository.findOne(id);
    }

    public Agenda addAgenda(Agenda agenda){
        agendaRepository.save(agenda);
        return agenda;
    }

//    public Agenda updateAgenda(long id, Agenda agenda){
//        Agenda agendaFound = agendaRepository.findOne(id);
//        agendaRepository.save(agenda);
//        return agenda;
//    }

    public void deleteAgenda(long id){
        agendaRepository.delete(id);
    }
}
