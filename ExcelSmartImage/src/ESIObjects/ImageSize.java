package ESIObjects;

import java.io.Serializable;

public class ImageSize implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8926828365053689353L;
	private int height;
	private int width;
	public int getHeight() {
		return height;
	}
	public String getHeightString() {
		return String.valueOf(height);
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setHeight(String height) {
		this.height = Integer.parseInt(height);
	}
	public int getWidth() {
		return width;
	}
	public String getWidthString() {
		return String.valueOf(width);
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public void setWidth(String width) {
		this.width = Integer.parseInt(width);
	}
	
}
