package awa.com.awatutorials.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import awa.com.awatutorials.R;
import awa.com.awatutorials.dbhelper.SQLiteDBHandler;
import awa.com.awatutorials.model.Player;

public class SQLitePersistenceActivity extends AppCompatActivity implements View.OnClickListener {
private SQLiteDBHandler sqLiteDBHandler;
    private Button addPlayer,getAllPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_persistence);
        sqLiteDBHandler = new SQLiteDBHandler(this);
        // create some players
        Player player1 = new Player(1, "Lebron James", "F", 203);
       // Player player2 = new Player(2, "Kevin Durant", "F", 208);
       // Player player3 = new Player(3, "Rudy Gobert", "C", 214);
        sqLiteDBHandler.addPlayer(player1);
       // sqLiteDBHandler.addPlayer(player2);
       // sqLiteDBHandler.addPlayer(player3);
        // list all players
        getViews();
        setClickListeners();
        // ShowAllPlayers();

    }



    private void getViews() {
        getAllPlayers= (Button) findViewById(R.id.getAllPlayers);
        addPlayer = (Button) findViewById(R.id.addAnewPlayer);
    }
    private void setClickListeners() {
        getAllPlayers.setOnClickListener(this);
        addPlayer.setOnClickListener(this);
    }

    private void showAllPlayers() {
        List<Player> players = sqLiteDBHandler.getAllPlayers();

        if (players != null) {
            String[] itemsNames = new String[players.size()];

            for (int i = 0; i < players.size(); i++) {
                itemsNames[i] = players.get(i).toString();
            }

            // display like string instances
            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, itemsNames));

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getAllPlayers:
                showAllPlayers();
                break;
            case R.id.addAnewPlayer:
                addNewPlayerInDB();
            default:
                break;
        }

    }

    private void addNewPlayerInDB() {

    }
}
