package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzesb implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzesb f30206a = new zzesb();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        return ((Throwable) obj) instanceof TimeoutException ? zzgym.a(new zzese(Integer.toString(17))) : zzgym.a(new zzese(null));
    }
}
