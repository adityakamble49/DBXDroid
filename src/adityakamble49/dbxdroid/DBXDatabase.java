package adityakamble49.dbxdroid;

import java.util.ArrayList;

import adityakamble49.dbxdroid.exceptions.DBXDBNotCreatedException;
import adityakamble49.dbxdroid.exceptions.DBXDBNotOpenException;
import adityakamble49.dbxdroid.exceptions.DBXZeroTablesException;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * <strong>Android SQLite Database </strong> Class to create database and
 * perform operations like DDL and DML . <br>
 * It is <strong> ORM - Object Relational Mapping </strong> for simplifying use
 * of <strong> Android SQlite Database </strong>
 * 
 * @author adityakamble49
 * 
 */
public class DBXDatabase {

	private String DATABASE_NAME;
	private ArrayList<DBXTable> tables = new ArrayList<DBXTable>();
	private Context context;

	private SQLiteOpenHelper sqLiteOpenHelper;
	private SQLiteDatabase sqLiteDatabase;

	private ArrayList<String> createTableQueries = new ArrayList<String>();
	private ArrayList<String> dropTableQueries = new ArrayList<String>();

	private boolean isDatabaseCreated;
	private boolean isDatabaseOpened;

	/**
	 * Create new {@link DBXDatabase} using this constructor by passing it name
	 * of the database and context
	 * 
	 * @param databaseName
	 *            - Name of the database to create
	 * @param context
	 *            - context for that database
	 */
	public DBXDatabase(String databaseName, Context context) {

		this.DATABASE_NAME = databaseName;
		this.context = context;

	}

	/**
	 * This method used to add {@link DBXTable} in {@link DBXDatabase}
	 * 
	 * @param dbxTable
	 *            - reference of {@link DBXTable} object to add in the database
	 */
	public void addTable(DBXTable dbxTable) {

		tables.add(dbxTable);

	}

	private class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {

			super(context, DATABASE_NAME, null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			for (int i = 0; i < tables.size(); i++) {

				db.execSQL(createTableQueries.get(i));
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

			for (int i = 0; i < tables.size(); i++) {

				db.execSQL(dropTableQueries.get(i));
			}
			onCreate(db);
		}

	}

	/**
	 * After defining the {@link DBXDatabase} and its tables with
	 * {@link DBXTable} this method should be called to create that database
	 * with provided tables.
	 * 
	 * @throws DBXZeroTablesException
	 *             It will throw {@link DBXZeroTablesException} if it does't
	 *             found single table to create with database
	 * 
	 */
	public void createDatabase() throws DBXZeroTablesException {

		if (tables.size() == 0) {

			throw new DBXZeroTablesException();
		}

		for (int i = 0; i < tables.size(); i++) {

			String createTable = "CREATE TABLE " + tables.get(i).getTableName()
					+ "(";

			for (int j = 0; j < tables.get(i).getColumns().size(); j++) {

				createTable += tables.get(i).getColumns().get(j)
						.getColumnWithType();

				if (j != tables.get(i).getColumns().size() - 1) {

					createTable += ",";
				}
			}

			createTable += ")";
			createTableQueries.add(createTable);

			String dropTable = "DROP TABLE IF EXISTS "
					+ tables.get(i).getTableName();
			dropTableQueries.add(dropTable);

		}

		isDatabaseCreated = true;

	}

	/**
	 * This method is used to <strong> Open Created Database </strong> . Use
	 * this method before doing any manipulation over database like
	 * <strong>Inserting , Deleting , Finding </strong> and all <strong> DML
	 * </strong> Stuff.
	 * 
	 * @throws DBXDBNotCreatedException
	 *             If used this method before creating database
	 * 
	 */
	public void openDatabase() throws DBXDBNotCreatedException {

		if (!isDatabaseCreated) {

			throw new DBXDBNotCreatedException();

		}

		sqLiteOpenHelper = new DatabaseHelper(context);
		sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();

		isDatabaseOpened = true;
	}

	/**
	 * This method is used to <strong> Close Opened Database </strong> . Use
	 * this method for closing Database
	 * 
	 * @throws DBXDBNotCreatedException
	 *             If used this method before <strong>Creating</strong>
	 *             database.
	 * @throws DBXDBNotOpenException
	 *             If used this method before <strong>Opening</strong> Database.
	 * 
	 */
	public void closeDatabase() throws DBXDBNotCreatedException,
			DBXDBNotOpenException {

		if (!isDatabaseCreated) {

			throw new DBXDBNotCreatedException();

		}

		if (!isDatabaseOpened) {

			throw new DBXDBNotOpenException();

		}

		sqLiteDatabase.close();

	}

	/**
	 * This method is to insert new entry in any table of the database , It
	 * takes Table Name and List of {@link DBXFieldValuePair} to create new
	 * entry for that table in database
	 * 
	 * @param tableName
	 *            - Name of the table
	 * @param dbxFieldValuePairList
	 *            - {@link DBXFieldValuePairList}
	 * @return
	 * @throws DBXDBNotCreatedException
	 * @throws DBXDBNotOpenException
	 */
	public long insertEntry(String tableName,
			DBXFieldValuePairList dbxFieldValuePairList)
			throws DBXDBNotCreatedException, DBXDBNotOpenException {

		if (!isDatabaseCreated) {

			throw new DBXDBNotCreatedException();

		}

		if (!isDatabaseOpened) {

			throw new DBXDBNotOpenException();
		}

		ContentValues contentValues = new ContentValues();

		for (int i = 0; i < dbxFieldValuePairList.size(); i++) {

			switch (dbxFieldValuePairList.get(i).getValueType()) {

			case 0:
				contentValues.put(dbxFieldValuePairList.get(i).getName(),
						String.valueOf(dbxFieldValuePairList.get(i)
								.getValueObject()));
				break;

			case 1:
				contentValues.put(dbxFieldValuePairList.get(i).getName(), Byte
						.parseByte(String.valueOf(dbxFieldValuePairList.get(i)
								.getValueObject())));
				break;

			case 2:
				contentValues.put(dbxFieldValuePairList.get(i).getName(), Short
						.parseShort(String.valueOf(dbxFieldValuePairList.get(i)
								.getValueObject())));
				break;

			case 3:
				contentValues.put(dbxFieldValuePairList.get(i).getName(),
						Integer.parseInt(String.valueOf(dbxFieldValuePairList
								.get(i).getValueObject())));
				break;

			case 4:
				contentValues.put(dbxFieldValuePairList.get(i).getName(), Long
						.parseLong(String.valueOf(dbxFieldValuePairList.get(i)
								.getValueObject())));
				break;

			case 5:
				contentValues.put(dbxFieldValuePairList.get(i).getName(),
						Double.parseDouble(String.valueOf(dbxFieldValuePairList
								.get(i).getValueObject())));
				break;

			case 6:
				contentValues.put(dbxFieldValuePairList.get(i).getName(), Float
						.parseFloat(String.valueOf(dbxFieldValuePairList.get(i)
								.getValueObject())));
				break;

			}
		}

		return sqLiteDatabase.insert(tableName, null, contentValues);
	}

	/**
	 * Use this method to get Entries in Database Table
	 * 
	 * @param tableName
	 *            The Table Name for getting entries
	 * @return
	 */
	public DBXResult getEntries(String tableName) {

		DBXFieldValuePairList dbxFieldValuePairsList = new DBXFieldValuePairList();
		int tableIndex = -1;
		for (int i = 0; i < tables.size(); i++) {

			if (tableName == tables.get(i).getTableName()) {

				tableIndex = i;
				break;
			}
		}

		int columnSize = tables.get(tableIndex).getColumns().size();
		DBXColumnList columnList = tables.get(tableIndex).getColumns();
		String[] columnNames = new String[columnSize];
		int[] columnType = new int[columnSize];
		
		for (int i = 0; i < columnSize; i++) {

			columnNames[i] = columnList.get(i).getColumnName();
		}
		
		DBXResult dbxResult = new DBXResult(columnSize,columnNames);
		String[] rowValues = new String[columnSize];
		Cursor cursor = sqLiteDatabase.query(tableName, columnNames, null, null,
				null, null, null);

		int rowIndex = 0;
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

			for (int j = 0; j < columnSize; j++) {

				String columnName = columnList.get(j).getColumnName();
				int columnIndex = cursor.getColumnIndex(columnName);
				String value = cursor.getString(columnIndex);
				rowValues[j] = value;
				
			}
			
			dbxResult.addResult(rowIndex, rowValues);
			
			rowIndex++;

		}

		return dbxResult;

	}

	public SQLiteDatabase getDatabase() {

		return sqLiteDatabase;
	}

}
