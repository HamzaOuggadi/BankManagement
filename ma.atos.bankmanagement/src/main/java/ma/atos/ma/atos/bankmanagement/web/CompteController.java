package ma.atos.ma.atos.bankmanagement.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.dtos.CompteDto;
import ma.atos.ma.atos.bankmanagement.exceptions.CompteException;
import ma.atos.ma.atos.bankmanagement.exceptions.GenResponse;
import ma.atos.ma.atos.bankmanagement.services.CompteService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Tag(name = "Compte", description = "API that handles the bank accounts")
@RestController
@CrossOrigin
@RequestMapping("/comptes")
@AllArgsConstructor
public class CompteController {

    private final CompteService compteService;
    private final MessageSource messageSource;

    @Operation(summary = "Returns a List of Accounts(Comptes).", description = "Returns a List of all the bank accounts available on the database.", tags = "Compte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "LIST RETURNED SUCCESSFULLY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "404", description = "LIST NOT FOUND OR EMPTY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = GenResponse.class)))
    })
    @GetMapping()
    public ResponseEntity<List<CompteDto>> listCompte() throws CompteException {
        return ResponseEntity.ok(compteService.listComptes());
    }


    @Operation(summary = "Returns one account by RIB.", description = "Returns an Account using the RIB, the return type is a List<> so its easy to display on the front using an Iterator.", tags = "Compte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ACCOUNT RETURNED SUCCESSFULLY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "404", description = "LIST NOT FOUND OR EMPTY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = GenResponse.class)))
    })
    @GetMapping("/{numRib}")
    public ResponseEntity<List<CompteDto>> getCompte(@PathVariable Long numRib) throws CompteException {
        List<CompteDto> compteDtos = new ArrayList<>();
        compteDtos.add(compteService.getCompte(numRib));
        return ResponseEntity.ok(compteDtos);
    }


    @Operation(summary = "Creates an account", description = "Creates an account by taking a body of type CompteDTO, a client number and the Gestionnaire ID.", tags = "Compte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ACCOUNT CREATED SUCCESSFULLY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "406", description = "NOT ACCEPTABLE", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = GenResponse.class)))
    })
    @PostMapping("/create")
    public ResponseEntity<GenResponse> createCompte(@RequestBody CompteDto compteDto,
                                                        @RequestParam String numClient,
                                                        @RequestParam Long idGestionnaire) throws CompteException {
        GenResponse result = new GenResponse();
        compteService.createCompte(compteDto, numClient, idGestionnaire);
        result.setDescription(messageSource.getMessage("account.created.success", new Object[] {compteDto.getRibCompte()}, Locale.getDefault()));
        result.setHttpStatusCode(String.valueOf(HttpStatus.OK));
        return ResponseEntity.ok(result);
    }


    @Operation(summary = "Delete an account", description = "Delete an account using the RIB", tags = "Compte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ACCOUNT DELETED SUCCESSFULLY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "404", description = "ACCOUNT NOT FOUND", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = GenResponse.class)))
    })
    @DeleteMapping("/deleteByRib/{ribCompte}")
    public ResponseEntity<GenResponse> deleteAccount(@PathVariable Long ribCompte) throws CompteException {
        GenResponse response = new GenResponse();
        compteService.deleteCompte(ribCompte);
        response.setError(false);
        response.setDescription(messageSource.getMessage("account.deleted.success", new Object[]{}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("account.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Returns an account using numClient.", description = "Returns an account using client number as a parameter.", tags = "Compte")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ACCOUNT RETURNED SUCCESSFULLY", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "404", description = "ACCOUNT NOT FOUND", content = @Content(schema = @Schema(implementation = GenResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = GenResponse.class)))
    })
    @GetMapping(params = "numClient")
    public ResponseEntity<List<CompteDto>> getCompteByNumClient(@RequestParam String numClient) throws CompteException {
        if (!Objects.equals(numClient, "")) {
            return ResponseEntity.ok(compteService.getCompteByTier(numClient));
        } else {
            return ResponseEntity.ok(compteService.listComptes());
        }
    }

    @GetMapping("/compteByGestionnaire/{idGestionnaire}")
    public ResponseEntity<List<CompteDto>> getCompteByGestionnaire(@PathVariable Long idGestionnaire) {
        return ResponseEntity.ok(compteService.getCompteByGestionnaire(idGestionnaire));
    }
}
