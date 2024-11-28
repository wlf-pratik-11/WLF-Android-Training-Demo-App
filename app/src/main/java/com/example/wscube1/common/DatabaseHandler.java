package com.example.wscube1.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2; // Incremented version
    private static final String DATABASE_NAME = "contactManager";
    private static final String TABLE_CONTACT = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phoneNumber";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + TABLE_CONTACT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT)";
        Log.d("Create Table", "Creating table...");
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);
        Log.d("Create Table", "Table created successfully.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d("Upgrade Table", "Upgrading database from version " + oldVersion + " to " + newVersion);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(sqLiteDatabase);
    }

    public void addContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        long result = sqLiteDatabase.insert(TABLE_CONTACT, null, values);
        if (result == -1) {
            Log.e("DB Insert", "Failed to insert contact: " + contact.getName());
        } else {
            Log.d("DB Insert", "Contact added: " + contact.getName());
        }
        sqLiteDatabase.close();
    }

    public Contact getContact(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Contact contact = null;

        Cursor cursor = sqLiteDatabase.query(
                TABLE_CONTACT,
                new String[]{KEY_ID, KEY_NAME, KEY_PH_NO},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null
        );

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                contact = new Contact(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );
            }
            cursor.close();
        }
        sqLiteDatabase.close();
        return contact;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACT;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Contact contact = new Contact();
                    contact.setID(cursor.getInt(0));
                    contact.setName(cursor.getString(1));
                    contact.setPhoneNumber(cursor.getString(2));
                    contactList.add(contact);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        sqLiteDatabase.close();
        return contactList;
    }

    public int updateContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        int rowsAffected = sqLiteDatabase.update(
                TABLE_CONTACT,
                values,
                KEY_ID + "=?",
                new String[]{String.valueOf(contact.getID())}
        );
        sqLiteDatabase.close();
        return rowsAffected;
    }

    public void deleteContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int rowsDeleted = sqLiteDatabase.delete(
                TABLE_CONTACT,
                KEY_ID + "=?",
                new String[]{String.valueOf(contact.getID())}
        );
        if (rowsDeleted > 0) {
            Log.d("DB Delete", "Contact deleted: " + contact.getName());
        } else {
            Log.e("DB Delete", "Failed to delete contact: " + contact.getName());
        }
        sqLiteDatabase.close();
    }

    public int getContactsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CONTACT;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();
        return count;
    }
}
