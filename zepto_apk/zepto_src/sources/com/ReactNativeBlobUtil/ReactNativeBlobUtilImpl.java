package com.ReactNativeBlobUtil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
class ReactNativeBlobUtilImpl {

    /* renamed from: b, reason: collision with root package name */
    public static ReactApplicationContext f13918b;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadPoolExecutor f13919c;

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f13920d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f13921e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseArray f13922f;

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f13923a;

    /* renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl$1, reason: invalid class name */
    class AnonymousClass1 implements ActivityEventListener {
        @Override // com.facebook.react.bridge.ActivityEventListener
        public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
            if (i2 == 99900 && i3 == -1) {
                Uri data = intent.getData();
                SparseArray sparseArray = ReactNativeBlobUtilImpl.f13922f;
                ((Promise) sparseArray.get(99900)).resolve(data.toString());
                sparseArray.remove(99900);
            }
        }

        @Override // com.facebook.react.bridge.ActivityEventListener
        public final void onNewIntent(Intent intent) {
        }
    }

    static {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        f13919c = new ThreadPoolExecutor(5, 10, 5000L, timeUnit, linkedBlockingQueue);
        new LinkedBlockingQueue();
        f13920d = new ThreadPoolExecutor(2, 10, 5000L, timeUnit, linkedBlockingQueue);
        f13921e = false;
        f13922f = new SparseArray();
    }

    public ReactNativeBlobUtilImpl(ReactApplicationContext reactApplicationContext) {
        OkHttpClient okHttpClientB = OkHttpClientProvider.b();
        this.f13923a = okHttpClientB;
        ((CookieJarContainer) okHttpClientB.f56306j).c(new JavaNetCookieJar(new ForwardingCookieHandler(reactApplicationContext)));
        f13918b = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new AnonymousClass1());
    }
}
