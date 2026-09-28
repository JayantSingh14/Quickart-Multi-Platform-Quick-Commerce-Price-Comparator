package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
final class zzva implements ParameterizedType, Serializable {
    private final Type zza;
    private final Type zzb;
    private final Type[] zzc;

    public zzva(Type type, Type type2, Type... typeArr) {
        Objects.requireNonNull(type2);
        if (type == null && (type2 instanceof Class)) {
            Class cls = (Class) type2;
            if (!Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
                throw new IllegalArgumentException("Must specify owner type for ".concat(String.valueOf(type2)));
            }
        }
        this.zza = type == null ? null : zzvc.zzc(type);
        this.zzb = zzvc.zzc(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.zzc = typeArr2;
        int length = typeArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            Objects.requireNonNull(this.zzc[i2]);
            zzvc.zzf(this.zzc[i2]);
            Type[] typeArr3 = this.zzc;
            typeArr3[i2] = zzvc.zzc(typeArr3[i2]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && zzvc.zzg(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.zzc.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.zza;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.zzb;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ Arrays.hashCode(this.zzc);
        Type type = this.zza;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        int length = this.zzc.length;
        if (length == 0) {
            return zzvc.zzb(this.zzb);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(zzvc.zzb(this.zzb));
        sb.append("<");
        sb.append(zzvc.zzb(this.zzc[0]));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(", ");
            sb.append(zzvc.zzb(this.zzc[i2]));
        }
        sb.append(">");
        return sb.toString();
    }
}
