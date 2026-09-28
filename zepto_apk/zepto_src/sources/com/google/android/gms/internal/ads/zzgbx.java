package com.google.android.gms.internal.ads;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: classes4.dex */
public final class zzgbx implements zzgby {

    /* renamed from: a, reason: collision with root package name */
    public final zzgcs f32237a;

    public zzgbx(zzgcs zzgcsVar) {
        this.f32237a = zzgcsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgby
    public final Object a(FileInputStream fileInputStream) {
        try {
            zzick zzickVarS = this.f32237a.s();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            return zzickVarS.a(fileInputStream, zziab.f34621c);
        } catch (zzibg e2) {
            throw new zzgbu("Cannot read proto.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgby
    public final /* synthetic */ void b(Object obj, FileOutputStream fileOutputStream) {
        ((zzicc) obj).a(fileOutputStream);
    }

    @Override // com.google.android.gms.internal.ads.zzgby
    public final /* synthetic */ Object zzc() {
        return this.f32237a;
    }
}
