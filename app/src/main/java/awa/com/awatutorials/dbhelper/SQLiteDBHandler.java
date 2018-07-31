package awa.com.awatutorials.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import awa.com.awatutorials.model.Player;

/**
 * Created by ${Awanish} on 18/04/18.
 */

public class SQLiteDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TutorialDB";
    private static final String TABLE_NAME = "PlayersTable";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_POSITION = "position";
    private static final String KEY_HEIGHT = "height";
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_POSITION,KEY_HEIGHT};
private Context mContext;
    public  SQLiteDBHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATION_TABLE = "CREATE TABLE PlayersTable ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, "
                + "position TEXT, " + "height INTEGER )";

        try{
            db.execSQL(CREATION_TABLE);
            Toast.makeText(mContext, " DB Creation Success  ", Toast.LENGTH_SHORT).show();
            Log.d("SQL", " DB Creation Success");
        }catch (SQLException e){
            Toast.makeText(mContext, " DB Creation issue  --  ", Toast.LENGTH_SHORT).show();
            Log.d("SQL", " DB Creation Issue");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }
    public void deleteOnePlayer(Player player){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String selection = KEY_ID + " = ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(player.getId())};
        sqLiteDatabase.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(player.getId())});
        //sqLiteDatabase.delete(TABLE_NAME,selection,selectionArgs);
        sqLiteDatabase.close();
    }
    public void selectOnePlayer(int id){
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.query(TABLE_NAME,COLUMNS,"id=?",new String[] { String.valueOf(id) },null,null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        Player player = new Player();
        player.setId(Integer.parseInt(cursor.getString(0)));
        player.setName(cursor.getString(1));
        player.setPosition(cursor.getString(2));
        player.setHeight(Integer.parseInt(cursor.getString(3)));

    }
    public List<Player> getAllPlayers(){
        List<Player> playerList = new LinkedList<Player>();
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        Player player = null;
        while (cursor.moveToNext()){
            player = new Player();
            player.setId(Integer.parseInt(cursor.getString(0)));
            player.setName(cursor.getString(1));
            player.setPosition(cursor.getString(2));
            player.setHeight(Integer.parseInt(cursor.getString(3)));
            playerList.add(player);
        }
        return playerList;
    }
    public void addPlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME,player.getName());
        cv.put(KEY_POSITION,player.getPosition());
        cv.put(KEY_HEIGHT,player.getHeight());
        db.insert(TABLE_NAME,null,cv);
        db.close();

    }
    public int  updatePlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME,player.getName());
        cv.put(KEY_POSITION,player.getPosition());
        cv.put(KEY_HEIGHT,player.getHeight());
        int i = db.update(TABLE_NAME, // table
                cv, // column/value
                "id = ?", // selections
                new String[] { String.valueOf(player.getId()) });

        db.close();
        return  i;
    }
}
