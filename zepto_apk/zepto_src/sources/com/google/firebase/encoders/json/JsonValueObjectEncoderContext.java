package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f44508a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f44509b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f44510c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f44511d;

    /* renamed from: e, reason: collision with root package name */
    public final a f44512e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f44513f;

    public JsonValueObjectEncoderContext(Writer writer, HashMap map, HashMap map2, a aVar, boolean z) {
        this.f44509b = new JsonWriter(writer);
        this.f44510c = map;
        this.f44511d = map2;
        this.f44512e = aVar;
        this.f44513f = z;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext a(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        String str = fieldDescriptor.f44494a;
        j();
        JsonWriter jsonWriter = this.f44509b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext b(FieldDescriptor fieldDescriptor, long j2) throws IOException {
        String str = fieldDescriptor.f44494a;
        j();
        JsonWriter jsonWriter = this.f44509b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(j2);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext c(FieldDescriptor fieldDescriptor, int i2) throws IOException {
        String str = fieldDescriptor.f44494a;
        j();
        JsonWriter jsonWriter = this.f44509b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(i2);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext d(FieldDescriptor fieldDescriptor, double d2) throws IOException {
        String str = fieldDescriptor.f44494a;
        j();
        JsonWriter jsonWriter = this.f44509b;
        jsonWriter.name(str);
        j();
        jsonWriter.value(d2);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext e(String str) throws IOException {
        j();
        this.f44509b.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext f(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        i(obj, fieldDescriptor.f44494a);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext g(boolean z) throws IOException {
        j();
        this.f44509b.value(z);
        return this;
    }

    public final JsonValueObjectEncoderContext h(Object obj) {
        JsonWriter jsonWriter = this.f44509b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        i(entry.getValue(), (String) key);
                    } catch (ClassCastException e2) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            ObjectEncoder objectEncoder = (ObjectEncoder) this.f44510c.get(obj.getClass());
            if (objectEncoder != null) {
                jsonWriter.beginObject();
                objectEncoder.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.f44511d.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                jsonWriter.beginObject();
                this.f44512e.a(obj, this);
                throw null;
            }
            if (obj instanceof NumberedEnum) {
                int iF = ((NumberedEnum) obj).f();
                j();
                jsonWriter.value(iF);
                return this;
            }
            String strName = ((Enum) obj).name();
            j();
            jsonWriter.value(strName);
            return this;
        }
        if (obj instanceof byte[]) {
            j();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        int i2 = 0;
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i2 < length) {
                jsonWriter.value(r6[i2]);
                i2++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i2 < length2) {
                long j2 = jArr[i2];
                j();
                jsonWriter.value(j2);
                i2++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i2 < length3) {
                jsonWriter.value(dArr[i2]);
                i2++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i2 < length4) {
                jsonWriter.value(zArr[i2]);
                i2++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i2 < length5) {
                h(numberArr[i2]);
                i2++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i2 < length6) {
                h(objArr[i2]);
                i2++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final JsonValueObjectEncoderContext i(Object obj, String str) throws IOException {
        boolean z = this.f44513f;
        JsonWriter jsonWriter = this.f44509b;
        if (z) {
            if (obj == null) {
                return this;
            }
            j();
            jsonWriter.name(str);
            h(obj);
            return this;
        }
        j();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        h(obj);
        return this;
    }

    public final void j() {
        if (!this.f44508a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
