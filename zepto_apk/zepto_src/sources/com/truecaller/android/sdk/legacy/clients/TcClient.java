package com.truecaller.android.sdk.legacy.clients;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.legacy.ITrueCallback;
import java.util.Locale;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class TcClient {

    /* renamed from: a, reason: collision with root package name */
    public final Context f47257a;

    /* renamed from: b, reason: collision with root package name */
    public ITrueCallback f47258b;

    /* renamed from: c, reason: collision with root package name */
    public final int f47259c;

    /* renamed from: d, reason: collision with root package name */
    public final String f47260d;

    /* renamed from: e, reason: collision with root package name */
    public String f47261e;

    /* renamed from: f, reason: collision with root package name */
    public Locale f47262f;

    /* renamed from: g, reason: collision with root package name */
    public int f47263g;

    public TcClient(Context context, String str, ITrueCallback iTrueCallback, int i2) {
        this.f47257a = context;
        this.f47260d = str;
        this.f47259c = i2;
        this.f47258b = iTrueCallback;
    }
}
