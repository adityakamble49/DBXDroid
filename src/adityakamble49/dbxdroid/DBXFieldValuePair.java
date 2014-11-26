package adityakamble49.dbxdroid;

public class DBXFieldValuePair {
	
	private final String columnName;
	private final Object valueObject;
	private final int valueType;
	
	public DBXFieldValuePair(String columnName , String value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 0;
	}
	
	public DBXFieldValuePair(String columnName , byte value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 1;
	}
	
	public DBXFieldValuePair(String columnName , short value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 2;
	}
	
	public DBXFieldValuePair(String columnName , int value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 3;
	}
	
	public DBXFieldValuePair(String columnName , long value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 4;
	}
	
	public DBXFieldValuePair(String columnName , double value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 5;
	}
	
	public DBXFieldValuePair(String columnName , float value) {
		
		this.columnName = columnName;
		this.valueObject = value;
		this.valueType = 6;
	}
	
	public String getName() {
		
		return columnName;
	}
	
	public Object getValueObject(){
		
		return valueObject;
	}
	
	public int getValueType(){
		
		return valueType;
	}
	

}
