package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReaderJsonLexer extends AbstractJsonLexer {

    /* renamed from: e, reason: collision with root package name */
    public int f56085e;

    public final void C(int i2) {
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void b(int i2, int i3) {
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean c() {
        n();
        int iW = w(this.f56006a);
        if (iW != -1) {
            throw null;
        }
        this.f56006a = iW;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String e() {
        h('\"');
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final byte f() {
        n();
        int iW = w(this.f56006a);
        if (iW != -1) {
            throw null;
        }
        this.f56006a = iW;
        return (byte) 10;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void n() {
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final CharSequence s() {
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String t(String keyToMatch, boolean z) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        return null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int w(int i2) {
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String y(int i2, int i3) {
        throw null;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean z() {
        x();
        throw null;
    }
}
