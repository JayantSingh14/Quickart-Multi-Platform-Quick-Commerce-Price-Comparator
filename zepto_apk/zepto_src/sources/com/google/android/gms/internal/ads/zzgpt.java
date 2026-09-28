package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class zzgpt extends zzgpq implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f33056a;

    public zzgpt(Pattern pattern) {
        pattern.getClass();
        this.f33056a = pattern;
    }

    @Override // com.google.android.gms.internal.ads.zzgpq
    public final zzgpp a(CharSequence charSequence) {
        return new zzgps(this.f33056a.matcher(charSequence));
    }

    public final String toString() {
        return this.f33056a.toString();
    }
}
