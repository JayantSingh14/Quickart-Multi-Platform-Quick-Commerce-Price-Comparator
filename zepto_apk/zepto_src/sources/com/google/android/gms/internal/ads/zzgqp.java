package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgqp {

    /* renamed from: a, reason: collision with root package name */
    public final zzgqo f33081a;

    public zzgqp(zzgqo zzgqoVar) {
        this.f33081a = zzgqoVar;
    }

    public static zzgqp a(final zzgpo zzgpoVar) {
        return new zzgqp(new zzgqo() { // from class: com.google.android.gms.internal.ads.zzgqm
            @Override // com.google.android.gms.internal.ads.zzgqo
            public final /* synthetic */ Iterator a(zzgqp zzgqpVar, CharSequence charSequence) {
                return new zzgqg(charSequence, zzgpoVar);
            }
        });
    }

    public static zzgqp b() {
        return new zzgqp(new zzgql());
    }

    public final Iterable c(String str) {
        str.getClass();
        return new zzgqj(this, str);
    }

    public final List d(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itA = this.f33081a.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itA.hasNext()) {
            arrayList.add((String) itA.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
