package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    public interface InternalOneOfEnum {
    }

    public static void h(Set set, List list) {
        Charset charset = Internal.f4024a;
        set.getClass();
        if (!(set instanceof LazyStringList)) {
            if (set instanceof PrimitiveNonBoxingCollection) {
                list.addAll(set);
                return;
            }
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(set.size() + list.size());
            }
            int size = list.size();
            for (Object obj : set) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
            return;
        }
        List listO = ((LazyStringList) set).O();
        LazyStringList lazyStringList = (LazyStringList) list;
        int size3 = list.size();
        for (Object obj2 : listO) {
            if (obj2 == null) {
                String str2 = "Element at index " + (lazyStringList.size() - size3) + " is null.";
                for (int size4 = lazyStringList.size() - 1; size4 >= size3; size4--) {
                    lazyStringList.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            if (obj2 instanceof ByteString) {
                lazyStringList.T0((ByteString) obj2);
            } else if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                lazyStringList.T0(ByteString.i(0, bArr, bArr.length));
            } else {
                lazyStringList.add((String) obj2);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final ByteString b() {
        try {
            int iJ = ((GeneratedMessageLite) this).j(null);
            ByteString byteString = ByteString.f3748b;
            ByteString.CodedBuilder codedBuilder = new ByteString.CodedBuilder(iJ);
            CodedOutputStream codedOutputStream = codedBuilder.f3756a;
            ((GeneratedMessageLite) this).g(codedOutputStream);
            CodedOutputStream.ArrayEncoder arrayEncoder = (CodedOutputStream.ArrayEncoder) codedOutputStream;
            if (arrayEncoder.f3808e - arrayEncoder.f3809f == 0) {
                return new ByteString.LiteralByteString(codedBuilder.f3757b);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e2) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    public int i() {
        throw new UnsupportedOperationException();
    }

    public int j(Schema schema) {
        int i2 = i();
        if (i2 != -1) {
            return i2;
        }
        int iD = schema.d(this);
        k(iD);
        return iD;
    }

    public void k(int i2) {
        throw new UnsupportedOperationException();
    }

    public final void l(OutputStream outputStream) throws IOException {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) this;
        int iJ = generatedMessageLite.j(null);
        Logger logger = CodedOutputStream.f3801b;
        if (iJ > 4096) {
            iJ = 4096;
        }
        CodedOutputStream.OutputStreamEncoder outputStreamEncoder = new CodedOutputStream.OutputStreamEncoder(outputStream, iJ);
        generatedMessageLite.g(outputStreamEncoder);
        if (outputStreamEncoder.f3806f > 0) {
            outputStreamEncoder.z0();
        }
    }

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        @Override // 
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract GeneratedMessageLite.Builder clone();

        public static final class LimitedInputStream extends FilterInputStream {

            /* renamed from: a, reason: collision with root package name */
            public int f3731a;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int available() {
                return Math.min(super.available(), this.f3731a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read() throws IOException {
                if (this.f3731a <= 0) {
                    return -1;
                }
                int i2 = super.read();
                if (i2 >= 0) {
                    this.f3731a--;
                }
                return i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final long skip(long j2) {
                int iSkip = (int) super.skip(Math.min(j2, this.f3731a));
                if (iSkip >= 0) {
                    this.f3731a -= iSkip;
                }
                return iSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read(byte[] bArr, int i2, int i3) throws IOException {
                int i4 = this.f3731a;
                if (i4 <= 0) {
                    return -1;
                }
                int i5 = super.read(bArr, i2, Math.min(i3, i4));
                if (i5 >= 0) {
                    this.f3731a -= i5;
                }
                return i5;
            }
        }
    }
}
