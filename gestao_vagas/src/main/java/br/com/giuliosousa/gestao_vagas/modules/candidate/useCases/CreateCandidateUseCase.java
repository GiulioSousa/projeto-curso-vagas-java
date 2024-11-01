package br.com.giuliosousa.gestao_vagas.modules.candidate.useCases;

import br.com.giuliosousa.gestao_vagas.exceptions.UserExistsException;
import br.com.giuliosousa.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.giuliosousa.gestao_vagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {

        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserExistsException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
