package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzaeh implements zzaei {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzaeh f22877a = new zzaeh();

    @Override // com.google.android.gms.internal.ads.zzaei
    public final /* synthetic */ Constructor zza() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int[] iArr = zzaek.f22880c;
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzaeo.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
}
