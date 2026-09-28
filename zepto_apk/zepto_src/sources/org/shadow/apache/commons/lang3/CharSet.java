package org.shadow.apache.commons.lang3;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class CharSet implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f57699b;

    /* renamed from: a, reason: collision with root package name */
    public final Set f57700a = Collections.synchronizedSet(new HashSet());

    static {
        CharSet charSet = new CharSet(null);
        CharSet charSet2 = new CharSet("a-zA-Z");
        CharSet charSet3 = new CharSet("a-z");
        CharSet charSet4 = new CharSet("A-Z");
        CharSet charSet5 = new CharSet("0-9");
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        f57699b = mapSynchronizedMap;
        mapSynchronizedMap.put(null, charSet);
        mapSynchronizedMap.put("", charSet);
        mapSynchronizedMap.put("a-zA-Z", charSet2);
        mapSynchronizedMap.put("A-Za-z", charSet2);
        mapSynchronizedMap.put("a-z", charSet3);
        mapSynchronizedMap.put("A-Z", charSet4);
        mapSynchronizedMap.put("0-9", charSet5);
    }

    public CharSet(String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                int length = str.length();
                int i2 = 0;
                while (i2 < length) {
                    int i3 = length - i2;
                    Set set = this.f57700a;
                    if (i3 >= 4 && str.charAt(i2) == '^' && str.charAt(i2 + 2) == '-') {
                        set.add(new CharRange(str.charAt(i2 + 1), str.charAt(i2 + 3), true));
                        i2 += 4;
                    } else if (i3 >= 3 && str.charAt(i2 + 1) == '-') {
                        set.add(new CharRange(str.charAt(i2), str.charAt(i2 + 2), false));
                        i2 += 3;
                    } else if (i3 < 2 || str.charAt(i2) != '^') {
                        char cCharAt = str.charAt(i2);
                        set.add(new CharRange(cCharAt, cCharAt, false));
                        i2++;
                    } else {
                        char cCharAt2 = str.charAt(i2 + 1);
                        set.add(new CharRange(cCharAt2, cCharAt2, true));
                        i2 += 2;
                    }
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CharSet) {
            return this.f57700a.equals(((CharSet) obj).f57700a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f57700a.hashCode() + 89;
    }

    public final String toString() {
        return this.f57700a.toString();
    }
}
