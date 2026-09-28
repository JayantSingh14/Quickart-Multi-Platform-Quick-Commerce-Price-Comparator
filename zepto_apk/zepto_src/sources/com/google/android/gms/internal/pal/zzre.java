package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzre {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f38041a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public zzrb f38042b = zzrb.f38039b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f38043c = null;

    public final zzri a() throws GeneralSecurityException {
        if (this.f38041a == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        Integer num = this.f38043c;
        if (num != null) {
            int iIntValue = num.intValue();
            ArrayList arrayList = this.f38041a;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                if (((zzrg) arrayList.get(i2)).f38045b != iIntValue) {
                    i2 = i3;
                }
            }
            throw new GeneralSecurityException("primary key ID is not present in entries");
        }
        zzri zzriVar = new zzri(this.f38042b, Collections.unmodifiableList(this.f38041a), this.f38043c);
        this.f38041a = null;
        return zzriVar;
    }
}
