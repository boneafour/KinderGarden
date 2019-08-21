package com.example.kindergarden3.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "KinderGarden";

	// Contacts table name
	private static final String TABLE_SHORT_INFO_KG= "shortinfo";
	//private static final String TABLE_PARENTS = "parents";
	// Contacts Table Columns names

	private static final String SHORT_INFO_KG_ID = "shortinfo_id";
	private static final String SHORT_INFO_KG_REG = "shortinfo_reg";
	private static final String SHORT_INFO_KG_MKR = "shortinfo_mkr";
	private static final String SHORT_INFO_KG_NAME = "shortinfo_name";
	private static final String SHORT_INFO_KG_ADRESS = "shortinfo_adress";
/*
	private static final String PARENTS_ID = "parent_id";
	private static final String PARENTS_NAME = "student_name";
	private static final String STUDENT_NUMBER = "student_number";
	private static final String STUDENT_COMMENT = "student_comment";


	private static final String MARKS_ID = "marks_id";
	private static final String MARKS_LECTURE= "marks_lecture";
	private static final String MARKS_NAME = "marks_name";
	private static final String MARKS_MARK= "marks_mark";

*/

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_SHORT_INFO_KG = "CREATE TABLE " + TABLE_SHORT_INFO_KG + "("
				+ SHORT_INFO_KG_ID + " INTEGER PRIMARY KEY," + SHORT_INFO_KG_REG  + " TEXT,"
				+ SHORT_INFO_KG_MKR +" TEXT,"+ SHORT_INFO_KG_NAME  +" TEXT,"+ SHORT_INFO_KG_ADRESS +" TEXT"+  ")";
		db.execSQL(CREATE_TABLE_SHORT_INFO_KG);
/*
		String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + "("
				+ STUDENT_ID + " INTEGER PRIMARY KEY," + STUDENT_NAME + " TEXT,"
				+ STUDENT_NUMBER +" TEXT,"+ STUDENT_COMMENT +" TEXT" +  ")";
		db.execSQL(CREATE_TABLE_STUDENTS);


		String CREATE_TABLE_MARK = "CREATE TABLE " + TABLE_MARKS + "("
				+ MARKS_ID + " INTEGER PRIMARY KEY,"
				+ MARKS_LECTURE + " TEXT," + MARKS_NAME + " TEXT,"+ MARKS_MARK + " TEXT"+  ")";
		db.execSQL(CREATE_TABLE_MARK);
*/
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHORT_INFO_KG);
		//db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARKS);
		onCreate(db);
	}

	public void addShortInfo(ShortInfoData shortInfo) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(SHORT_INFO_KG_REG, shortInfo.getShortInfoReg());
		values.put(SHORT_INFO_KG_MKR, shortInfo.getShortInfoMKR());
		values.put(SHORT_INFO_KG_NAME, shortInfo.getShortInfoName());;
		values.put(SHORT_INFO_KG_ADRESS, shortInfo.getShortInfoAdress());
		db.insert(TABLE_SHORT_INFO_KG, null, values);
		db.close();

	}
/*


	private static final String SHORT_INFO_KG_ID = "shortinfo_id";
	private static final String SHORT_INFO_KG_REG = "shortinfo_reg";
	private static final String SHORT_INFO_KG_MKR = "shortinfo_mkr";
	private static final String SHORT_INFO_KG_NAME = "shortinfo_name";
	private static final String SHORT_INFO_KG_ADRESS = "shortinfo_adress";

	void addStudent(StudentData student) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(STUDENT_NAME, student.getStudentName());
		values.put(STUDENT_NUMBER, student.getStudentPhone());
		values.put(STUDENT_COMMENT, student.getStudentComment());
		db.insert(TABLE_STUDENTS, null, values);
		db.close();
	}



	public void addMark(MarkData mark) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(MARKS_LECTURE, mark.getMarkLecture());
		values.put(MARKS_NAME, mark.getMarkName());
		values.put(MARKS_MARK, mark.getMarks());
		db.insert(TABLE_MARKS, null, values);
		db.close();
	}
*/
	public List<ShortInfoData> getAllShortInfo() {
		List<ShortInfoData> shortInfoList = new ArrayList<ShortInfoData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SHORT_INFO_KG;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ShortInfoData shortInfo = new ShortInfoData();
				shortInfo.setShortInfoID(Integer.parseInt(cursor.getString(0)));
				shortInfo.setShortInfoReg(cursor.getString(1));
				shortInfo.setShortInfoMKR(cursor.getString(2));
				shortInfo.setShortInfoName(cursor.getString(3));
				shortInfo.setShortInfoAdress(cursor.getString(4));
				shortInfoList.add(shortInfo);
			} while (cursor.moveToNext());
		}

		// return contact list
		return shortInfoList;
	}
	/*
	public List<StudentData> getAllStudents() {
		List<StudentData> studentList = new ArrayList<StudentData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				StudentData student = new StudentData();
				student.setStudentID(Integer.parseInt(cursor.getString(0)));
				student.setStudentName(cursor.getString(1));
				student.setStudentPhone(cursor.getString(2));
				student.setStudentComment(cursor.getString(3));
				studentList.add(student);
			} while (cursor.moveToNext());
		}
		return studentList;
	}




	public List<MarkData> getAllMarks() {
		List<MarkData> markList = new ArrayList<MarkData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MARKS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				MarkData mark = new MarkData();
				mark.setMarkID(Integer.parseInt(cursor.getString(0)));
				mark.setMarkLecture(cursor.getString(1));
				mark.setMarkName(cursor.getString(2));
				mark.setMarks(cursor.getString(3));
				markList.add(mark);
			} while (cursor.moveToNext());
		}
		return markList;
	}
*/
/*
	// Deleting single contact
	public void deleteContact(ContactData contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, CONTACT_ID +NAME +ADRESS+ORGAN+ROLE +PHONE+COMMENT+ " = ?",
				new String[] { String.valueOf(contact.getID()) });
		db.close();
	}



	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

*/

}
