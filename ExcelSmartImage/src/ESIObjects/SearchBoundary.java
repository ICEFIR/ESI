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
	public void setRowIndex(String num)
	{
		RowIndex = Integer.parseInt(num);
	}
	
	public void setColIndex(int num)
	{
		ColIndex = num;
	}
	public void setColIndex(String num)
	{
		ColIndex = Integer.parseInt(num);
	}
	public void setInitialRow(int num) {
		InitialRow = num;
	}
	public void setInitialRow(String num) {
		InitialRow = Integer.parseInt(num);
	}
	public void setInitialCol(int num) {
		InitialCol = num;
	}
	public void setInitialCol(String num) {
		InitialRow = Integer.parseInt(num);
	}
	public int getRowIndex()
	{
		return RowIndex;
	}
	public String getRowIndexString()
	{
		return String.valueOf(RowIndex);
	}
	public int getColIndex()
	{
		return ColIndex;
	}
	public String getColIndexString()
	{
		return String.valueOf(ColIndex);
	}
	public int getInitialRow() {
		return InitialRow;
	}
	public String getInitialRowString() {
		return String.valueOf(InitialRow);
	}
	public int getInitialCol() {
		return InitialCol;
	}
	public String getInitialColString() {
		return String.valueOf(InitialCol);
	}
	
}
