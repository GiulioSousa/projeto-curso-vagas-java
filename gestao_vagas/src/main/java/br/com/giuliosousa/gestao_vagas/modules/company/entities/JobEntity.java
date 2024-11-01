package br.com.giuliosousa.gestao_vagas.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "job")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    @NotBlank(message = "Este campo é obrigatório")
    private String level;

    private String benefits;

    @ManyToOne()
    @JoinColumn(name = "id_company", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "id_company", nullable = false)
    private UUID idCompany;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
