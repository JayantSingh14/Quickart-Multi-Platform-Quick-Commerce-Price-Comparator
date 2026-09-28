package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.os.Build;
import android.util.SparseArray;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzpp {

    /* renamed from: c, reason: collision with root package name */
    public static final zzpp f35332c = new zzpp(zzgtd.n(zzpo.f35328d));

    /* renamed from: d, reason: collision with root package name */
    public static final zzgtd f35333d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzgtg f35334e;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f35335a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final int f35336b;

    static {
        Object[] objArr = {2, 5, 6};
        zzguw.a(3, objArr);
        f35333d = zzgtd.t(3, objArr);
        zzgtf zzgtfVar = new zzgtf();
        zzgtfVar.a(5, 6);
        zzgtfVar.a(17, 6);
        zzgtfVar.a(7, 6);
        zzgtfVar.a(30, 10);
        zzgtfVar.a(18, 6);
        zzgtfVar.a(6, 8);
        zzgtfVar.a(8, 8);
        zzgtfVar.a(14, 8);
        f35334e = zzgtfVar.d(true);
    }

    public zzpp(List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzpo zzpoVar = (zzpo) list.get(i2);
            this.f35335a.put(zzpoVar.f35329a, zzpoVar);
        }
        int iMax = 0;
        for (int i3 = 0; i3 < this.f35335a.size(); i3++) {
            iMax = Math.max(iMax, ((zzpo) this.f35335a.valueAt(i3)).f35330b);
        }
        this.f35336b = iMax;
    }

    public static zzpp a(Context context, zzd zzdVar, AudioDeviceInfo audioDeviceInfo) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzdVar, audioDeviceInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzpp b(android.content.Context r12, android.content.Intent r13, com.google.android.gms.internal.ads.zzd r14, android.media.AudioDeviceInfo r15) {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpp.b(android.content.Context, android.content.Intent, com.google.android.gms.internal.ads.zzd, android.media.AudioDeviceInfo):com.google.android.gms.internal.ads.zzpp");
    }

    public static zzgtd d(int i2, int[] iArr) {
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgta zzgtaVar = new zzgta();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i3 : iArr) {
            zzgtaVar.c(new zzpo(i3, i2));
        }
        return zzgtaVar.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[PHI: r2
      0x003f: PHI (r2v3 int) = (r2v2 int), (r2v6 int) binds: [B:11:0x0033, B:14:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair c(com.google.android.gms.internal.ads.zzv r17, com.google.android.gms.internal.ads.zzd r18) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpp.c(com.google.android.gms.internal.ads.zzv, com.google.android.gms.internal.ads.zzd):android.util.Pair");
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof zzpp) {
                zzpp zzppVar = (zzpp) obj;
                SparseArray sparseArray = this.f35335a;
                SparseArray sparseArray2 = zzppVar.f35335a;
                String str = zzfj.f31254a;
                if (Build.VERSION.SDK_INT < 31) {
                    int size = sparseArray.size();
                    if (size == sparseArray2.size()) {
                        for (int i2 = 0; i2 < size; i2++) {
                            if (!Objects.equals(sparseArray.valueAt(i2), sparseArray2.get(sparseArray.keyAt(i2)))) {
                                break;
                            }
                        }
                        if (this.f35336b != zzppVar.f35336b) {
                            break;
                        }
                    }
                } else if (sparseArray.contentEquals(sparseArray2)) {
                    if (this.f35336b != zzppVar.f35336b) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzfj.f31254a;
        int i2 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.f35335a;
        if (i2 >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iHashCode = 17;
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                iHashCode = Objects.hashCode(sparseArray.valueAt(i3)) + ((sparseArray.keyAt(i3) + (iHashCode * 31)) * 31);
            }
            iContentHashCode = iHashCode;
        }
        return (iContentHashCode * 31) + this.f35336b;
    }

    public final String toString() {
        String string = this.f35335a.toString();
        int i2 = this.f35336b;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 50 + string.length() + 1);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i2);
        sb.append(", audioProfiles=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
