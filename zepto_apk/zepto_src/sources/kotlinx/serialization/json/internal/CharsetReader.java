package kotlinx.serialization.json.internal;

import android.support.v4.media.b;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class CharsetReader {

    /* renamed from: a, reason: collision with root package name */
    public boolean f56031a;

    /* renamed from: b, reason: collision with root package name */
    public char f56032b;

    public final int a(char[] array, int i2, int i3) {
        int i4;
        char c2;
        Intrinsics.checkNotNullParameter(array, "array");
        if (i3 == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= array.length || i3 < 0 || i2 + i3 > array.length) {
            StringBuilder sbT = b.t(i2, i3, "Unexpected arguments: ", ", ", ", ");
            sbT.append(array.length);
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        if (this.f56031a) {
            array[i2] = this.f56032b;
            i2++;
            i3--;
            this.f56031a = false;
            if (i3 == 0) {
                return 1;
            }
            i4 = 1;
        } else {
            i4 = 0;
        }
        if (i3 != 1) {
            CharBuffer charBufferWrap = CharBuffer.wrap(array, i2, i3);
            if (charBufferWrap.position() != 0) {
                charBufferWrap.slice();
            }
            throw null;
        }
        if (this.f56031a) {
            this.f56031a = false;
            c2 = this.f56032b;
        } else {
            char[] cArr = new char[2];
            int iA = a(cArr, 0, 2);
            if (iA == -1) {
                c2 = 65535;
            } else if (iA == 1) {
                c2 = cArr[0];
            } else {
                if (iA != 2) {
                    throw new IllegalStateException(("Unreachable state: " + iA).toString());
                }
                this.f56032b = cArr[1];
                this.f56031a = true;
                c2 = cArr[0];
            }
        }
        if (c2 != 65535) {
            array[i2] = c2;
            return i4 + 1;
        }
        if (i4 == 0) {
            return -1;
        }
        return i4;
    }
}
