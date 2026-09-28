package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdph {

    /* renamed from: a, reason: collision with root package name */
    public final zzdua f28168a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdsp f28169b;

    /* renamed from: c, reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f28170c = null;

    public zzdph(zzdua zzduaVar, zzdsp zzdspVar) {
        this.f28168a = zzduaVar;
        this.f28169b = zzdspVar;
    }

    public static final int b(Context context, int i2, String str) throws NumberFormatException {
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        return com.google.android.gms.ads.internal.util.client.zzf.b(i2, context);
    }

    public final View a(final FrameLayout frameLayout, final WindowManager windowManager) throws zzcjg {
        zzcir zzcirVarA = this.f28168a.a(com.google.android.gms.ads.internal.client.zzr.b(), null, null);
        zzcirVarA.x().setVisibility(4);
        zzcirVarA.x().setContentDescription("policy_validator");
        zzcirVarA.k0("/sendMessageToSdk", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdpg
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final /* synthetic */ void a(Object obj, Map map) {
                this.f28167a.f28169b.d(map);
            }
        });
        zzcirVarA.k0("/hideValidatorOverlay", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdpb
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final /* synthetic */ void a(Object obj, Map map) {
                zzcir zzcirVar = (zzcir) obj;
                zzdph zzdphVar = this;
                zzdphVar.getClass();
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.a("Hide native ad policy validator overlay.");
                zzcirVar.x().setVisibility(8);
                if (zzcirVar.x().getWindowToken() != null) {
                    windowManager.removeView(zzcirVar.x());
                }
                zzcirVar.destroy();
                ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
                if (zzdphVar.f28170c == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                viewTreeObserver.removeOnScrollChangedListener(zzdphVar.f28170c);
            }
        });
        zzcirVarA.k0("/open", new zzboa(null, null, null, null, null, null));
        WeakReference weakReference = new WeakReference(zzcirVarA);
        zzbnn zzbnnVar = new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdpc
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final void a(Object obj, final Map map) throws NumberFormatException {
                final zzcir zzcirVar = (zzcir) obj;
                final zzdph zzdphVar = this;
                zzdphVar.getClass();
                zzcirVar.e0().f26375g = new zzckn() { // from class: com.google.android.gms.internal.ads.zzdpf
                    @Override // com.google.android.gms.internal.ads.zzckn
                    public final /* synthetic */ void a(String str, int i2, String str2, boolean z) {
                        zzdph zzdphVar2 = zzdphVar;
                        zzdphVar2.getClass();
                        HashMap map2 = new HashMap();
                        map2.put("messageType", "validatorHtmlLoaded");
                        map2.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, (String) map.get(CLConstants.SHARED_PREFERENCE_ITEM_ID));
                        zzdphVar2.f28169b.d(map2);
                    }
                };
                if (map == null) {
                    return;
                }
                final FrameLayout frameLayout2 = frameLayout;
                Context context = frameLayout2.getContext();
                String str = (String) map.get("validator_width");
                zzbgb zzbgbVar = zzbgk.c9;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                int iB = zzdph.b(context, ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue(), str);
                String str2 = (String) map.get("validator_height");
                zzbgb zzbgbVar2 = zzbgk.d9;
                zzbgi zzbgiVar = zzbdVar.f21153c;
                int iB2 = zzdph.b(context, ((Integer) zzbgiVar.a(zzbgbVar2)).intValue(), str2);
                int iB3 = zzdph.b(context, 0, (String) map.get("validator_x"));
                int iB4 = zzdph.b(context, 0, (String) map.get("validator_y"));
                zzcirVar.W(new zzclb(1, iB, iB2));
                try {
                    zzcirVar.k().getSettings().setUseWideViewPort(((Boolean) zzbgiVar.a(zzbgk.e9)).booleanValue());
                    zzcirVar.k().getSettings().setLoadWithOverviewMode(((Boolean) zzbgiVar.a(zzbgk.f9)).booleanValue());
                } catch (NullPointerException unused) {
                }
                final WindowManager.LayoutParams layoutParamsI = com.google.android.gms.ads.internal.util.zzbs.i();
                layoutParamsI.x = iB3;
                layoutParamsI.y = iB4;
                View viewX = zzcirVar.x();
                final WindowManager windowManager2 = windowManager;
                windowManager2.updateViewLayout(viewX, layoutParamsI);
                final String str3 = (String) map.get("orientation");
                Rect rect = new Rect();
                if (frameLayout2.getGlobalVisibleRect(rect)) {
                    final int i2 = (("1".equals(str3) || "2".equals(str3)) ? rect.bottom : rect.top) - iB4;
                    zzdphVar.f28170c = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdpe
                        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                        public final /* synthetic */ void onScrollChanged() {
                            Rect rect2 = new Rect();
                            if (frameLayout2.getGlobalVisibleRect(rect2)) {
                                zzcir zzcirVar2 = zzcirVar;
                                if (zzcirVar2.x().getWindowToken() == null) {
                                    return;
                                }
                                String str4 = str3;
                                boolean zEquals = "1".equals(str4);
                                WindowManager.LayoutParams layoutParams = layoutParamsI;
                                int i3 = i2;
                                if (zEquals || "2".equals(str4)) {
                                    layoutParams.y = rect2.bottom - i3;
                                } else {
                                    layoutParams.y = rect2.top - i3;
                                }
                                windowManager2.updateViewLayout(zzcirVar2.x(), layoutParams);
                            }
                        }
                    };
                    ViewTreeObserver viewTreeObserver = frameLayout2.getViewTreeObserver();
                    if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnScrollChangedListener(zzdphVar.f28170c);
                    }
                }
                String str4 = (String) map.get("overlay_url");
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                zzcirVar.loadUrl(str4);
            }
        };
        zzdsp zzdspVar = this.f28169b;
        zzdspVar.b("/loadNativeAdPolicyViolations", new zzdso(zzdspVar, weakReference, "/loadNativeAdPolicyViolations", zzbnnVar));
        zzdspVar.b("/showValidatorOverlay", new zzdso(zzdspVar, new WeakReference(zzcirVarA), "/showValidatorOverlay", zzdpd.f28158a));
        return zzcirVarA.x();
    }
}
