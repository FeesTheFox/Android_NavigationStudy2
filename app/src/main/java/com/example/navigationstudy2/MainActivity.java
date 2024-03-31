package com.example.navigationstudy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.navigationstudy2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //work with binding
        View view = binding.getRoot();
        setContentView(view);
    }
    //creating menu
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,0,"add");
        menu.add(0,2,0,"edit");
        menu.add(0,3,0,"delete");
        menu.add(1,4,0,"copy");
        menu.add(1,5,0,"paste");
        menu.add(1,6,0,"exit");
        return super.onCreateOptionsMenu(menu);
    }
    //menu appearance

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //menu items with ID groups that = 1 are visible, if Checkbox is chosen
        menu.setGroupVisible(1, binding.chbExtMenu.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }
    //processing the selection of a menu item

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Output info about selected menu item in TextView
        String sb = "Item Menu"+
                "\r\n groupId: " + String.valueOf(item.getGroupId()) +
                "\r\n itemId: " + String.valueOf(item.getItemId()) +
                "\r\n order: " + String.valueOf(item.getOrder()) +
                "\r\n title: " + item.getTitle();
        binding.textView.setText(sb);
        return super.onOptionsItemSelected(item);
    }
}