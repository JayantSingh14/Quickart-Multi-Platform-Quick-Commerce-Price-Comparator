package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* loaded from: classes4.dex */
final class zzaso implements zzasf {

    /* renamed from: a, reason: collision with root package name */
    public File f24282a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f24283b;

    public zzaso(Context context) {
        this.f24283b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzasf
    public final File zza() {
        if (this.f24282a == null) {
            this.f24282a = new File(this.f24283b.getCacheDir(), "volley");
        }
        return this.f24282a;
    }
}
