package com.google.android.gms.internal.atv_ads_framework;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
final class zzeg implements zzez {

    /* renamed from: b, reason: collision with root package name */
    public static final zzee f36149b = new zzee();

    /* renamed from: a, reason: collision with root package name */
    public final zzef f36150a;

    public zzeg() {
        zzem zzemVar;
        try {
            zzemVar = (zzem) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzemVar = f36149b;
        }
        zzef zzefVar = new zzef(zzde.f36119a, zzemVar);
        Charset charset = zzdp.f36125a;
        this.f36150a = zzefVar;
    }
}
