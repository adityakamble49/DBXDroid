## DBXDroid

Index
-----

* [Description](#description)
* [Features](#features)
* [Compatibility](#compatibility)
* [Installation](#installation)
* [Use](#use)
* [License](#license)


Description
------------

This is android library to simplify Android SQlite Database <br>
Refer <a href="https://github.com/adityakamble49/DBXDroidDemo">DBXDroidDemo</a> for Usage.

It become very tedious to write large Android SQLite Open helper for simple database usage.
So I developed this library to create android databases very easily using straight forward functions.



Features
---------
<ul>
<li>Create Android SQLite Database</li>
<li>Add Tables to database</li>
<li>Insert new entry to tables</li>
<li>Fetch entries from tables</li>
<li>Ability to interact with database directly using <b>getDatabase()</b> function.</li>
</ul>


Compatibility
----------------
<b>DBXDroid</b> library is compatible for Android 2.3+

Installation
---------------
To use <strong>DBXDroid</strong> , 
<ul>
<li>Download Library</li>
<li>Extract it to DBXDroid directory</li>
<li>Copy it to your Android Project Workspace</li>
<li>Add it as a project to your Android ADT</li>
<li>Edit properties of your project -> Android -> Library -> Add DBXDroid as Library</li>
<li>Library is now ready to use</li>
</ul>

Use
-------
<strong>1. Define Database</strong>
```java

DBXDatabase studentDatabase;
studentDatabase = new DBXDatabase("college.db", this);

```

<strong>2. Create ColumnList </strong>
```java

DBXColumnList studentColumns = new DBXColumnList();
studentColumns.addColumn(new DBXColumn("student_id",DBXFieldType.INTEGER));
studentColumns.addColumn(new DBXColumn("student_name",DBXFieldType.TEXT));
studentColumns.addColumn(new DBXColumn("student_dept",DBXFieldType.VARCHAR));

```
<strong>3. Add new Table to Database </strong>
```java

studentDatabase.addTable(new DBXTable("students", studentColumns));

```

<strong>4. Create Database </strong>
```java

try {
	studentDatabase.createDatabase();
} catch (Exception e) {
	e.printStackTrace();
}

```

<strong>5. Open Database </strong>
```java

try {
	studentDatabase.openDatabase();
} catch (Exception e) {
	e.printStackTrace();
}

```

<strong>6. Inserting new Entry to table </strong>
```java

DBXFieldValuePairList studentFieldsList = new DBXFieldValuePairList();
studentFieldsList.addFieldValuePair(new DBXFieldValuePair("student_id", Integer.parseInt(studentID)));
studentFieldsList.addFieldValuePair(new DBXFieldValuePair("student_name", studentName));
studentFieldsList.addFieldValuePair(new DBXFieldValuePair("student_dept", studentDept));

try {
	if (studentDatabase.insertEntry("students", studentFieldsList) != -1) {

		Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
	}
} catch (Exception e) {
	e.printStackTrace();
}

```

<strong>7. Fetching Entries </strong>
```java

DBXResult dbxResult = studentDatabase.getEntries("students");
String[][] result = dbxResult.getResults();

```

<strong>8. Access Database Directly </strong>
```java

public SQLiteDatabase getDatabase();

```

This method returns <b>SQLiteDatabase object reference</b> for your database, So you can interact normally and directly to database

<strong>9. Closing Database </strong>
```java

try {
	studentDatabase.closeDatabase();
} catch (Exception e) {
	e.printStackTrace();
}

```

<b>Refer <a href="https://github.com/adityakamble49/DBXDroidDemo">DBXDroidDemo</a> for Full Demo</b>


License
-------

DBXDroid  is under the [GNU General Public License v3.0 License](https://www.gnu.org/licenses/gpl.html).