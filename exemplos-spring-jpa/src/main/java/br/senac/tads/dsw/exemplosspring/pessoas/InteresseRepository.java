/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.List;
import java.util.Optional;

public interface InteresseRepository {

    List<Interesse> findAll();

    Optional<Interesse> findById(Integer id);

    Interesse save(Interesse interesse);

}
