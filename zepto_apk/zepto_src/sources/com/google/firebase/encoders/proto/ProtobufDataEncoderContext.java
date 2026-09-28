package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f44520f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final FieldDescriptor f44521g;

    /* renamed from: h, reason: collision with root package name */
    public static final FieldDescriptor f44522h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f44523i;

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f44524a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f44525b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f44526c;

    /* renamed from: d, reason: collision with root package name */
    public final a f44527d;

    /* renamed from: e, reason: collision with root package name */
    public final ProtobufValueEncoderContext f44528e = new ProtobufValueEncoderContext(this);

    /* renamed from: com.google.firebase.encoders.proto.ProtobufDataEncoderContext$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44529a;

        static {
            int[] iArr = new int[Protobuf.IntEncoding.values().length];
            f44529a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44529a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44529a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        FieldDescriptor.Builder builder = new FieldDescriptor.Builder("key");
        AtProtobuf atProtobuf = new AtProtobuf();
        atProtobuf.f44515a = 1;
        f44521g = android.support.v4.media.a.h(atProtobuf, builder);
        FieldDescriptor.Builder builder2 = new FieldDescriptor.Builder(CLConstants.FIELD_PAY_INFO_VALUE);
        AtProtobuf atProtobuf2 = new AtProtobuf();
        atProtobuf2.f44515a = 2;
        f44522h = android.support.v4.media.a.h(atProtobuf2, builder2);
        f44523i = new a(0);
    }

    public ProtobufDataEncoderContext(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, a aVar) {
        this.f44524a = byteArrayOutputStream;
        this.f44525b = map;
        this.f44526c = map2;
        this.f44527d = aVar;
    }

    public static int k(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.f44495b.get(Protobuf.class));
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext a(FieldDescriptor fieldDescriptor, boolean z) {
        g(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext b(FieldDescriptor fieldDescriptor, long j2) throws IOException {
        h(fieldDescriptor, j2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext c(FieldDescriptor fieldDescriptor, int i2) {
        g(fieldDescriptor, i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext d(FieldDescriptor fieldDescriptor, double d2) throws IOException {
        e(fieldDescriptor, d2, true);
        return this;
    }

    public final void e(FieldDescriptor fieldDescriptor, double d2, boolean z) throws IOException {
        if (z && d2 == 0.0d) {
            return;
        }
        l((k(fieldDescriptor) << 3) | 1);
        this.f44524a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d2).array());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj) {
        i(fieldDescriptor, obj, true);
        return this;
    }

    public final void g(FieldDescriptor fieldDescriptor, int i2, boolean z) {
        if (z && i2 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.f44495b.get(Protobuf.class));
        if (protobuf == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        int iOrdinal = protobuf.intEncoding().ordinal();
        if (iOrdinal == 0) {
            l(protobuf.tag() << 3);
            l(i2);
        } else if (iOrdinal == 1) {
            l(protobuf.tag() << 3);
            l((i2 << 1) ^ (i2 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            l((protobuf.tag() << 3) | 5);
            this.f44524a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i2).array());
        }
    }

    public final void h(FieldDescriptor fieldDescriptor, long j2, boolean z) throws IOException {
        if (z && j2 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.f44495b.get(Protobuf.class));
        if (protobuf == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        int iOrdinal = protobuf.intEncoding().ordinal();
        if (iOrdinal == 0) {
            l(protobuf.tag() << 3);
            m(j2);
        } else if (iOrdinal == 1) {
            l(protobuf.tag() << 3);
            m((j2 >> 63) ^ (j2 << 1));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            l((protobuf.tag() << 3) | 1);
            this.f44524a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j2).array());
        }
    }

    public final void i(FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return;
            }
            l((k(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f44520f);
            l(bytes.length);
            this.f44524a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                i(fieldDescriptor, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                j(f44523i, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            e(fieldDescriptor, ((Double) obj).doubleValue(), z);
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z && fFloatValue == 0.0f) {
                return;
            }
            l((k(fieldDescriptor) << 3) | 5);
            this.f44524a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            h(fieldDescriptor, ((Number) obj).longValue(), z);
            return;
        }
        if (obj instanceof Boolean) {
            g(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return;
            }
            l((k(fieldDescriptor) << 3) | 2);
            l(bArr.length);
            this.f44524a.write(bArr);
            return;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.f44525b.get(obj.getClass());
        if (objectEncoder != null) {
            j(objectEncoder, fieldDescriptor, obj, z);
            return;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.f44526c.get(obj.getClass());
        if (valueEncoder != null) {
            ProtobufValueEncoderContext protobufValueEncoderContext = this.f44528e;
            protobufValueEncoderContext.f44537a = false;
            protobufValueEncoderContext.f44539c = fieldDescriptor;
            protobufValueEncoderContext.f44538b = z;
            valueEncoder.a(obj, protobufValueEncoderContext);
            return;
        }
        if (obj instanceof ProtoEnum) {
            g(fieldDescriptor, ((ProtoEnum) obj).f(), true);
        } else if (obj instanceof Enum) {
            g(fieldDescriptor, ((Enum) obj).ordinal(), true);
        } else {
            j(this.f44527d, fieldDescriptor, obj, z);
        }
    }

    public final void j(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        lengthCountingOutputStream.f44517a = 0L;
        try {
            OutputStream outputStream = this.f44524a;
            this.f44524a = lengthCountingOutputStream;
            try {
                objectEncoder.a(obj, this);
                this.f44524a = outputStream;
                long j2 = lengthCountingOutputStream.f44517a;
                lengthCountingOutputStream.close();
                if (z && j2 == 0) {
                    return;
                }
                l((k(fieldDescriptor) << 3) | 2);
                m(j2);
                objectEncoder.a(obj, this);
            } catch (Throwable th) {
                this.f44524a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void l(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.f44524a.write((i2 & WKSRecord.Service.LOCUS_CON) | 128);
            i2 >>>= 7;
        }
        this.f44524a.write(i2 & WKSRecord.Service.LOCUS_CON);
    }

    public final void m(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            this.f44524a.write((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128);
            j2 >>>= 7;
        }
        this.f44524a.write(((int) j2) & WKSRecord.Service.LOCUS_CON);
    }
}
