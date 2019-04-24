package ar.edu.iua.orden.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.iua.orden.model.Orden;

@Repository
public class OrdenRepository extends JpaRepository<Orden, Integer>{

}
