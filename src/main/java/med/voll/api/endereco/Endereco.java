package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter //para ele gerar os getters e setters
@NoArgsConstructor // para ele gerar o construtor sem o argumento pq a JPA exige
@AllArgsConstructor // para ele gerar um construtor que recebe todos os campos

public class Endereco {

    private String longradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

}
