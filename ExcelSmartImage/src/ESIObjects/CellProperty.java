package ESIObjects;

import java.io.Serializable;

public class CellProperty implements Serializable {

	private static final long serialVersionUID = -2030553076971687156L;

	private float CellHeightExcelUnit;
	private float CellWidthExcelUnit;
	public float getCellHeightExcelUnit() {
		return CellHeightExcelUnit;
	}
	public void setCellHeightExcelUnit(float cellHeightExcelUnit) {
		CellHeightExcelUnit = cellHeightExcelUnit;
	}
	public float getCellWidthExcelUnit() {
		return CellWidthExcelUnit;
	}
	public void setCellWidthExcelUnit(float cellWidthExcelUnit) {
		CellWidthExcelUnit = cellWidthExcelUnit;
	}
	
}
