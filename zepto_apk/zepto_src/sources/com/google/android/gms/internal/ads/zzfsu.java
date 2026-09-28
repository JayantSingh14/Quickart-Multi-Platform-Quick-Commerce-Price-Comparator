package com.google.android.gms.internal.ads;

import android.view.View;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfsu implements zzfsr {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f31809a = new int[2];

    public final JSONObject a(View view) {
        if (view == null) {
            return zzftb.a(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr = this.f31809a;
        view.getLocationOnScreen(iArr);
        return zzftb.a(iArr[0], iArr[1], width, height);
    }
}
