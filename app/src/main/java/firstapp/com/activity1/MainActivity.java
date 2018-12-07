package firstapp.com.activity1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Button btnComp1;
    private TextView txtViewTotalFare;
    private EditText editTextDist, editTextDura;
    int editTxt1Distance, editTxt2Duration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComp1 = findViewById(R.id.btnCompute);
        txtViewTotalFare = findViewById(R.id.txtViewTotalFare);
        editTextDist = findViewById(R.id.editTxtDistance);
        editTextDura = findViewById(R.id.editTxtDuration);
        this.SetupListener();



    }
    private void SetupListener()
    {
        try {
            btnComp1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editTxt1Distance = Integer.parseInt(editTextDist.getText().toString());
                    editTxt2Duration = Integer.parseInt(editTextDura.getText().toString());
                    if(editTxt1Distance <= 400)
                    {
                        int quoDura = editTxt2Duration / 120;
                        int modDura = editTxt2Duration % 120;
                        if(modDura > 0){
                            modDura = 1;
                        }
                        Double finalFare = 35.00 +  (quoDura * 2.50) + (modDura * 2.50);
                        txtViewTotalFare.setText(Double.toString(finalFare));

                    }
                    else
                    {
                        int newDistance = editTxt1Distance - 400;
                        int quoDist = newDistance / 1000;
                        int modDist = newDistance % 1000;
                        if(modDist > 0){
                            modDist = 1;
                        }

                        int quoDura = editTxt2Duration / 120;
                        int modDura = editTxt2Duration % 120;
                        if(modDura > 0){
                            modDura = 1;
                        }

                        Double finalFare = 35 + (quoDist * 13.50) + (modDist * 13.50) + (quoDura * 2.50) + (modDura * 2.50);
                        txtViewTotalFare.setText(String.format("%.2f", finalFare));
                    }
                }
            });
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }




}
