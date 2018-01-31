package com.example.kt.MRshifty;

import android.graphics.Bitmap;

public class Animation {
    private Bitmap[] frames;
    private long startTime;
    private int currentFrames;
    private long delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames){
       this.frames = frames;
       currentFrames = 0;
       startTime = System.nanoTime();
    }

    public void setDelay(long d){
        delay = d;
    }
    public void setCurrentFrames(int i){
        currentFrames = i;
    }

    public void update(){
        long elapsed = (System.nanoTime() - startTime)/1000000;

        if (elapsed > delay){
            currentFrames++;
            startTime = System.nanoTime();
        }
        if (currentFrames == frames.length){
            currentFrames = 0;
            playedOnce = true;
        }
    }

    public Bitmap getImage(){
        return frames[currentFrames];
    }

    public int getCurrentFrames() {
        return currentFrames;
    }

    public boolean isPlayedOnce() {
        return playedOnce;
    }
}
