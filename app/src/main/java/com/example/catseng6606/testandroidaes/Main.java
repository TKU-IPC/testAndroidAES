package com.example.catseng6606.testandroidaes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    TextView tv;
    Button btnAes128;
    Button btnAes256;
    String _plainText = "This is the text to be encrypted";
    String _iv = "275d75495a3d196e";
    String _key = "b16920894899c7780b5fc7161560a412";
    String _cypherText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAes128 = (Button) findViewById(R.id.btnAES128);
        btnAes256 = (Button) findViewById(R.id.btnAES256);
        tv = (TextView) findViewById(R.id.tv);
        btnAes128.setOnClickListener(listenerAes128);
        btnAes256.setOnClickListener(listenerAes256);
    }

    View.OnClickListener listenerAes128 = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                Log.v("Log", "This is Verbose.");
                String s;
                try {

                    String output = "";
                    output += "AES 128" + "\n";
                    output += "iv = " + _iv + "\n";
                    output += "key= " + _key + "\n";
                    output += "Plain text = " + _plainText + "\n";
                    _cypherText = AES128Helper.AESEncrypt(_plainText, _key);
                    output += "Cypher text = " + _cypherText + "\n";
                    output += "Back text = " + AES128Helper.AESDecrypt(_cypherText, _key) + "\n";
                    /*
                    sb.Length = 0;
                    sb.AppendLine("AES 128");
                    sb.AppendLine("iv=" + _iv);
                    sb.AppendLine("key=" + _key);
                    sb.AppendLine("Plain text = " + _plainText);
                    _cypherText = AES128Helper.AESEncrypt(_plainText, _key);
                    sb.AppendLine("Cypher text = " + _cypherText);

                    sb.AppendLine("Back text = " + AES128Helper.AESDecrypt(_cypherText, _key));
                    textBox1.Text = sb.ToString();
                    */
                    tv.setText(output);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (Exception e) {
                Log.v("Log", e.getMessage().toString());
            }
        }
    };
    View.OnClickListener listenerAes256 = new View.OnClickListener() {
        public void onClick(View v) {
            try {
                Log.v("Log", "This is Verbose.");
                String s;
                try {
                    AES256Helper aes = new AES256Helper();
                    String output = "";
                    output += "AES 256" + "\n";
                    output += "iv = " + _iv + "\n";
                    output += "key= " + _key + "\n";
                    output += "Plain text = " + _plainText + "\n";
                    _cypherText = aes.encrypt(_plainText, _key, _iv);
                    output += "Cypher text = " + _cypherText + "\n";
                    output += "Back text = " + aes.decrypt(_cypherText, _key, _iv) + "\n";
                    /*
                    sb.Length = 0;
                    sb.AppendLine("AES 128");
                    sb.AppendLine("iv=" + _iv);
                    sb.AppendLine("key=" + _key);
                    sb.AppendLine("Plain text = " + _plainText);
                    _cypherText = AES128Helper.AESEncrypt(_plainText, _key);
                    sb.AppendLine("Cypher text = " + _cypherText);

                    sb.AppendLine("Back text = " + AES128Helper.AESDecrypt(_cypherText, _key));
                    textBox1.Text = sb.ToString();
                    */
                    tv.setText(output);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (Exception e) {
                Log.v("Log", e.getMessage().toString());
            }
        }
    };
}
