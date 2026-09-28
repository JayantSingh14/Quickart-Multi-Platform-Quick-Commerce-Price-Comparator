package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.xbill.DNS.TTL;

/* loaded from: classes3.dex */
final class RopeByteString extends ByteString {

    /* renamed from: d, reason: collision with root package name */
    public final int f4122d;

    /* renamed from: e, reason: collision with root package name */
    public final ByteString f4123e;

    /* renamed from: f, reason: collision with root package name */
    public final ByteString f4124f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4125g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4126h;

    /* renamed from: androidx.datastore.preferences.protobuf.RopeByteString$1, reason: invalid class name */
    class AnonymousClass1 extends ByteString.AbstractByteIterator {

        /* renamed from: a, reason: collision with root package name */
        public final PieceIterator f4127a;

        /* renamed from: b, reason: collision with root package name */
        public ByteString.ByteIterator f4128b = a();

        public AnonymousClass1(RopeByteString ropeByteString) {
            this.f4127a = new PieceIterator(ropeByteString);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteIterator
        public final byte A() {
            ByteString.ByteIterator byteIterator = this.f4128b;
            if (byteIterator == null) {
                throw new NoSuchElementException();
            }
            byte bA = byteIterator.A();
            if (!this.f4128b.hasNext()) {
                this.f4128b = a();
            }
            return bA;
        }

        public final ByteString.ByteIterator a() {
            PieceIterator pieceIterator = this.f4127a;
            if (pieceIterator.hasNext()) {
                return new ByteString.AnonymousClass1();
            }
            return null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4128b != null;
        }
    }

    public static class Balancer {
    }

    public static final class PieceIterator implements Iterator<ByteString.LeafByteString> {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayDeque f4129a;

        /* renamed from: b, reason: collision with root package name */
        public ByteString.LeafByteString f4130b;

        public PieceIterator(ByteString byteString) {
            if (!(byteString instanceof RopeByteString)) {
                this.f4129a = null;
                this.f4130b = (ByteString.LeafByteString) byteString;
                return;
            }
            RopeByteString ropeByteString = (RopeByteString) byteString;
            ArrayDeque arrayDeque = new ArrayDeque(ropeByteString.f4126h);
            this.f4129a = arrayDeque;
            arrayDeque.push(ropeByteString);
            ByteString byteString2 = ropeByteString.f4123e;
            while (byteString2 instanceof RopeByteString) {
                RopeByteString ropeByteString2 = (RopeByteString) byteString2;
                this.f4129a.push(ropeByteString2);
                byteString2 = ropeByteString2.f4123e;
            }
            this.f4130b = (ByteString.LeafByteString) byteString2;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString;
            ByteString.LeafByteString leafByteString2 = this.f4130b;
            if (leafByteString2 == null) {
                throw new NoSuchElementException();
            }
            do {
                ArrayDeque arrayDeque = this.f4129a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    leafByteString = null;
                    break;
                }
                ByteString byteString = ((RopeByteString) arrayDeque.pop()).f4124f;
                while (byteString instanceof RopeByteString) {
                    RopeByteString ropeByteString = (RopeByteString) byteString;
                    arrayDeque.push(ropeByteString);
                    byteString = ropeByteString.f4123e;
                }
                leafByteString = (ByteString.LeafByteString) byteString;
            } while (leafByteString.size() == 0);
            this.f4130b = leafByteString;
            return leafByteString2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f4130b != null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public RopeByteString(ByteString byteString, ByteString byteString2) {
        this.f4123e = byteString;
        this.f4124f = byteString2;
        int size = byteString.size();
        this.f4125g = size;
        this.f4122d = byteString2.size() + size;
        this.f4126h = Math.max(byteString.m(), byteString2.m()) + 1;
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final ByteBuffer b() {
        return ByteBuffer.wrap(u()).asReadOnlyBuffer();
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final byte d(int i2) {
        ByteString.f(i2, this.f4122d);
        return n(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            int i2 = this.f4122d;
            if (i2 == size) {
                if (i2 == 0) {
                    return true;
                }
                int i3 = this.f3750a;
                int i4 = byteString.f3750a;
                if (i3 == 0 || i4 == 0 || i3 == i4) {
                    PieceIterator pieceIterator = new PieceIterator(this);
                    ByteString.LeafByteString next = pieceIterator.next();
                    PieceIterator pieceIterator2 = new PieceIterator(byteString);
                    ByteString.LeafByteString next2 = pieceIterator2.next();
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (true) {
                        int size2 = next.size() - i5;
                        int size3 = next2.size() - i6;
                        int iMin = Math.min(size2, size3);
                        if (!(i5 == 0 ? next.z(next2, i6, iMin) : next2.z(next, i5, iMin))) {
                            break;
                        }
                        i7 += iMin;
                        if (i7 >= i2) {
                            if (i7 == i2) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (iMin == size2) {
                            i5 = 0;
                            next = pieceIterator.next();
                        } else {
                            i5 += iMin;
                            next = next;
                        }
                        if (iMin == size3) {
                            next2 = pieceIterator2.next();
                            i6 = 0;
                        } else {
                            i6 += iMin;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
    public final Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final void k(int i2, int i3, byte[] bArr, int i4) {
        int i5 = i2 + i4;
        ByteString byteString = this.f4123e;
        int i6 = this.f4125g;
        if (i5 <= i6) {
            byteString.k(i2, i3, bArr, i4);
            return;
        }
        ByteString byteString2 = this.f4124f;
        if (i2 >= i6) {
            byteString2.k(i2 - i6, i3, bArr, i4);
            return;
        }
        int i7 = i6 - i2;
        byteString.k(i2, i3, bArr, i7);
        byteString2.k(0, i3 + i7, bArr, i4 - i7);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final int m() {
        return this.f4126h;
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final byte n(int i2) {
        int i3 = this.f4125g;
        return i2 < i3 ? this.f4123e.n(i2) : this.f4124f.n(i2 - i3);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final boolean o() {
        int iS = this.f4123e.s(0, 0, this.f4125g);
        ByteString byteString = this.f4124f;
        return byteString.s(iS, 0, byteString.size()) == 0;
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    /* renamed from: p */
    public final ByteString.ByteIterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final CodedInputStream q() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().b());
        }
        Iterator it = arrayList.iterator();
        int i2 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        if (i2 == 2) {
            return new CodedInputStream.IterableDirectByteBufferDecoder(iRemaining, arrayList);
        }
        IterableByteBufferInputStream iterableByteBufferInputStream = new IterableByteBufferInputStream();
        iterableByteBufferInputStream.f4029a = arrayList.iterator();
        iterableByteBufferInputStream.f4031c = 0;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            iterableByteBufferInputStream.f4031c++;
        }
        iterableByteBufferInputStream.f4032d = -1;
        if (!iterableByteBufferInputStream.a()) {
            iterableByteBufferInputStream.f4030b = Internal.f4026c;
            iterableByteBufferInputStream.f4032d = 0;
            iterableByteBufferInputStream.f4033e = 0;
            iterableByteBufferInputStream.f4037i = 0L;
        }
        return CodedInputStream.d(iterableByteBufferInputStream);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final int r(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        ByteString byteString = this.f4123e;
        int i6 = this.f4125g;
        if (i5 <= i6) {
            return byteString.r(i2, i3, i4);
        }
        ByteString byteString2 = this.f4124f;
        if (i3 >= i6) {
            return byteString2.r(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return byteString2.r(byteString.r(i2, i3, i7), 0, i4 - i7);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final int s(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        ByteString byteString = this.f4123e;
        int i6 = this.f4125g;
        if (i5 <= i6) {
            return byteString.s(i2, i3, i4);
        }
        ByteString byteString2 = this.f4124f;
        if (i3 >= i6) {
            return byteString2.s(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return byteString2.s(byteString.s(i2, i3, i7), 0, i4 - i7);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final int size() {
        return this.f4122d;
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final ByteString t(int i2, int i3) {
        int i4 = this.f4122d;
        int iG = ByteString.g(i2, i3, i4);
        if (iG == 0) {
            return ByteString.f3748b;
        }
        if (iG == i4) {
            return this;
        }
        ByteString byteString = this.f4123e;
        int i5 = this.f4125g;
        if (i3 <= i5) {
            return byteString.t(i2, i3);
        }
        ByteString byteString2 = this.f4124f;
        return i2 >= i5 ? byteString2.t(i2 - i5, i3 - i5) : new RopeByteString(byteString.t(i2, byteString.size()), byteString2.t(0, i3 - i5));
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final String v(Charset charset) {
        return new String(u(), charset);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final void w(ByteOutput byteOutput) {
        this.f4123e.w(byteOutput);
        this.f4124f.w(byteOutput);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteString
    public final void y(ByteOutput byteOutput) {
        this.f4124f.y(byteOutput);
        this.f4123e.y(byteOutput);
    }

    public class RopeInputStream extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        public PieceIterator f4131a;

        /* renamed from: b, reason: collision with root package name */
        public ByteString.LeafByteString f4132b;

        /* renamed from: c, reason: collision with root package name */
        public int f4133c;

        /* renamed from: d, reason: collision with root package name */
        public int f4134d;

        /* renamed from: e, reason: collision with root package name */
        public int f4135e;

        /* renamed from: f, reason: collision with root package name */
        public int f4136f;

        public final void a() {
            if (this.f4132b != null) {
                int i2 = this.f4134d;
                int i3 = this.f4133c;
                if (i2 == i3) {
                    this.f4135e += i3;
                    this.f4134d = 0;
                    if (!this.f4131a.hasNext()) {
                        this.f4132b = null;
                        this.f4133c = 0;
                    } else {
                        ByteString.LeafByteString next = this.f4131a.next();
                        this.f4132b = next;
                        this.f4133c = next.size();
                    }
                }
            }
        }

        @Override // java.io.InputStream
        public final int available() {
            throw null;
        }

        public final int b(int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i4 > 0) {
                a();
                if (this.f4132b == null) {
                    break;
                }
                int iMin = Math.min(this.f4133c - this.f4134d, i4);
                if (bArr != null) {
                    ByteString.LeafByteString leafByteString = this.f4132b;
                    int i5 = this.f4134d;
                    ByteString.g(i5, i5 + iMin, leafByteString.size());
                    ByteString.g(i2, i2 + iMin, bArr.length);
                    if (iMin > 0) {
                        leafByteString.k(i5, i2, bArr, iMin);
                    }
                    i2 += iMin;
                }
                this.f4134d += iMin;
                i4 -= iMin;
            }
            return i3 - i4;
        }

        @Override // java.io.InputStream
        public final void mark(int i2) {
            this.f4136f = this.f4135e + this.f4134d;
        }

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) {
            bArr.getClass();
            if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            int iB = b(i2, bArr, i3);
            if (iB != 0) {
                return iB;
            }
            if (i3 > 0) {
                return -1;
            }
            throw null;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            PieceIterator pieceIterator = new PieceIterator(null);
            this.f4131a = pieceIterator;
            ByteString.LeafByteString next = pieceIterator.next();
            this.f4132b = next;
            this.f4133c = next.size();
            this.f4134d = 0;
            this.f4135e = 0;
            b(0, null, this.f4136f);
        }

        @Override // java.io.InputStream
        public final long skip(long j2) {
            if (j2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j2 > TTL.MAX_VALUE) {
                j2 = 2147483647L;
            }
            return b(0, null, (int) j2);
        }

        @Override // java.io.InputStream
        public final int read() {
            a();
            ByteString.LeafByteString leafByteString = this.f4132b;
            if (leafByteString == null) {
                return -1;
            }
            int i2 = this.f4134d;
            this.f4134d = i2 + 1;
            return leafByteString.d(i2) & 255;
        }
    }
}
