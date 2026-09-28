package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.SmallSortedMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

@CheckReturnValue
/* loaded from: classes3.dex */
final class SchemaUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f4138a;

    /* renamed from: b, reason: collision with root package name */
    public static final UnknownFieldSchema f4139b;

    /* renamed from: c, reason: collision with root package name */
    public static final UnknownFieldSetLiteSchema f4140c;

    static {
        Class<?> cls;
        Class<?> cls2;
        Protobuf protobuf = Protobuf.f4112c;
        UnknownFieldSchema unknownFieldSchema = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f4138a = cls;
        try {
            Protobuf protobuf2 = Protobuf.f4112c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                unknownFieldSchema = (UnknownFieldSchema) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        f4139b = unknownFieldSchema;
        f4140c = new UnknownFieldSetLiteSchema();
    }

    public static int a(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iA0 = 0;
            while (i2 < size) {
                iA0 += CodedOutputStream.a0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iA0;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iA02 = 0;
        while (i2 < size) {
            iA02 += CodedOutputStream.a0(intArrayList.getInt(i2));
            i2++;
        }
        return iA02;
    }

    public static int b(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.Y(i2) + 4) * size;
    }

    public static int c(int i2, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (CodedOutputStream.Y(i2) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iA0 = 0;
            while (i2 < size) {
                iA0 += CodedOutputStream.a0(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iA0;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iA02 = 0;
        while (i2 < size) {
            iA02 += CodedOutputStream.a0(intArrayList.getInt(i2));
            i2++;
        }
        return iA02;
    }

    public static int e(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iA0 = 0;
            while (i2 < size) {
                iA0 += CodedOutputStream.a0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iA0;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iA02 = 0;
        while (i2 < size) {
            iA02 += CodedOutputStream.a0(longArrayList.g(i2));
            i2++;
        }
        return iA02;
    }

    public static int f(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iV = 0;
            while (i2 < size) {
                iV += CodedOutputStream.V(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iV;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iV2 = 0;
        while (i2 < size) {
            iV2 += CodedOutputStream.V(intArrayList.getInt(i2));
            i2++;
        }
        return iV2;
    }

    public static int g(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iW = 0;
            while (i2 < size) {
                iW += CodedOutputStream.W(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iW;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iW2 = 0;
        while (i2 < size) {
            iW2 += CodedOutputStream.W(longArrayList.g(i2));
            i2++;
        }
        return iW2;
    }

    public static int h(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iZ = 0;
            while (i2 < size) {
                iZ += CodedOutputStream.Z(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return iZ;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iZ2 = 0;
        while (i2 < size) {
            iZ2 += CodedOutputStream.Z(intArrayList.getInt(i2));
            i2++;
        }
        return iZ2;
    }

    public static int i(List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iA0 = 0;
            while (i2 < size) {
                iA0 += CodedOutputStream.a0(((Long) list.get(i2)).longValue());
                i2++;
            }
            return iA0;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iA02 = 0;
        while (i2 < size) {
            iA02 += CodedOutputStream.a0(longArrayList.g(i2));
            i2++;
        }
        return iA02;
    }

    public static Object j(Object obj, int i2, List list, Internal.EnumVerifier enumVerifier, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        if (enumVerifier == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!enumVerifier.a(iIntValue)) {
                    obj2 = m(obj, i2, iIntValue, obj2, unknownFieldSchema);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) list.get(i4);
            int iIntValue2 = num.intValue();
            if (enumVerifier.a(iIntValue2)) {
                if (i4 != i3) {
                    list.set(i3, num);
                }
                i3++;
            } else {
                obj2 = m(obj, i2, iIntValue2, obj2, unknownFieldSchema);
            }
        }
        if (i3 != size) {
            list.subList(i3, size).clear();
        }
        return obj2;
    }

    public static void k(ExtensionSchema extensionSchema, Object obj, Object obj2) {
        FieldSet fieldSetC = extensionSchema.c(obj2);
        if (fieldSetC.f3980a.isEmpty()) {
            return;
        }
        FieldSet fieldSetD = extensionSchema.d(obj);
        fieldSetD.getClass();
        SmallSortedMap.AnonymousClass1 anonymousClass1 = fieldSetC.f3980a;
        int size = anonymousClass1.f4142a.size();
        for (int i2 = 0; i2 < size; i2++) {
            fieldSetD.k(anonymousClass1.c(i2));
        }
        Iterator it = anonymousClass1.d().iterator();
        while (it.hasNext()) {
            fieldSetD.k((Map.Entry) it.next());
        }
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Object m(Object obj, int i2, int i3, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        if (obj2 == null) {
            obj2 = unknownFieldSchema.f(obj);
        }
        unknownFieldSchema.e(obj2, i2, i3);
        return obj2;
    }

    public static void n(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.I(i2, list, z);
    }

    public static void o(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.N(i2, list, z);
    }

    public static void p(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.l(i2, list, z);
    }

    public static void q(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.G(i2, list, z);
    }

    public static void r(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i2, list, z);
    }

    public static void s(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.h(i2, list, z);
    }

    public static void t(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.M(i2, list, z);
    }

    public static void u(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.H(i2, list, z);
    }

    public static void v(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.v(i2, list, z);
    }

    public static void w(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.K(i2, list, z);
    }

    public static void x(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.o(i2, list, z);
    }

    public static void y(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.n(i2, list, z);
    }

    public static void z(int i2, List list, Writer writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.w(i2, list, z);
    }
}
