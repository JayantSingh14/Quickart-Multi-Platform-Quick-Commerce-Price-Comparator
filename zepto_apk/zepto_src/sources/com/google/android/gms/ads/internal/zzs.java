package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbzs;
import java.util.Iterator;
import java.util.TreeMap;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzs extends zzbw {

    /* renamed from: a, reason: collision with root package name */
    public final VersionInfoParcel f21670a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f21671b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f21672c;

    /* renamed from: d, reason: collision with root package name */
    public final zzr f21673d;

    /* renamed from: e, reason: collision with root package name */
    public WebView f21674e;

    /* renamed from: f, reason: collision with root package name */
    public zzbk f21675f;

    /* renamed from: g, reason: collision with root package name */
    public AsyncTask f21676g;

    public zzs(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, VersionInfoParcel versionInfoParcel) {
        this.f21672c = context;
        this.f21670a = versionInfoParcel;
        this.f21671b = zzrVar;
        this.f21674e = new WebView(context);
        this.f21673d = new zzr(context, str);
        Xb(0);
        this.f21674e.setVerticalScrollBarEnabled(false);
        this.f21674e.getSettings().setJavaScriptEnabled(true);
        this.f21674e.setWebViewClient(new zzo(this));
        this.f21674e.setOnTouchListener(new zzp());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void B7(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void C0(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Ga(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean H() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void J6(zzco zzcoVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long L() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Q4(zzbk zzbkVar) {
        this.f21675f = zzbkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean U0(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        TreeMap treeMap;
        Preconditions.checkNotNull(this.f21674e, "This Search Ad has already been torn down");
        zzr zzrVar = this.f21673d;
        zzrVar.getClass();
        zzrVar.f21667d = zzmVar.f21263j.f21245a;
        Bundle bundle = zzmVar.f21266m;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 != null) {
            String str = (String) zzbhw.f25102c.c();
            Iterator<String> it = bundle2.keySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                treeMap = zzrVar.f21666c;
                if (!zHasNext) {
                    break;
                }
                String next = it.next();
                if (str.equals(next)) {
                    zzrVar.f21668e = bundle2.getString(next);
                } else if (next.startsWith("csa_")) {
                    treeMap.put(next.substring(4), bundle2.getString(next));
                }
            }
            treeMap.put("SDKVersion", this.f21670a.f21400a);
            if (((Boolean) zzbhw.f25100a.c()).booleanValue()) {
                Bundle bundleB = zzac.b(zzrVar.f21664a, (String) zzbhw.f25101b.c());
                for (String str2 : bundleB.keySet()) {
                    treeMap.put(str2, bundleB.get(str2).toString());
                }
            }
        }
        this.f21676g = new zzq(this).execute(new Void[0]);
        return true;
    }

    public final void Xb(int i2) {
        if (this.f21674e == null) {
            return;
        }
        this.f21674e.setLayoutParams(new ViewGroup.LayoutParams(-1, i2));
    }

    public final String Yb() {
        String str = this.f21673d.f21668e;
        if (true == TextUtils.isEmpty(str)) {
            str = "www.google.com";
        }
        String str2 = (String) zzbhw.f25103d.c();
        return b.s(new StringBuilder(String.valueOf(str).length() + 8 + String.valueOf(str2).length()), "https://", str, str2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void b2(zzbhf zzbhfVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String c() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void c3() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void d8(zzx zzxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void eb(zzga zzgaVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzea f() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzco h() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzbk j() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void j2(long j2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void k6(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void m() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void o8(zzbh zzbhVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void qa(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean t() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void t5(zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzed w() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void w4(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void x() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void xa(zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z2(zzbeg zzbegVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z3(zzcs zzcsVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z8(zzbzs zzbzsVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return new ObjectWrapper(this.f21674e);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.f21676g.cancel(true);
        this.f21674e.destroy();
        this.f21674e = null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zzk() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzl() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzm() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzn() {
        return this.f21671b;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzp() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzq() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzr() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() {
        return null;
    }
}
