package com.example.echolin.week7.utils;


import android.os.AsyncTask;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by echolin on 2017/5/23.
 */

public class DownloadUtil<T> extends AsyncTask<String,Void,Object> {

    private Class<T> type;
    private InfoCallBack<T> callBack;

    public DownloadUtil( InfoCallBack<T> callBack) {
        this.callBack = callBack;
        Type[] types = callBack.getClass().getGenericInterfaces();
        for (Type type1 : types) {
            if (type1 instanceof ParameterizedType){
                if (((ParameterizedType) type1).getRawType() == InfoCallBack.class) {
                    type = (Class<T>) ((ParameterizedType) type1).getActualTypeArguments()[0];
                    return;
                }
            }
        }
    }


    @Override
    protected Object doInBackground(String... params) {
        String json = HttpUtils.infoDownLoad(params[0]);
        return new Gson().fromJson(json,type);
    }

    @Override
    protected void onPostExecute(Object o) {
        if (o != null){
            callBack.callBack((T) o);
        }
    }

    public interface InfoCallBack<R>{
        void callBack(R r);
    }
}
