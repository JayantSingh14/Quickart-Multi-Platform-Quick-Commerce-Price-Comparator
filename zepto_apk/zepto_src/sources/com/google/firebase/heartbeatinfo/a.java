package com.google.firebase.heartbeatinfo;

import android.util.Base64OutputStream;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44555a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultHeartBeatController f44556b;

    public /* synthetic */ a(DefaultHeartBeatController defaultHeartBeatController, int i2) {
        this.f44555a = i2;
        this.f44556b = defaultHeartBeatController;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String string;
        switch (this.f44555a) {
            case 0:
                DefaultHeartBeatController defaultHeartBeatController = this.f44556b;
                synchronized (defaultHeartBeatController) {
                    ((HeartBeatInfoStorage) defaultHeartBeatController.f44545a.get()).h(System.currentTimeMillis(), ((UserAgentPublisher) defaultHeartBeatController.f44547c.get()).a());
                }
                return null;
            default:
                DefaultHeartBeatController defaultHeartBeatController2 = this.f44556b;
                synchronized (defaultHeartBeatController2) {
                    try {
                        HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage) defaultHeartBeatController2.f44545a.get();
                        ArrayList arrayListC = heartBeatInfoStorage.c();
                        heartBeatInfoStorage.b();
                        JSONArray jSONArray = new JSONArray();
                        for (int i2 = 0; i2 < arrayListC.size(); i2++) {
                            HeartBeatResult heartBeatResult = (HeartBeatResult) arrayListC.get(i2);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("agent", heartBeatResult.c());
                            jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.b()));
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("heartbeats", jSONArray);
                        jSONObject2.put("version", "2");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                            try {
                                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                                gZIPOutputStream.close();
                                base64OutputStream.close();
                                string = byteArrayOutputStream.toString("UTF-8");
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return string;
        }
    }
}
