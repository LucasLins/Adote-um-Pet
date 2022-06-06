package br.com.pets.adoteumpet.core.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Valor tem que ser positivo")
    @Column(nullable = false)
    private BigDecimal amount;

    @Email(message = "Email inválido")
    @Column(nullable = false)
    private String email;

    @ManyToOne
    private Pet pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Adoption adoption = (Adoption) o;
        return id != null && Objects.equals(id, adoption.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
