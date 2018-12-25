package com.example.veda.stickerpack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;

import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.builders.Indexables;
import com.google.firebase.appindexing.builders.StickerBuilder;
import com.google.firebase.appindexing.builders.StickerPackBuilder;

import java.util.ArrayList;

public class StickerIndexingServices extends JobIntentService {
    private static final int UNIQUE_JOB_ID = 0;

    public static void enqueueWork(Context context)
    {
        enqueueWork(context, StickerIndexingServices.class, UNIQUE_JOB_ID, new Intent());
    }

    /**
     * building stickerpack
     */
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        ArrayList<StickerBuilder> stickers = new ArrayList<>();

        stickers.add(Indexables.stickerBuilder()
                .setName("Sticker Name")
                .setUrl("mystickers://sticker/myStickers")
                .setImage(Uri.parse("android.resource://com.example.veda.stickerpack/drawable/name").toString())
                .setDescription("sticker")
                .setKeywords("mySticker"));


        //Builds the entire package
        StickerPackBuilder stickerPackBuilder = Indexables.stickerPackBuilder()
                .setName("Stickers")
                .setUrl("mystickers://sticker/pack/myStickers")
                .setImage(Uri.parse("android.resource://com.example.veda.stickerpack/drawable/name").toString())
                .setHasSticker(stickers.toArray(new StickerBuilder[stickers.size()]));

        ///////////////////////                      update indexes                 ///////////////////////////
        FirebaseAppIndex.getInstance().update(stickerPackBuilder.build());
    }
}
