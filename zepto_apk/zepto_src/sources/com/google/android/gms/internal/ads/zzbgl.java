package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbgl {
    public static void a(ArrayList arrayList, zzbhu zzbhuVar) {
        String str = (String) zzbhuVar.c();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        arrayList.add(str);
    }
}
