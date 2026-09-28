package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.xbill.DNS.Message;

@RestrictTo
/* loaded from: classes3.dex */
class VersionedParcelStream extends VersionedParcel {

    /* renamed from: m, reason: collision with root package name */
    public static final Charset f12308m = Charset.forName("UTF-16");

    /* renamed from: d, reason: collision with root package name */
    public final DataInputStream f12309d;

    /* renamed from: e, reason: collision with root package name */
    public final DataOutputStream f12310e;

    /* renamed from: f, reason: collision with root package name */
    public final DataInputStream f12311f;

    /* renamed from: g, reason: collision with root package name */
    public DataOutputStream f12312g;

    /* renamed from: h, reason: collision with root package name */
    public FieldBuffer f12313h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12314i;

    /* renamed from: j, reason: collision with root package name */
    public int f12315j;

    /* renamed from: k, reason: collision with root package name */
    public int f12316k;

    /* renamed from: l, reason: collision with root package name */
    public int f12317l;

    public static class FieldBuffer {

        /* renamed from: a, reason: collision with root package name */
        public final ByteArrayOutputStream f12319a;

        /* renamed from: b, reason: collision with root package name */
        public final DataOutputStream f12320b;

        /* renamed from: c, reason: collision with root package name */
        public final int f12321c;

        /* renamed from: d, reason: collision with root package name */
        public final DataOutputStream f12322d;

        public FieldBuffer(int i2, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f12319a = byteArrayOutputStream;
            this.f12320b = new DataOutputStream(byteArrayOutputStream);
            this.f12321c = i2;
            this.f12322d = dataOutputStream;
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f12315j = 0;
        this.f12316k = -1;
        this.f12317l = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read() throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i2 = versionedParcelStream.f12317l;
                if (i2 != -1 && versionedParcelStream.f12315j >= i2) {
                    throw new IOException();
                }
                int i3 = super.read();
                versionedParcelStream.f12315j++;
                return i3;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final long skip(long j2) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i2 = versionedParcelStream.f12317l;
                if (i2 != -1 && versionedParcelStream.f12315j >= i2) {
                    throw new IOException();
                }
                long jSkip = super.skip(j2);
                if (jSkip > 0) {
                    versionedParcelStream.f12315j += (int) jSkip;
                }
                return jSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read(byte[] bArr, int i2, int i3) throws IOException {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i4 = versionedParcelStream.f12317l;
                if (i4 != -1 && versionedParcelStream.f12315j >= i4) {
                    throw new IOException();
                }
                int i5 = super.read(bArr, i2, i3);
                if (i5 > 0) {
                    versionedParcelStream.f12315j += i5;
                }
                return i5;
            }
        }) : null;
        this.f12309d = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.f12310e = dataOutputStream;
        this.f12311f = dataInputStream;
        this.f12312g = dataOutputStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void a() throws IOException {
        FieldBuffer fieldBuffer = this.f12313h;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.f12319a.size() != 0) {
                    FieldBuffer fieldBuffer2 = this.f12313h;
                    fieldBuffer2.f12320b.flush();
                    ByteArrayOutputStream byteArrayOutputStream = fieldBuffer2.f12319a;
                    int size = byteArrayOutputStream.size();
                    int i2 = fieldBuffer2.f12321c << 16;
                    int i3 = size >= 65535 ? 65535 : size;
                    DataOutputStream dataOutputStream = fieldBuffer2.f12322d;
                    dataOutputStream.writeInt(i2 | i3);
                    if (size >= 65535) {
                        dataOutputStream.writeInt(size);
                    }
                    byteArrayOutputStream.writeTo(dataOutputStream);
                }
                this.f12313h = null;
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final VersionedParcel b() {
        return new VersionedParcelStream(this.f12311f, this.f12312g, this.f12297a, this.f12298b, this.f12299c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean g() {
        try {
            return this.f12311f.readBoolean();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final byte[] h() throws IOException {
        DataInputStream dataInputStream = this.f12311f;
        try {
            int i2 = dataInputStream.readInt();
            if (i2 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i2];
            dataInputStream.readFully(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final CharSequence i() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final boolean j(int i2) throws IOException {
        while (true) {
            try {
                int i3 = this.f12316k;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    break;
                }
                int i4 = this.f12315j;
                int i5 = this.f12317l;
                DataInputStream dataInputStream = this.f12309d;
                if (i4 < i5) {
                    dataInputStream.skip(i5 - i4);
                }
                this.f12317l = -1;
                int i6 = dataInputStream.readInt();
                this.f12315j = 0;
                int i7 = i6 & Message.MAXLENGTH;
                if (i7 == 65535) {
                    i7 = dataInputStream.readInt();
                }
                this.f12316k = (i6 >> 16) & Message.MAXLENGTH;
                this.f12317l = i7;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final int k() {
        try {
            return this.f12311f.readInt();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final Parcelable m() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final String n() throws IOException {
        DataInputStream dataInputStream = this.f12311f;
        try {
            int i2 = dataInputStream.readInt();
            if (i2 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i2];
            dataInputStream.readFully(bArr);
            return new String(bArr, f12308m);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void p(int i2) throws IOException {
        a();
        FieldBuffer fieldBuffer = new FieldBuffer(i2, this.f12310e);
        this.f12313h = fieldBuffer;
        this.f12312g = fieldBuffer.f12320b;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void q(boolean z, boolean z2) {
        if (!z) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.f12314i = z2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void r(boolean z) throws IOException {
        try {
            this.f12312g.writeBoolean(z);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void s(byte[] bArr) throws IOException {
        try {
            if (bArr == null) {
                this.f12312g.writeInt(-1);
            } else {
                this.f12312g.writeInt(bArr.length);
                this.f12312g.write(bArr);
            }
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void t(CharSequence charSequence) {
        if (!this.f12314i) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void u(int i2) throws IOException {
        try {
            this.f12312g.writeInt(i2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void w(Parcelable parcelable) {
        if (!this.f12314i) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public final void x(String str) throws IOException {
        try {
            if (str == null) {
                this.f12312g.writeInt(-1);
                return;
            }
            byte[] bytes = str.getBytes(f12308m);
            this.f12312g.writeInt(bytes.length);
            this.f12312g.write(bytes);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }
}
