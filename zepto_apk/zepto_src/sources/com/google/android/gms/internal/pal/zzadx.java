package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
final class zzadx implements zzaes {

    /* renamed from: b, reason: collision with root package name */
    public static final zzadv f37433b = new zzadv();

    /* renamed from: a, reason: collision with root package name */
    public final zzadw f37434a;

    public zzadx() {
        zzaed zzaedVar;
        try {
            zzaedVar = (zzaed) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzaedVar = f37433b;
        }
        zzadw zzadwVar = new zzadw(zzacu.f37403a, zzaedVar);
        Charset charset = zzadg.f37410a;
        this.f37434a = zzadwVar;
    }
}
