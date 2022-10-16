package com.customer.sms;

import android.app.ProgressDialog;

public class Progres extends Thread{
    ProgressDialog progres;
    boolean hasProgress;

    public Progres(ProgressDialog progressDialog, boolean hasProgress){
        this.progres = progressDialog;
        this.hasProgress = hasProgress;
    }


    @Override
    public void run(){
        sleepWithProgress();
        progres.dismiss();
    }

    public  void sleepWithProgress(){
        try {
            while(progres.getProgress()<100){
                Thread.sleep(1000);
                progres.incrementProgressBy(10);
            }
        }catch(InterruptedException e){
        }
    }
}
