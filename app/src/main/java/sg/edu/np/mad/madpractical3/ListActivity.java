package sg.edu.np.mad.madpractical3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    ImageView image = findViewById(R.id.imageView2);

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Profile");
    builder.setMessage("MADness");
    builder.setCancelable(true);
    builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //Toast.makeText(getApplicationContext(),"testing",Toast.LENGTH_SHORT).show();
            Random rand = new Random();
            int upperbound = 99999;
            int random_int = rand.nextInt(upperbound);
            //Toast.makeText(getApplicationContext(),Integer.toString(random_int),Toast.LENGTH_SHORT).show();
            Intent activity  = new Intent(ListActivity.this,MainActivity.class);
            String rand_int = Integer.toString(random_int);
            activity.putExtra("Key",rand_int);
            startActivity(activity);
        }
    });
    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });
    AlertDialog alert = builder.create();
    image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alert.show();
        }
    });

    }
}