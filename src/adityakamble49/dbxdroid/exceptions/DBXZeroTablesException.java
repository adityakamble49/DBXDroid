package adityakamble49.dbxdroid.exceptions;

import android.util.Log;

public class DBXZeroTablesException extends DBXException{
	
	public DBXZeroTablesException() {
		
		Log.e("DBXZeroTablesException", "No single table found for this database");
		
	}

}
