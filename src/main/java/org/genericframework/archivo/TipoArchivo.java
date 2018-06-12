package org.genericframework.archivo;

public enum TipoArchivo {
	TXT(".txt", "text/plain"),
	CSV(".csv", "text/plain"),
	PDF(".pdf", "application/pdf"),
	XLSX(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
	XLS(".xls", "application/vnd.ms-excel"),
	XML(".xml", "application/xml"),
	ZIP(".zip", "application/zip");

	private String ext;
	private String mimeType;

	private TipoArchivo(String ext, String mimeType){
		this.ext = ext;
		this.mimeType = mimeType;
	}

	public String getExt() {
		return ext;
	}

	public String getMimeType() {
		return mimeType;
	}
}