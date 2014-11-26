package adityakamble49.dbxdroid.exceptions;

import android.util.Log;

public class DBXDBNotCreatedException extends DBXException{
	
	public DBXDBNotCreatedException() {
		
		Log.e("DBXDBNotCreatedException", "Database Not created");
	}
}