package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
final class zzxv extends zzxx {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Method zzb;
    final /* synthetic */ zzuu zzc;
    final /* synthetic */ zzuu zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzxv(zzyb zzybVar, String str, Field field, boolean z, Method method, zzuu zzuuVar, zzuu zzuuVar2, boolean z2, boolean z3) {
        super(str, field);
        this.zza = z;
        this.zzb = method;
        this.zzc = zzuuVar;
        this.zzd = zzuuVar2;
        this.zze = z2;
        this.zzf = z3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzxx
    public final void zza(zzaaq zzaaqVar, int i2, Object[] objArr) throws zzug, IOException {
        Object obj = this.zzd.read(zzaaqVar);
        if (obj == null && this.zze) {
            throw new zzug(e.p("null is not allowed as value for record component '", this.zzi, "' of primitive type; at path ", zzaaqVar.zze()));
        }
        objArr[i2] = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzxx
    public final void zzb(zzaaq zzaaqVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
        Object obj2 = this.zzd.read(zzaaqVar);
        if (obj2 == null && this.zze) {
            return;
        }
        if (this.zza) {
            zzyb.zzb(obj, this.zzh);
        } else if (this.zzf) {
            throw new zzud("Cannot set value of 'static final' ".concat(zzaab.zze(this.zzh, false)));
        }
        this.zzh.set(obj, obj2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzxx
    public final void zzc(zzaas zzaasVar, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        if (this.zza) {
            Method method = this.zzb;
            if (method == null) {
                zzyb.zzb(obj, this.zzh);
            } else {
                zzyb.zzb(obj, method);
            }
        }
        Method method2 = this.zzb;
        if (method2 != null) {
            try {
                objInvoke = method2.invoke(obj, null);
            } catch (InvocationTargetException e2) {
                throw new zzud(b.D("Accessor ", zzaab.zze(this.zzb, false), " threw exception"), e2.getCause());
            }
        } else {
            objInvoke = this.zzh.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        zzaasVar.zzf(this.zzg);
        this.zzc.write(zzaasVar, objInvoke);
    }
}
