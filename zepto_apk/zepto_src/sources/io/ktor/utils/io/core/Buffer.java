package io.ktor.utils.io.core;

import android.support.v4.media.b;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;

@Deprecated
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class Buffer {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f51180a;

    /* renamed from: b, reason: collision with root package name */
    public int f51181b;

    /* renamed from: c, reason: collision with root package name */
    public int f51182c;

    /* renamed from: d, reason: collision with root package name */
    public int f51183d;

    /* renamed from: e, reason: collision with root package name */
    public int f51184e;

    /* renamed from: f, reason: collision with root package name */
    public final int f51185f;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public Buffer(ByteBuffer memory) {
        Intrinsics.checkNotNullParameter(memory, "memory");
        this.f51180a = memory;
        this.f51184e = memory.limit();
        this.f51185f = memory.limit();
    }

    public final void a(int i2) {
        int i3 = this.f51182c;
        int i4 = i3 + i2;
        if (i2 < 0 || i4 > this.f51184e) {
            BufferKt.a(i2, this.f51184e - i3);
            throw null;
        }
        this.f51182c = i4;
    }

    public final void b(int i2) {
        int i3 = this.f51184e;
        int i4 = this.f51182c;
        if (i2 < i4) {
            BufferKt.a(i2 - i4, i3 - i4);
            throw null;
        }
        if (i2 < i3) {
            this.f51182c = i2;
        } else if (i2 == i3) {
            this.f51182c = i2;
        } else {
            BufferKt.a(i2 - i4, i3 - i4);
            throw null;
        }
    }

    public final void c(int i2) {
        if (i2 == 0) {
            return;
        }
        int i3 = this.f51181b;
        int i4 = i3 + i2;
        if (i2 < 0 || i4 > this.f51182c) {
            BufferKt.b(i2, this.f51182c - i3);
            throw null;
        }
        this.f51181b = i4;
    }

    public final void d(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(b.f(i2, "newReadPosition shouldn't be negative: ").toString());
        }
        if (i2 > this.f51181b) {
            StringBuilder sbU = b.u(i2, "newReadPosition shouldn't be ahead of the read position: ", " > ");
            sbU.append(this.f51181b);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        this.f51181b = i2;
        if (this.f51183d > i2) {
            this.f51183d = i2;
        }
    }

    public final void e() {
        int i2 = this.f51185f - 8;
        int i3 = this.f51182c;
        if (i2 >= i3) {
            this.f51184e = i2;
            return;
        }
        if (i2 < 0) {
            BufferKt.c(this);
            throw null;
        }
        if (i2 < this.f51183d) {
            BufferKt.e(this);
            throw null;
        }
        if (this.f51181b != i3) {
            BufferKt.d(this);
            throw null;
        }
        this.f51184e = i2;
        this.f51181b = i2;
        this.f51182c = i2;
    }

    public final void f(int i2) {
        int i3 = this.f51183d;
        this.f51181b = i3;
        this.f51182c = i3;
        this.f51184e = i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Buffer[0x");
        String string = Integer.toString(hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        sb.append(string);
        sb.append("](");
        sb.append(this.f51182c - this.f51181b);
        sb.append(" used, ");
        sb.append(this.f51184e - this.f51182c);
        sb.append(" free, ");
        int i2 = this.f51183d;
        int i3 = this.f51184e;
        int i4 = this.f51185f;
        sb.append((i4 - i3) + i2);
        sb.append(" reserved of ");
        return b.n(sb, i4, ')');
    }
}
