package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbie;
import java.util.Map;

/* loaded from: classes4.dex */
public class CsiUrlBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final String f21968a = (String) zzbie.f25136a.c();

    public final String a(Map map) {
        Uri.Builder builderBuildUpon = Uri.parse(this.f21968a).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }
}
