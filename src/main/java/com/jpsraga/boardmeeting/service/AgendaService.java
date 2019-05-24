package com.jpsraga.boardmeeting.service;

import com.jpsraga.boardmeeting.entity.Agenda;

public interface AgendaService {
	Agenda save(Agenda agenda);

	Agenda findById(Long agendaId);

	Agenda update(Agenda agenda);
}
