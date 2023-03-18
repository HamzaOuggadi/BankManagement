package ma.atos.ma.atos.bankmanagement.feignproxies;

import ma.atos.ma.atos.bankmanagement.Dtos.CompteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("BANKMANAGEMENT2")
public interface SitexProxy {
    @GetMapping("/comptes")
    List<CompteDto> getComptes();

}
