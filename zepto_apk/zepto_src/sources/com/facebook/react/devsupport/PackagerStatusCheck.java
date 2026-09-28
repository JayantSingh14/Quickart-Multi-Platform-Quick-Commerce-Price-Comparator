package com.facebook.react.devsupport;

import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

@Nullsafe
/* loaded from: classes3.dex */
public class PackagerStatusCheck {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f18862a;

    public PackagerStatusCheck() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.b(5000L, timeUnit);
        builder.c(0L, timeUnit);
        builder.d(0L, timeUnit);
        this.f18862a = new OkHttpClient(builder);
    }

    public PackagerStatusCheck(OkHttpClient okHttpClient) {
        this.f18862a = okHttpClient;
    }
}
