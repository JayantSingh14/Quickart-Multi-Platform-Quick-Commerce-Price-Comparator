package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzeyr implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30595a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30596b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f30597c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f30598d;

    public zzeyr(Context context, zzgyw zzgywVar, zzfik zzfikVar, VersionInfoParcel versionInfoParcel) {
        this.f30595a = context;
        this.f30596b = zzgywVar;
        this.f30597c = zzfikVar;
        this.f30598d = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30596b).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyq
            /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[Catch: IOException -> 0x0032, TryCatch #1 {IOException -> 0x0032, blocks: (B:3:0x0005, B:5:0x001a, B:7:0x002c, B:12:0x0037, B:17:0x005d, B:18:0x0081, B:20:0x0093, B:22:0x00a7, B:24:0x00b0, B:29:0x00d2, B:31:0x00ee, B:32:0x0111, B:40:0x0122, B:41:0x0127, B:49:0x013c, B:47:0x0138, B:38:0x0120, B:27:0x00c2, B:15:0x004b, B:42:0x0128, B:43:0x0132, B:33:0x0112, B:34:0x011c), top: B:55:0x0005, inners: #0, #2 }] */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00d2 A[Catch: IOException -> 0x0032, TryCatch #1 {IOException -> 0x0032, blocks: (B:3:0x0005, B:5:0x001a, B:7:0x002c, B:12:0x0037, B:17:0x005d, B:18:0x0081, B:20:0x0093, B:22:0x00a7, B:24:0x00b0, B:29:0x00d2, B:31:0x00ee, B:32:0x0111, B:40:0x0122, B:41:0x0127, B:49:0x013c, B:47:0x0138, B:38:0x0120, B:27:0x00c2, B:15:0x004b, B:42:0x0128, B:43:0x0132, B:33:0x0112, B:34:0x011c), top: B:55:0x0005, inners: #0, #2 }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object call() {
                /*
                    Method dump skipped, instructions count: 344
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyq.call():java.lang.Object");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 53;
    }
}
