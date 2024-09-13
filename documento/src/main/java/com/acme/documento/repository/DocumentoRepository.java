package com.acme.documento.repository;

import com.acme.documento.model.*;
import org.springframework.data.jpa.repository.*;

import javax.print.*;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}