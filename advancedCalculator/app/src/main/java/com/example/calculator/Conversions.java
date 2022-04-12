package com.example.calculator;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Conversions extends BaseActivity  {

    String result;
    ListView listView;
   public TextView textFromLabel;
 public   TextView  textToLabel;
    EditText editToResult, editFromResult;
    EditText edtConversionResult;
    boolean test = false;
    double number = 0;
//    Resources res = getResources();
//    String [] from = res.getStringArray(R.array.from);
//    String [] to = res.getStringArray(R.array.to);
    //1*7=7 Humans Years to Dog Years
    //1/7=0.1428 Dog Years to Human Years
    //Some may be converted to scientific notation for obvious reasons

    String [] from = {
        "Human Year",
        "Dog Year",
        "Inches",
        "Centimeter",
        "Miles",
        "Kilometer",
        "Gallons",
        "Cups",
        "Light Year",
        "Parsec",
        "Beerbarrel",
        "Hogshead",
        "Newton",
        "Dyne",
        "Fortnight",
        "Sidereal Year",
        "Petabyte",
        "Terabit",
        "Gigahertz",
        "Megahertz",
        "Joule",
        "BTU",
        "Link",
        "Chains",
        "Pascal",
        "PSI",
        "Gigawatt",
        "HP",
        "Gbit/s",
        "GB/s",
        "Rood",
        "Are",
        "Milliradian",
        "Arcsecond",
        "Angstrom",
        "Nautical mile",
        "Stick",
        "Stone",
        "Slug",
        "AMU",




    };
    String [] to = {
        "Dog Year",
        "Human Year",
        "Centimeter",
        "Inches",
        "Kilometer",
        "Miles",
        "Cups",
        "Gallons",
        "Parsec",
        "Light Year",
        "Hogshead",
        "Beerbarrel",
        "Dyne",
        "Newton",
        "Sidereal Year",
        "Fortnight",
        "Terabit",
        "Petabyte",
        "Megahertz",
        "Gigahertz",
        "BTU",
        "Joule",
        "Chains",
        "Link",
        "PSI",
        "Pascal",
        "HP",
        "Gigawatt",
        "GB/s",
        "Gbit/s",
        "Are",
        "Rood",
        "Arcsecond",
        "Milliradian",
        "Nautical mile",
        "Angstrom",
        "Stone",
        "Stick",
        "AMU",
        "Slug",





    };


    String[ ] items = {
        "Humans Years to Dog Years",
        "Dog Years to Human Years",
        "Inches to Centimeter",
        "Centimeters to Inches",
        "Miles to Kilometers",
        "Kilometers to Miles",
        "Gallons to Cups",
        "Cups to Gallons",

        "Light Year to Parsec",
        "Parsec to Light Year",
        "Beerbarral to Hogshead",
        "Hogshead to Beerbarral",

        "Newton to Dyne",
        "Dyne to Newton",
        "Fortnight to Sidereal Year",
        "Sidereal Year to Fortnight",

        "Petabyte to Terabit",
        "Terabit to Petabyte",
        "Gigahertz to Megahertz",
        "Megahertz to Gigahertz",
        "Joule to BTU",
        "BTU to Joule",
        "Link to Chains",
        "Chains to Link",
        "Pascal to PSI",
        "PSI to Pascal",
        "Gigawatt to HP",
        "HP to Gigawatt",
        "Gigabit per second to Gigabyte per second",
        "Gigabyte per second to Gigabit per second",
        "Rood to Are",
        "Are to Rood",
        "Milliradian to Arcsecond",
        "Arcsecond to Milliradian",
        "Angstrom to Nautical mile",
        "Nautical mile to Angstrom",
        "Stick to Stone",
        "Stone to Stick",
        "Slug to Atomic Mass Unit",
        "Atomic Mass Unit to Slug"


    } ;


    Double[] conversionRates = {
        7.0,
        0.1428 ,
        2.54,
        0.393,
        1.6093,
        0.6213,
        15.7725,
        0.06340149,
        //lightyear-parsec
        0.3066014,
        3.261564,
        0.4920635,
        2.032258,
        100000.0,
        0.00001,
        0.03832924,
        26.08974,
        8000.0,
        0.000125,
        1000.0,
        0.001,
        0.0009478171,
        1055.056,
        0.01,
        100.0,
        0.0001450377,
        6894.757,
        1341022.0,
        0.0000007456999,
        0.125,
        8.0,
        10.11714,
        0.09884215,
        206.2648,
        0.004848137,
        0.00000000000005399565,
        18520010000000.0,
        0.0181094,
        55.21994,
        8.788655e+27,
        0.0000000000000000000000000001137831,
















    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversions);
        edtConversionResult = findViewById(R.id.editFromResult);
        editToResult = findViewById(R.id.editToResult);
        editFromResult = findViewById(R.id.editFromResult);
        textToLabel = findViewById(R.id.textToLabel);
        textFromLabel = findViewById(R.id.textFromLabel);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.title2));
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        result = intent.getStringExtra("editResult");
        Log.i("Calc", "Result from calculator: " + result);

        edtConversionResult.setText(result);

//associates the string array with the cell layout with the view

        listView =findViewById(R.id.listViewConversions);

        ArrayAdapter adapter = new ArrayAdapter<String>( this, R.layout.conversion_item, items );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String toText, fromText;

                if(editFromResult.getText().length() > 0)
                {
                    fromText = from[position];
                    ((TextView)textFromLabel).setText(fromText);
                    toText = to[position];
                    ((TextView)textToLabel).setText(toText);


                }
               else {
                    editFromResult.setError("Enter a number");



                    //       number = Double.parseDouble( editFromResult.getText().toString());

                    editFromResult.setText(Double.toString(number));

                }

                performCalculation (position);
            }
        });

//        listView.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView <? > adapterView, View rowView,
//                                    int position1, long id) {
//
//
//////                TextView  textToLabel = (TextView) rowView.findViewById(R.id.textToLabel);
//   //           TextView  textFromLabel = (TextView) rowView.findViewById(R.id.textFromLabel);
//////
//
//////                toText = to[position];
//////
//////                textFromLabel.setText(fromText);
//////                textToLabel.setText(toText);
//
//
//
//            }
//        });
    }

    //create the callback method to activate whenever the user clicks on a cell
private void performCalculation(int position){
    Toast.makeText(this, "You clicked on: " + position, Toast.LENGTH_SHORT ).show();

    Double fromNumber, toNumber;


    fromNumber = Double.parseDouble( editFromResult.getText().toString());


    toNumber = fromNumber * conversionRates[position];
    editToResult.setText(Double.toString(toNumber));




}


    public void calcButtonOnClick (View v)
    {
        Log.i("Calc", "going to calculator");

    }



}
