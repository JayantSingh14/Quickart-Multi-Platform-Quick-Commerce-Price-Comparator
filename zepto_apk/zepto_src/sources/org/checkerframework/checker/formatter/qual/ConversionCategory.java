package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public enum ConversionCategory {
    /* JADX INFO: Fake field, exist only in values array */
    GENERAL(null),
    /* JADX INFO: Fake field, exist only in values array */
    CHAR(Character.class, Byte.class, Short.class, Integer.class),
    /* JADX INFO: Fake field, exist only in values array */
    INT(Byte.class, Short.class, Integer.class, Long.class, BigInteger.class),
    /* JADX INFO: Fake field, exist only in values array */
    FLOAT(Float.class, Double.class, BigDecimal.class),
    /* JADX INFO: Fake field, exist only in values array */
    TIME(Long.class, Calendar.class, Date.class),
    /* JADX INFO: Fake field, exist only in values array */
    CHAR_AND_INT(Byte.class, Short.class, Integer.class),
    /* JADX INFO: Fake field, exist only in values array */
    INT_AND_TIME(Long.class),
    /* JADX INFO: Fake field, exist only in values array */
    NULL(new Class[0]),
    /* JADX INFO: Fake field, exist only in values array */
    UNUSED(null);


    /* renamed from: a, reason: collision with root package name */
    public final Class[] f57450a;

    ConversionCategory(Class... clsArr) {
        if (clsArr == null) {
            this.f57450a = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        int length = clsArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Class cls = clsArr[i2];
            arrayList.add(cls);
            Class cls2 = cls == Byte.class ? Byte.TYPE : cls == Character.class ? Character.TYPE : cls == Short.class ? Short.TYPE : cls == Integer.class ? Integer.TYPE : cls == Long.class ? Long.TYPE : cls == Float.class ? Float.TYPE : cls == Double.class ? Double.TYPE : cls == Boolean.class ? Boolean.TYPE : null;
            if (cls2 != null) {
                arrayList.add(cls2);
            }
        }
        this.f57450a = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" conversion category");
        Class[] clsArr = this.f57450a;
        if (clsArr == null || clsArr.length == 0) {
            return sb.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "(one of: ", ")");
        for (Class cls : clsArr) {
            stringJoiner.add(cls.getSimpleName());
        }
        sb.append(StringUtils.SPACE);
        sb.append(stringJoiner);
        return sb.toString();
    }
}
