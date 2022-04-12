package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    switch (item.getItemId()) {
      case R.id.menuCalc:

        Intent calculatorIntent = new Intent( this, MainActivity.class );
        startActivity(calculatorIntent);
        Toast.makeText(this, "Calculator selected", Toast.LENGTH_SHORT).show();
        return true;
      case R.id.menuConversions:

        Intent  conversionIntent = new Intent( this, Conversions.class );
        startActivity(conversionIntent);
        Toast.makeText(this, "Conversions selected", Toast.LENGTH_SHORT).show();
        return true;
      case R.id.menuHistory:

        Intent  historyIntent = new Intent( this, History.class );
        startActivity(historyIntent);
        Toast.makeText(this, "History selected", Toast.LENGTH_SHORT).show();
        return true;
      case R.id.menuAbout:
        Intent  aboutIntent = new Intent( this, About.class );
        startActivity(aboutIntent);
        Toast.makeText(this, "About selected", Toast.LENGTH_SHORT).show();
        return true;

      default:
        return super.onOptionsItemSelected(item);
    }

  }
}
