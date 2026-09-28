package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes.dex */
final class LinesIterator implements Iterator<String>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f53978a;

    /* renamed from: b, reason: collision with root package name */
    public int f53979b;

    /* renamed from: c, reason: collision with root package name */
    public int f53980c;

    /* renamed from: d, reason: collision with root package name */
    public int f53981d;

    /* renamed from: e, reason: collision with root package name */
    public int f53982e;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class State {
    }

    public LinesIterator(CharSequence string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.f53978a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2;
        int i3;
        int i4 = this.f53979b;
        if (i4 != 0) {
            return i4 == 1;
        }
        if (this.f53982e < 0) {
            this.f53979b = 2;
            return false;
        }
        CharSequence charSequence = this.f53978a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i5 = this.f53980c; i5 < length2; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i2 = (cCharAt == '\r' && (i3 = i5 + 1) < charSequence.length() && charSequence.charAt(i3) == '\n') ? 2 : 1;
                length = i5;
                this.f53979b = 1;
                this.f53982e = i2;
                this.f53981d = length;
                return true;
            }
        }
        i2 = -1;
        this.f53979b = 1;
        this.f53982e = i2;
        this.f53981d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f53979b = 0;
        int i2 = this.f53981d;
        int i3 = this.f53980c;
        this.f53980c = this.f53982e + i2;
        return this.f53978a.subSequence(i3, i2).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
