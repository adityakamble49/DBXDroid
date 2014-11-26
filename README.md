## DBXDroid

Index
-----

* [Description](#description)
* [Features](#features)
* [Compatibility](#compatibility)
* [License](#license)
* [Installation](#installation)
* [Use](#use)


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
<li>Ability to interact with database directly using getDatabase() function.</li>
</ul>


Installation
---------------
To use <string>DBXDroid</strong> , 
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
DBXColumnList studentColumns = new DBXColumnList();
studentColumns.addColumn(new DBXColumn("student_id",DBXFieldType.INTEGER));
studentColumns.addColumn(new DBXColumn("student_name",DBXFieldType.TEXT));
studentColumns.addColumn(new DBXColumn("student_dept",DBXFieldType.VARCHAR));
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

License
-------

DBXDroid  is under the [GNU General Public License v3.0 License](https://www.gnu.org/licenses/gpl.html).