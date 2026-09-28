package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbnl implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzbnl f25336a = new zzbnl();

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* synthetic */ void a(Object obj, Map map) {
        zzckd zzckdVar = (zzckd) obj;
        zzbnn zzbnnVar = zzbnm.f25337a;
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] strArrSplit = str.split(",");
        HashMap map2 = new HashMap();
        PackageManager packageManager = zzckdVar.getContext().getPackageManager();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split(";", 2);
            Boolean boolValueOf = Boolean.valueOf(packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) != null);
            map2.put(str2, boolValueOf);
            StringBuilder sb = new StringBuilder(str2.length() + 14 + boolValueOf.toString().length());
            sb.append("/canOpenURLs;");
            sb.append(str2);
            sb.append(";");
            sb.append(boolValueOf);
            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        }
        ((zzbqj) zzckdVar).g("openableURLs", map2);
    }
}
