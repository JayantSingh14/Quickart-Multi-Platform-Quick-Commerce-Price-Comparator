package j$.sun.nio.cs;

import java.nio.CharBuffer;
import java.nio.charset.CoderResult;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public CoderResult f53171a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f53172b;

    public final int a(char c2, CharBuffer charBuffer) {
        if (Character.isHighSurrogate(c2)) {
            if (!charBuffer.hasRemaining()) {
                this.f53171a = CoderResult.UNDERFLOW;
                return -1;
            }
            char c3 = charBuffer.get();
            if (Character.isLowSurrogate(c3)) {
                int codePoint = Character.toCodePoint(c2, c3);
                this.f53172b = true;
                this.f53171a = null;
                return codePoint;
            }
            this.f53171a = CoderResult.malformedForLength(1);
            return -1;
        }
        if (Character.isLowSurrogate(c2)) {
            this.f53171a = CoderResult.malformedForLength(1);
            return -1;
        }
        this.f53172b = false;
        this.f53171a = null;
        return c2;
    }

    public final int b(char c2, char[] cArr, int i2, int i3) {
        if (!Character.isHighSurrogate(c2)) {
            if (Character.isLowSurrogate(c2)) {
                this.f53171a = CoderResult.malformedForLength(1);
                return -1;
            }
            this.f53172b = false;
            this.f53171a = null;
            return c2;
        }
        if (i3 - i2 < 2) {
            this.f53171a = CoderResult.UNDERFLOW;
            return -1;
        }
        char c3 = cArr[i2 + 1];
        if (Character.isLowSurrogate(c3)) {
            int codePoint = Character.toCodePoint(c2, c3);
            this.f53172b = true;
            this.f53171a = null;
            return codePoint;
        }
        this.f53171a = CoderResult.malformedForLength(1);
        return -1;
    }
}
