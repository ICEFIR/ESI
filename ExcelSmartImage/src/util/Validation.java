package util;

import javax.swing.JTextField;

public class Validation {

	public static void ValidateToInt (JTextField textfield)
	{
		String txtGap = "";
		if (textfield.getText().length()<=0) return;
		
		
		
		//Simple Way Of achieving.......
		
		for (int i = 0; i<textfield.getText().length();i++)
		{
			if (isInt(textfield.getText().substring(i,i+1)))
			{
				txtGap = txtGap + textfield.getText().substring(i,i+1);
			}
		}
		
		
		//Complex way of achieving
		/*while(!txtGap.matches("\\d*"))
		{
			for (int i = 1; i <= txtGap.length();i++)
			{
				if (isInt(txtGap.substring(i-1, i))==false)
				{
					
					if (!(i==txtGap.length()))
					{
						txtGap = txtGap.substring(0, i-1)+txtGap.substring(i);
						break;
					}
					else
					{
						txtGap = txtGap.substring(0, i-1);
						break;
					}
					
				}
			}
		}*/
			
		
		if (!textfield.getText().equals(txtGap)) textfield.setText(txtGap);

		
	}
	
	public static boolean isInt(String str)  
	{  
		
		try {
		    Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
