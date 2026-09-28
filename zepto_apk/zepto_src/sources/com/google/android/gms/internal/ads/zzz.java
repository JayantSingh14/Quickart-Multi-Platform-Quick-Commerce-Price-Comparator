package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzz {

    /* renamed from: a, reason: collision with root package name */
    public String f35941a;

    /* renamed from: b, reason: collision with root package name */
    public Uri f35942b;

    /* renamed from: c, reason: collision with root package name */
    public final List f35943c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgtd f35944d;

    /* renamed from: e, reason: collision with root package name */
    public final zzai f35945e;

    public zzz() {
        new zzaa();
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgtd zzgtdVar = zzguy.f33232e;
        this.f35943c = Collections.EMPTY_LIST;
        this.f35944d = zzguy.f33232e;
        new zzae();
        this.f35945e = zzai.f23171a;
    }

    public final zzak a() {
        zzag zzagVar;
        Uri uri = this.f35942b;
        if (uri != null) {
            zzagVar = new zzag(uri, this.f35943c, this.f35944d);
        } else {
            zzagVar = null;
        }
        zzag zzagVar2 = zzagVar;
        String str = this.f35941a;
        if (str == null) {
            str = "";
        }
        return new zzak(str, new zzac(), zzagVar2, new zzaf(), zzan.B, this.f35945e);
    }
}
