package io.ktor.utils.io.core;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class Input$readAvailableCharacters$out$1 implements Appendable {

    /* renamed from: a, reason: collision with root package name */
    public int f51201a;

    @Override // java.lang.Appendable
    public final Appendable append(char c2) {
        this.f51201a++;
        throw null;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        boolean z = charSequence instanceof String;
        throw null;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i2, int i3) {
        throw new UnsupportedOperationException();
    }
}
