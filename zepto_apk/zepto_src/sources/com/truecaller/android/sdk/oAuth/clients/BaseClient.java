package com.truecaller.android.sdk.oAuth.clients;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.oAuth.TcOAuthCallback;
import java.util.Locale;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class BaseClient {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47276a;

    /* renamed from: b, reason: collision with root package name */
    public final TcOAuthCallback f47277b;

    /* renamed from: c, reason: collision with root package name */
    public final int f47278c;

    /* renamed from: d, reason: collision with root package name */
    public final String f47279d;

    /* renamed from: e, reason: collision with root package name */
    public Locale f47280e;

    /* renamed from: f, reason: collision with root package name */
    public int f47281f = 0;

    /* renamed from: g, reason: collision with root package name */
    public String[] f47282g;

    /* renamed from: h, reason: collision with root package name */
    public String f47283h;

    /* renamed from: i, reason: collision with root package name */
    public String f47284i;

    public BaseClient(Context context, String str, TcOAuthCallback tcOAuthCallback, int i2) {
        this.f47276a = context;
        this.f47279d = str;
        this.f47278c = i2;
        this.f47277b = tcOAuthCallback;
    }
}
