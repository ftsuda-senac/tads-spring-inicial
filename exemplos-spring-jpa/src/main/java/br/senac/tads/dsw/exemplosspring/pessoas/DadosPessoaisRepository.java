/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.senac.tads.dsw.exemplosspring.pessoas;

import java.util.List;
import java.util.Optional;

public interface DadosPessoaisRepository {

    List<DadosPessoais> findAll(int qtde, int offset);

    List<DadosPessoais> findByInteresses(List<Integer> interessesIds, int qtde, int offset);

    Optional<DadosPessoais> findById(Integer id);

    Optional<DadosPessoais> findByApelido(String apelido);

    DadosPessoais save(DadosPessoais dados);

}
