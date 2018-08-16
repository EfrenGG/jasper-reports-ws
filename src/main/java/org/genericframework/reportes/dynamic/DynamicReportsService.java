
package org.genericframework.reportes.dynamic;

import static net.sf.dynamicreports.report.builder.DynamicReports.cm;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static org.genericframework.reportes.dynamic.DynamicReportsTemplate.createNoDataBand;
import static org.genericframework.reportes.dynamic.DynamicReportsTemplate.createTitleComponent;
import static org.genericframework.reportes.dynamic.DynamicReportsTemplate.reportTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.genericframework.archivo.TipoArchivo;
import org.genericframework.reportes.ReportesJasperUtils;
import org.genericframework.reportes.ReportesService;
import org.genericframework.schemas.reportes.ColumnaReporte;
import org.genericframework.schemas.reportes.TamanoReporte;
import org.genericframework.schemas.reportes.TipoCampo;
import org.springframework.stereotype.Service;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.datatype.AbstractDataType;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.MarginBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRAbstractTextDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;

@Service
public class DynamicReportsService implements ReportesService {
	
	private ColumnGroupBuilder agrupador;

	@Override
	public byte[] generaReporteJasper(String tituloReporte, TamanoReporte tamanoMargen, TamanoReporte tamanoFuente,
			boolean esHorizontal, TipoArchivo tipoArchivo, String datos, List<ColumnaReporte> columnas) {
		byte[] reporte = null;
		try {
			reporte = generaReporteJasper(tituloReporte, tamanoMargen, tamanoFuente, esHorizontal, tipoArchivo, generaDataSourceJson(datos), obtenColumnas(columnas));
		} catch(JRException e) {
			e.printStackTrace();
		}
		return reporte;
	}

	@Override
	public byte[] generaReporteJasper(String tituloReporte, TamanoReporte tamanoMargen, TamanoReporte tamanoFuente, boolean esHorizontal, TipoArchivo tipoArchivo, byte[] datos,
			List<ColumnaReporte> columnas) {
		byte[] reporte = null;
		try {
			reporte = generaReporteJasper(tituloReporte, tamanoMargen, tamanoFuente, esHorizontal, tipoArchivo, generaDataSourceXml(datos),
					obtenColumnas(columnas));
		} catch (JRException e) {
			e.printStackTrace();
		}
		return reporte;
	}

	private byte[] generaReporteJasper(String tituloReporte, TamanoReporte tamanoMargen, TamanoReporte tamanoFuente, boolean esHorizontal, TipoArchivo tipoArchivo, JRAbstractTextDataSource datos,
			ColumnBuilder<?, ?>[] columnas) {
		byte[] reporte = null;
		try {
			JasperReportBuilder jasperReportBuilder = report()
					.setTemplate(reportTemplate)
					.setPageFormat(PageType.A4, esHorizontal ? PageOrientation.LANDSCAPE : PageOrientation.PORTRAIT)
					.setPageMargin(obtenMargenes(tamanoMargen))
					.setDefaultFont(obtenTamanoFuente(tamanoFuente))
					.setWhenNoDataType(WhenNoDataType.NO_DATA_SECTION)
					.columns(columnas)
					.title(createTitleComponent(tituloReporte))
					.setDataSource(datos)
					.addNoData(createNoDataBand());
			if (agrupador != null)
				jasperReportBuilder.groupBy(agrupador);
			reporte = ReportesJasperUtils.generaBytes(jasperReportBuilder.toJasperPrint(), tipoArchivo);
		} catch (DRException | JRException e) {
			e.printStackTrace();
		} finally {
			agrupador = null;
		}
		return reporte;
	}
	
	private FontBuilder obtenTamanoFuente(TamanoReporte tamanoReporte) {
		int tamanoFuente;
		switch (tamanoReporte) {
		case SM:
			tamanoFuente = 8;
			break;
		case MD:
			tamanoFuente = 10;
			break;
		default:
			tamanoFuente = 11;
			break;
		}
		FontBuilder fontBuilder = DynamicReports.stl.font();
		fontBuilder.setFontSize(tamanoFuente);
		return fontBuilder;
	}
	
	private MarginBuilder obtenMargenes(TamanoReporte tamanoReporte) {
		double top, left, bottom, right;
		switch (tamanoReporte) {
		case SM:
			top = 1.27;
			left = 1.27;
			bottom = 1.27;
			right = 1.27;
			break;
		case LG:
			top = 2.5;
			left = 3;
			bottom = 2.5;
			right = 3;
			break;
		default:
			top = 2.54;
			left = 1.91;
			bottom = 2.54;
			right = 1.91;
			break;
		}
		MarginBuilder margin = DynamicReports.margin();
		margin.setTop(cm(top));
		margin.setLeft(cm(left));
		margin.setBottom(cm(bottom));
		margin.setRight(cm(right));
		return margin;
	}

	@SuppressWarnings("unchecked")
	private ColumnBuilder<?, ?>[] obtenColumnas(List<ColumnaReporte> defColumnas) {
		List<ColumnBuilder<?, ?>> columnas = new ArrayList<>();
		for (ColumnaReporte columna : defColumnas) {
			TextColumnBuilder<?> textColumn = col.column(columna.getTitulo(), columna.getNombre(), obtenTipoCampo(columna.getTipo()));
			if (columna.getTamano() != null)
				textColumn.setWidth(columna.getTamano().intValue());
			if (columna.getPatron() != null)
			textColumn.setPattern(columna.getPatron());
			// agrega las columnas
			columnas.add(textColumn);
			// verifica si es agrupador
			if (columna.isAgrupador() && agrupador == null) {
				agrupador = grp.group(textColumn)
						.setHeaderLayout(GroupHeaderLayout.VALUE);
				if (columna.getTamano() != null)
						agrupador.setTitleWidth(columna.getTamano().intValue());
			}
		}
		return columnas.toArray(new ColumnBuilder<?, ?>[columnas.size()]);
	}

	@SuppressWarnings("rawtypes")
	private DRIDataType obtenTipoCampo(TipoCampo tipo) {
		AbstractDataType<?, ?> tipoCampo = null;
		switch (tipo) {
		case LONG:
			tipoCampo = type.longType();
			break;
		case DATE:
			tipoCampo = type.dateType();
			break;
		case BIG_DECIMAL:
			tipoCampo = type.bigDecimalType();
			break;
		case INTEGER:
			tipoCampo = type.integerType();
			break;
		default:
			tipoCampo = type.stringType();
			break;
		}
		return (DRIDataType) tipoCampo;
	}
	
	private JsonDataSource generaDataSourceJson(String datos) throws JRException {
		return new JsonDataSource(new ByteArrayInputStream(datos.getBytes()), "datos");
	}

	private JRXmlDataSource generaDataSourceXml(byte[] datos) throws JRException {
		return generaDataSourceXml(datos, "/data/record");
	}

	private JRXmlDataSource generaDataSourceXml(byte[] datos, String xpath) throws JRException {
		InputStream archivoXml = new ByteArrayInputStream(datos);
		JRXmlDataSource dataSource = new JRXmlDataSource(archivoXml, xpath);
		return dataSource;
	}
}
