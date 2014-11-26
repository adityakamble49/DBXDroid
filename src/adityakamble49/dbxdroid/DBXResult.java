package adityakamble49.dbxdroid;

import java.util.ArrayList;

public class DBXResult {

	private String[] columnNames;
	int columnSize;
	ArrayList<String[]> resultList;

	public DBXResult(int totalColumns, String[] columns) {

		columnSize = totalColumns;
		columnNames = new String[totalColumns];
		columnNames = columns;
		resultList = new ArrayList<String[]>();
	}

	public String[] getColumnNames() {

		return columnNames;

	}

	void addResult(int row, String rowValues[]) {

		String[] values = new String[columnSize];
		
		for(int i=0; i<rowValues.length; i++){
			
			values[i] = rowValues[i];
		}
		
		resultList.add(values);

	}
	
	public int getRowSize(){
		
		return resultList.size();
	}
	
	public int getColumnSize(){
		
		return columnSize;
	}
	
	public String[][] getResults() {
		
		int rowSize = resultList.size();
		String[][] resultArray = new String[rowSize][columnSize];
		
		for(int i=0; i<rowSize; i++){
			
			for(int j=0; j<columnSize; j++){
				
				resultArray[i][j] = resultList.get(i)[j];
			}
		}
		
		return resultArray;
	}
}
