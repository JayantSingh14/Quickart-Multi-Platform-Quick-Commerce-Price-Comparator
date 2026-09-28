package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzyh {

    /* renamed from: d, reason: collision with root package name */
    public static final zzyh f35904d = new zzyh(new zzbg[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int f35905a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgtd f35906b;

    /* renamed from: c, reason: collision with root package name */
    public int f35907c;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
    }

    public zzyh(zzbg... zzbgVarArr) {
        this.f35906b = zzgtd.s(zzbgVarArr);
        this.f35905a = zzbgVarArr.length;
        int i2 = 0;
        while (i2 < this.f35906b.size()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f35906b.size(); i4++) {
                if (((zzbg) this.f35906b.get(i2)).equals(this.f35906b.get(i4))) {
                    zzee.f("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i3;
        }
    }

    public final zzbg a(int i2) {
        return (zzbg) ((zzguy) this.f35906b).get(i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzyh.class == obj.getClass()) {
            zzyh zzyhVar = (zzyh) obj;
            if (this.f35905a == zzyhVar.f35905a && this.f35906b.equals(zzyhVar.f35906b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f35907c;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = this.f35906b.hashCode();
        this.f35907c = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        return this.f35906b.toString();
    }
}
