package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.apache.commons.lang3.StringUtils;

@Metadata
/* loaded from: classes.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f56256a;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f56257a = new ArrayList(20);

        public final void a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion.a(name);
            Companion.b(value, name);
            c(name, value);
        }

        public final void b(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            int iW = StringsKt.w(line, ':', 1, 4);
            if (iW != -1) {
                String strSubstring = line.substring(0, iW);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iW + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                c(strSubstring, strSubstring2);
                return;
            }
            if (line.charAt(0) != ':') {
                c("", line);
                return;
            }
            String strSubstring3 = line.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
            c("", strSubstring3);
        }

        public final void c(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            ArrayList arrayList = this.f56257a;
            arrayList.add(name);
            arrayList.add(StringsKt.b0(value).toString());
        }

        public final void d(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion.a(name);
            c(name, value);
        }

        public final Headers e() {
            return new Headers((String[]) this.f56257a.toArray(new String[0]));
        }

        public final String f(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            ArrayList arrayList = this.f56257a;
            int size = arrayList.size() - 2;
            int iA = ProgressionUtilKt.a(size, 0, -2);
            if (iA > size) {
                return null;
            }
            while (!StringsKt.t(name, (String) arrayList.get(size), true)) {
                if (size == iA) {
                    return null;
                }
                size -= 2;
            }
            return (String) arrayList.get(size + 1);
        }

        public final void g(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f56257a;
                if (i2 >= arrayList.size()) {
                    return;
                }
                if (StringsKt.t(name, (String) arrayList.get(i2), true)) {
                    arrayList.remove(i2);
                    arrayList.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
        }

        public final void h(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion.a(name);
            Companion.b(value, name);
            g(name);
            c(name, value);
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        public static void a(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), str).toString());
                }
            }
        }

        public static void b(String str, String str2) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i2), str2));
                    sb.append(Util.q(str2) ? "" : ": ".concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public static Headers c(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String str = strArr[i3];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr[i3] = StringsKt.b0(str).toString();
            }
            int iA = ProgressionUtilKt.a(0, strArr.length - 1, 2);
            if (iA >= 0) {
                while (true) {
                    String str2 = strArr[i2];
                    String str3 = strArr[i2 + 1];
                    a(str2);
                    b(str3, str2);
                    if (i2 == iA) {
                        break;
                    }
                    i2 += 2;
                }
            }
            return new Headers(strArr);
        }
    }

    public Headers(String[] strArr) {
        this.f56256a = strArr;
    }

    public static final Headers j(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String[] strArr = new String[map.size() * 2];
        int i2 = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            String string = StringsKt.b0(str).toString();
            String string2 = StringsKt.b0(str2).toString();
            Companion.a(string);
            Companion.b(string2, string);
            strArr[i2] = string;
            strArr[i2 + 1] = string2;
            i2 += 2;
        }
        return new Headers(strArr);
    }

    public final long b() {
        String[] strArr = this.f56256a;
        long length = strArr.length * 2;
        for (String str : strArr) {
            length += str.length();
        }
        return length;
    }

    public final String d(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.f56256a;
        int length = strArr.length - 2;
        int iA = ProgressionUtilKt.a(length, 0, -2);
        if (iA > length) {
            return null;
        }
        while (!StringsKt.t(name, strArr[length], true)) {
            if (length == iA) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return Arrays.equals(this.f56256a, ((Headers) obj).f56256a);
        }
        return false;
    }

    public final String f(int i2) {
        return this.f56256a[i2 * 2];
    }

    public final Set g() {
        Intrinsics.checkNotNullParameter(StringCompanionObject.f53805a, "<this>");
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeSet treeSet = new TreeSet(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            treeSet.add(f(i2));
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f56256a);
    }

    public final Builder i() {
        Builder builder = new Builder();
        CollectionsKt.j(builder.f56257a, this.f56256a);
        return builder;
    }

    @Override // java.lang.Iterable
    public final Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i2 = 0; i2 < size; i2++) {
            pairArr[i2] = new Pair(f(i2), m(i2));
        }
        return ArrayIteratorKt.a(pairArr);
    }

    public final TreeMap k() {
        Intrinsics.checkNotNullParameter(StringCompanionObject.f53805a, "<this>");
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        TreeMap treeMap = new TreeMap(CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String strF = f(i2);
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = strF.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(m(i2));
        }
        return treeMap;
    }

    public final String m(int i2) {
        return this.f56256a[(i2 * 2) + 1];
    }

    public final List n(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            if (StringsKt.t(name, f(i2), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m(i2));
            }
        }
        if (arrayList == null) {
            return EmptyList.f53609a;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public final int size() {
        return this.f56256a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            String strF = f(i2);
            String strM = m(i2);
            sb.append(strF);
            sb.append(": ");
            if (Util.q(strF)) {
                strM = "██";
            }
            sb.append(strM);
            sb.append(StringUtils.LF);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
