package application.utils;

public class Utils {

	public boolean isStringFieldInteger(String stringData){

		try{
			Integer.parseInt(stringData);
		}catch(NumberFormatException e){
			return false;
		}

		return true;
	}
}
