package serkan.com.sharedpreferencesders;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtKadi,edtSifre,edtKadi2,edtSifre2,edtSifre2Tekrar;
    Button btnKaydet;
    String kullaniciAdi,sifre;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtKadi=(EditText)findViewById(R.id.editText);
        edtSifre=(EditText)findViewById(R.id.editText2);
        edtKadi2=(EditText)findViewById(R.id.editText3);
        edtSifre2=(EditText)findViewById(R.id.editText4);
        edtSifre2Tekrar=(EditText)findViewById(R.id.editText5);
        btnKaydet=(Button) findViewById(R.id.button3);

        edtKadi2.setVisibility(View.INVISIBLE);
        edtSifre2.setVisibility(View.INVISIBLE);
        edtSifre2Tekrar.setVisibility(View.INVISIBLE);
        btnKaydet.setVisibility(View.INVISIBLE);

        sharedPreferences=this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);



    }

    public void UyeOl(View view){
        edtKadi2.setVisibility(View.VISIBLE);
        edtSifre2.setVisibility(View.VISIBLE);
        edtSifre2Tekrar.setVisibility(View.VISIBLE);
        btnKaydet.setVisibility(View.VISIBLE);


    }


    public void Giris(View view){

        String ad=sharedPreferences.getString("user",""); //Key değeri user olan değeri ad değişkenine atıyor.
        String sif=sharedPreferences.getString("password","");

        if((edtKadi.getText().toString().equals(ad)) && edtSifre.getText().toString().equals(sif)){
            Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Giriş Hatalı....!", Toast.LENGTH_SHORT).show();
        }


    }

    public void Kaydet(View view){

        sharedPreferences.edit().remove("user").apply();  // Key user olan shared !ı silmek için kullanılıyor.
        sharedPreferences.edit().remove("password").apply();

        kullaniciAdi=edtKadi2.getText().toString();
        sifre=edtSifre2.getText().toString();
        String sifre2=edtSifre2Tekrar.getText().toString();

        if((sifre.equals(sifre2)) && !(edtKadi2.getText().equals("")) ){

            sharedPreferences.edit().putString("user",kullaniciAdi).apply(); //Key user olan değerin içine kullaniciAdi değişkenini atıyor.
            sharedPreferences.edit().putString("password",sifre).apply();
            Toast.makeText(this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Kayıt Hatalı.....!", Toast.LENGTH_SHORT).show();
        }

    }


}
