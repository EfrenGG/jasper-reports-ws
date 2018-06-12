package org.genericframework.web;

import org.genericframework.archivo.TipoArchivo;
import org.genericframework.reportes.ReportesService;
import org.genericframework.schemas.reportes.GeneraReporteRequest;
import org.genericframework.schemas.reportes.GeneraReporteResponse;
import org.genericframework.schemas.reportes.TamanoReporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ReporteEndpoint {

	private static final String NAMESPACE_URI = "http://genericframework.org/schemas/reportes";
	
	@Autowired
	ReportesService reportesService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generaReporteRequest")
	@ResponsePayload
	public GeneraReporteResponse generaReporte(@RequestPayload GeneraReporteRequest request) {
		GeneraReporteResponse response = new GeneraReporteResponse();
		if (request.getTamanoFuente() == null)
			request.setTamanoFuente(TamanoReporte.LG);
		if (request.getTamanoMargen() == null)
			request.setTamanoMargen(TamanoReporte.LG);
		if (request.getTipoArchivo() == null)
			throw new IllegalArgumentException("El tipo de archivo debe ser TXT, CSV, PDF o XLSX");
		response.setRespuesta("Generado correctamente!");
		response.setArchivo(reportesService.generaReporteJasper(request.getNombreReporte(),
				TamanoReporte.valueOf(request.getTamanoMargen().toString()),
				TamanoReporte.valueOf(request.getTamanoFuente().toString()),
				request.isHorizontal(),
				TipoArchivo.valueOf(request.getTipoArchivo().toString()),
				request.getDatos(),
				request.getColumnas()));
		return response;
	}
}
