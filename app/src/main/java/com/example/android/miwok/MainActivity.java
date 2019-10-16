/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        Log.i("MainActivity", "Apply TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        Log.i("MainActivity", "TabLayout implemented");
        tabLayout.setupWithViewPager(viewPager);



//        //Find the View that shows the numbers category
//        TextView numbers = (TextView) findViewById(R.id.numbers);
//        TextView colors = (TextView) findViewById(R.id.colors);
//        TextView family = (TextView) findViewById(R.id.family);
//        TextView phrases = (TextView) findViewById(R.id.phrases);
//
//        //Sets a ClickListener on that View
//        numbers.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                //Create a new intent to open the NumbersActivity
//                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
//                startActivity(numbersIntent);
//
//            }
//            });
//
//        colors.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                //Create a new intent to open the NumbersActivity
//                Intent colors = new Intent(MainActivity.this, ColorLayout.class);
//                startActivity(colors);
//
//            }
//        });
//
//        family.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                //Create a new intent to open the NumbersActivity
//                Intent family = new Intent(MainActivity.this, FamilyLayout.class);
//                startActivity(family);
//
//            }
//        });
//
//        phrases.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                //Create a new intent to open the NumbersActivity
//                Intent phrases = new Intent(MainActivity.this, PhrasesLayout.class);
//                startActivity(phrases);
//            }
//        });
//
//        TextView contacts = (TextView) findViewById(R.id.contacts);
//        contacts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(MainActivity.this, Contacts.class);
//                startActivity(intent);
//            }
//        });

    }
}

