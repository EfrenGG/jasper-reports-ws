package org.genericframework.reportes;

import java.io.ByteArrayOutputStream;

import org.genericframework.archivo.TipoArchivo;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

@SuppressWarnings("deprecation")
public class ReportesJasperUtils {

	public static JRAbstractExporter<?, ?, ?, ?> obtenExportador(TipoArchivo tipoArchivo) {
		JRAbstractExporter<?, ?, ?, ?> exportador = null;
		switch (tipoArchivo) {
		case PDF:
			exportador = new JRPdfExporter();
			break;
		case XLSX:
			exportador = new JRXlsxExporter();
			break;
		case TXT:
			exportador = new JRTextExporter();
			break;
		case CSV:
			exportador = new JRCsvExporter();
			break;
		default:
			break;
		}
		return exportador;
	}
	
	public static byte[] generaBytes(JasperPrint jasperPrint, TipoArchivo tipoArchivo) throws JRException {
		return generaBytes(jasperPrint, obtenExportador(tipoArchivo));
	}
	
	public static byte[] generaBytes(JasperPrint jasperPrint, JRAbstractExporter<?, ?, ?, ?> exportador) throws JRException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		exportador.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exportador.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exportador.exportReport();
		return baos.toByteArray();
	}
}
