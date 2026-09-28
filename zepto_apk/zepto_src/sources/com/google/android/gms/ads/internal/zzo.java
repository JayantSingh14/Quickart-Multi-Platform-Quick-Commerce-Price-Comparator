package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.internal.ads.zzfjm;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzo extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzs f21662a;

    public zzo(zzs zzsVar) {
        Objects.requireNonNull(zzsVar);
        this.f21662a = zzsVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzs zzsVar = this.f21662a;
        zzbk zzbkVar = zzsVar.f21675f;
        if (zzbkVar != null) {
            try {
                zzbkVar.t0(zzfjm.d(1, null, null));
            } catch (RemoteException e2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
            }
        }
        zzbk zzbkVar2 = zzsVar.f21675f;
        if (zzbkVar2 != null) {
            try {
                zzbkVar2.l(0);
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzs zzsVar = this.f21662a;
        int iB = 0;
        if (str.startsWith(zzsVar.Yb())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzbk zzbkVar = zzsVar.f21675f;
            if (zzbkVar != null) {
                try {
                    zzbkVar.t0(zzfjm.d(3, null, null));
                } catch (RemoteException e2) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
                }
            }
            zzbk zzbkVar2 = zzsVar.f21675f;
            if (zzbkVar2 != null) {
                try {
                    zzbkVar2.l(3);
                } catch (RemoteException e3) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                }
            }
            zzsVar.Xb(0);
            return true;
        }
        if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzbk zzbkVar3 = zzsVar.f21675f;
            if (zzbkVar3 != null) {
                try {
                    zzbkVar3.t0(zzfjm.d(1, null, null));
                } catch (RemoteException e4) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e4);
                }
            }
            zzbk zzbkVar4 = zzsVar.f21675f;
            if (zzbkVar4 != null) {
                try {
                    zzbkVar4.l(0);
                } catch (RemoteException e5) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e5);
                }
            }
            zzsVar.Xb(0);
            return true;
        }
        boolean zStartsWith = str.startsWith("gmsg://adResized");
        Context context = zzsVar.f21672c;
        if (zStartsWith) {
            zzbk zzbkVar5 = zzsVar.f21675f;
            if (zzbkVar5 != null) {
                try {
                    zzbkVar5.zzf();
                } catch (RemoteException e6) {
                    int i6 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e6);
                }
            }
            String queryParameter = Uri.parse(str).getQueryParameter(Snapshot.HEIGHT);
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbb.f21141g.f21142a;
                    iB = com.google.android.gms.ads.internal.util.client.zzf.b(Integer.parseInt(queryParameter), context);
                } catch (NumberFormatException unused) {
                }
            }
            zzsVar.Xb(iB);
            return true;
        }
        if (!str.startsWith("gmsg://")) {
            zzbk zzbkVar6 = zzsVar.f21675f;
            if (zzbkVar6 != null) {
                try {
                    zzbkVar6.zzh();
                    zzsVar.f21675f.zze();
                } catch (RemoteException e7) {
                    int i7 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e7);
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        }
        return true;
    }
}
