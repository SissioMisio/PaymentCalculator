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
                new Item("Marmelada de Flor de Jamaica", 130, "ml"),
                new Item("Marmelada de Flor de Jamaica", 230, "ml"),
                new Item("Chutney de mango", 130, "ml"),
                new Item("Pasta de achiote", 30, "ml"),
                new Item("Dulce de Orejaro", 130, "ml"),
                new Item("Humus de Orejaro"),
                new Item("Marmelada de Acerola", 130, "ml"),
                new Item("Marmelada de Acerola", 230, "ml"),
                new Item("Polvo Guaimaro", 125, "g"),
                new Item("Polvo Guaimaro", 250, "g"),
                new Item("Polvo Guaimaro", 500, "g"),
                new Item("Polvo Guaimaro", 1, "Kg"),
                new Item("Dulce de guaimaro"),
                new Item("Flores jamaica", 50, "g"),
                new Item("Flores jamaica", 250, "g"),
                new Item("Flores jamaica", 500, "g"),
                new Item("Flores jamaica", 1, "Kg"),
                new Item("Semillas de Orejero", 1, "Kg"),
                new Item("Chutney de Jobo")
        };

        RecyclerView recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomAdapter(items));

        findViewById(R.id.confirm).setOnClickListener(v -> MainActivity.this.startActivity(new Intent(MainActivity.this, PricesActivity.class)));
    }
}