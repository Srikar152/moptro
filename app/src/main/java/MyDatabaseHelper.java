import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class MyDatabaseHelper extends SQLiteOpenHelper {
//    private final Context context;
    private Context con;
private static final String DATABASE_NAME="Employee.db";
private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="Employees";
    private static final String COLUMN_ID="Emp_Id";
    private static final String COLUMN_NAME="Emp_Name";
    private static final String COLUMN_DOB="Emp_Dob";

    private static final String COLUMN_ROLE="Emp_Role";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="CREATE TABLE" + TABLE_NAME + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_NAME + " TEXT, " + COLUMN_DOB + " DATE " + COLUMN_ROLE + " TEXT);";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
    }
}
