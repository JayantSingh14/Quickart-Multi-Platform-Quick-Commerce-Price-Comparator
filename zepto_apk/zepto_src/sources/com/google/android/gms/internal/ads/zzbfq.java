package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbfq implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzbfq f24977a = new zzbfq();

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
