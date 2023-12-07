package com.example.myvc.authentication.database.databaseHelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myvc.authentication.database.Extension

class ExtensionDBHelper (context: Context): SQLiteOpenHelper (context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "Extension_DB"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "Extension"
        private const val COLUMN_ID = "id"
        private const val COLUMN_FULLNAME = "fullName"
        private const val COLUMN_CAMPUS = "campus"
        private const val COLUMN_DELIVERY = "delivery"
        private const val COLUMN_REGISTRATION = "registration"
        private const val COLUMN_QUALIFICATION = "qualification"
        private const val COLUMN_REASON = "reason"
        private const val COLUMN_PREVIOUS = "previous"
        private const val COLUMN_ASSESSMENT1 = "assessment1"
        private const val COLUMN_MISSED = "missed"
        private const val COLUMN_ASSESSMENT2 = "assessment2"
        private const val COLUMN_REPLACEMENT = "replacement"
        private const val COLUMN_MODULE = "module"
        private const val COLUMN_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_FULLNAME TEXT," +
                "$COLUMN_CAMPUS TEXT," +
                "$COLUMN_DELIVERY TEXT," +
                "$COLUMN_REGISTRATION TEXT," +
                "$COLUMN_QUALIFICATION TEXT," +
                "$COLUMN_REASON TEXT," +
                "$COLUMN_PREVIOUS TEXT," +
                "$COLUMN_ASSESSMENT1 TEXT," +
                "$COLUMN_MISSED TEXT," +
                "$COLUMN_ASSESSMENT2 TEXT," +
                "$COLUMN_REPLACEMENT TEXT," +
                "$COLUMN_MODULE TEXT," +
                "$COLUMN_STATUS TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertExtension(e: Extension) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FULLNAME, e.fullName)
            put(COLUMN_CAMPUS, e.campus)
            put(COLUMN_DELIVERY, e.delivery)
            put(COLUMN_REGISTRATION, e.registration)
            put(COLUMN_QUALIFICATION, e.qualification)
            put(COLUMN_REASON, e.reason)
            put(COLUMN_PREVIOUS, e.previous)
            put(COLUMN_ASSESSMENT1, e.assessment1)
            put(COLUMN_MISSED, e.missed)
            put(COLUMN_ASSESSMENT2, e.assessment2)
            put(COLUMN_REPLACEMENT, e.replacement)
            put(COLUMN_MODULE, e.module)
            put(COLUMN_STATUS, e.status)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun displayExtension(): List<Extension> {
        val eList = mutableListOf<Extension>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val fullName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FULLNAME))
            val campus = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CAMPUS))
            val delivery = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DELIVERY))
            val registration = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REGISTRATION))
            val qualification = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_QUALIFICATION))
            val reason = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REASON))
            val previous = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PREVIOUS))
            val assessment1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ASSESSMENT1))
            val missed = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MISSED))
            val assessment2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ASSESSMENT2))
            val replacement = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REPLACEMENT))
            val module = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MODULE))
            val status = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STATUS))

            val e = Extension(
                id,
                fullName,
                campus,
                delivery,
                registration,
                qualification,
                reason,
                previous,
                assessment1,
                missed,
                assessment2,
                replacement,
                module,
                status
            )
            eList.add(e)
        }
        cursor.close()
        db.close()

        return eList
    }

    fun findExtension(name: String): Int {
        val db = readableDatabase
        val query = "SELECT COUNT($COLUMN_FULLNAME) FROM $TABLE_NAME WHERE $COLUMN_FULLNAME = $name"
        val cursor = db.rawQuery(query, null)

        val count = cursor.count
        cursor.close()
        db.close()

        return count
    }
}