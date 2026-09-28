package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzag {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f22978a;

    /* renamed from: b, reason: collision with root package name */
    public final List f22979b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgtd f22980c;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    public zzag(Uri uri, List list, zzgtd zzgtdVar) {
        this.f22978a = uri;
        ArrayList arrayList = zzas.f24254a;
        this.f22979b = list;
        this.f22980c = zzgtdVar;
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgta zzgtaVar = new zzgta();
        if (((zzguy) zzgtdVar).f33234d <= 0) {
            zzgtaVar.f();
        } else {
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        return this.f22978a.equals(zzagVar.f22978a) && this.f22979b.equals(zzagVar.f22979b) && this.f22980c.equals(zzagVar.f22980c);
    }

    public final int hashCode() {
        return (int) ((((this.f22980c.hashCode() + androidx.fragment.app.e.f(this.f22978a.hashCode() * 923521, 961, this.f22979b)) * 31) * 31) - Long.MAX_VALUE);
    }
}
