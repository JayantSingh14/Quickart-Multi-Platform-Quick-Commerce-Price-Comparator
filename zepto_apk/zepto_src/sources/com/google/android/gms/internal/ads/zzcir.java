package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public interface zzcir extends com.google.android.gms.ads.internal.client.zza, zzdir, zzcii, zzbqj, zzcjy, zzckd, zzbqv, zzbck, zzckh, com.google.android.gms.ads.internal.zzn, zzckk, zzckl, zzcfk, zzckm {
    com.google.android.gms.ads.internal.overlay.zzm A();

    boolean B();

    void B0();

    zzfio C();

    void C0(boolean z);

    boolean D();

    zzbjl E();

    boolean G();

    void H();

    zzbdx I();

    ListenableFuture J();

    void K(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    zzejb L();

    void M(String str, String str2);

    void N(Context context);

    Context O();

    void Q(boolean z);

    void U(zzfhr zzfhrVar, zzfhu zzfhuVar);

    void V(int i2);

    void W(zzclb zzclbVar);

    boolean X(int i2, boolean z);

    void Z(boolean z);

    void b0(zzeiz zzeizVar);

    void c0(String str, Predicate predicate);

    boolean canGoBack();

    @Override // com.google.android.gms.internal.ads.zzckk
    zzayq d();

    void d0();

    void destroy();

    @Override // com.google.android.gms.internal.ads.zzcjy
    zzfhu e();

    zzcjc e0();

    void f0(boolean z);

    void g0(boolean z);

    @Override // com.google.android.gms.internal.ads.zzckd, com.google.android.gms.internal.ads.zzcfk
    Context getContext();

    ViewGroup.LayoutParams getLayoutParams();

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void h0(String str, zzbnn zzbnnVar);

    void i();

    boolean isAttachedToWindow();

    void j0(int i2);

    WebView k();

    void k0(String str, zzbnn zzbnnVar);

    void l();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    boolean n();

    void n0(zzbjl zzbjlVar);

    void o();

    void o0(zzdrr zzdrrVar);

    void onPause();

    void onResume();

    void p();

    void p0(boolean z);

    zzeiz q();

    void q0(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    boolean r();

    void r0(zzejb zzejbVar);

    boolean s();

    @Override // com.google.android.gms.internal.ads.zzcfk
    void setBackgroundColor(int i2);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void u();

    @Override // com.google.android.gms.internal.ads.zzcii
    zzfhr v();

    ArrayList w();

    @Override // com.google.android.gms.internal.ads.zzckm
    View x();

    void y0(zzbdx zzbdxVar);

    com.google.android.gms.ads.internal.overlay.zzm z();

    @Override // com.google.android.gms.internal.ads.zzckj
    zzclb zzN();

    String zzO();

    @Override // com.google.android.gms.internal.ads.zzcfk
    zzcjx zzh();

    @Override // com.google.android.gms.internal.ads.zzcfk
    Activity zzj();

    @Override // com.google.android.gms.internal.ads.zzcfk
    com.google.android.gms.ads.internal.zza zzk();

    @Override // com.google.android.gms.internal.ads.zzcfk
    zzbgx zzq();

    @Override // com.google.android.gms.internal.ads.zzckl, com.google.android.gms.internal.ads.zzcfk
    VersionInfoParcel zzs();
}
