package ESIObjects;

public class SearchBoundary {
	
	private int InitialRow;
	private int InitialCol;
	private int RowIndex;
	private int ColIndex;
	
	public void setRowIndex(int num)
	{
		RowIndex = num;
	}
	public void setColIndex(int num)
	{
		ColIndex = num;
	}
	public void setInitialRow(int initialRow) {
		InitialRow = initialRow;
	}
	public void setInitialCol(int initialCol) {
		InitialCol = initialCol;
	}
	
	public int getRowIndex()
	{
		return RowIndex;
	}
	public int getColIndex()
	{
		return ColIndex;
	}
	public int getInitialRow() {
		return InitialRow;
	}
	public int getInitialCol() {
		return InitialCol;
	}
	
}
