package adityakamble49.dbxdroid;

import java.util.ArrayList;

/**
 * This is <strong>List class</strong> for {@link DBXFieldValuePair}. It is used
 * to create new entry for table . It is used with
 * <strong>insertEntry()</strong> method to pass entries to enter in database
 * 
 * @author adityakamble49
 * 
 */
public class DBXFieldValuePairList {

	ArrayList<DBXFieldValuePair> dbxFieldValuePairsList;

	public DBXFieldValuePairList() {

		dbxFieldValuePairsList = new ArrayList<DBXFieldValuePair>();
	}

	public void addFieldValuePair(DBXFieldValuePair dbxFieldValuePair) {

		dbxFieldValuePairsList.add(dbxFieldValuePair);
	}

	public int size() {

		return dbxFieldValuePairsList.size();

	}

	public DBXFieldValuePair get(int position) {

		return dbxFieldValuePairsList.get(position);
	}

}
