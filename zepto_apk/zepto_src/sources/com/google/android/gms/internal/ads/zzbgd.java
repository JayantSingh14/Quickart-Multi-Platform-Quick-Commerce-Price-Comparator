package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public final class zzbgd {
    public static final SharedPreferences a(Context context) {
        try {
            return context.getSharedPreferences("google_ads_flags", 0);
        } catch (IllegalStateException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.g("", e2);
            return null;
        }
    }
}
