package ma.atos.ma.atos.bankmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgenceDto {


    private String codeAgence;
    private String nomAgence;
    private String adressAgence;
}
