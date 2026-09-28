package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes3.dex */
abstract class zzwp {
    public static final zzwp zzb;

    static {
        zzwp zzwmVar = null;
        if (zzvz.zza()) {
            try {
                zzwmVar = new zzwm(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzwmVar == null) {
            zzwmVar = new zzwn();
        }
        zzb = zzwmVar;
    }

    public /* synthetic */ zzwp(zzwo zzwoVar) {
    }

    public abstract boolean zza(AccessibleObject accessibleObject, Object obj);
}
