package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class StringLexer {

    /* renamed from: a, reason: collision with root package name */
    public final String f50238a;

    /* renamed from: b, reason: collision with root package name */
    public int f50239b;

    public StringLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f50238a = source;
    }

    public final boolean a(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean zC = c(predicate);
        if (zC) {
            this.f50239b++;
        }
        return zC;
    }

    public final void b(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (c(predicate)) {
            while (c(predicate)) {
                this.f50239b++;
            }
        }
    }

    public final boolean c(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = this.f50239b;
        String str = this.f50238a;
        return i2 < str.length() && ((Boolean) predicate.invoke(Character.valueOf(str.charAt(this.f50239b)))).booleanValue();
    }
}
