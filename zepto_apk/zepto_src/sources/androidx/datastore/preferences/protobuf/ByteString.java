package androidx.datastore.preferences.protobuf;

import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.CodedInputStream;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.datastore.preferences.protobuf.Utf8;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@CheckReturnValue
/* loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f3748b = new LiteralByteString(Internal.f4025b);

    /* renamed from: c, reason: collision with root package name */
    public static final ByteArrayCopier f3749c;

    /* renamed from: a, reason: collision with root package name */
    public int f3750a = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.ByteString$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractByteIterator {

        /* renamed from: a, reason: collision with root package name */
        public int f3751a = 0;

        /* renamed from: b, reason: collision with root package name */
        public final int f3752b;

        public AnonymousClass1() {
            this.f3752b = ByteString.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteIterator
        public final byte A() {
            int i2 = this.f3751a;
            if (i2 >= this.f3752b) {
                throw new NoSuchElementException();
            }
            this.f3751a = i2 + 1;
            return ByteString.this.n(i2);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f3751a < this.f3752b;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.ByteString$2, reason: invalid class name */
    public class AnonymousClass2 implements Comparator<ByteString> {
        @Override // java.util.Comparator
        public final int compare(ByteString byteString, ByteString byteString2) {
            ByteString byteString3 = byteString;
            ByteString byteString4 = byteString2;
            ByteIterator it = byteString3.iterator();
            ByteIterator it2 = byteString4.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int iCompareTo = Integer.valueOf(it.A() & 255).compareTo(Integer.valueOf(it2.A() & 255));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(byteString3.size()).compareTo(Integer.valueOf(byteString4.size()));
        }
    }

    public static abstract class AbstractByteIterator implements ByteIterator {
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(A());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public final byte[] a(int i2, byte[] bArr, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
    }

    public static final class BoundedByteString extends LiteralByteString {

        /* renamed from: e, reason: collision with root package name */
        public final int f3754e;

        /* renamed from: f, reason: collision with root package name */
        public final int f3755f;

        public BoundedByteString(byte[] bArr, int i2, int i3) {
            super(bArr);
            ByteString.g(i2, i2 + i3, bArr.length);
            this.f3754e = i2;
            this.f3755f = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        public final int A() {
            return this.f3754e;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public final byte d(int i2) {
            ByteString.f(i2, this.f3755f);
            return this.f3758d[this.f3754e + i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public final void k(int i2, int i3, byte[] bArr, int i4) {
            System.arraycopy(this.f3758d, this.f3754e + i2, bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString.LeafByteString, androidx.datastore.preferences.protobuf.ByteString
        public final byte n(int i2) {
            return this.f3758d[this.f3754e + i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public final int size() {
            return this.f3755f;
        }
    }

    public interface ByteArrayCopier {
        byte[] a(int i2, byte[] bArr, int i3);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte A();
    }

    public static final class CodedBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final CodedOutputStream f3756a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f3757b;

        public CodedBuilder(int i2) {
            byte[] bArr = new byte[i2];
            this.f3757b = bArr;
            Logger logger = CodedOutputStream.f3801b;
            this.f3756a = new CodedOutputStream.ArrayEncoder(bArr, i2);
        }
    }

    public static abstract class LeafByteString extends ByteString {
        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public final Iterator<Byte> iterator() {
            return new AnonymousClass1();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int m() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte n(int i2) {
            return d(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void y(ByteOutput byteOutput) {
            w(byteOutput);
        }

        public abstract boolean z(ByteString byteString, int i2, int i3);
    }

    public static class LiteralByteString extends LeafByteString {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f3758d;

        public LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f3758d = bArr;
        }

        public int A() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteBuffer b() {
            return ByteBuffer.wrap(this.f3758d, A(), size()).asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte d(int i2) {
            return this.f3758d[i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int i2 = this.f3750a;
            int i3 = literalByteString.f3750a;
            if (i2 == 0 || i3 == 0 || i2 == i3) {
                return z(literalByteString, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void k(int i2, int i3, byte[] bArr, int i4) {
            System.arraycopy(this.f3758d, i2, bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte n(int i2) {
            return this.f3758d[i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean o() {
            int iA = A();
            return Utf8.f4190a.e(0, iA, this.f3758d, size() + iA) == 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final CodedInputStream q() {
            return CodedInputStream.e(this.f3758d, A(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int r(int i2, int i3, int i4) {
            int iA = A() + i3;
            Charset charset = Internal.f4024a;
            for (int i5 = iA; i5 < iA + i4; i5++) {
                i2 = (i2 * 31) + this.f3758d[i5];
            }
            return i2;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int s(int i2, int i3, int i4) {
            int iA = A() + i3;
            return Utf8.f4190a.e(i2, iA, this.f3758d, i4 + iA);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f3758d.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString t(int i2, int i3) {
            int iG = ByteString.g(i2, i3, size());
            if (iG == 0) {
                return ByteString.f3748b;
            }
            return new BoundedByteString(this.f3758d, A() + i2, iG);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final String v(Charset charset) {
            return new String(this.f3758d, A(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void w(ByteOutput byteOutput) {
            byteOutput.Q(A(), this.f3758d, size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        public final boolean z(ByteString byteString, int i2, int i3) {
            if (i3 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i3 + size());
            }
            int i4 = i2 + i3;
            if (i4 > byteString.size()) {
                StringBuilder sbT = b.t(i2, i3, "Ran off end of other: ", ", ", ", ");
                sbT.append(byteString.size());
                throw new IllegalArgumentException(sbT.toString());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.t(i2, i4).equals(t(0, i3));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            int iA = A() + i3;
            int iA2 = A();
            int iA3 = literalByteString.A() + i2;
            while (iA2 < iA) {
                if (this.f3758d[iA2] != literalByteString.f3758d[iA3]) {
                    return false;
                }
                iA2++;
                iA3++;
            }
            return true;
        }
    }

    public static final class NioByteString extends LeafByteString {

        /* renamed from: d, reason: collision with root package name */
        public final ByteBuffer f3759d;

        /* renamed from: androidx.datastore.preferences.protobuf.ByteString$NioByteString$1, reason: invalid class name */
        class AnonymousClass1 extends InputStream {
            @Override // java.io.InputStream
            public final int available() {
                throw null;
            }

            @Override // java.io.InputStream
            public final void mark(int i2) {
                throw null;
            }

            @Override // java.io.InputStream
            public final boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream
            public final int read() {
                throw null;
            }

            @Override // java.io.InputStream
            public final void reset() {
                throw null;
            }

            @Override // java.io.InputStream
            public final int read(byte[] bArr, int i2, int i3) {
                throw null;
            }
        }

        public NioByteString(ByteBuffer byteBuffer) {
            Charset charset = Internal.f4024a;
            this.f3759d = byteBuffer.slice().order(ByteOrder.nativeOrder());
        }

        public final ByteBuffer A(int i2, int i3) {
            ByteBuffer byteBuffer = this.f3759d;
            if (i2 < byteBuffer.position() || i3 > byteBuffer.limit() || i2 > i3) {
                throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.position(i2 - byteBuffer.position());
            byteBufferSlice.limit(i3 - byteBuffer.position());
            return byteBufferSlice;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteBuffer b() {
            return this.f3759d.asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final byte d(int i2) {
            try {
                return this.f3759d.get(i2);
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw e2;
            } catch (IndexOutOfBoundsException e3) {
                throw new ArrayIndexOutOfBoundsException(e3.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString)) {
                return false;
            }
            ByteString byteString = (ByteString) obj;
            ByteBuffer byteBuffer = this.f3759d;
            if (byteBuffer.remaining() != byteString.size()) {
                return false;
            }
            if (byteBuffer.remaining() == 0) {
                return true;
            }
            return obj instanceof NioByteString ? byteBuffer.equals(((NioByteString) obj).f3759d) : obj instanceof RopeByteString ? obj.equals(this) : byteBuffer.equals(byteString.b());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void k(int i2, int i3, byte[] bArr, int i4) {
            ByteBuffer byteBufferSlice = this.f3759d.slice();
            byteBufferSlice.position(i2);
            byteBufferSlice.get(bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean o() {
            Utf8.Processor processor = Utf8.f4190a;
            ByteBuffer byteBuffer = this.f3759d;
            return Utf8.f4190a.f(byteBuffer, 0, byteBuffer.position(), byteBuffer.remaining()) == 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final CodedInputStream q() {
            ByteBuffer byteBuffer = this.f3759d;
            if (byteBuffer.hasArray()) {
                return CodedInputStream.e(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining(), true);
            }
            if (byteBuffer.isDirect() && UnsafeUtil.f4184d) {
                return new CodedInputStream.UnsafeDirectNioDecoder(byteBuffer);
            }
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            return CodedInputStream.e(bArr, 0, iRemaining, true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int r(int i2, int i3, int i4) {
            for (int i5 = i3; i5 < i3 + i4; i5++) {
                i2 = (i2 * 31) + this.f3759d.get(i5);
            }
            return i2;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int s(int i2, int i3, int i4) {
            return Utf8.f4190a.f(this.f3759d, i2, i3, i4 + i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int size() {
            return this.f3759d.remaining();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString t(int i2, int i3) {
            try {
                return new NioByteString(A(i2, i3));
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw e2;
            } catch (IndexOutOfBoundsException e3) {
                throw new ArrayIndexOutOfBoundsException(e3.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final String v(Charset charset) {
            byte[] bArrU;
            int length;
            int iPosition;
            ByteBuffer byteBuffer = this.f3759d;
            if (byteBuffer.hasArray()) {
                bArrU = byteBuffer.array();
                iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
                length = byteBuffer.remaining();
            } else {
                bArrU = u();
                length = bArrU.length;
                iPosition = 0;
            }
            return new String(bArrU, iPosition, length, charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void w(ByteOutput byteOutput) {
            byteOutput.R(this.f3759d.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        public final boolean z(ByteString byteString, int i2, int i3) {
            return t(0, i3).equals(byteString.t(i2, i3 + i2));
        }
    }

    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public final byte[] a(int i2, byte[] bArr, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    static {
        f3749c = Android.a() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
    }

    public static void f(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) < 0) {
            if (i2 >= 0) {
                throw new ArrayIndexOutOfBoundsException(b.d(i2, i3, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(b.f(i2, "Index < 0: "));
        }
    }

    public static int g(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(b.g(i2, "Beginning index: ", " < 0"));
        }
        if (i3 < i2) {
            throw new IndexOutOfBoundsException(b.d(i2, i3, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(b.d(i3, i4, "End index: ", " >= "));
    }

    public static ByteString i(int i2, byte[] bArr, int i3) {
        g(i2, i2 + i3, bArr.length);
        return new LiteralByteString(f3749c.a(i2, bArr, i3));
    }

    public static ByteString j(byte[] bArr) {
        return i(0, bArr, bArr.length);
    }

    public abstract ByteBuffer b();

    public abstract byte d(int i2);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iR = this.f3750a;
        if (iR == 0) {
            int size = size();
            iR = r(size, 0, size);
            if (iR == 0) {
                iR = 1;
            }
            this.f3750a = iR;
        }
        return iR;
    }

    public abstract void k(int i2, int i3, byte[] bArr, int i4);

    public abstract int m();

    public abstract byte n(int i2);

    public abstract boolean o();

    @Override // java.lang.Iterable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public ByteIterator iterator() {
        return new AnonymousClass1();
    }

    public abstract CodedInputStream q();

    public abstract int r(int i2, int i3, int i4);

    public abstract int s(int i2, int i3, int i4);

    public abstract int size();

    public abstract ByteString t(int i2, int i3);

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        String strA = size() <= 50 ? TextFormatEscaper.a(this) : b.r(new StringBuilder(), TextFormatEscaper.a(t(0, 47)), "...");
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(size);
        sb.append(" contents=\"");
        return b.r(sb, strA, "\">");
    }

    public final byte[] u() {
        int size = size();
        if (size == 0) {
            return Internal.f4025b;
        }
        byte[] bArr = new byte[size];
        k(0, 0, bArr, size);
        return bArr;
    }

    public abstract String v(Charset charset);

    public abstract void w(ByteOutput byteOutput);

    public abstract void y(ByteOutput byteOutput);

    public static final class Output extends OutputStream {
        public final String toString() {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            synchronized (this) {
            }
            return String.format("<ByteString.Output@%s size=%d>", hexString, 0);
        }

        @Override // java.io.OutputStream
        public final synchronized void write(int i2) {
            throw null;
        }

        @Override // java.io.OutputStream
        public final synchronized void write(byte[] bArr, int i2, int i3) {
            throw null;
        }
    }
}
