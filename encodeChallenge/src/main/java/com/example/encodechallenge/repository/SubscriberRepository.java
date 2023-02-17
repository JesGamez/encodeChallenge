package com.example.encodechallenge.repository;

import com.example.encodechallenge.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriberRepository implements ISubscriberRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Subscriber> findAll() {
        String SQL = "SELECT * FROM suscriptor";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Subscriber.class));
    }

    @Override
    public int save(Subscriber subscriber) {
        String SQL = "INSERT INTO Suscriptor VALUES (?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{subscriber.getNombre(), subscriber.getApellido(),
                subscriber.getNumeroDocumento(),subscriber.getTipoDocumento(),subscriber.getDireccion(),
                subscriber.getTelefono(),subscriber.getEmail(),subscriber.getNombreUsuario(),subscriber.getPassword()});
    }

    @Override
    public int update(Subscriber subscriber) {
        String SQL = "UPDATE Suscriptor SET  Nombre = ?, Apellido= ?, NumeroDocumento= ?, " +
                "TipoDocumento= ?, Direccion= ?, Telefono= ?, Email = ?,NombreUsuario = ?,Password= ? WHERE IdSuscriptor = ?";
        return jdbcTemplate.update(SQL, new Object[]{subscriber.getNombre(), subscriber.getApellido(),
                subscriber.getNumeroDocumento(),subscriber.getTipoDocumento(),subscriber.getDireccion(),
                subscriber.getTelefono(),subscriber.getEmail(),subscriber.getNombreUsuario(),subscriber.getPassword(),subscriber.getIdSuscriptor()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM Suscriptor WHERE IdSuscriptor = ? ";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
