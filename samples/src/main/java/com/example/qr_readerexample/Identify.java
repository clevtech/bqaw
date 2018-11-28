package com.example.qr_readerexample;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Identify extends AppCompatActivity {
    private EditText username;
    private EditText password;
//    private Button login;
//    private TextView loginLocked;
//    private TextView attempts;
//    private TextView numberOfAttempts;
    private Button link;
    private final static int REQUEST_ENABLE_BT = 1;

//    int i = 1;
//    Intent bluetoothIntent;
//    // Число для подсчета попыток залогиниться:
//    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);
        BluetoothAdapter bluetooth= BluetoothAdapter.getDefaultAdapter();
        if (bluetooth.isEnabled()) {
            // Bluetooth включен. Работаем.
        }
        else
        {
            // Bluetooth выключен. Предложим пользователю включить его.
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
//        switchButton = (Switch)findViewById(R.id.switch1);
//        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
//
//        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                // TODO Auto-generated method stub
//                if(isChecked)
//                {
//                    BluetoothEnable();
//                }
//                else {
//                    BluetoothDisable();
//                }
//            }
//        });
        // Связываемся с элементами нашего интерфейса:
        link = (Button) findViewById(R.id.link);
        username = (EditText) findViewById(R.id.edit_user);
        password = (EditText) findViewById(R.id.edit_password);
        //loginLocked = (TextView) findViewById(R.id.login_locked);
//        attempts = (TextView) findViewById(R.id.attempts);
//        numberOfAttempts = (TextView) findViewById(R.id.number_of_attempts);
//        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
                return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){

            case R.id.gst:
                Intent intent = new Intent(Identify.this,myName.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    // Обрабатываем нажатие кнопки "Войти":
    public void Login(View view) {

        // Если введенные логин и пароль будут словом "admin",
        // показываем Toast сообщение об успешном входе:
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Вход выполнен!",Toast.LENGTH_SHORT).show();
            // Выполняем переход на другой экран:
            Intent intent = new Intent(Identify.this,QRCodeGenerator.class);
            startActivity(intent);
        }

        // В другом случае выдаем сообщение с ошибкой:
        else {
            Toast.makeText(getApplicationContext(), "Неправильные данные!",Toast.LENGTH_SHORT).show();
          //  numberOfRemainingLoginAttempts--;

            // Делаем видимыми текстовые поля, указывающие на количество оставшихся попыток:
//            attempts.setVisibility(View.VISIBLE);
//            numberOfAttempts.setVisibility(View.VISIBLE);
//            numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

            // Когда выполнено 3 безуспешных попытки залогиниться,
            // делаем видимым текстовое поле с надписью, что все пропало и выставляем
            // кнопке настройку невозможности нажатия setEnabled(false):
//            if (numberOfRemainingLoginAttempts == 0) {
//                login.setEnabled(false);
//                loginLocked.setVisibility(View.VISIBLE);
//                loginLocked.setBackgroundColor(Color.RED);
//                loginLocked.setText("Вход заблокирован!!!");
//            }
        }
    }
//    public void BluetoothEnable(){
//        bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//        startActivityForResult(bluetoothIntent, i);
//
//    }
//
//    public void BluetoothDisable(){
//        bluetoothadapter.disable();
//    }
}