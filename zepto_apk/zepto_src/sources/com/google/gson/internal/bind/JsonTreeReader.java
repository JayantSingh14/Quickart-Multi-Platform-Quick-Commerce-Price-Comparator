package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes.dex */
public final class JsonTreeReader extends JsonReader {
    public static final Reader t = new Reader() { // from class: com.google.gson.internal.bind.JsonTreeReader.1
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public final int read(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    };
    public static final Object u = new Object();
    public Object[] p;
    public int q;
    public String[] r;
    public int[] s;

    /* renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45357a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f45357a = iArr;
            try {
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45357a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45357a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45357a[9] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public final String D0() {
        return " at path " + z0(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public final void E() {
        int iOrdinal = j0().ordinal();
        if (iOrdinal == 1) {
            e();
            return;
        }
        if (iOrdinal != 9) {
            if (iOrdinal == 3) {
                t();
                return;
            }
            if (iOrdinal == 4) {
                T0(true);
                return;
            }
            j1();
            int i2 = this.q;
            if (i2 > 0) {
                int[] iArr = this.s;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public final String K0() {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.f45480f;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.f45481g) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + D0());
        }
        String strN = ((JsonPrimitive) j1()).n();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return strN;
    }

    @Override // com.google.gson.stream.JsonReader
    public final boolean N() {
        y0(JsonToken.f45482h);
        boolean zK = ((JsonPrimitive) j1()).k();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return zK;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void T() {
        y0(JsonToken.f45483i);
        j1();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final String T0(boolean z) {
        y0(JsonToken.f45479e);
        Map.Entry entry = (Map.Entry) ((Iterator) c1()).next();
        String str = (String) entry.getKey();
        this.r[this.q - 1] = z ? "<skipped>" : str;
        l1(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.JsonReader
    public final String X() {
        return T0(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public final void a() {
        y0(JsonToken.f45475a);
        l1(((JsonArray) c1()).f45254a.iterator());
        this.s[this.q - 1] = 0;
    }

    public final Object c1() {
        return this.p[this.q - 1];
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.p = new Object[]{u};
        this.q = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void e() {
        y0(JsonToken.f45476b);
        j1();
        j1();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public final String j() {
        return z0(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public final JsonToken j0() {
        if (this.q == 0) {
            return JsonToken.f45484j;
        }
        Object objC1 = c1();
        if (objC1 instanceof Iterator) {
            boolean z = this.p[this.q - 2] instanceof JsonObject;
            Iterator it = (Iterator) objC1;
            if (!it.hasNext()) {
                return z ? JsonToken.f45478d : JsonToken.f45476b;
            }
            if (z) {
                return JsonToken.f45479e;
            }
            l1(it.next());
            return j0();
        }
        if (objC1 instanceof JsonObject) {
            return JsonToken.f45477c;
        }
        if (objC1 instanceof JsonArray) {
            return JsonToken.f45475a;
        }
        if (objC1 instanceof JsonPrimitive) {
            Serializable serializable = ((JsonPrimitive) objC1).f45257a;
            if (serializable instanceof String) {
                return JsonToken.f45480f;
            }
            if (serializable instanceof Boolean) {
                return JsonToken.f45482h;
            }
            if (serializable instanceof Number) {
                return JsonToken.f45481g;
            }
            throw new AssertionError();
        }
        if (objC1 instanceof JsonNull) {
            return JsonToken.f45483i;
        }
        if (objC1 == u) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + objC1.getClass().getName() + " is not supported");
    }

    public final Object j1() {
        Object[] objArr = this.p;
        int i2 = this.q - 1;
        this.q = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public final void k() {
        y0(JsonToken.f45477c);
        l1(((JsonObject) c1()).f45256a.entrySet().iterator());
    }

    public final void l1(Object obj) {
        int i2 = this.q;
        Object[] objArr = this.p;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.p = Arrays.copyOf(objArr, i3);
            this.s = Arrays.copyOf(this.s, i3);
            this.r = (String[]) Arrays.copyOf(this.r, i3);
        }
        Object[] objArr2 = this.p;
        int i4 = this.q;
        this.q = i4 + 1;
        objArr2[i4] = obj;
    }

    @Override // com.google.gson.stream.JsonReader
    public final double nextDouble() throws MalformedJsonException {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.f45481g;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.f45480f) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + D0());
        }
        double dB = ((JsonPrimitive) c1()).b();
        if (this.f45463b != Strictness.f45265a && (Double.isNaN(dB) || Double.isInfinite(dB))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dB);
        }
        j1();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return dB;
    }

    @Override // com.google.gson.stream.JsonReader
    public final int nextInt() {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.f45481g;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.f45480f) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + D0());
        }
        int iD = ((JsonPrimitive) c1()).d();
        j1();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return iD;
    }

    @Override // com.google.gson.stream.JsonReader
    public final long nextLong() {
        JsonToken jsonTokenJ0 = j0();
        JsonToken jsonToken = JsonToken.f45481g;
        if (jsonTokenJ0 != jsonToken && jsonTokenJ0 != JsonToken.f45480f) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenJ0 + D0());
        }
        long jI = ((JsonPrimitive) c1()).i();
        j1();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return jI;
    }

    @Override // com.google.gson.stream.JsonReader
    public final String s() {
        return z0(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public final void t() {
        y0(JsonToken.f45478d);
        this.r[this.q - 1] = null;
        j1();
        j1();
        int i2 = this.q;
        if (i2 > 0) {
            int[] iArr = this.s;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.JsonReader
    public final String toString() {
        return "JsonTreeReader" + D0();
    }

    @Override // com.google.gson.stream.JsonReader
    public final boolean x() {
        JsonToken jsonTokenJ0 = j0();
        return (jsonTokenJ0 == JsonToken.f45478d || jsonTokenJ0 == JsonToken.f45476b || jsonTokenJ0 == JsonToken.f45484j) ? false : true;
    }

    public final void y0(JsonToken jsonToken) {
        if (j0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + j0() + D0());
    }

    public final String z0(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (true) {
            int i3 = this.q;
            if (i2 >= i3) {
                return sb.toString();
            }
            Object[] objArr = this.p;
            Object obj = objArr[i2];
            if (obj instanceof JsonArray) {
                i2++;
                if (i2 < i3 && (objArr[i2] instanceof Iterator)) {
                    int i4 = this.s[i2];
                    if (z && i4 > 0 && (i2 == i3 - 1 || i2 == i3 - 2)) {
                        i4--;
                    }
                    sb.append('[');
                    sb.append(i4);
                    sb.append(']');
                }
            } else if ((obj instanceof JsonObject) && (i2 = i2 + 1) < i3 && (objArr[i2] instanceof Iterator)) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.r[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
            i2++;
        }
    }
}
