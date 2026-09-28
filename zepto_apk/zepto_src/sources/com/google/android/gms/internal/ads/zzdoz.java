package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzdoz {

    /* renamed from: a, reason: collision with root package name */
    public final zzdua f28140a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdsp f28141b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcsh f28142c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdmg f28143d;

    public zzdoz(zzdua zzduaVar, zzdsp zzdspVar, zzcsh zzcshVar, zzdmg zzdmgVar) {
        this.f28140a = zzduaVar;
        this.f28141b = zzdspVar;
        this.f28142c = zzcshVar;
        this.f28143d = zzdmgVar;
    }

    public final View a() throws zzcjg {
        zzcir zzcirVarA = this.f28140a.a(com.google.android.gms.ads.internal.client.zzr.b(), null, null);
        zzcirVarA.x().setVisibility(8);
        zzcirVarA.k0("/sendMessageToSdk", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdoy
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final /* synthetic */ void a(Object obj, Map map) {
                this.f28139a.f28141b.d(map);
            }
        });
        zzcirVarA.k0("/adMuted", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdot
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final /* synthetic */ void a(Object obj, Map map) {
                this.f28133a.f28143d.j();
            }
        });
        WeakReference weakReference = new WeakReference(zzcirVarA);
        zzbnn zzbnnVar = new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdou
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final void a(Object obj, final Map map) {
                zzcir zzcirVar = (zzcir) obj;
                zzcjc zzcjcVarE0 = zzcirVar.e0();
                final zzdoz zzdozVar = this.f28134a;
                zzcjcVarE0.f26375g = new zzckn() { // from class: com.google.android.gms.internal.ads.zzdox
                    @Override // com.google.android.gms.internal.ads.zzckn
                    public final /* synthetic */ void a(String str, int i2, String str2, boolean z) {
                        zzdoz zzdozVar2 = zzdozVar;
                        zzdozVar2.getClass();
                        HashMap map2 = new HashMap();
                        map2.put("messageType", "htmlLoaded");
                        map2.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, (String) map.get(CLConstants.SHARED_PREFERENCE_ITEM_ID));
                        zzdozVar2.f28141b.d(map2);
                    }
                };
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcirVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcirVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        };
        zzdsp zzdspVar = this.f28141b;
        zzdspVar.b("/loadHtml", new zzdso(zzdspVar, weakReference, "/loadHtml", zzbnnVar));
        zzdspVar.b("/showOverlay", new zzdso(zzdspVar, new WeakReference(zzcirVarA), "/showOverlay", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdov
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final void a(Object obj, Map map) {
                zzdoz zzdozVar = this.f28135a;
                zzdozVar.getClass();
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.e("Showing native ads overlay.");
                ((zzcir) obj).x().setVisibility(0);
                zzdozVar.f28142c.f27055f = true;
            }
        }));
        zzdspVar.b("/hideOverlay", new zzdso(zzdspVar, new WeakReference(zzcirVarA), "/hideOverlay", new zzbnn() { // from class: com.google.android.gms.internal.ads.zzdow
            @Override // com.google.android.gms.internal.ads.zzbnn
            public final void a(Object obj, Map map) {
                zzdoz zzdozVar = this.f28136a;
                zzdozVar.getClass();
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.e("Hiding native ads overlay.");
                ((zzcir) obj).x().setVisibility(8);
                zzdozVar.f28142c.f27055f = false;
            }
        }));
        return zzcirVarA.x();
    }
}
