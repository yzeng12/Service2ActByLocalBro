package com.example.cln62.service2actbylocalbro;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

public class FetchDataService extends IntentService {

    DataSourceDAO dataSourceDAO;

    public FetchDataService() {
        super("name");
    }

    public FetchDataService(String name, DataSourceDAO dataSourceDAO) {
        super(name);
        this.dataSourceDAO = dataSourceDAO;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        dataSourceDAO = new DataSourceDAO(this);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        sendBroadcast();
    }

    public void sendBroadcast() {
        dataSourceDAO.dbInitializer();
        String data = dataSourceDAO.getData();
        Intent intent = new Intent("send");
        intent.putExtra("key", data);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }


}
