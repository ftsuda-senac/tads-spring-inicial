package br.senac.tads.dsw.exemplorest;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import br.senac.tads.dsw.exemplorest.dominio.Interesse;
import br.senac.tads.dsw.exemplorest.dominio.InteresseRepository;
import br.senac.tads.dsw.exemplorest.dominio.Pessoa;
import br.senac.tads.dsw.exemplorest.dominio.PessoaRepository;

@SpringBootApplication
public class ExemploRestApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private InteresseRepository interesseRepository;

    private Random random = new SecureRandom();

    public static void main(String[] args) {
        SpringApplication.run(ExemploRestApplication.class, args);
    }

    private Set<Interesse> getRandomInteresses(List<Interesse> interesses) {
        int qtdInteresses = 1 + random.nextInt(3);
        Set<Interesse> interessesSelecionados = new LinkedHashSet<>();
        for (int i = 0; i < qtdInteresses; i++) {
            interessesSelecionados.add(interesses.get(random.nextInt(interesses.size())));
        }
        return interessesSelecionados;
    }

    // Executa após a inicialização do sistema para cadastrar dados iniciais no banco de dados H2
    // Para reiniciar os dados, parar a aplicação, apagar o arquivo de banco de dados do disco e reiniciar a aplicação
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Interesse> interesses;
        if (interesseRepository.count() < 1) {
            interesses = new ArrayList<>();
            interesses.add(interesseRepository.save(new Interesse("Tecnologia")));
            interesses.add(interesseRepository.save(new Interesse("Gastronomia")));
            interesses.add(interesseRepository.save(new Interesse("Viagens")));
            interesses.add(interesseRepository.save(new Interesse("Investimentos")));
            interesses.add(interesseRepository.save(new Interesse("Esportes")));
        } else {
            interesses = interesseRepository.findAll();
        }

        if (pessoaRepository.count() < 1) {
            pessoaRepository.save(new Pessoa("Agenor Barros", 1, LocalDate.of(1981, 11, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Almeida", 0, LocalDate.of(1961, 4, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Amanda Araujo", 0, LocalDate.of(1978, 12, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Chaves", 0, LocalDate.of(1976, 8, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gustavo Marques", 1, LocalDate.of(1985, 10, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("David Adams", 1, LocalDate.of(1979, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vânia Lemos", 0, LocalDate.of(1965, 4, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Silva", 1, LocalDate.of(1986, 12, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz Marinho", 0, LocalDate.of(1975, 1, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Enzo Cardoso", 1, LocalDate.of(1982, 10, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitor Lobato", 1, LocalDate.of(1984, 7, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juraci Campos", 0, LocalDate.of(1982, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daiane Delgado", 0, LocalDate.of(1976, 4, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Peter de Souza", 1, LocalDate.of(1992, 10, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sheila Machado", 0, LocalDate.of(1990, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabio Suzuki", 1, LocalDate.of(1998, 8, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandro Azevedo", 1, LocalDate.of(1992, 6, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carlos Cardoso", 1, LocalDate.of(1998, 12, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodnei Smith", 1, LocalDate.of(1995, 7, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Magali Machado", 0, LocalDate.of(1996, 8, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel Carvalho", 1, LocalDate.of(1979, 12, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gislaine Novaes", 0, LocalDate.of(1969, 7, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodrigo Rodrigues", 1, LocalDate.of(1974, 2, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leonardo Alves", 1, LocalDate.of(1997, 11, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ruth dos Santos", 0, LocalDate.of(1976, 9, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carina Sanches", 0, LocalDate.of(1968, 1, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley Rodrigues", 1, LocalDate.of(1982, 7, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elton Pinto", 1, LocalDate.of(1986, 5, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Renata Leite", 0, LocalDate.of(1960, 6, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sofia Barros", 0, LocalDate.of(1998, 12, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Pedro Travassos", 1, LocalDate.of(1996, 4, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruno Araujo", 1, LocalDate.of(1971, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruno Moreno", 1, LocalDate.of(1986, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Solange Fernandes", 0, LocalDate.of(2000, 6, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gislaine Lucena", 0, LocalDate.of(1978, 3, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joice Machado", 0, LocalDate.of(1994, 7, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Enzo Araujo", 1, LocalDate.of(1995, 1, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiano Bastos", 1, LocalDate.of(1968, 10, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Viviane Rossi", 0, LocalDate.of(1993, 7, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Telma Rossi", 0, LocalDate.of(1999, 11, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Janaína Guerra", 0, LocalDate.of(1971, 9, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gerson Bueno", 1, LocalDate.of(2001, 7, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Julia Travassos", 0, LocalDate.of(1990, 6, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Natasha Gimenez", 0, LocalDate.of(1976, 1, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diego Leite", 1, LocalDate.of(1995, 12, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Maria Assis", 0, LocalDate.of(2000, 2, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carolina Poeta", 0, LocalDate.of(1980, 5, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiano Loreto", 1, LocalDate.of(1975, 2, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nair Ferreira", 0, LocalDate.of(1988, 6, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sérgio Jonhson", 1, LocalDate.of(1984, 11, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eric Bastos", 1, LocalDate.of(1997, 7, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marta Jonhson", 0, LocalDate.of(1969, 11, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lucas Lopes", 1, LocalDate.of(1962, 10, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodrigo Costa", 1, LocalDate.of(1972, 3, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Pedro Adams", 1, LocalDate.of(1965, 10, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Laura Godoi", 0, LocalDate.of(1973, 12, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriano Pinheiro", 1, LocalDate.of(1983, 5, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jeremias Furtado", 1, LocalDate.of(1976, 6, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosiane Luxemburgo", 0, LocalDate.of(1962, 7, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Amanda Bauer", 0, LocalDate.of(1963, 12, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leonor Monteiro", 0, LocalDate.of(1980, 6, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabela Barbosa", 0, LocalDate.of(1967, 4, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carlos Ruas", 1, LocalDate.of(1990, 12, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joaquim Dantas", 1, LocalDate.of(1994, 11, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley Amaral", 1, LocalDate.of(1970, 6, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitória Travassos", 0, LocalDate.of(1989, 11, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samara Braga", 0, LocalDate.of(1994, 3, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sofia Sousa", 0, LocalDate.of(1988, 1, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Miguel Suzuki", 1, LocalDate.of(1960, 12, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vicente Siqueira", 1, LocalDate.of(2000, 1, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vânia Vasconcelos", 0, LocalDate.of(1991, 6, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edvaldo Travassos", 1, LocalDate.of(1969, 1, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sandro Silva", 1, LocalDate.of(1998, 2, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paloma Furtado", 0, LocalDate.of(1965, 3, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Patricia West", 0, LocalDate.of(1983, 2, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marta Barbosa", 0, LocalDate.of(1981, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiana Coelho", 0, LocalDate.of(1978, 10, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Priscila das Cruzes", 0, LocalDate.of(1990, 10, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caio Freitas", 1, LocalDate.of(2001, 7, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andrea das Dores", 0, LocalDate.of(1986, 1, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leonor Neves", 0, LocalDate.of(1999, 6, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciano Marinho", 1, LocalDate.of(1961, 4, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karen Kent", 0, LocalDate.of(1965, 10, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiano Alves", 1, LocalDate.of(1963, 4, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luana Leal", 0, LocalDate.of(1963, 7, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciano Barbosa", 1, LocalDate.of(1991, 8, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karolina das Dores", 0, LocalDate.of(1977, 7, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Odete Adams", 0, LocalDate.of(1991, 11, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roberto Mendes", 1, LocalDate.of(1977, 6, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilson Neves", 1, LocalDate.of(1991, 8, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carla Marques", 0, LocalDate.of(1993, 8, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joice Ramalho", 0, LocalDate.of(1970, 7, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriana Novaes", 0, LocalDate.of(1993, 10, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Celso Furtado", 1, LocalDate.of(1997, 5, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angelo Sakamoto", 1, LocalDate.of(1980, 12, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reginaldo Lins", 1, LocalDate.of(1976, 2, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caio Travassos", 1, LocalDate.of(1986, 8, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Murilo Marinho", 1, LocalDate.of(1972, 1, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ruth Assis", 0, LocalDate.of(1977, 12, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabela Viana", 0, LocalDate.of(1977, 12, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcos Cortez", 1, LocalDate.of(1992, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roger Pinheiro", 1, LocalDate.of(1999, 8, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fernanda Moreno", 0, LocalDate.of(1967, 8, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosana Esteves", 0, LocalDate.of(1986, 6, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jessica Mendes", 0, LocalDate.of(1989, 3, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rui Lobato", 1, LocalDate.of(1976, 7, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tamires Smith", 0, LocalDate.of(1968, 5, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Teresa Chaves", 0, LocalDate.of(1978, 2, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Manoela Azevedo", 0, LocalDate.of(1983, 7, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Taís Lins", 0, LocalDate.of(1964, 2, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Heloísa Kent", 0, LocalDate.of(1972, 8, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Telma Souza", 0, LocalDate.of(1971, 4, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvio Mota", 1, LocalDate.of(1967, 5, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Renato da Paz", 1, LocalDate.of(1999, 3, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caetano de Souza", 1, LocalDate.of(1964, 11, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reginaldo Loreto", 1, LocalDate.of(1988, 11, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fernanda Lane", 0, LocalDate.of(1999, 2, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcela Mota", 0, LocalDate.of(1989, 10, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Cunha", 0, LocalDate.of(2000, 11, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diogo das Dores", 1, LocalDate.of(1969, 12, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leonardo Lima", 1, LocalDate.of(1990, 7, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mauro Farias", 1, LocalDate.of(1999, 4, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elisa Silveira", 0, LocalDate.of(1986, 11, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angelo Ribeiro", 1, LocalDate.of(1962, 4, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Prado", 0, LocalDate.of(1974, 6, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samanta da Luz", 0, LocalDate.of(1976, 1, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodnei Lombardi", 1, LocalDate.of(1983, 10, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Priscila Guerra", 0, LocalDate.of(1979, 3, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roger Bloch", 1, LocalDate.of(1989, 9, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Amaral", 1, LocalDate.of(1977, 10, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Verônica Marques", 0, LocalDate.of(1985, 9, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paloma Bonifácio", 0, LocalDate.of(2001, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rafaela Marques", 0, LocalDate.of(2000, 12, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("João Chaves", 1, LocalDate.of(1961, 2, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rafael  Guimarães", 1, LocalDate.of(1979, 6, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Zuleica Dias", 0, LocalDate.of(1978, 9, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitor Marques", 1, LocalDate.of(1990, 10, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Regina Stallone", 0, LocalDate.of(1979, 6, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Verônica Liberato", 0, LocalDate.of(1993, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jonathan Ribeiro", 1, LocalDate.of(1970, 11, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanda Luxemburgo", 0, LocalDate.of(1979, 11, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diogo Alencar", 1, LocalDate.of(1981, 1, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eduardo Lucena", 1, LocalDate.of(1990, 5, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana dos Santos", 0, LocalDate.of(1973, 5, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lois Coelho", 0, LocalDate.of(1996, 4, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("John Bastos", 1, LocalDate.of(1961, 11, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alan Gomes", 1, LocalDate.of(1989, 5, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Zuleica Freitas", 0, LocalDate.of(1976, 9, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Domingos", 0, LocalDate.of(1970, 12, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joaquim Araujo", 1, LocalDate.of(1991, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilian de Souza", 1, LocalDate.of(2001, 10, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Vieira", 0, LocalDate.of(1995, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Alves", 0, LocalDate.of(1997, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz da Luz", 0, LocalDate.of(1968, 1, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fatima Constantino", 0, LocalDate.of(1977, 9, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosa Bloch", 0, LocalDate.of(1992, 2, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eric Constantino", 1, LocalDate.of(1972, 8, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandra Almeida", 0, LocalDate.of(1988, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glaucia Fontoura", 0, LocalDate.of(1974, 5, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiana Cunha", 0, LocalDate.of(1993, 9, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Domingos", 0, LocalDate.of(1996, 4, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Guilherme Sousa", 1, LocalDate.of(1976, 2, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alan Domingues", 1, LocalDate.of(1986, 10, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Hellen Godoi", 0, LocalDate.of(1982, 12, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosiane Guerra", 0, LocalDate.of(1975, 3, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reginaldo Ramalho", 1, LocalDate.of(1966, 4, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana França", 0, LocalDate.of(1987, 10, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bartolomeu Carvalho", 1, LocalDate.of(1962, 5, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Josias Santos", 1, LocalDate.of(1988, 2, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Suzana Lins", 0, LocalDate.of(1974, 5, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isis Godoi", 0, LocalDate.of(1965, 4, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina Santos", 0, LocalDate.of(1975, 11, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Solange Cortez", 0, LocalDate.of(1960, 12, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angelo Rodrigues", 1, LocalDate.of(2000, 12, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiana Bernades", 0, LocalDate.of(1977, 9, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("João Bonifácio", 1, LocalDate.of(1969, 10, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karen Peixoto", 0, LocalDate.of(1967, 9, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago West", 1, LocalDate.of(1994, 5, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carolina Leite", 0, LocalDate.of(1979, 8, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karina Allen", 0, LocalDate.of(1962, 1, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley Nakamura", 1, LocalDate.of(1970, 3, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sandro Sales", 1, LocalDate.of(1977, 9, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiano Pinheiro", 1, LocalDate.of(1974, 8, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvia Lins", 0, LocalDate.of(1978, 11, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanessa Bonifácio", 0, LocalDate.of(1981, 7, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Lins", 0, LocalDate.of(1991, 11, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jaqueline Silveira", 0, LocalDate.of(1979, 8, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valentina Cunha", 0, LocalDate.of(1960, 12, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mario  Rossi", 1, LocalDate.of(1976, 9, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gioavana Lucena", 0, LocalDate.of(1989, 3, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gael Luxemburgo", 1, LocalDate.of(1975, 6, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caetano Leal", 1, LocalDate.of(1986, 12, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vânia Medeiros", 0, LocalDate.of(1993, 11, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilian Nunes", 1, LocalDate.of(1983, 6, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Janaína Travassos", 0, LocalDate.of(1964, 12, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leticia Silveira", 0, LocalDate.of(1966, 5, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Arnold Bueno", 1, LocalDate.of(1997, 3, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sueli Lombardi", 0, LocalDate.of(1974, 12, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henry Santos", 1, LocalDate.of(1962, 2, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vinicius Lombardi", 1, LocalDate.of(1978, 3, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniela França", 0, LocalDate.of(1961, 4, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rafaela Medeiros", 0, LocalDate.of(1976, 1, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("André Nogueira", 1, LocalDate.of(1969, 2, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Anita Loreto", 0, LocalDate.of(1996, 3, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Heloísa Vasconcelos", 0, LocalDate.of(1974, 10, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sofia Bauer", 0, LocalDate.of(1984, 8, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruce Fernandes", 1, LocalDate.of(1983, 5, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilian Farias", 1, LocalDate.of(1999, 4, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Barry Sakamoto", 1, LocalDate.of(2000, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kátia Freitas", 0, LocalDate.of(1997, 12, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel Travassos", 1, LocalDate.of(1975, 10, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Laura Amaral", 0, LocalDate.of(1990, 2, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juraci Ruas", 1, LocalDate.of(1969, 4, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gislaine Pinto", 0, LocalDate.of(1986, 5, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isis Monteiro", 0, LocalDate.of(2001, 12, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Escobar Allen", 1, LocalDate.of(1968, 8, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Janaína Suzuki", 0, LocalDate.of(1984, 2, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Robson dos Santos", 1, LocalDate.of(1976, 3, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fatima Portman", 0, LocalDate.of(1974, 3, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mateus Gonzaga", 1, LocalDate.of(1991, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiana Monteiro", 0, LocalDate.of(1986, 3, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Agenor Gil", 1, LocalDate.of(1986, 7, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paulo Cortez", 1, LocalDate.of(1963, 6, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Escobar Azevedo", 1, LocalDate.of(2001, 1, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Camila Novaes", 0, LocalDate.of(1960, 12, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Godoi", 0, LocalDate.of(1994, 3, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cláudio Bernades", 1, LocalDate.of(1978, 11, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Antonio Poeta", 1, LocalDate.of(1998, 10, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ulisses Chaves", 1, LocalDate.of(1984, 1, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Evelyn Gomes", 0, LocalDate.of(1960, 6, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ellen Souza", 0, LocalDate.of(1961, 1, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Antonio Gimenez", 1, LocalDate.of(1999, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("André Carvalho", 1, LocalDate.of(1969, 9, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jason Rodrigues", 1, LocalDate.of(2001, 11, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nair Barros", 0, LocalDate.of(1998, 2, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Domingues", 1, LocalDate.of(1984, 11, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juraci Oliveira", 1, LocalDate.of(1995, 7, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristian Almeida", 1, LocalDate.of(1977, 4, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ulisses Lobato", 1, LocalDate.of(1989, 11, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabio Ruas", 1, LocalDate.of(1977, 7, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Inês Barbosa", 0, LocalDate.of(1996, 9, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Gomes", 0, LocalDate.of(1980, 4, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina Chaves", 0, LocalDate.of(1988, 1, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Oscar Jonhson", 1, LocalDate.of(1980, 3, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tiago Olsen", 1, LocalDate.of(1999, 4, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Telma Siqueira", 0, LocalDate.of(1990, 10, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henrique Bauer", 1, LocalDate.of(1983, 9, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Santos", 0, LocalDate.of(1969, 8, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joana Adams", 0, LocalDate.of(1994, 6, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bartolomeu Guimarães", 1, LocalDate.of(1968, 6, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kiko Souza", 1, LocalDate.of(1976, 2, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Richard Cortez", 1, LocalDate.of(1961, 8, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juraci Mota", 1, LocalDate.of(1984, 6, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tadeu Loreto", 1, LocalDate.of(1991, 9, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandra Oliveira", 0, LocalDate.of(1994, 5, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruno dos Santos", 1, LocalDate.of(1978, 1, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Nakamura", 0, LocalDate.of(1984, 8, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mariana Chaves", 0, LocalDate.of(1992, 1, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodrigo Marinho", 1, LocalDate.of(1986, 2, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Bonifácio", 1, LocalDate.of(1985, 1, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mariana Silveira", 0, LocalDate.of(1977, 2, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Rocha", 0, LocalDate.of(1970, 11, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Barry Marques", 1, LocalDate.of(1975, 8, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel Domingos", 1, LocalDate.of(1965, 9, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luiz Rodrigues", 1, LocalDate.of(1992, 12, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kelly Alencar", 0, LocalDate.of(1967, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Rocha", 0, LocalDate.of(1976, 3, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Yuji Fontoura", 1, LocalDate.of(1982, 6, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leandro  Nogueira", 1, LocalDate.of(1981, 10, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ivete Rocha", 0, LocalDate.of(1992, 2, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Jonhson", 0, LocalDate.of(1985, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alan Nascimento", 1, LocalDate.of(1980, 7, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carla West", 0, LocalDate.of(1993, 2, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Magda Moreno", 0, LocalDate.of(1974, 5, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabio Pinheiro", 1, LocalDate.of(1960, 5, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("John Machado", 1, LocalDate.of(1993, 6, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Inês Magalhães", 0, LocalDate.of(1987, 9, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Darci dos Santos", 0, LocalDate.of(1984, 6, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elisa das Cruzes", 0, LocalDate.of(1973, 2, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ulisses Constantino", 1, LocalDate.of(2000, 5, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Rocha", 0, LocalDate.of(1970, 12, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Evandro Olsen", 1, LocalDate.of(1971, 9, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reinaldo Bueno", 1, LocalDate.of(1966, 1, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Amanda Olsen", 0, LocalDate.of(1961, 11, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mateus Marques", 1, LocalDate.of(2000, 7, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rafaela Rossi", 0, LocalDate.of(1982, 12, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gael da Paz", 1, LocalDate.of(1983, 11, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Telma Gimenez", 0, LocalDate.of(1968, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joana West", 0, LocalDate.of(1998, 4, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcela Rossi", 0, LocalDate.of(1965, 10, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andreia Alencar", 0, LocalDate.of(1998, 9, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina Lobato", 0, LocalDate.of(1994, 6, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joice Luxemburgo", 0, LocalDate.of(1972, 6, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Yuji França", 1, LocalDate.of(1971, 10, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Selma Fernandes", 0, LocalDate.of(1984, 2, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rui Almeida", 1, LocalDate.of(1986, 4, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kleber Liberato", 1, LocalDate.of(1993, 9, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eric Loreto", 1, LocalDate.of(1976, 7, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elias Marques", 1, LocalDate.of(1998, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gael Mendes", 1, LocalDate.of(1960, 5, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Celso Santos", 1, LocalDate.of(1961, 10, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Laura Allen", 0, LocalDate.of(1985, 10, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Melissa Bastos", 0, LocalDate.of(1999, 8, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabrício Pinheiro", 1, LocalDate.of(2001, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana Bueno", 0, LocalDate.of(1973, 8, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Peter Ruas", 1, LocalDate.of(1993, 7, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Robson Pinheiro", 1, LocalDate.of(1997, 6, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marlene Constantino", 0, LocalDate.of(1969, 2, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vilma Lemos", 0, LocalDate.of(1969, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Antonio Olsen", 1, LocalDate.of(1982, 8, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fernando Costa", 1, LocalDate.of(1985, 12, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carolina Bueno", 0, LocalDate.of(1997, 9, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tiago Lobato", 1, LocalDate.of(1967, 3, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victor Araujo", 1, LocalDate.of(1975, 4, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Renata Barros", 0, LocalDate.of(1960, 11, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gabriela Guerra", 0, LocalDate.of(1983, 5, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rubens Domingues", 1, LocalDate.of(1962, 11, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ricardo Mota", 1, LocalDate.of(1962, 5, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daiane Duarte", 0, LocalDate.of(1997, 12, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Geraldo Nakamura", 1, LocalDate.of(1973, 4, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciana Leite", 0, LocalDate.of(1990, 7, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mauro Medeiros", 1, LocalDate.of(1983, 12, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Bloch", 0, LocalDate.of(1988, 5, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ronaldo Braga", 1, LocalDate.of(1983, 4, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henry Arruda", 1, LocalDate.of(1998, 11, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriana Souza", 0, LocalDate.of(2000, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Pinto", 0, LocalDate.of(1967, 10, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gilda Cunha", 0, LocalDate.of(1988, 8, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Telma Smith", 0, LocalDate.of(1975, 4, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Quitéria Rocha", 0, LocalDate.of(1974, 10, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paulo Neves", 1, LocalDate.of(1996, 1, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rafael  Freitas", 1, LocalDate.of(1978, 8, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jefferson Vieira", 1, LocalDate.of(1985, 12, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joaquim Sakamoto", 1, LocalDate.of(2001, 3, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Hugo Alba", 1, LocalDate.of(1965, 2, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eduarda Campos", 0, LocalDate.of(1987, 12, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diego Bernades", 1, LocalDate.of(1968, 9, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina Dantas", 0, LocalDate.of(1974, 3, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Regina Siqueira", 0, LocalDate.of(1990, 11, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Barbara Santiago", 0, LocalDate.of(1991, 3, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciano Lopez", 1, LocalDate.of(1992, 5, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samanta dos Santos", 0, LocalDate.of(1997, 3, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Danilo Barros", 1, LocalDate.of(1973, 4, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley Lobato", 1, LocalDate.of(1963, 7, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ruth Leite", 0, LocalDate.of(1979, 2, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michel Araujo", 1, LocalDate.of(1998, 1, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Renata Constantino", 0, LocalDate.of(1993, 10, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diana Lopez", 0, LocalDate.of(1993, 4, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvio Rodrigues", 1, LocalDate.of(1965, 4, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gael Alves", 1, LocalDate.of(1975, 5, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Domingues", 0, LocalDate.of(1986, 6, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elisa Gimenez", 0, LocalDate.of(1997, 2, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angelo Vasconcelos", 1, LocalDate.of(1974, 5, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Josias Siqueira", 1, LocalDate.of(1975, 11, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Danilo Mota", 1, LocalDate.of(1962, 7, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Madalena Jonhson", 0, LocalDate.of(1976, 11, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carina Rodrigues", 0, LocalDate.of(1994, 11, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luana Gimenez", 0, LocalDate.of(1968, 2, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina Magalhães", 0, LocalDate.of(1993, 8, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rubens Almeida", 1, LocalDate.of(1972, 10, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marlene Neves", 0, LocalDate.of(1974, 9, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jaqueline Ruas", 0, LocalDate.of(1962, 10, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Augusto Ruas", 1, LocalDate.of(1965, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andrey Amaral", 1, LocalDate.of(1999, 1, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henrique Freitas", 1, LocalDate.of(1984, 2, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caetano Magalhães", 1, LocalDate.of(1978, 7, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Melissa Lemos", 0, LocalDate.of(1998, 1, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Anita Amaral", 0, LocalDate.of(1985, 2, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Otávio Santiago", 1, LocalDate.of(1997, 3, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Peter Prado", 1, LocalDate.of(1991, 5, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Oscar Freitas", 1, LocalDate.of(1976, 2, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristina Ferreira", 0, LocalDate.of(1997, 8, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luana Olsen", 0, LocalDate.of(1996, 4, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Murilo Alencar", 1, LocalDate.of(1963, 1, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reinaldo Siqueira", 1, LocalDate.of(1966, 5, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sérgio Amaral", 1, LocalDate.of(1985, 4, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rubens Nunes", 1, LocalDate.of(1980, 6, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana Siqueira", 0, LocalDate.of(1993, 12, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniela Liberato", 0, LocalDate.of(2001, 3, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marina Cunha", 0, LocalDate.of(1985, 4, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victor Santos", 1, LocalDate.of(1984, 12, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Erica Ribeiro", 0, LocalDate.of(1969, 10, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jason Amaral", 1, LocalDate.of(1997, 11, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vilma Pinto", 0, LocalDate.of(1966, 7, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elton da Paz", 1, LocalDate.of(1960, 6, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bartolomeu Gil", 1, LocalDate.of(1961, 10, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karolina Nascimento", 0, LocalDate.of(1999, 4, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gioavana Portman", 0, LocalDate.of(1967, 4, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanda Campos", 0, LocalDate.of(1993, 10, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luiza Prado", 0, LocalDate.of(1987, 5, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edilene Pinheiro", 0, LocalDate.of(1980, 9, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andreia Guedes", 0, LocalDate.of(1974, 11, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reinaldo das Cruzes", 1, LocalDate.of(1988, 4, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Oscar Poeta", 1, LocalDate.of(1979, 10, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diana Kent", 0, LocalDate.of(1963, 10, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Enzo Ribeiro", 1, LocalDate.of(1964, 2, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leandro  Santana", 1, LocalDate.of(1999, 12, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Jonhson", 1, LocalDate.of(1969, 4, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriana Costa", 0, LocalDate.of(1983, 1, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henry Gimenez", 1, LocalDate.of(1986, 2, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ellen Leal", 0, LocalDate.of(1996, 7, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcela Lemos", 0, LocalDate.of(1989, 11, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carmem Rossi", 0, LocalDate.of(1965, 3, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz Lopes", 0, LocalDate.of(1969, 2, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mônica Mendes", 0, LocalDate.of(1999, 5, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samanta Almeida", 0, LocalDate.of(1984, 2, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Gonzaga", 0, LocalDate.of(1982, 1, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Richard Cortez", 1, LocalDate.of(1980, 6, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabíola Nunes", 0, LocalDate.of(1974, 5, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcos Magalhães", 1, LocalDate.of(2001, 10, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniela Adams", 0, LocalDate.of(1980, 1, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luis Bonifácio", 1, LocalDate.of(1999, 2, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Enzo Poeta", 1, LocalDate.of(1997, 8, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Darci Santana", 0, LocalDate.of(1995, 4, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marlene Monteiro", 0, LocalDate.of(1991, 2, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sueli Arruda", 0, LocalDate.of(1964, 7, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lucas Esteves", 1, LocalDate.of(1976, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Guilherme Souza", 1, LocalDate.of(1978, 3, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Evandro Gonzaga", 1, LocalDate.of(1967, 3, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cecília Marques", 0, LocalDate.of(1998, 5, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Laura Gonzaga", 0, LocalDate.of(1975, 12, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ruth Pinheiro", 0, LocalDate.of(1996, 9, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alexandre Gonzaga", 1, LocalDate.of(1987, 2, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciana Freitas", 0, LocalDate.of(1990, 1, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andrea de Souza", 0, LocalDate.of(1967, 3, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Anita Rodrigues", 0, LocalDate.of(1981, 6, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cesar Dantas", 1, LocalDate.of(1980, 2, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Sousa", 1, LocalDate.of(1999, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("John Cardoso", 1, LocalDate.of(1968, 6, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Flávia Bauer", 0, LocalDate.of(1991, 2, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Priscila Pinto", 0, LocalDate.of(1987, 11, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valdirene Gil", 0, LocalDate.of(1994, 11, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sérgio Gomes", 1, LocalDate.of(1988, 8, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Richard Gimenez", 1, LocalDate.of(1996, 5, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vicente Lins", 1, LocalDate.of(1996, 4, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Domingues", 1, LocalDate.of(1960, 10, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanda Silveira", 0, LocalDate.of(1972, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samuel Santos", 1, LocalDate.of(1988, 7, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Denise Stacy", 0, LocalDate.of(1995, 1, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosana Ferreira", 0, LocalDate.of(1992, 9, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fernando Freitas", 1, LocalDate.of(1961, 6, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jorge Stallone", 1, LocalDate.of(1985, 11, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Madalena Esteves", 0, LocalDate.of(1962, 9, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Sakamoto", 0, LocalDate.of(1979, 7, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alberto Gomes", 1, LocalDate.of(1960, 9, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bernardo Ramalho", 1, LocalDate.of(1984, 8, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diego Oliveira", 1, LocalDate.of(1966, 6, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Escobar Lins", 1, LocalDate.of(1978, 9, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("João Novaes", 1, LocalDate.of(1963, 6, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitória Stallone", 0, LocalDate.of(1970, 3, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Evandro Araujo", 1, LocalDate.of(1960, 10, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Machado", 1, LocalDate.of(1972, 10, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Robson Poeta", 1, LocalDate.of(1981, 12, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Pedro Sakamoto", 1, LocalDate.of(1981, 1, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina Gonzaga", 0, LocalDate.of(1967, 3, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcio Farias", 1, LocalDate.of(1997, 1, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Igor Bueno", 1, LocalDate.of(1979, 9, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jonathan Lima", 1, LocalDate.of(1967, 4, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabela Lane", 0, LocalDate.of(1972, 8, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristian Farias", 1, LocalDate.of(1986, 6, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sérgio da Silva", 1, LocalDate.of(1971, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Yuji Coelho", 1, LocalDate.of(1996, 10, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Douglas Delgado", 1, LocalDate.of(1967, 2, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alice Duarte", 0, LocalDate.of(1980, 1, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henrique Sanches", 1, LocalDate.of(1990, 9, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elisa Cardoso", 0, LocalDate.of(1970, 2, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Clotilde Constantino", 0, LocalDate.of(1981, 10, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiano Machado", 1, LocalDate.of(1963, 9, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Domingos", 0, LocalDate.of(1972, 1, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniel Dias", 1, LocalDate.of(1969, 3, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marta Gimenez", 0, LocalDate.of(1994, 8, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandro Carvalho", 1, LocalDate.of(1972, 2, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roberto Esteves", 1, LocalDate.of(1983, 6, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juliana Gonzaga", 0, LocalDate.of(1977, 12, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Natasha Siqueira", 0, LocalDate.of(1994, 8, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Natasha Fernandes", 0, LocalDate.of(1981, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ivete Azevedo", 0, LocalDate.of(1978, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Darci Amaral", 1, LocalDate.of(2000, 8, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Taís Kent", 0, LocalDate.of(1977, 4, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cesar Medeiros", 1, LocalDate.of(1989, 11, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marisa Barros", 0, LocalDate.of(1967, 9, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samara Carvalho", 0, LocalDate.of(1981, 1, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alvaro Poeta", 1, LocalDate.of(1977, 10, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luis Dantas", 1, LocalDate.of(1976, 10, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilson da Silva", 1, LocalDate.of(1987, 9, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sidnei da Luz", 1, LocalDate.of(1993, 8, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Neves", 0, LocalDate.of(1989, 12, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edvaldo Nunes", 1, LocalDate.of(1960, 1, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kátia Carvalho", 0, LocalDate.of(1969, 6, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alan Marques", 1, LocalDate.of(1987, 12, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kiko Lima", 1, LocalDate.of(1975, 9, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bianca Marinho", 0, LocalDate.of(1982, 7, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Natália Gil", 0, LocalDate.of(1968, 3, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabel Fontoura", 0, LocalDate.of(1961, 9, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("José Esteves", 1, LocalDate.of(1993, 5, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eduarda Delgado", 0, LocalDate.of(1967, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cleber Guedes", 1, LocalDate.of(1993, 7, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samanta Nakamura", 0, LocalDate.of(1999, 2, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Portman", 0, LocalDate.of(1983, 8, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniela Azevedo", 0, LocalDate.of(1987, 12, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lilian Lemos", 0, LocalDate.of(1966, 3, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ricardo Ribeiro", 1, LocalDate.of(1984, 2, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lorena Guedes", 0, LocalDate.of(1962, 9, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Jonhson", 1, LocalDate.of(1970, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eduarda Vasconcelos", 0, LocalDate.of(1969, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilson de Souza", 1, LocalDate.of(1985, 10, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Flávio Stallone", 1, LocalDate.of(1999, 9, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caio da Paz", 1, LocalDate.of(1978, 11, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Peter Nascimento", 1, LocalDate.of(1978, 11, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alice Rocha", 0, LocalDate.of(1968, 9, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kleber da Paz", 1, LocalDate.of(1999, 9, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Poeta", 1, LocalDate.of(1990, 6, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gustavo Ramalho", 1, LocalDate.of(1986, 10, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roberto Braga", 1, LocalDate.of(1974, 8, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanessa Delgado", 0, LocalDate.of(1988, 10, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Sales", 0, LocalDate.of(1971, 2, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilian Marques", 1, LocalDate.of(1989, 7, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leticia Lane", 0, LocalDate.of(1960, 7, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Lima", 0, LocalDate.of(1999, 10, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elias Silva", 1, LocalDate.of(1987, 10, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Felipe Arruda", 1, LocalDate.of(1986, 6, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Darci Rodrigues", 0, LocalDate.of(1994, 1, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kátia Pinto", 0, LocalDate.of(1983, 7, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leandro  Pinheiro", 1, LocalDate.of(1987, 8, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edson Portman", 1, LocalDate.of(1979, 5, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Barbara Gimenez", 0, LocalDate.of(1961, 11, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kátia Nunes", 0, LocalDate.of(1981, 2, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juliana Araujo", 0, LocalDate.of(2000, 7, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("John França", 1, LocalDate.of(1988, 6, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nicole Lima", 0, LocalDate.of(1973, 12, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luiza Magalhães", 0, LocalDate.of(1965, 7, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodrigo Oliveira", 1, LocalDate.of(1975, 11, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz Bueno", 0, LocalDate.of(1981, 11, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eliana Novaes", 0, LocalDate.of(1974, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodnei Portman", 1, LocalDate.of(1960, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("José Sakamoto", 1, LocalDate.of(1988, 7, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Julia Ruas", 0, LocalDate.of(1993, 5, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mateus Pires", 1, LocalDate.of(1964, 10, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodolfo Rocha", 1, LocalDate.of(1993, 10, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lana Amaral", 0, LocalDate.of(1993, 2, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cláudio Nogueira", 1, LocalDate.of(1961, 6, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodolfo Souza", 1, LocalDate.of(1972, 7, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciano Coelho", 1, LocalDate.of(1969, 1, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Augusto Leite", 1, LocalDate.of(1989, 8, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Santana", 1, LocalDate.of(1982, 12, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roberta Coelho", 0, LocalDate.of(1981, 4, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcia Adams", 0, LocalDate.of(1974, 4, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fatima Assis", 0, LocalDate.of(1963, 9, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Barbara Ribeiro", 0, LocalDate.of(1980, 1, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vilma das Dores", 0, LocalDate.of(1960, 3, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tamires Lins", 0, LocalDate.of(1993, 6, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joice Viana", 0, LocalDate.of(1983, 7, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Airton Magalhães", 1, LocalDate.of(1975, 12, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paulo Braga", 1, LocalDate.of(1980, 6, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Ferreira", 0, LocalDate.of(1999, 8, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosa Ramalho", 0, LocalDate.of(1963, 7, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco das Dores", 1, LocalDate.of(1978, 7, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mauro Kent", 1, LocalDate.of(1977, 1, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cleber Stacy", 1, LocalDate.of(1978, 2, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Lucena", 1, LocalDate.of(1984, 6, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabel Lopes", 0, LocalDate.of(1978, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michel Lucena", 1, LocalDate.of(1963, 12, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Neusa Lins", 0, LocalDate.of(1980, 5, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carlos de Souza", 1, LocalDate.of(1974, 2, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Suzuki", 0, LocalDate.of(1979, 11, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel de Souza", 1, LocalDate.of(1965, 10, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Osmar Farias", 1, LocalDate.of(1991, 2, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lucas Marinho", 1, LocalDate.of(1969, 12, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gustavo Neves", 1, LocalDate.of(1975, 3, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Osvaldo Bonifácio", 1, LocalDate.of(1984, 12, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sandro Esteves", 1, LocalDate.of(1978, 6, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ricardo Rossi", 1, LocalDate.of(1993, 6, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Viviane Carvalho", 0, LocalDate.of(1981, 7, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glaucia Marques", 0, LocalDate.of(1995, 8, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcelo Domingues", 1, LocalDate.of(1995, 9, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kelly Ramalho", 0, LocalDate.of(1970, 1, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Flávio Dias", 1, LocalDate.of(1992, 6, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juliana Luxemburgo", 0, LocalDate.of(1997, 8, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodolfo Olsen", 1, LocalDate.of(1971, 7, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andrea Godoi", 0, LocalDate.of(1997, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diana Silveira", 0, LocalDate.of(1961, 7, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Madalena da Paz", 0, LocalDate.of(1987, 10, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandro Marques", 1, LocalDate.of(2001, 1, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reinaldo Poeta", 1, LocalDate.of(1987, 7, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Celso Rodrigues", 1, LocalDate.of(1970, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Escobar Poeta", 1, LocalDate.of(1973, 9, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marina Godoi", 0, LocalDate.of(1972, 9, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Teresa Nogueira", 0, LocalDate.of(1968, 11, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("David Coelho", 1, LocalDate.of(1994, 2, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leandro  Leal", 1, LocalDate.of(1981, 9, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rui Santana", 1, LocalDate.of(1978, 2, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanessa Peixoto", 0, LocalDate.of(2001, 6, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juraci Lopes", 1, LocalDate.of(1988, 9, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diana Alves", 0, LocalDate.of(1966, 4, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Natasha Novaes", 0, LocalDate.of(1984, 9, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Amanda Guimarães", 0, LocalDate.of(1974, 6, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lucas Poeta", 1, LocalDate.of(1961, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Anita Guerra", 0, LocalDate.of(1989, 6, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitória Rocha", 0, LocalDate.of(1990, 4, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Selma Fernandes", 0, LocalDate.of(1997, 1, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Inês Delgado", 0, LocalDate.of(1988, 11, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michel Ferreira", 1, LocalDate.of(1988, 5, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sérgio Rocha", 1, LocalDate.of(1987, 8, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Evelyn Bauer", 0, LocalDate.of(1966, 2, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Sakamoto", 1, LocalDate.of(1979, 12, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Davi da Paz", 1, LocalDate.of(2000, 7, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Chaves", 0, LocalDate.of(1977, 6, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eduarda Leite", 0, LocalDate.of(1984, 10, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Neusa Dantas", 0, LocalDate.of(1986, 5, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriano Rocha", 1, LocalDate.of(1971, 12, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Taís Ramos", 0, LocalDate.of(1965, 11, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Magali Liberato", 0, LocalDate.of(1963, 3, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Silveira", 1, LocalDate.of(1988, 3, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodnei Fernandes", 1, LocalDate.of(1991, 1, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henry Souza", 1, LocalDate.of(1979, 6, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Ribeiro", 0, LocalDate.of(1988, 1, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Neusa Guedes", 0, LocalDate.of(1992, 8, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karen Gil", 0, LocalDate.of(1960, 12, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carmem Liberato", 0, LocalDate.of(2000, 11, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Renato Constantino", 1, LocalDate.of(1960, 10, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Barbosa", 1, LocalDate.of(1998, 5, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nicole Nakamura", 0, LocalDate.of(1963, 5, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Arthur Poeta", 1, LocalDate.of(1970, 4, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daiane das Cruzes", 0, LocalDate.of(1986, 5, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edvaldo Arruda", 1, LocalDate.of(1964, 10, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Patricia Dantas", 0, LocalDate.of(1984, 5, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tiago Leal", 1, LocalDate.of(1971, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paloma Domingos", 0, LocalDate.of(1999, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roseli Sakamoto", 0, LocalDate.of(1984, 2, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edvaldo Nascimento", 1, LocalDate.of(1972, 12, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitória Vieira", 0, LocalDate.of(1998, 2, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabio da Paz", 1, LocalDate.of(1974, 7, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Vieira", 0, LocalDate.of(1992, 4, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Magali Furtado", 0, LocalDate.of(1973, 10, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Poeta", 1, LocalDate.of(1997, 2, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Almeida", 1, LocalDate.of(1976, 5, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley Lopes", 1, LocalDate.of(1976, 3, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Barbara Marques", 0, LocalDate.of(1992, 6, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Danilo Portman", 1, LocalDate.of(1961, 1, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandro das Dores", 1, LocalDate.of(1989, 1, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Davi Fontoura", 1, LocalDate.of(1966, 11, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Guilherme Gil", 1, LocalDate.of(1990, 5, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilson Lima", 1, LocalDate.of(1963, 7, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvia Esteves", 0, LocalDate.of(1966, 6, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabela Lemos", 0, LocalDate.of(1974, 8, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Ruas", 0, LocalDate.of(1965, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Maria Silveira", 0, LocalDate.of(1996, 9, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valdirene Neves", 0, LocalDate.of(1961, 8, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bartolomeu Allen", 1, LocalDate.of(1997, 12, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luiza Amaral", 0, LocalDate.of(1961, 10, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vera Furtado", 0, LocalDate.of(1962, 10, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jaqueline Lucena", 0, LocalDate.of(1981, 1, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jonathas Peixoto", 1, LocalDate.of(1976, 7, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rogério Nunes", 1, LocalDate.of(1965, 1, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("John Gomes", 1, LocalDate.of(1992, 7, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz Guerra", 0, LocalDate.of(1967, 10, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ari da Luz", 1, LocalDate.of(1977, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samanta Delgado", 0, LocalDate.of(1999, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Bonifácio", 1, LocalDate.of(1985, 3, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Natália Ribeiro", 0, LocalDate.of(1977, 9, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Regiane de Souza", 0, LocalDate.of(1988, 3, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paulo Novaes", 1, LocalDate.of(1992, 7, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Teresa Kent", 0, LocalDate.of(1987, 10, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Flávio Adams", 1, LocalDate.of(1989, 4, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valentina Bastos", 0, LocalDate.of(2001, 7, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Pinheiro", 1, LocalDate.of(1979, 8, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("David Nakamura", 1, LocalDate.of(1960, 2, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Antonio Ramos", 1, LocalDate.of(1960, 3, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elton Siqueira", 1, LocalDate.of(1997, 8, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Magda Leal", 0, LocalDate.of(1987, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Osmar Furtado", 1, LocalDate.of(1973, 2, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Richard Pinto", 1, LocalDate.of(1960, 9, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcia Nogueira", 0, LocalDate.of(1983, 3, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marina Bernades", 0, LocalDate.of(1999, 4, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lidiane Pinto", 0, LocalDate.of(1983, 2, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosa Prado", 0, LocalDate.of(1961, 8, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Teresa Pinheiro", 0, LocalDate.of(1990, 2, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Selma Ferraz", 0, LocalDate.of(1961, 7, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carla Monteiro", 0, LocalDate.of(1975, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mario  Guerra", 1, LocalDate.of(1986, 11, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Melissa Stacy", 0, LocalDate.of(1981, 12, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabíola Lane", 0, LocalDate.of(1966, 8, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reginaldo Alencar", 1, LocalDate.of(1975, 12, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gael Viana", 1, LocalDate.of(1973, 7, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiane Jonhson", 0, LocalDate.of(1979, 3, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nicolau Souza", 1, LocalDate.of(1969, 7, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mariana Godoi", 0, LocalDate.of(1979, 10, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jessica Lopes", 0, LocalDate.of(1971, 1, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Almeida", 0, LocalDate.of(1967, 10, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samuel Prado", 1, LocalDate.of(1973, 4, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cláudia Chaves", 0, LocalDate.of(1979, 12, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vânia Sakamoto", 0, LocalDate.of(1976, 7, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Solange Fontoura", 0, LocalDate.of(1972, 9, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cleber Lins", 1, LocalDate.of(1997, 7, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carolina Bueno", 0, LocalDate.of(1997, 3, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ronaldo Amaral", 1, LocalDate.of(1962, 8, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paulo das Dores", 1, LocalDate.of(1996, 4, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lucas Prado", 1, LocalDate.of(1965, 5, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ellen Esteves", 0, LocalDate.of(1998, 8, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samuel Sousa", 1, LocalDate.of(1962, 1, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Nascimento", 1, LocalDate.of(1972, 6, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angela Oliveira", 0, LocalDate.of(1969, 1, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leila Leal", 0, LocalDate.of(1967, 6, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jeremias Moreno", 1, LocalDate.of(1971, 10, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniel Souza", 1, LocalDate.of(1971, 9, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Ribeiro", 0, LocalDate.of(1968, 9, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gioavana Lombardi", 0, LocalDate.of(1967, 4, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Vasconcelos", 1, LocalDate.of(1984, 5, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cleber Pires", 1, LocalDate.of(1971, 6, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriano Bastos", 1, LocalDate.of(1998, 7, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bartolomeu Bloch", 1, LocalDate.of(1965, 10, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mario  Furtado", 1, LocalDate.of(1980, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caio Stacy", 1, LocalDate.of(2000, 9, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jorge Siqueira", 1, LocalDate.of(1970, 7, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Manoel Domingos", 1, LocalDate.of(1980, 2, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Felipe Alves", 1, LocalDate.of(1985, 12, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanessa Bastos", 0, LocalDate.of(1965, 6, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ruth Farias", 0, LocalDate.of(1965, 12, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosiane Sales", 0, LocalDate.of(1991, 5, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Otávio Lane", 1, LocalDate.of(1972, 12, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lauro Marinho", 1, LocalDate.of(1977, 9, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz Sakamoto", 0, LocalDate.of(1963, 4, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cláudia Neves", 0, LocalDate.of(1977, 3, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Camila Novaes", 0, LocalDate.of(1994, 1, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edna Suzuki", 0, LocalDate.of(1976, 3, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Guilherme Poeta", 1, LocalDate.of(1999, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Travassos", 0, LocalDate.of(1998, 8, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gilberto Fernandes", 1, LocalDate.of(1963, 2, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodnei Lane", 1, LocalDate.of(2001, 7, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Dirceu Alencar", 1, LocalDate.of(1968, 9, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiano Alba", 1, LocalDate.of(1964, 7, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Ferraz", 1, LocalDate.of(1993, 4, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reginaldo Nascimento", 1, LocalDate.of(1992, 12, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cláudio Dantas", 1, LocalDate.of(2000, 3, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Erica dos Santos", 0, LocalDate.of(1961, 6, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Lopez", 1, LocalDate.of(1976, 8, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joana Liberato", 0, LocalDate.of(1968, 11, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jaqueline Machado", 0, LocalDate.of(1961, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edmilson Travassos", 1, LocalDate.of(1999, 5, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Julia Lemos", 0, LocalDate.of(2001, 6, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angelo Guimarães", 1, LocalDate.of(1969, 1, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Lucena", 0, LocalDate.of(1977, 5, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvio Pereira", 1, LocalDate.of(1967, 3, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sandra West", 0, LocalDate.of(1980, 5, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Igor Poeta", 1, LocalDate.of(1964, 3, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Suzana da Luz", 0, LocalDate.of(1970, 8, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana Sanches", 0, LocalDate.of(1987, 8, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bernardo Carvalho", 1, LocalDate.of(1976, 10, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruce da Luz", 1, LocalDate.of(1981, 9, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sofia Adams", 0, LocalDate.of(1962, 7, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jason Peixoto", 1, LocalDate.of(1978, 2, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juliana Magalhães", 0, LocalDate.of(1961, 5, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Domingos", 0, LocalDate.of(1983, 9, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vânia Pires", 0, LocalDate.of(1971, 9, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Laura Silveira", 0, LocalDate.of(1971, 8, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carmem Rossi", 0, LocalDate.of(1960, 2, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Afonso Braga", 1, LocalDate.of(1964, 9, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tamires Marinho", 0, LocalDate.of(1970, 4, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel Rodrigues", 1, LocalDate.of(1972, 9, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lorena Domingues", 0, LocalDate.of(1980, 11, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriana Cunha", 0, LocalDate.of(1989, 6, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana Lucena", 0, LocalDate.of(1968, 3, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carla Smith", 0, LocalDate.of(1988, 11, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("José Monteiro", 1, LocalDate.of(1988, 12, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edgar Farias", 1, LocalDate.of(1969, 5, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabíola Nunes", 0, LocalDate.of(2001, 7, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanessa Luxemburgo", 0, LocalDate.of(1960, 12, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Diana Almeida", 0, LocalDate.of(1976, 3, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Regiane Domingues", 0, LocalDate.of(1994, 4, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilian Costa", 1, LocalDate.of(1993, 4, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vagner Vieira", 1, LocalDate.of(1968, 6, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sheila Gonzaga", 0, LocalDate.of(1979, 9, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("João Farias", 1, LocalDate.of(1969, 11, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcos da Silva", 1, LocalDate.of(1964, 8, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jaqueline Azevedo", 0, LocalDate.of(1965, 4, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lidiane Monteiro", 0, LocalDate.of(1962, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gilda Esteves", 0, LocalDate.of(1967, 10, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Otávio Ramalho", 1, LocalDate.of(1987, 1, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruno Ramalho", 1, LocalDate.of(1998, 8, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriano da Silva", 1, LocalDate.of(1974, 5, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Campos", 0, LocalDate.of(1968, 5, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcos Moreno", 1, LocalDate.of(1966, 8, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Darci Suzuki", 1, LocalDate.of(1968, 7, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Viana", 0, LocalDate.of(1963, 4, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Dirceu da Silva", 1, LocalDate.of(1973, 9, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elisa Gonzaga", 0, LocalDate.of(1967, 8, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Arruda", 1, LocalDate.of(1963, 12, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Loreto", 0, LocalDate.of(1981, 9, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Viviane Fernandes", 0, LocalDate.of(1983, 6, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristian Dantas", 1, LocalDate.of(1967, 10, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Michele Godoi", 0, LocalDate.of(2000, 7, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lorena Poeta", 0, LocalDate.of(1973, 1, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Teresa das Dores", 0, LocalDate.of(1960, 8, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Vieira", 1, LocalDate.of(1990, 1, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvia Lins", 0, LocalDate.of(1976, 5, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luciana Neves", 0, LocalDate.of(1983, 11, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sheila Campos", 0, LocalDate.of(1993, 1, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Juraci Moreno", 0, LocalDate.of(1960, 12, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lorena Gimenez", 0, LocalDate.of(1968, 2, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Regiane Braga", 0, LocalDate.of(1983, 5, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Manoela Novaes", 0, LocalDate.of(1970, 4, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carla Vasconcelos", 0, LocalDate.of(1988, 10, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosiane Gomes", 0, LocalDate.of(1975, 11, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marta Leite", 0, LocalDate.of(1991, 12, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Otávio Santana", 1, LocalDate.of(1970, 6, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gabriela Moreno", 0, LocalDate.of(1967, 11, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriano Chaves", 1, LocalDate.of(1966, 4, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alexandre Braga", 1, LocalDate.of(1997, 12, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Hugo Barros", 1, LocalDate.of(1960, 1, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joana França", 0, LocalDate.of(1979, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cesar das Dores", 1, LocalDate.of(1995, 7, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roger Nogueira", 1, LocalDate.of(1999, 6, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Pinto", 0, LocalDate.of(1987, 4, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Geraldo Suzuki", 1, LocalDate.of(1975, 4, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angela Lima", 0, LocalDate.of(1987, 7, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Flávia Silveira", 0, LocalDate.of(1993, 4, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Silvia Ferraz", 0, LocalDate.of(1970, 11, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Margarete Dantas", 0, LocalDate.of(1987, 2, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Reginaldo Smith", 1, LocalDate.of(1982, 6, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Magali Fernandes", 0, LocalDate.of(1988, 3, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodolfo Ruas", 1, LocalDate.of(1973, 6, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nicole Araujo", 0, LocalDate.of(1970, 11, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alan Domingos", 1, LocalDate.of(1971, 10, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Manoel Pinto", 1, LocalDate.of(1977, 12, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ivete Lobato", 0, LocalDate.of(1994, 9, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marina Nakamura", 0, LocalDate.of(1974, 12, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cibele Alves", 0, LocalDate.of(1964, 6, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marta Machado", 0, LocalDate.of(2000, 11, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Anderson Rocha", 1, LocalDate.of(1979, 2, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel Carvalho", 1, LocalDate.of(1997, 12, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Oscar Peixoto", 1, LocalDate.of(2000, 12, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosana Smith", 0, LocalDate.of(1971, 2, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gioavana Cortez", 0, LocalDate.of(1978, 4, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fernanda Nogueira", 0, LocalDate.of(1968, 7, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sabrina das Cruzes", 0, LocalDate.of(1964, 11, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marta da Silva", 0, LocalDate.of(1977, 4, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Dirceu Esteves", 1, LocalDate.of(1994, 7, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Felipe Rocha", 1, LocalDate.of(1962, 2, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roger Kent", 1, LocalDate.of(1986, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ruth Viana", 0, LocalDate.of(1991, 7, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edgar Allen", 1, LocalDate.of(1977, 7, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alvaro Stallone", 1, LocalDate.of(1971, 4, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jessica Lucena", 0, LocalDate.of(1989, 7, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carlos Santana", 1, LocalDate.of(1983, 2, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Danilo Gimenez", 1, LocalDate.of(1977, 2, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valentina Nunes", 0, LocalDate.of(1979, 5, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Miguel Peixoto", 1, LocalDate.of(1979, 1, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Barbosa", 0, LocalDate.of(1972, 7, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Davi Olsen", 1, LocalDate.of(1970, 4, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Anderson Farias", 1, LocalDate.of(1978, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Prado", 0, LocalDate.of(1970, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Richard Jonhson", 1, LocalDate.of(1962, 11, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Clotilde Farias", 0, LocalDate.of(1998, 9, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tiago Dantas", 1, LocalDate.of(1962, 4, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Douglas Freitas", 1, LocalDate.of(1995, 7, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gislaine Cardoso", 0, LocalDate.of(1981, 5, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kátia Siqueira", 0, LocalDate.of(1963, 4, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rogério Smith", 1, LocalDate.of(1968, 11, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Arthur Marinho", 1, LocalDate.of(1966, 3, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Paloma Guimarães", 0, LocalDate.of(1987, 8, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edna Barros", 0, LocalDate.of(1990, 8, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roseli Moreno", 0, LocalDate.of(1967, 4, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alice Machado", 0, LocalDate.of(1989, 2, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Elton Neves", 1, LocalDate.of(1991, 1, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valdirene Guimarães", 0, LocalDate.of(1984, 1, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alan Alba", 1, LocalDate.of(1987, 3, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana Vasconcelos", 0, LocalDate.of(1964, 8, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Humberto Rocha", 1, LocalDate.of(2000, 5, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lidiane Lane", 0, LocalDate.of(1983, 11, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Adriano Portman", 1, LocalDate.of(1963, 9, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Escobar Ramos", 1, LocalDate.of(1997, 5, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Samara Pinheiro", 0, LocalDate.of(1972, 9, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristian Costa", 1, LocalDate.of(1998, 6, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Murilo Constantino", 1, LocalDate.of(1976, 7, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcelo Bauer", 1, LocalDate.of(2001, 8, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Joana Santos", 0, LocalDate.of(1978, 6, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("John Fontoura", 1, LocalDate.of(1991, 4, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Valdirene Santiago", 0, LocalDate.of(2000, 5, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Enzo Nunes", 1, LocalDate.of(1970, 5, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mônica Marinho", 0, LocalDate.of(1982, 3, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("João Ferraz", 1, LocalDate.of(2000, 8, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Isabela Pires", 0, LocalDate.of(1967, 8, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Andrea Smith", 0, LocalDate.of(1994, 2, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jorge Rocha", 1, LocalDate.of(1995, 10, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roseli Barbosa", 0, LocalDate.of(1981, 11, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rodrigo Azevedo", 1, LocalDate.of(1980, 8, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Maria Machado", 0, LocalDate.of(1971, 2, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Luis Lopez", 1, LocalDate.of(1969, 1, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henry Lobato", 1, LocalDate.of(2001, 10, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Caio Allen", 1, LocalDate.of(1971, 6, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lana Nascimento", 0, LocalDate.of(1987, 9, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Afonso Monteiro", 1, LocalDate.of(1969, 10, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Miguel Constantino", 1, LocalDate.of(1965, 10, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rosana Ramalho", 0, LocalDate.of(1997, 4, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Bernades", 0, LocalDate.of(1994, 7, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kelly Pires", 0, LocalDate.of(1964, 11, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Guilherme Alba", 1, LocalDate.of(1993, 11, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alvaro Medeiros", 1, LocalDate.of(1974, 7, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jessica Stallone", 0, LocalDate.of(1978, 6, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kelly Alves", 0, LocalDate.of(1978, 5, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lilian Nunes", 0, LocalDate.of(1987, 6, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Leite", 1, LocalDate.of(1984, 6, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Flávio Travassos", 1, LocalDate.of(1997, 6, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Suzana das Cruzes", 0, LocalDate.of(1967, 8, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Miriam Nunes", 0, LocalDate.of(1970, 5, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Carlos Mota", 1, LocalDate.of(1968, 6, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leonardo Jonhson", 1, LocalDate.of(2000, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tamires Silveira", 0, LocalDate.of(1960, 4, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kelly Nakamura", 0, LocalDate.of(1991, 6, 30),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Francisco Ferreira", 1, LocalDate.of(1968, 5, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Arnold Guerra", 1, LocalDate.of(1975, 8, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roseli Lane", 0, LocalDate.of(1989, 10, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruno Godoi", 1, LocalDate.of(1961, 4, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Kátia Sakamoto", 0, LocalDate.of(1968, 6, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Duarte", 1, LocalDate.of(1985, 4, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanessa Araujo", 0, LocalDate.of(1963, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wagner Ferreira", 1, LocalDate.of(1981, 6, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Beatriz Barbosa", 0, LocalDate.of(1998, 1, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Maria Dias", 0, LocalDate.of(2000, 6, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Robson Campos", 1, LocalDate.of(1970, 9, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Camila Stacy", 0, LocalDate.of(1993, 10, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Sueli Pereira", 0, LocalDate.of(1972, 11, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Maria Arruda", 0, LocalDate.of(1970, 2, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Priscila Azevedo", 0, LocalDate.of(1970, 11, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karen Lombardi", 0, LocalDate.of(1988, 8, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Magalhães", 0, LocalDate.of(1964, 9, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Teresa Pires", 0, LocalDate.of(1960, 8, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Celso Gomes", 1, LocalDate.of(1997, 11, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Victória Cortez", 0, LocalDate.of(1969, 11, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruce Carvalho", 1, LocalDate.of(1993, 5, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruce Almeida", 1, LocalDate.of(1967, 6, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Antonio Siqueira", 1, LocalDate.of(1975, 7, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Angela Santiago", 0, LocalDate.of(1990, 9, 20),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley dos Santos", 1, LocalDate.of(1969, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Lopez", 1, LocalDate.of(1998, 9, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Darci Nunes", 1, LocalDate.of(1989, 12, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcel das Cruzes", 1, LocalDate.of(1967, 2, 21),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Nicole Lins", 0, LocalDate.of(1990, 2, 12),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vicente Stallone", 1, LocalDate.of(1986, 1, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Peixoto", 0, LocalDate.of(1970, 11, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Miriam Rossi", 0, LocalDate.of(1999, 12, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gerson Gomes", 1, LocalDate.of(1982, 11, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Lucena", 0, LocalDate.of(1996, 12, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vanda Lopez", 0, LocalDate.of(1989, 7, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Rafael  Ribeiro", 1, LocalDate.of(1999, 4, 17),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Peter Silveira", 1, LocalDate.of(1982, 3, 11),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Mauro Travassos", 1, LocalDate.of(2000, 6, 25),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Otávio Furtado", 1, LocalDate.of(1997, 12, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Bruna Ribeiro", 0, LocalDate.of(1979, 3, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lois Medeiros", 0, LocalDate.of(1962, 2, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jorge Rocha", 1, LocalDate.of(1991, 8, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Suzana Loreto", 0, LocalDate.of(1976, 10, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Dirceu da Luz", 1, LocalDate.of(1962, 10, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Célia Rossi", 0, LocalDate.of(1991, 10, 23),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Matias Ferraz", 1, LocalDate.of(1968, 2, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gustavo Leal", 1, LocalDate.of(1979, 3, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabrício Marinho", 1, LocalDate.of(1996, 11, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Ana das Cruzes", 0, LocalDate.of(1993, 11, 16),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Pires", 0, LocalDate.of(1969, 2, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cristiana Araujo", 0, LocalDate.of(1961, 8, 15),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glaucia Almeida", 0, LocalDate.of(1992, 1, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Gabriel Liberato", 1, LocalDate.of(1984, 2, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vagner Duarte", 1, LocalDate.of(1969, 3, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wilson Duarte", 1, LocalDate.of(1962, 4, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandra Vasconcelos", 0, LocalDate.of(1994, 11, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Laura Neves", 0, LocalDate.of(1986, 3, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Tiago Fernandes", 1, LocalDate.of(1991, 8, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Wesley Lopes", 1, LocalDate.of(1973, 4, 13),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henry Costa", 1, LocalDate.of(1999, 8, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Henrique Campos", 1, LocalDate.of(1996, 2, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Evelyn Ruas", 0, LocalDate.of(1967, 2, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alessandra Vieira", 0, LocalDate.of(1989, 3, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Alberto Almeida", 1, LocalDate.of(1985, 4, 28),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cesar Barbosa", 1, LocalDate.of(2001, 5, 24),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Daniel Alencar", 1, LocalDate.of(1997, 5, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marina Bauer", 0, LocalDate.of(1976, 7, 2),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vitória West", 0, LocalDate.of(1968, 7, 27),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Roberto Poeta", 1, LocalDate.of(1993, 5, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Guerra", 0, LocalDate.of(1984, 2, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("David Lopes", 1, LocalDate.of(1983, 11, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cintia Chaves", 0, LocalDate.of(1976, 12, 7),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Jefferson Delgado", 1, LocalDate.of(1974, 2, 4),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Taís Bonifácio", 0, LocalDate.of(1988, 9, 26),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marlene Barros", 0, LocalDate.of(1987, 8, 14),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karen Freitas", 0, LocalDate.of(1972, 4, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Karen Lima", 0, LocalDate.of(2000, 11, 5),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Glória Magalhães", 0, LocalDate.of(1985, 6, 3),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Lana Vasconcelos", 0, LocalDate.of(1980, 9, 22),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Julia Novaes", 0, LocalDate.of(1988, 6, 1),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Marcos Gonzaga", 1, LocalDate.of(1989, 8, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Leonardo Rocha", 1, LocalDate.of(1990, 10, 29),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eduardo Bastos", 1, LocalDate.of(1966, 7, 8),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Eliana Cortez", 0, LocalDate.of(2000, 6, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Vagner Mota", 1, LocalDate.of(1966, 3, 10),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Viviane Braga", 0, LocalDate.of(1996, 6, 18),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Janaína Mendes", 0, LocalDate.of(1963, 7, 6),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Edilene Leal", 0, LocalDate.of(1996, 6, 9),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Cesar Alencar", 1, LocalDate.of(2001, 11, 19),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Fabiana  Neves", 0, LocalDate.of(1967, 3, 31),
                    getRandomInteresses(interesses)));
            pessoaRepository.save(new Pessoa("Thiago Neves", 1, LocalDate.of(1995, 1, 24),
                    getRandomInteresses(interesses)));
        }
    }

}
