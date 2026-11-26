package it.edu.iiscopernico.paymentcalculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        WindowCompat.enableEdgeToEdge(window);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars((getBaseContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO);
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars((getBaseContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO);

        Item[] items = new Item[]{
                new Item("Marmelada de Flor de Jamaica", 130, "ml", R.drawable.mermelada_flor_de_jamaica),
                new Item("Marmelada de Flor de Jamaica", 230, "ml", R.drawable.mermelada_flor_de_jamaica),
                new Item("Chutney de mango", 130, "ml", R.drawable.chutney_de_mango),
                new Item("Pasta de achiote", 30, "ml", R.drawable.pasta_de_achiote),
                new Item("Dulce de Orejaro", 130, "ml", R.drawable.dulce_de_orejero),
                new Item("Humus de Orejaro", R.drawable.humus_de_orejero),
                new Item("Marmelada de Acerola", 130, "ml", R.drawable.mermelada_de_acerola),
                new Item("Marmelada de Acerola", 230, "ml", R.drawable.mermelada_de_acerola),
                new Item("Polvo Guaimaro", 125, "g", R.drawable.polvo_guaimaro),
                new Item("Polvo Guaimaro", 250, "g", R.drawable.polvo_guaimaro),
                new Item("Polvo Guaimaro", 500, "g", R.drawable.polvo_guaimaro),
                new Item("Polvo Guaimaro", 1, "Kg", R.drawable.polvo_guaimaro),
                new Item("Dulce de guaimaro", R.drawable.dulce_de_guaimaro),
                new Item("Flores jamaica", 50, "g", R.drawable.flores_jamaica),
                new Item("Flores jamaica", 250, "g", R.drawable.flores_jamaica),
                new Item("Flores jamaica", 500, "g", R.drawable.flores_jamaica),
                new Item("Flores jamaica", 1, "Kg", R.drawable.flores_jamaica),
                new Item("Semillas de Orejero", 1, "Kg", R.drawable.semillas_de_orejero),
                new Item("Chutney de Jobo", R.drawable.chutney_de_jobo)
        };

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter(items));

        findViewById(R.id.confirm).setOnClickListener(v -> MainActivity.this.startActivity(new Intent(MainActivity.this, PricesActivity.class)));
    }
}