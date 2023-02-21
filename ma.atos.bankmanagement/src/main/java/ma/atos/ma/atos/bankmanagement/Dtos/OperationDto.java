package ma.atos.ma.atos.bankmanagement.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.atos.ma.atos.bankmanagement.entities.Compte;
import ma.atos.ma.atos.bankmanagement.enums.SensOperation;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {

        private double montant;
        private String description;
        private Date dateOperation;
        private SensOperation sensOperation;
        private String typeOperation;
        private Compte compte;
        private String typeOperation;
    }



