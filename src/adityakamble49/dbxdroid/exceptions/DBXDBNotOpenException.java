package adityakamble49.dbxdroid.exceptions;

import android.util.Log;

public class DBXDBNotOpenException extends DBXException{
	
public DBXDBNotOpenException() {
		
		Log.e("DBXDBNotOpenedException", "Database Not Opened");
	}

}
