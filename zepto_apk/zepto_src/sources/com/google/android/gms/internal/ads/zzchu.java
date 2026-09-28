package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* loaded from: classes4.dex */
final /* synthetic */ class zzchu implements zzmn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzchz f26297a;

    public /* synthetic */ zzchu(zzchz zzchzVar) {
        this.f26297a = zzchzVar;
    }

    public final zzmi[] a(Handler handler, zzadg zzadgVar, zzqy zzqyVar) {
        zzchz zzchzVar = this.f26297a;
        zzchzVar.getClass();
        zzus zzusVar = zzus.f35671a;
        zzur zzurVar = zzur.f35670b;
        Context context = zzchzVar.f26303c;
        zzsl zzslVar = new zzsl(context);
        zzgqa.f(!zzslVar.f35516c);
        zzslVar.f35516c = true;
        if (zzslVar.f35519f == null) {
            zzslVar.f35519f = new zzsn(new zzco[0]);
        }
        if (zzslVar.f35518e == null) {
            if (zzslVar.f35520g == null) {
                zzslVar.f35520g = new zzsi(context);
            }
            if (zzslVar.f35517d == null) {
                zzslVar.f35517d = zzsk.f35513a;
            }
            zzsc zzscVar = new zzsc(context);
            zzpp zzppVar = context != null ? null : zzslVar.f35515b;
            Context context2 = zzscVar.f35481a;
            if (context2 == null) {
                zzscVar.f35482b = zzppVar;
            }
            zzsi zzsiVar = zzslVar.f35520g;
            zzscVar.f35483c = zzsiVar;
            if (zzsiVar == null) {
                zzscVar.f35483c = new zzsi(context2);
            }
            zzslVar.f35518e = new zzse(zzscVar);
        } else {
            zzgqa.f(zzslVar.f35520g == null);
            zzgqa.f(zzslVar.f35517d == null);
        }
        zzsw zzswVar = new zzsw(context, new zzty(context), handler, zzqyVar, new zzss(zzslVar));
        zzabu zzabuVar = new zzabu(context);
        zzabuVar.f22679c = zzurVar;
        zzabuVar.f22681e = handler;
        zzabuVar.f22682f = zzadgVar;
        zzgqa.f(!zzabuVar.f22678b);
        Handler handler2 = zzabuVar.f22681e;
        zzgqa.f((handler2 == null && zzabuVar.f22682f == null) || !(handler2 == null || zzabuVar.f22682f == null));
        zzabuVar.f22678b = true;
        return new zzmi[]{zzswVar, new zzabw(zzabuVar)};
    }
}
