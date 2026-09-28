package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
final class zzfai implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30745a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30746b;

    /* renamed from: c, reason: collision with root package name */
    public final zzebp f30747c;

    public zzfai(zzgyw zzgywVar, Context context, zzebp zzebpVar) {
        this.f30745a = zzgywVar;
        this.f30746b = context;
        this.f30747c = zzebpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30745a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfah
            /* JADX WARN: Removed duplicated region for block: B:29:0x0121  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x012e  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x018f  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x01c9  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x01f9  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x01fe  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x0201  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x0209  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:77:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object call() {
                /*
                    Method dump skipped, instructions count: 546
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfah.call():java.lang.Object");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 38;
    }
}
