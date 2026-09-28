package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public class zzgye extends zzgyn {
    public static zzgye s(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzgye ? (zzgye) listenableFuture : new zzgyf(listenableFuture);
    }
}
