package adityakamble49.dbxdroid;

import java.util.ArrayList;

/**
 * It is <strong>>List class</strong>> for {@link DBXColumn} to hold all columns for specific
 * table. It is use to create list of {@link DBXColumn} to add in
 * {@link DBXTable}
 * 
 * @author adityakamble49
 * 
 */
public class DBXColumnList {

	ArrayList<DBXColumn> dbxColumnsList;

	public DBXColumnList() {

		dbxColumnsList = new ArrayList<DBXColumn>();

	}

	/**
	 * This method is used to add new column to {@link DBXColumnList}
	 * 
	 * @param dbxColumn - {@link DBXColumn} object to add in {@link DBXColumnList}
	 */
	public void addColumn(DBXColumn dbxColumn) {

		dbxColumnsList.add(dbxColumn);
	}

	/**
	 * This method used to get size of the {@link DBXColumnList}
	 * 
	 * @return size of {@link DBXColumnList}
	 */
	public int size() {

		return dbxColumnsList.size();
	}

	/**
	 * This method used to get {@link DBXColumn} from {@link DBXColumnList} in
	 * specified position
	 * 
	 * @param position
	 * @return {@link DBXColumn} object for specified position in
	 *         {@link DBXColumnList}
	 */
	public DBXColumn get(int position) {

		return dbxColumnsList.get(position);
	}

}
