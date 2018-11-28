package com.example.qr_readerexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.uriio.beacons.Beacons;
import com.uriio.beacons.model.Beacon;
import com.uriio.beacons.model.iBeacon;

import static com.example.qr_readerexample.myName.username;

public class MainActivity extends AppCompatActivity {
    public TextView snamename;
    public TextView suuid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myName.ASCIIToHex.main();
        byte[] UUID = hexStringToByteArray(myName.ASCIIToHex.main());
        Beacons.initialize(this);
        Beacon myiBeacon = new iBeacon (UUID, 424, 4242);
myiBeacon.edit().setName(username.getText().toString())
                .apply();
myiBeacon.start();
             System.out.println (myName.ASCIIToHex.main());
//        snamename = (TextView) findViewById(R.id.edit_user);
//         snamename.setText(myName.username.getText().toString());
//        suuid = (TextView) findViewById(R.id.edit_password);
//        suuid.setText(UUID);
//        System.out.println(UUID);

//        new EddystoneUID( UUID, AdvertiseSettings.ADVERTISE_MODE_BALANCED, AdvertiseSettings.ADVERTISE_TX_POWER_HIGH)
//                .start();

    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem myItem = menu.findItem(R.id.nnn);
//        myItem.setTitle(myName.username.getText().toString());
//        return true;
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch(id){
//            case R.id.gst:
//                Intent intent = new Intent(MainActivity.this,myName.class);
//                startActivity(intent);
//                return true;
//            case R.id.nnn :
//                intent = new Intent(MainActivity.this,MainActivity.class);
//                startActivity(intent);
//                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu3, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.mst:
                Intent intent = new Intent(MainActivity.this,Identify.class);
                startActivity(intent);
                return true;
            case R.id.gst :
                intent = new Intent(MainActivity.this,myName.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

//    public static class ASCIIToHex {
//
//        public static String main() {
//            myName.loginname.main();
//            String ascii = myName.loginname.main();
//
//            // Step-1 - Convert ASCII string to char array
//            char[] ch = ascii.toCharArray();
//
//            // Step-2 Iterate over char array and cast each element to Integer.
//            StringBuilder builder = new StringBuilder();
//
//            for (char c : ch) {
//                int i = (int) c;
//                // Step-3 Convert integer value to hex using toHexString() method.
//                builder.append(Integer.toHexString(i).toUpperCase());
//            }
//            SimpleDateFormat dateFormat = new SimpleDateFormat("HHmm");
//            dateFormat.format( new Date() );
//            System.out.println(dateFormat.format(new Date()));
//            String name = dateFormat.format(new Date()) + builder.toString();
//
//            System.out.println("ASCII = " + ascii);
//            System.out.println("Hex = " + builder.toString());
//            System.out.println(dateFormat.format(new Date()) + builder.toString());
//            return name;
//        }
 //   }

}


