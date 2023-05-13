package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter //para ele gerar os getters e setters
@NoArgsConstructor // para ele gerar o construtor sem o argumento pq a JPA exige
@AllArgsConstructor // para ele gerar um construtor que recebe todos os campos
@EqualsAndHashCode(of = "id") // para ele criar o HashCode em cima do ID e nao em cima de todos os atributos
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;


    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;


    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

}
