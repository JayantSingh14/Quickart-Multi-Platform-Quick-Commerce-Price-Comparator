package com.google.android.gms.internal.pal;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzri {

    /* renamed from: a, reason: collision with root package name */
    public final zzrb f38047a;

    /* renamed from: b, reason: collision with root package name */
    public final List f38048b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f38049c;

    public /* synthetic */ zzri(zzrb zzrbVar, List list, Integer num) {
        this.f38047a = zzrbVar;
        this.f38048b = list;
        this.f38049c = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzri)) {
            return false;
        }
        zzri zzriVar = (zzri) obj;
        if (this.f38047a.equals(zzriVar.f38047a) && this.f38048b.equals(zzriVar.f38048b)) {
            Integer num = this.f38049c;
            Integer num2 = zzriVar.f38049c;
            if (num == num2) {
                return true;
            }
            if (num != null && num.equals(num2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f38047a, this.f38048b});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.f38047a, this.f38048b, this.f38049c);
    }
}
