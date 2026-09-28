package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzepr extends com.google.android.gms.ads.internal.client.zzbs {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30062a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclg f30063b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfij f30064c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdnv f30065d;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzbk f30066e;

    public zzepr(zzclg zzclgVar, Context context, String str) {
        zzfij zzfijVar = new zzfij();
        this.f30064c = zzfijVar;
        this.f30065d = new zzdnv();
        this.f30063b = zzclgVar;
        zzfijVar.f31202c = str;
        this.f30062a = context;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void A8(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.f30064c.w = zzcsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void F8(AdManagerAdViewOptions adManagerAdViewOptions) {
        zzfij zzfijVar = this.f30064c;
        zzfijVar.f31209j = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            zzfijVar.f31204e = adManagerAdViewOptions.f21044a;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void Ob(zzbpy zzbpyVar) {
        zzfij zzfijVar = this.f30064c;
        zzfijVar.n = zzbpyVar;
        zzfijVar.f31203d = new com.google.android.gms.ads.internal.client.zzga(false, true, false);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void P8(zzbjn zzbjnVar) {
        this.f30064c.f31207h = zzbjnVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void S8(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.f30066e = zzbkVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void U6(zzbkw zzbkwVar) {
        this.f30065d.f28051b = zzbkwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void f4(PublisherAdViewOptions publisherAdViewOptions) {
        zzfij zzfijVar = this.f30064c;
        zzfijVar.f31210k = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            zzfijVar.f31204e = publisherAdViewOptions.f21059a;
            zzfijVar.f31211l = publisherAdViewOptions.f21060b;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void i3(String str, zzblf zzblfVar, zzblc zzblcVar) {
        zzdnv zzdnvVar = this.f30065d;
        zzdnvVar.f28055f.put(str, zzblfVar);
        if (zzblcVar != null) {
            zzdnvVar.f28056g.put(str, zzblcVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void jb(zzblj zzbljVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.f30065d.f28053d = zzbljVar;
        this.f30064c.f31201b = zzrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void l5(zzbkz zzbkzVar) {
        this.f30065d.f28050a = zzbkzVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void ob(zzblm zzblmVar) {
        this.f30065d.f28052c = zzblmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void y1(zzbqh zzbqhVar) {
        this.f30065d.f28054e = zzbqhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final com.google.android.gms.ads.internal.client.zzbq zze() {
        zzdnv zzdnvVar = this.f30065d;
        zzdnvVar.getClass();
        zzdnw zzdnwVar = new zzdnw(zzdnvVar);
        ArrayList arrayList = new ArrayList();
        if (zzdnwVar.f28060c != null) {
            arrayList.add(Integer.toString(6));
        }
        if (zzdnwVar.f28058a != null) {
            arrayList.add(Integer.toString(1));
        }
        if (zzdnwVar.f28059b != null) {
            arrayList.add(Integer.toString(2));
        }
        SimpleArrayMap simpleArrayMap = zzdnwVar.f28063f;
        if (!simpleArrayMap.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (zzdnwVar.f28062e != null) {
            arrayList.add(Integer.toString(7));
        }
        zzfij zzfijVar = this.f30064c;
        zzfijVar.f31205f = arrayList;
        ArrayList arrayList2 = new ArrayList(simpleArrayMap.f1605c);
        for (int i2 = 0; i2 < simpleArrayMap.f1605c; i2++) {
            arrayList2.add((String) simpleArrayMap.f(i2));
        }
        zzfijVar.f31206g = arrayList2;
        if (zzfijVar.f31201b == null) {
            zzfijVar.f31201b = com.google.android.gms.ads.internal.client.zzr.b();
        }
        com.google.android.gms.ads.internal.client.zzbk zzbkVar = this.f30066e;
        return new zzeps(this.f30062a, this.f30063b, zzfijVar, zzdnwVar, zzbkVar);
    }
}
