package adityakamble49.dbxdroid;

/**
 * It is column class which holds column name and field type of column
 * 
 * @author adityakamble49
 * 
 */
public class DBXColumn {

	private final String columnName;
	private final String fieldType;

	/**
	 * Constructs {@link DBXColumn} having Column Name and Field Type
	 * 
	 * @param columnName
	 *            - Name of the column
	 * @param fieldType
	 *            - Type of the field
	 */
	public DBXColumn(String columnName, String fieldType) {

		this.columnName = columnName;
		this.fieldType = fieldType;

	}

	/**
	 * This returns the column name with the type , used in DDL fro defining
	 * that column in Database Table
	 * 
	 * @return - Name of Column With Type
	 */
	public String getColumnWithType() {

		return columnName + " " + fieldType;

	}

	public String getColumnName() {

		return columnName;

	}

}
