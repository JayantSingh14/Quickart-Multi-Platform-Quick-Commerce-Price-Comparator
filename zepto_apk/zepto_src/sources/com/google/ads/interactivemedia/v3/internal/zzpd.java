package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public final class zzpd {
    public static int zza(int i2, int i3, String str) {
        String strZzb;
        if (i2 >= 0 && i2 < i3) {
            return i2;
        }
        if (i2 < 0) {
            strZzb = zzpg.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i2));
        } else {
            if (i3 < 0) {
                throw new IllegalArgumentException(b.f(i3, "negative size: "));
            }
            strZzb = zzpg.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i2, int i3, String str) {
        if (i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException(zzh(i2, i3, "index"));
        }
        return i2;
    }

    public static void zzc(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zze(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(zzpg.zzb(str, obj));
        }
    }

    public static void zzf(int i2, int i3, int i4) {
        if (i2 < 0 || i3 < i2 || i3 > i4) {
            throw new IndexOutOfBoundsException((i2 < 0 || i2 > i4) ? zzh(i2, i4, "start index") : (i3 < 0 || i3 > i4) ? zzh(i3, i4, "end index") : zzpg.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    public static void zzg(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzh(int i2, int i3, String str) {
        if (i2 < 0) {
            return zzpg.zzb("%s (%s) must not be negative", str, Integer.valueOf(i2));
        }
        if (i3 >= 0) {
            return zzpg.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
        }
        throw new IllegalArgumentException(b.f(i3, "negative size: "));
    }
}
