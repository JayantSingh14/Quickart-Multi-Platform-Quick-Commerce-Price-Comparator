package com.facebook.react.devsupport.inspector;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class InspectorNetworkHelper {

    /* renamed from: a, reason: collision with root package name */
    public static OkHttpClient f18937a;

    public static void a(String str, final InspectorNetworkRequestListener inspectorNetworkRequestListener) {
        if (f18937a == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.b(10L, timeUnit);
            builder.d(10L, timeUnit);
            builder.c(0L, TimeUnit.MINUTES);
            f18937a = new OkHttpClient(builder);
        }
        try {
            Request.Builder builder2 = new Request.Builder();
            builder2.i(str);
            f18937a.a(builder2.b()).l0(new Callback() { // from class: com.facebook.react.devsupport.inspector.InspectorNetworkHelper.1
                @Override // okhttp3.Callback
                public final void onFailure(Call call, IOException iOException) {
                    if (call.s()) {
                        return;
                    }
                    inspectorNetworkRequestListener.onError(iOException.getMessage());
                }

                @Override // okhttp3.Callback
                public final void onResponse(Call call, Response response) {
                    Headers headers = response.f56355f;
                    HashMap map = new HashMap();
                    for (String str2 : headers.g()) {
                        map.put(str2, headers.d(str2));
                    }
                    int i2 = response.f56353d;
                    InspectorNetworkRequestListener inspectorNetworkRequestListener2 = inspectorNetworkRequestListener;
                    inspectorNetworkRequestListener2.onHeaders(i2, map);
                    try {
                        ResponseBody responseBody = response.f56356g;
                        if (responseBody != null) {
                            try {
                                InputStream inputStreamA = responseBody.a();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    try {
                                        int i3 = inputStreamA.read(bArr);
                                        if (i3 == -1) {
                                            break;
                                        } else {
                                            inspectorNetworkRequestListener2.onData(new String(bArr, 0, i3));
                                        }
                                    } catch (Throwable th) {
                                        inputStreamA.close();
                                        throw th;
                                    }
                                }
                                inputStreamA.close();
                            } finally {
                            }
                        }
                        inspectorNetworkRequestListener2.onCompletion();
                        if (responseBody != null) {
                            responseBody.close();
                        }
                    } catch (IOException e2) {
                        inspectorNetworkRequestListener2.onError(e2.getMessage());
                    }
                }
            });
        } catch (IllegalArgumentException unused) {
            inspectorNetworkRequestListener.onError("Not a valid URL: " + str);
        }
    }
}
