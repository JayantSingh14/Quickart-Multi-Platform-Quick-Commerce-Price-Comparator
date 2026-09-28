package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;

/* loaded from: classes3.dex */
public final class zzfl {
    private final Context zza;
    private AdsRenderingSettings zzb;

    public zzfl(Context context, AdsRenderingSettings adsRenderingSettings) {
        this.zza = context;
        this.zzb = adsRenderingSettings;
    }

    public final void zza(AdsRenderingSettings adsRenderingSettings) {
        this.zzb = adsRenderingSettings;
    }

    public final boolean zzb(String str) {
        ResolveInfo resolveInfoResolveActivity = this.zza.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://")), 65536);
        if (resolveInfoResolveActivity == null || resolveInfoResolveActivity.activityInfo == null) {
            zzeo.zza("The click was ignored because no browser was available.");
            return false;
        }
        if (this.zzb.getEnableCustomTabs()) {
            new CustomTabsIntent.Builder().a().a(this.zza, Uri.parse(str));
            return true;
        }
        Context context = this.zza;
        if (str == null || str.length() <= 0) {
            return true;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }
}
