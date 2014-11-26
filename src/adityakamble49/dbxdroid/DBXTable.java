package adityakamble49.dbxdroid;

/**
 * This is a Table class for {@link DBXDatabase}. This can be used to create
 * table and add it to required {@link DBXDatabase}
 * 
 * @author adityakamble49
 * 
 */
public class DBXTable {

	private String tableName;
	private DBXColumnList columns;

	/**
	 * This can be used to create new table by providing Table Name with the
	 * List of {@link DBXColumn} using {@link DBXColumnList} class
	 * 
	 * @param tableName
	 *            - Name for the table
	 * @param columns
	 *            - {@link DBXColumnList} object to add in Table
	 */
	public DBXTable(String tableName, DBXColumnList columns) {

		this.tableName = tableName;
		this.columns = columns;
	}

	public String getTableName() {

		return tableName;
	}

	public DBXColumnList getColumns() {

		return columns;
	}

}
