package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzgtr {
    public static Object a(Iterable iterable, String str) {
        zzgrb zzgrbVar = (zzgrb) ((zzgvi) iterable).iterator();
        return zzgrbVar.hasNext() ? zzgrbVar.next() : str;
    }

    public static void b(List list, zzgqb zzgqbVar, int i2, int i3) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i3) {
                break;
            } else if (zzgqbVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i3--;
            if (i3 < i2) {
                return;
            } else {
                list.remove(i3);
            }
        }
    }
}
