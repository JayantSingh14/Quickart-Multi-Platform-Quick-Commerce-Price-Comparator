package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbt;
import com.google.android.gms.internal.ads.zzbyh;
import com.google.android.gms.internal.ads.zzcbk;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21623a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21624b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcbk f21625c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbyh f21626d = new zzbyh(Collections.EMPTY_LIST, false);

    public zzb(Context context, zzcbk zzcbkVar) {
        this.f21623a = context;
        this.f21625c = zzcbkVar;
    }

    public final boolean a() {
        zzcbk zzcbkVar = this.f21625c;
        return ((zzcbkVar == null || !zzcbkVar.zza().f25830f) && !this.f21626d.f25703a) || this.f21624b;
    }

    public final void b(String str) {
        List<String> list;
        zzbyh zzbyhVar = this.f21626d;
        zzcbk zzcbkVar = this.f21625c;
        if ((zzcbkVar == null || !zzcbkVar.zza().f25830f) && !zzbyhVar.f25703a) {
            return;
        }
        if (str == null) {
            str = "";
        }
        if (zzcbkVar != null) {
            zzcbkVar.a(str, null, 3);
            return;
        }
        if (!zzbyhVar.f25703a || (list = zzbyhVar.f25704b) == null) {
            return;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                com.google.android.gms.ads.internal.util.zzs zzsVar = zzt.C.f21679c;
                new zzbt(this.f21623a, "", strReplace, null).b();
            }
        }
    }
}
