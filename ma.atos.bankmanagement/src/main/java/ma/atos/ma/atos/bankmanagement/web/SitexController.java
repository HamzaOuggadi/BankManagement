package ma.atos.ma.atos.bankmanagement.web;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import ma.atos.ma.atos.bankmanagement.dtos.SitexDto;
import ma.atos.ma.atos.bankmanagement.dtos.responses.GenericResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.GenResponse;
import ma.atos.ma.atos.bankmanagement.exceptions.SitexExeption;
import ma.atos.ma.atos.bankmanagement.repositories.SitexRepository;
import ma.atos.ma.atos.bankmanagement.services.impl.SitexServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


/**
 * REST controller for managing the Sitex {@link ma.atos.ma.atos.bankmanagement.dtos.SitexDto}.
 *
 */



@Tag(name = "Sitex", description = "Api handles the sitex")
@RestController
@RequestMapping("/sitex")
@AllArgsConstructor
public class SitexController {

    private final SitexRepository sitexRepository;
    private final SitexServiceImpl sitexService;
    private final MessageSource messageSource;

    @Operation(summary = "Get one sitex by Id", description = "This EndPoint allows to get a sitex by Id", tags = { "Sitex" })
    @GetMapping(path = "/{idSitex}")
    public SitexDto getSitex(@PathVariable(name = "idSitex") Long idSitex) {
       return sitexService.getSitex(idSitex);
    }


    @Operation(summary = "Search all the sitex", description = "This EndPoint allows to search all the sitex", tags = { "Sitex" })

    @GetMapping()
    public List<SitexDto> sitexes() throws SitexExeption {
        return sitexService.listSitex();
    }

    @Operation(summary = "Create a new sitex", description = "This EndPoint allows to create a new sitex", tags = { "Sitex" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESSFULLY CREATED", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createSitex(@RequestBody SitexDto sitexDto) throws SitexExeption {
        GenericResponse result = new GenericResponse();
        sitexService.createSitex(sitexDto);
        result.setDescription(messageSource.getMessage("sitex.created.success", new Object[] {sitexDto.getIdSitex()}, Locale.getDefault()));

        return ResponseEntity.ok(result);

    }

    @Operation(summary = "Delete a sitex", description = "This EndPoint allows to delete a sitex", tags = { "Sitex" })
    @DeleteMapping("delete/{idSitex}")
    public ResponseEntity<GenResponse> deleteSitex(@PathVariable Long idSitex) throws SitexExeption {
        GenResponse response = new GenResponse();
        sitexService.deleteSitex(idSitex);
        response.setError(false);
        response.setDescription(messageSource.getMessage("sitex.deleted.success", new Object[]{}, Locale.getDefault()));
        response.setDescriptionFront(messageSource.getMessage("sitex.deleted.success", new Object[]{}, Locale.getDefault()));
        return ResponseEntity.ok(response);
    }




}
