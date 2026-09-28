package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class JsonToStringWriter implements InternalJsonWriter {

    /* renamed from: a, reason: collision with root package name */
    public char[] f56054a;

    /* renamed from: b, reason: collision with root package name */
    public int f56055b;

    public JsonToStringWriter() {
        char[] cArr;
        CharArrayPool charArrayPool = CharArrayPool.f56026c;
        synchronized (charArrayPool) {
            ArrayDeque arrayDeque = charArrayPool.f56027a;
            cArr = null;
            char[] cArr2 = (char[]) (arrayDeque.isEmpty() ? null : arrayDeque.removeLast());
            if (cArr2 != null) {
                charArrayPool.f56028b -= cArr2.length;
                cArr = cArr2;
            }
        }
        this.f56054a = cArr == null ? new char[128] : cArr;
    }

    public final void a(int i2, int i3) {
        int i4 = i3 + i2;
        char[] cArr = this.f56054a;
        if (cArr.length <= i4) {
            int i5 = i2 * 2;
            if (i4 < i5) {
                i4 = i5;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i4);
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            this.f56054a = cArrCopyOf;
        }
    }

    public final void b() {
        CharArrayPool charArrayPool = CharArrayPool.f56026c;
        char[] array = this.f56054a;
        charArrayPool.getClass();
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (charArrayPool) {
            try {
                int i2 = charArrayPool.f56028b;
                if (array.length + i2 < ArrayPoolsKt.f56025a) {
                    charArrayPool.f56028b = i2 + array.length;
                    charArrayPool.f56027a.addLast(array);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        a(this.f56055b, length);
        text.getChars(0, text.length(), this.f56054a, this.f56055b);
        this.f56055b += length;
    }

    public final void d(long j2) {
        c(String.valueOf(j2));
    }

    public final String toString() {
        return new String(this.f56054a, 0, this.f56055b);
    }
}
