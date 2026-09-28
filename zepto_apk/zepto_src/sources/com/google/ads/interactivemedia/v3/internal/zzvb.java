package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* loaded from: classes3.dex */
final class zzvb implements WildcardType, Serializable {
    private final Type zza;
    private final Type zzb;

    public zzvb(Type[] typeArr, Type[] typeArr2) {
        int length = typeArr2.length;
        zzuy.zza(length <= 1);
        zzuy.zza(typeArr.length == 1);
        if (length != 1) {
            Objects.requireNonNull(typeArr[0]);
            zzvc.zzf(typeArr[0]);
            this.zzb = null;
            this.zza = zzvc.zzc(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        zzvc.zzf(typeArr2[0]);
        zzuy.zza(typeArr[0] == Object.class);
        this.zzb = zzvc.zzc(typeArr2[0]);
        this.zza = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && zzvc.zzg(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.zzb;
        return type != null ? new Type[]{type} : zzvc.zza;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.zza};
    }

    public final int hashCode() {
        Type type = this.zzb;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.zza.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.zzb;
        if (type != null) {
            return "? super ".concat(String.valueOf(zzvc.zzb(type)));
        }
        Type type2 = this.zza;
        return type2 == Object.class ? "?" : "? extends ".concat(String.valueOf(zzvc.zzb(type2)));
    }
}
