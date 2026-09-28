package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzgk extends zzma implements zznm {
    public /* synthetic */ zzgk() {
        super(zzgl.zzu);
    }

    public final int o() {
        return ((zzgl) this.f37107b).x();
    }

    public final zzgj p(int i2) {
        return ((zzgl) this.f37107b).y(i2);
    }

    public final void q(int i2, zzgi zzgiVar) {
        i();
        ((zzgl) this.f37107b).K(i2, (zzgj) zzgiVar.l());
    }

    public final List t() {
        return Collections.unmodifiableList(((zzgl) this.f37107b).z());
    }

    public final void u() {
        i();
        ((zzgl) this.f37107b).L();
    }

    public final void v() {
        i();
        ((zzgl) this.f37107b).M();
    }

    public final List w() {
        return Collections.unmodifiableList(((zzgl) this.f37107b).C());
    }

    public final String x() {
        return ((zzgl) this.f37107b).D();
    }
}
