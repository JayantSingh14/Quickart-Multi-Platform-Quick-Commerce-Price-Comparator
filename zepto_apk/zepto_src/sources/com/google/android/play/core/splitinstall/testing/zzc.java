package com.google.android.play.core.splitinstall.testing;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzc extends zzv {

    /* renamed from: b, reason: collision with root package name */
    public final Integer f42028b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f42029c;

    public /* synthetic */ zzc(Integer num, Map map) {
        this.f42028b = num;
        this.f42029c = map;
    }

    @Override // com.google.android.play.core.splitinstall.testing.zzv
    public final Integer a() {
        return this.f42028b;
    }

    @Override // com.google.android.play.core.splitinstall.testing.zzv
    public final Map b() {
        return this.f42029c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzv)) {
            return false;
        }
        zzv zzvVar = (zzv) obj;
        Integer num = this.f42028b;
        if (num == null) {
            if (zzvVar.a() != null) {
                return false;
            }
        } else if (!num.equals(zzvVar.a())) {
            return false;
        }
        return this.f42029c.equals(zzvVar.b());
    }

    public final int hashCode() {
        Integer num = this.f42028b;
        return (((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f42029c.hashCode();
    }

    public final String toString() {
        return "LocalTestingConfig{defaultSplitInstallErrorCode=" + this.f42028b + ", splitInstallErrorCodeByModule=" + String.valueOf(this.f42029c) + "}";
    }
}
