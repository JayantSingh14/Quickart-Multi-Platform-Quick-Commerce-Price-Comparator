package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class CharArrayBuilder extends PrimitiveArrayBuilder<char[]> {

    /* renamed from: a, reason: collision with root package name */
    public char[] f55782a;

    /* renamed from: b, reason: collision with root package name */
    public int f55783b;

    public CharArrayBuilder(char[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f55782a = bufferWithData;
        this.f55783b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final Object a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f55782a, this.f55783b);
        Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void b(int i2) {
        char[] cArr = this.f55782a;
        if (cArr.length < i2) {
            int length = cArr.length * 2;
            if (i2 < length) {
                i2 = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i2);
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            this.f55782a = cArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final int d() {
        return this.f55783b;
    }

    public final void e(char c2) {
        b(d() + 1);
        char[] cArr = this.f55782a;
        int i2 = this.f55783b;
        this.f55783b = i2 + 1;
        cArr[i2] = c2;
    }
}
