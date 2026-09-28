package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
final class zzvv implements zzwl {
    final /* synthetic */ Constructor zza;

    public zzvv(Constructor constructor) {
        this.zza = constructor;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzwl
    public final Object zza() {
        try {
            return this.zza.newInstance(null);
        } catch (IllegalAccessException e2) {
            throw zzaab.zzb(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(b.D("Failed to invoke constructor '", zzaab.zzc(this.zza), "' with no args"), e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(b.D("Failed to invoke constructor '", zzaab.zzc(this.zza), "' with no args"), e4.getCause());
        }
    }
}
