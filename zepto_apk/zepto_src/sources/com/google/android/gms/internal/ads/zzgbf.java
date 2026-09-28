package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* loaded from: classes4.dex */
final /* synthetic */ class zzgbf implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgbi f32209a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f32210b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f32211c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f32212d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ byte[] f32213e;

    public /* synthetic */ zzgbf(zzgbi zzgbiVar, String str, boolean z, String str2, byte[] bArr) {
        this.f32209a = zzgbiVar;
        this.f32210b = str;
        this.f32211c = z;
        this.f32212d = str2;
        this.f32213e = bArr;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final /* synthetic */ Object a(final CallbackToFutureAdapter.Completer completer) {
        final zzgbi zzgbiVar = this.f32209a;
        zzgbiVar.getClass();
        final byte[] bArr = this.f32213e;
        final String str = this.f32210b;
        final boolean z = this.f32211c;
        final String str2 = this.f32212d;
        zzgbiVar.f32217a.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgbe
            /* JADX WARN: Removed duplicated region for block: B:77:0x0106  */
            /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 272
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgbe.run():void");
            }
        });
        return "";
    }
}
