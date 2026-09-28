package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbjk;
import com.google.android.gms.internal.ads.zzbkc;

/* loaded from: classes4.dex */
final /* synthetic */ class zzb implements zzbjk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdView f21742a;

    public final /* synthetic */ void a(MediaContent mediaContent) {
        zzbkc zzbkcVar = this.f21742a.f21740b;
        if (zzbkcVar == null) {
            return;
        }
        try {
            if (mediaContent instanceof zzfe) {
                ((zzfe) mediaContent).getClass();
                zzbkcVar.Tb(null);
            } else if (mediaContent == null) {
                zzbkcVar.Tb(null);
            } else {
                zzo.a("Use MediaContent provided by NativeAd.getMediaContent");
            }
        } catch (RemoteException e2) {
            zzo.d("Unable to call setMediaContent on delegate", e2);
        }
    }
}
