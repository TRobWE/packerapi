package io.threestacks.packerapi.agenda;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AgendaRepository extends CrudRepository<Agenda, Long>{
    List<Agenda> findByUserId(long userId);

}

