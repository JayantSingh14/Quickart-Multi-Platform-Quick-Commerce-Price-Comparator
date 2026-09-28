package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.HashMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Escapers {

    /* renamed from: com.google.common.escape.Escapers$1, reason: invalid class name */
    public class AnonymousClass1 extends CharEscaper {
    }

    /* renamed from: com.google.common.escape.Escapers$2, reason: invalid class name */
    class AnonymousClass2 extends UnicodeEscaper {
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f43174a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public char f43175b = 65535;

        /* renamed from: c, reason: collision with root package name */
        public String f43176c = null;

        /* renamed from: com.google.common.escape.Escapers$Builder$1, reason: invalid class name */
        class AnonymousClass1 extends ArrayBasedCharEscaper {
        }

        public final void a() {
            char[][] cArr;
            HashMap map = this.f43174a;
            map.getClass();
            if (map.isEmpty()) {
                cArr = ArrayBasedEscaperMap.f43173a;
            } else {
                char[][] cArr2 = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
                for (Character ch2 : map.keySet()) {
                    cArr2[ch2.charValue()] = ((String) map.get(ch2)).toCharArray();
                }
                cArr = cArr2;
            }
            int length = cArr.length;
            String str = this.f43176c;
            if (str != null) {
                str.toCharArray();
            }
        }
    }
}
