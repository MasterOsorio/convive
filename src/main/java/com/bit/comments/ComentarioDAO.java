package com.bit.comments;

import org.springframework.stereotype.Repository;

import com.bit.dao.DAOTemplate;

@Repository
public class ComentarioDAO extends DAOTemplate<Comentario, Integer> {

	private static final long serialVersionUID = -5756296921331918735L;

}
