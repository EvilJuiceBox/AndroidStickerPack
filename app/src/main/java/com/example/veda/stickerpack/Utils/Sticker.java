package com.example.veda.stickerpack.Utils;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Sticker {
    private Bitmap bitmap;
    private String name;
    private String description;
    private ArrayList<String> keywords;

    public Sticker(Bitmap b, String n, String d, String ...kw)
    {
        this.bitmap = b;
        this.name = n;
        this.description = d;
        for(String element: kw)
        {
            keywords.add(element);
        }
    }

    public Bitmap getImage()
    {
        return this.bitmap;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public ArrayList<String> getKeywords()
    {
        return this.keywords;
    }
}
