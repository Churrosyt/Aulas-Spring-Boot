package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // É ele que instanciar e passar esse atributo repository dentro da classe nossa classe controller
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) { //requestbody e para o json pegar os valores do corpo
    repository.save(new Medico(dados));
    }
    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        // page devolve a lista e a paginação
     return repository.findAll(paginacao).map(DadosListagemMedico::new);
     // convertendo de medico, para dados listagem medico

    }

}
