package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.media.b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
/* loaded from: classes4.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final int f36659a;

    /* renamed from: b, reason: collision with root package name */
    public final int f36660b;

    /* renamed from: c, reason: collision with root package name */
    public final String f36661c;

    /* renamed from: d, reason: collision with root package name */
    public final String f36662d;

    /* renamed from: e, reason: collision with root package name */
    public final int f36663e;

    /* renamed from: f, reason: collision with root package name */
    public final String f36664f;

    /* renamed from: g, reason: collision with root package name */
    public final zzd f36665g;

    /* renamed from: h, reason: collision with root package name */
    public final zzds f36666h;

    static {
        Process.myUid();
        Process.myPid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzd(int i2, int i3, String str, String str2, String str3, int i4, List list, zzd zzdVar) {
        zzdt zzdtVar;
        zzds zzdsVarG;
        this.f36659a = i2;
        this.f36660b = i3;
        this.f36661c = str;
        this.f36662d = str2;
        this.f36664f = str3;
        this.f36663e = i4;
        zzdv zzdvVar = zzds.f36701b;
        if (list instanceof zzdp) {
            zzdsVarG = ((zzdp) list).g();
            if (zzdsVarG.j()) {
                Object[] array = zzdsVarG.toArray(zzdp.f36696a);
                int length = array.length;
                if (length == 0) {
                    zzdsVarG = zzdt.f36702e;
                } else {
                    zzdtVar = new zzdt(array, length);
                    zzdsVarG = zzdtVar;
                }
            }
        } else {
            Object[] array2 = list.toArray();
            int length2 = array2.length;
            for (int i5 = 0; i5 < length2; i5++) {
                if (array2[i5] == null) {
                    throw new NullPointerException(b.f(i5, "at index "));
                }
            }
            if (length2 == 0) {
                zzdsVarG = zzdt.f36702e;
            } else {
                zzdtVar = new zzdt(array2, length2);
                zzdsVarG = zzdtVar;
            }
        }
        this.f36666h = zzdsVarG;
        this.f36665g = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzdVar = (zzd) obj;
        return this.f36659a == zzdVar.f36659a && this.f36660b == zzdVar.f36660b && this.f36663e == zzdVar.f36663e && this.f36661c.equals(zzdVar.f36661c) && zzdl.a(this.f36662d, zzdVar.f36662d) && zzdl.a(this.f36664f, zzdVar.f36664f) && zzdl.a(this.f36665g, zzdVar.f36665g) && this.f36666h.equals(zzdVar.f36666h);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f36659a), this.f36661c, this.f36662d, this.f36664f});
    }

    public final String toString() {
        String str = this.f36661c;
        int length = str.length() + 18;
        String str2 = this.f36662d;
        if (str2 != null) {
            length += str2.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.f36659a);
        sb.append("/");
        sb.append(str);
        if (str2 != null) {
            sb.append("[");
            if (str2.startsWith(str)) {
                sb.append((CharSequence) str2, str.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        String str3 = this.f36664f;
        if (str3 != null) {
            sb.append("/");
            sb.append(Integer.toHexString(str3.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36659a);
        SafeParcelWriter.writeInt(parcel, 2, this.f36660b);
        SafeParcelWriter.writeString(parcel, 3, this.f36661c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f36662d, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f36663e);
        SafeParcelWriter.writeString(parcel, 6, this.f36664f, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f36665g, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 8, this.f36666h, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
