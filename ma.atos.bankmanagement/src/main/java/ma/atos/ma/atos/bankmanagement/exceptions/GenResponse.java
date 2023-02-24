package ma.atos.ma.atos.bankmanagement.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenResponse {
    private String statusCode;
    private String description;
    private String descriptionFront;
    private boolean error;
}
