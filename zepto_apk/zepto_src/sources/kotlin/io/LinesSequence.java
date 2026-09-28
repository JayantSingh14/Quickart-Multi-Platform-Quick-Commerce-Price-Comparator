package kotlin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: classes3.dex */
final class LinesSequence implements Sequence<String> {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedReader f53748a;

    @Metadata
    /* renamed from: kotlin.io.LinesSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator<String>, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        public String f53749a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f53750b;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() throws IOException {
            if (this.f53749a == null && !this.f53750b) {
                String line = LinesSequence.this.f53748a.readLine();
                this.f53749a = line;
                if (line == null) {
                    this.f53750b = true;
                }
            }
            return this.f53749a != null;
        }

        @Override // java.util.Iterator
        public final String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f53749a;
            this.f53749a = null;
            Intrinsics.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public LinesSequence(BufferedReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.f53748a = reader;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
