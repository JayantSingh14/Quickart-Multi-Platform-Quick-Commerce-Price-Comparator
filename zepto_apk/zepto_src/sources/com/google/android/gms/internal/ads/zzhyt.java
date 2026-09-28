package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhyt;
import com.google.android.gms.internal.ads.zzhyu;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzhyt<MessageType extends zzhyu<MessageType, BuilderType>, BuilderType extends zzhyt<MessageType, BuilderType>> implements zzicb {
    public static void h(int i2, List list) {
        int size = list.size() - i2;
        String strU = androidx.fragment.app.e.u(new StringBuilder(String.valueOf(size).length() + 26), "Element at index ", size, " is null.");
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i2) {
                throw new NullPointerException(strU);
            }
            list.remove(size2);
        }
    }

    @Override // 
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public abstract zzial clone();
}
