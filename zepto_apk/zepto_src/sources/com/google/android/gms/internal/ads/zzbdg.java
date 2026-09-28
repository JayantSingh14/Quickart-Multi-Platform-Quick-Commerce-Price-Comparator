package com.google.android.gms.internal.ads;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzbdg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f24773a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbdk f24774b;

    public zzbdg(zzbdk zzbdkVar, View view) {
        this.f24773a = view;
        this.f24774b = zzbdkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Application application;
        zzbdk zzbdkVar = this.f24774b;
        View view = this.f24773a;
        zzbdkVar.getClass();
        try {
            zzbda zzbdaVar = new zzbda(zzbdkVar.f24789f, zzbdkVar.f24790g, zzbdkVar.f24791h, zzbdkVar.f24792i, zzbdkVar.f24793j, zzbdkVar.f24794k, zzbdkVar.f24795l, zzbdkVar.o);
            zzbdf zzbdfVar = com.google.android.gms.ads.internal.zzt.C.f21683g;
            synchronized (zzbdfVar.f24770a) {
                zzbdd zzbddVar = zzbdfVar.f24771b;
                application = zzbddVar != null ? zzbddVar.f24761b : null;
            }
            if (application != null) {
                String str = zzbdkVar.f24796m;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) view.getTag(application.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.u0), CLConstants.SHARED_PREFERENCE_ITEM_ID, application.getPackageName()));
                    if (str2 != null && str2.equals(str)) {
                        return;
                    }
                }
            }
            zzbdj zzbdjVarA = zzbdkVar.a(view, zzbdaVar);
            zzbdaVar.b();
            if (zzbdjVarA.f24782a == 0 && zzbdjVarA.f24783b == 0) {
                return;
            }
            int i2 = zzbdjVarA.f24783b;
            if (i2 != 0) {
                if (i2 == 0) {
                }
                zzbdkVar.f24787d.b(zzbdaVar);
            } else if (zzbdaVar.f24753k == 0) {
                return;
            }
            zzbdb zzbdbVar = zzbdkVar.f24787d;
            synchronized (zzbdbVar.f24756a) {
                try {
                    if (zzbdbVar.f24758c.contains(zzbdaVar)) {
                        return;
                    }
                    zzbdkVar.f24787d.b(zzbdaVar);
                } finally {
                }
            }
        } catch (Exception e2) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception in fetchContentOnUIThread", e2);
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("ContentFetchTask.fetchContent", e2);
        }
    }
}
