package com.example.memovaradegante.apimarvel.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.memovaradegante.apimarvel.API.API;
import com.example.memovaradegante.apimarvel.API.APIService.CharacterClass;
import com.example.memovaradegante.apimarvel.Models.Character;
import com.example.memovaradegante.apimarvel.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editName;
    private ImageButton btnSearch;
    private ImageView imagCharacter;
    private TextView txtCharacterName;
    private TextView txtDescriptionCharacter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editName);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        imagCharacter = (ImageView) findViewById(R.id.imagCharacter);
        txtCharacterName = (TextView) findViewById(R.id.txtCharacterName);
        txtDescriptionCharacter = (TextView) findViewById(R.id.txtDescriptionCharacter);

        Picasso.get().load(R.drawable.marvel).fit().into(imagCharacter);

        btnSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSearch:
                if(!(editName.getText().toString().matches(""))){
                    //Consulta al API
                    final String character = editName.getText().toString();
                    CharacterClass service = API.getAPI().create(CharacterClass.class);

                    Call<Character> characterCall = service.getCharacter(API.Ts,API.APIKey, character, API.Hash);

                    characterCall.enqueue(new Callback<Character>() {
                        @Override
                        public void onResponse(Call<Character> call, Response<Character> response) {
                            Character character1 = response.body();
                            txtCharacterName.setText(character1.getName());
                            txtDescriptionCharacter.setText(character1.getDescription());
                            Picasso.get().load(character1.generateImage()).fit().into(imagCharacter);
                        }

                        @Override
                        public void onFailure(Call<Character> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Please try again",Toast.LENGTH_SHORT).show();

                        }
                    });



                }else{
                    Toast.makeText(getApplicationContext(), "Please introduce a Character name", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
