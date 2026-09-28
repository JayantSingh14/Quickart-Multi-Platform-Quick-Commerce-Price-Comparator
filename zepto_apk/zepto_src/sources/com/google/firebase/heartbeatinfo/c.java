package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f44558a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f44559b;

    public /* synthetic */ c(Context context, String str) {
        this.f44558a = context;
        this.f44559b = str;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return new HeartBeatInfoStorage(this.f44558a, this.f44559b);
    }
}
