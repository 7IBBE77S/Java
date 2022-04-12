package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.zip.Inflater;

public class MainActivity extends BaseActivity implements View.OnClickListener {

  public EditText editResult;
  private double num1, total = 0;
  //    private String operator;
  boolean haveDecimal = false;

  String displayResult = "";
  boolean isAvailable = false;
  private Calculate Calculate;
//    double numbers;@

  //
  String numbers = ".9876543210";


  public double input2;
  public String sign2;


 // public Toolbar toolbar;
//num
  Button zero, one, two, three, four, five, six, seven, eight, nine, dot1, back, cos, clear, change, random;
////op
//Button Add, Subtract, Multiply, Divide, Decimal, Equal, Clear;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.title));
       setSupportActionBar(toolbar);

    editResult = findViewById(R.id.editResult);
//editResult.setText(displayResult);

    // findViewById(R.id.btn0).setOnClickListener(this);

    back = (Button) findViewById(R.id.btnDelete);
    random = (Button) findViewById(R.id.btnRdm);
    zero = (Button) findViewById(R.id.btn0);
    change = (Button) findViewById(R.id.btnChange);
    findViewById(R.id.btn0).setOnClickListener(this);
    findViewById(R.id.btn1).setOnClickListener(this);
    findViewById(R.id.btn2).setOnClickListener(this);
    findViewById(R.id.btn3).setOnClickListener(this);
    findViewById(R.id.btn4).setOnClickListener(this);
    findViewById(R.id.btn5).setOnClickListener(this);
    findViewById(R.id.btn6).setOnClickListener(this);
    findViewById(R.id.btn7).setOnClickListener(this);
    findViewById(R.id.btn8).setOnClickListener(this);
    findViewById(R.id.btn9).setOnClickListener(this);

    //   one = (Button) findViewById(R.id.btn1);
//        one.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editResult.setText(editResult.getText() + "1");
//            }
//        });

    //base
    findViewById(R.id.btnAdd).setOnClickListener(this);
    findViewById(R.id.btnSubtract).setOnClickListener(this);
    findViewById(R.id.btnMultiply).setOnClickListener(this);
    findViewById(R.id.btnDivide).setOnClickListener(this);
//        findViewById(R.id.btnChange).setOnClickListener(this);
    findViewById(R.id.btnDecimal).setOnClickListener(this);

    findViewById(R.id.btnCalculate).setOnClickListener(this);
    findViewById(R.id.btnClear).setOnClickListener(this);


    //landscape


    if (null != findViewById(R.id.btnSqr)) {
      findViewById(R.id.btnSqr).setOnClickListener(this);

      if (null != findViewById(R.id.btnSqrRt)) {
        findViewById(R.id.btnSqrRt).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnSin)) {
        findViewById(R.id.btnSin).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnCos)) {
        findViewById(R.id.btnCos).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnTan)) {
        findViewById(R.id.btnTan).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnChange)) {
        findViewById(R.id.btnChange).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnPi)) {
        findViewById(R.id.btnPi).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnRdm)) {
        findViewById(R.id.btnRdm).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnPer)) {
        findViewById(R.id.btnPer).setOnClickListener(this);
      }
      if (null != findViewById(R.id.btnDelete))
        findViewById(R.id.btnDelete).setOnClickListener(this);
    }
    if (back != null) {
      findViewById(R.id.btnDelete).setOnClickListener(this);

      back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


          if (editResult.length() < 0) {
            back.setEnabled(false);
            change.setEnabled(false);


            Log.i("test123", "disabled");
          } else {
            if (editResult.length() > 0) {
              back.setEnabled(true);
              editResult.setText(editResult.getText().toString().substring(0, editResult.length() - 1));
            } else {
              return;
            }
          }

        }
      });

    }

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if (editResult.length() >= 0) {
//                    if (editResult.length() <= 0) {
//                        return;
//                    }
//                    back.setEnabled(true);
//                    editResult.setText(editResult.getText().toString().substring(0, editResult.length() - 1));
//                } else {
//                    back.setEnabled(false);
//                    change.setEnabled(false);
//
//
//                    Log.i("test123", "disabled");
//                }
//
//            }
//        });
    Calculate = new Calculate();
  }

  //    public void numberButtonOnClick(View v) {
//        Button btnName = (Button) v;
//        num1 = Double.parseDouble(btnName.getText().toString());
//        editResult.setText(num1+"");
//
//    }
//    else if (operator.equals(BACK)) {
//        //  editResult.setText(editResult.getText().toString().substring(0, editResult.length() - 1));
//
//
//        //    return s.substring(input);
//
//    }
  @Override
  public void onClick(View v) {

    String btnName;
    btnName = ((Button) v).getText().toString();

    if (!numbers.contains(btnName)) {
      if (isAvailable) {

        Calculate.setOperand(Double.parseDouble(editResult.getText().toString()));
        isAvailable = false;
      }
      Calculate.Calculation(btnName);
      editResult.setText(dot.format(Calculate.ans()));

    } else {

      if (isAvailable)
        if (!(!("." == btnName) || !editResult.getText().toString().contains(".")))
          editResult.setText(editResult.getText() + btnName);
        else editResult.append(btnName);
      else {

        if (!".".equals(btnName)) editResult.setText(btnName);
        else editResult.setText(0 + btnName);

        isAvailable = true;
      }

    }

  }

  public void decimal(View v) {
    String btnName = ((Button) v).getText().toString();
    if (btnName.equals(".")) {
      if (!haveDecimal) {
        displayResult += btnName;
        haveDecimal = true;

      } else {
        displayResult += btnName;
      }
      editResult.setText(displayResult);
    }
  }


  public DecimalFormat dot;

  {
    dot = new DecimalFormat("0.00000000");
    dot.setMaximumIntegerDigits(1000);
    dot.setMinimumIntegerDigits(1);
    dot.setMaximumFractionDigits(1000);
    dot.setMinimumFractionDigits(0);
  }

  public class Calculate {



    public double ans() {
      return input;
    }

    public void setOperand(double input) {
      this.input = input;
    }

    public Calculate() {

      input = 0.0;
      input2 = 0.0;
      sign2 = "";

    }

    public double input;

    String A = "+", S = "-", M = "*", D = "/", Modulus = "%", SQR = "x²", ROOT = "√", NEG = "±", TAN = "TAN", SIN = "SIN", COS = "COS", PIE = "π";
    String RANDOM = "RANDOM", ALEATORIA = "ALEATORIA";
    String CLEAR = "CLEAR", CLARO = "CLARO";


    public void simpleCalc() {

      if (A.equals(sign2)) input = input2 + input;
      else if (S.equals(sign2)) input = input2 - input;
      else if (M.equals(sign2)) input = input2 * input;
      else if (D.equals(sign2)) if (input != 0) input = input2 / input;


    }


//        private  String removeLastChar(String str) {
//            return str.substring(0, str.length() - 1);
//        }


    public double Calculation(String sign) {



      if (sign.equals(CLEAR)) {

        input = 0;
        sign2 = "";
        input2 = 0;


      }
      if (sign.equals(CLARO)) {

        input = 0;
        sign2 = "";
        input2 = 0;


      } else {
        if (!sign.equals(ROOT)) {
          if (!sign.equals(Modulus)) {
            if (PIE.equals(sign)) input = Math.PI;
            else if (SQR.equals(sign)) input = input * input;
            else if (NEG.equals(sign)) input = -input;
            else if (SIN.equals(sign)) input = Math.sin(Math.toRadians(input));
            else if (COS.equals(sign)) input = Math.cos(Math.toRadians(input));
            else if (TAN.equals(sign)) input = Math.tan(Math.toRadians(input));
            else //  text=editResult.getText().toString();
            {
              if (!RANDOM.equals(sign)) {
              } else {
                input = Math.random();
              }
            }
          } else {
            input = input / 100;
          }
          if (!ALEATORIA.equals(sign)) {
            simpleCalc();
            sign2 = sign;
            input2 = input;
          } else {
            input = Math.random();
          }
        } else {
          input = Math.sqrt(input);
        }
      }

      return input;
    }


    public String toString() {
      return Double.toString(input);

    }

  }



//    public void gotoConversionBtnOnClick(View v)
//  {
//  Log.i("Calc", "going to conversions");
//  Intent  conversionIntent = new Intent( this, Conversions.class );
//  conversionIntent.putExtra("editResult", displayResult);
//  startActivity(conversionIntent);
//
//
//  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    outState.putString("RESULT", displayResult);
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onRestoreInstanceState( Bundle saveState) {
    super.onRestoreInstanceState(saveState);

    displayResult = saveState.getString("RESULT");
    editResult.setText(displayResult);

  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.i("Calc", "In onPause");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.i("Calc", "In onStart");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.i("Calc", "In onStop");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.i("Calc", "In OnRestart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.i("Calc", "In onResume");
  }
}


//

//
//    public void operatorOnClick(View v) {
//        Button btnName = (Button) v;
//        operator = btnName.getText().toString();
//        calc(v);
//    }
//
//    public void calc(View v) {
//        Button btnName = (Button) v;
//
//        if (operator.equals("+")) {
//            total = total + num1;
//        }
//
//        editResult.setText(total+"");
//        num1 = 0;
//
//    }
//

