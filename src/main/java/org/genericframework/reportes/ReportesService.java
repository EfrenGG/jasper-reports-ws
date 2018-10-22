package org.genericframework.reportes;

import java.util.List;

import org.genericframework.archivo.TipoArchivo;
import org.genericframework.schemas.reportes.ColumnaReporte;
import org.genericframework.schemas.reportes.TamanoReporte;

public interface ReportesService {
	public byte[] generaReporteJasper(String nomReporte, TipoArchivo tipoArchivo, String datos);
	public byte[] generaReporteJasper(String tituloReporte, TamanoReporte tamanoMargen, TamanoReporte tamanoFuente, boolean esHorizontal, TipoArchivo tipoArchivo, String datos, List<ColumnaReporte> columnas);
	public byte[] generaReporteJasper(String tituloReporte, TamanoReporte tamanoMargen, TamanoReporte tamanoFuente, boolean esHorizontal, TipoArchivo tipoArchivo, byte[] datos, List<ColumnaReporte> columnas);
}
