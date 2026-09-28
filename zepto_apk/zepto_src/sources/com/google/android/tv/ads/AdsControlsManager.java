package com.google.android.tv.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.internal.atv_ads_framework.zzad;
import com.google.android.gms.internal.atv_ads_framework.zzm;
import com.google.android.gms.internal.atv_ads_framework.zzn;
import com.google.android.tv.ads.controls.FallbackImageActivity;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class AdsControlsManager {

    /* renamed from: a, reason: collision with root package name */
    public final Context f42209a;

    public AdsControlsManager(Context context) {
        context.getClass();
        this.f42209a = context;
    }

    public final void a(IconClickFallbackImages iconClickFallbackImages) {
        String strE;
        String queryParameter;
        iconClickFallbackImages.getClass();
        Iterator it = iconClickFallbackImages.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                strE = null;
                break;
            }
            IconClickFallbackImage iconClickFallbackImage = (IconClickFallbackImage) it.next();
            String strE2 = iconClickFallbackImage.e();
            if (strE2 != null && (queryParameter = Uri.parse(strE2).getQueryParameter("atvatc")) != null && queryParameter.equals("1")) {
                strE = iconClickFallbackImage.e();
                break;
            }
        }
        Context context = this.f42209a;
        if (strE == null) {
            if (!iconClickFallbackImages.b().isEmpty()) {
                context.startActivity(new Intent().setClassName(context.getPackageName(), FallbackImageActivity.class.getName()).setFlags(268435456).putExtra("icon_click_fallback_images", iconClickFallbackImages));
                return;
            }
            com.google.android.gms.internal.atv_ads_framework.zzf zzfVarA = com.google.android.gms.internal.atv_ads_framework.zzf.a(context);
            zzm zzmVarK = zzn.k();
            zzmVarK.e();
            zzmVarK.g(2);
            zzmVarK.f(6);
            zzfVarA.b((zzn) zzmVarK.b());
            b();
            return;
        }
        try {
            Intent intentPutExtra = new Intent().setAction("com.google.android.tv.ads.intent.action.LAUNCH_ATC_MENU").setFlags(268435456).putExtra("extra_atc_uri", strE).putExtra("extra_publisher_package", context.getPackageName());
            int iOrdinal = zzad.a(context).ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    com.google.android.gms.internal.atv_ads_framework.zzf zzfVarA2 = com.google.android.gms.internal.atv_ads_framework.zzf.a(context);
                    zzm zzmVarK2 = zzn.k();
                    zzmVarK2.e();
                    zzmVarK2.g(3);
                    zzfVarA2.b((zzn) zzmVarK2.b());
                    context.startActivity(intentPutExtra.setPackage("com.google.android.apps.tv.launcherx"));
                    return;
                }
                if (iOrdinal != 2) {
                    if (iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5) {
                        com.google.android.gms.internal.atv_ads_framework.zzf zzfVarA3 = com.google.android.gms.internal.atv_ads_framework.zzf.a(context);
                        zzm zzmVarK3 = zzn.k();
                        zzmVarK3.e();
                        zzmVarK3.g(3);
                        zzmVarK3.f(3);
                        zzfVarA3.b((zzn) zzmVarK3.b());
                        b();
                        return;
                    }
                    return;
                }
            }
            com.google.android.gms.internal.atv_ads_framework.zzf zzfVarA4 = com.google.android.gms.internal.atv_ads_framework.zzf.a(context);
            zzm zzmVarK4 = zzn.k();
            zzmVarK4.e();
            zzmVarK4.g(3);
            zzfVarA4.b((zzn) zzmVarK4.b());
            context.startActivity(intentPutExtra.setPackage("com.google.android.tvrecommendations"));
        } catch (ActivityNotFoundException unused) {
            com.google.android.gms.internal.atv_ads_framework.zzf zzfVarA5 = com.google.android.gms.internal.atv_ads_framework.zzf.a(context);
            zzm zzmVarK5 = zzn.k();
            zzmVarK5.e();
            zzmVarK5.g(3);
            zzmVarK5.f(2);
            zzfVarA5.b((zzn) zzmVarK5.b());
            b();
        }
    }

    public final void b() {
        Intent intent = new Intent();
        Context context = this.f42209a;
        context.startActivity(intent.setClassName(context.getPackageName(), FallbackImageActivity.class.getName()).setFlags(268435456).putExtra("render_error_message", true));
    }
}
