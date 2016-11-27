package com.junction.tarjous;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;

public class ItemActivity extends AppCompatActivity {

    private LinearLayout productsLayout;
    private HashMap products;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        products = new HashMap();
        inflater = LayoutInflater.from(this);
        addProducts();
        addProductsView();
    }

    private void addProducts()
    {
        products.put("Product 1", R.drawable.backgrd);
        products.put("Product 2", R.drawable.ball);
        products.put("Product 3", R.drawable.backgrd);
        products.put("Product 4", R.drawable.ball);
        products.put("Product 5", R.drawable.backgrd);
        products.put("Product 6", R.drawable.ball);
        products.put("Product 7", R.drawable.backgrd);
    }

    private void addProductsView()
    {
        String name;
        int image;
        productsLayout = (LinearLayout) findViewById(R.id.products_layout);

        Iterator iterator = products.keySet().iterator();
        while(iterator.hasNext()){
            name   = (String) iterator.next();
            image = (Integer) products.get(name);

            View view = inflater.inflate(R.layout.products_item, productsLayout, false);
            ImageView img = (ImageView) view.findViewById(R.id.product_image);
            img.setImageResource(image);
            TextView txt = (TextView) view.findViewById(R.id.product_name);
            txt.setText(name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                }
            });
            productsLayout.addView(view);
        }

    }

    View insertPhoto(){

        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.ball);
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setLayoutParams(new ActionBar.LayoutParams(250, 250));
        layout.setGravity(Gravity.CENTER);


        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setLayoutParams(new ActionBar.LayoutParams(220, 220));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bm);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
            }
        });
        layout.addView(imageView);
        return layout;
    }
}
