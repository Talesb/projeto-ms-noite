package com.acme.venda.service.clients;

import com.acme.venda.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("LICENCIAMENTO-SERVICE")
public interface LicenciamentoClient {

    @PostMapping("/")
    LicenciamentoResponsePayload calcularTotalLicenciamento (@RequestBody Venda venda);

}
