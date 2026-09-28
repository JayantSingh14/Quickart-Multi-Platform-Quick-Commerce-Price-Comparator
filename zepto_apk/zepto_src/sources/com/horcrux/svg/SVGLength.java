package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
class SVGLength {

    /* renamed from: a, reason: collision with root package name */
    public final double f45853a;

    /* renamed from: b, reason: collision with root package name */
    public final UnitType f45854b;

    /* renamed from: com.horcrux.svg.SVGLength$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45855a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            f45855a = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45855a[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45855a[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum UnitType {
        UNKNOWN,
        NUMBER,
        PERCENTAGE,
        EMS,
        EXS,
        PX,
        CM,
        MM,
        IN,
        PT,
        PC
    }

    public SVGLength() {
        this.f45853a = 0.0d;
        this.f45854b = UnitType.UNKNOWN;
    }

    public static ArrayList a(Dynamic dynamic) {
        int i2 = AnonymousClass1.f45855a[dynamic.getType().ordinal()];
        if (i2 == 1) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new SVGLength(dynamic.asDouble()));
            return arrayList;
        }
        int i3 = 0;
        if (i2 == 2) {
            String[] strArrSplit = dynamic.asString().trim().replaceAll(",", StringUtils.SPACE).split(StringUtils.SPACE);
            ArrayList arrayList2 = new ArrayList(strArrSplit.length);
            int length = strArrSplit.length;
            while (i3 < length) {
                arrayList2.add(new SVGLength(strArrSplit[i3]));
                i3++;
            }
            return arrayList2;
        }
        if (i2 != 3) {
            return null;
        }
        ReadableArray readableArrayAsArray = dynamic.asArray();
        int size = readableArrayAsArray.size();
        ArrayList arrayList3 = new ArrayList(size);
        while (i3 < size) {
            arrayList3.add(b(readableArrayAsArray.getDynamic(i3)));
            i3++;
        }
        return arrayList3;
    }

    public static SVGLength b(Dynamic dynamic) {
        int i2 = AnonymousClass1.f45855a[dynamic.getType().ordinal()];
        return i2 != 1 ? i2 != 2 ? new SVGLength() : new SVGLength(dynamic.asString()) : new SVGLength(dynamic.asDouble());
    }

    public static String c(Dynamic dynamic) {
        int i2 = AnonymousClass1.f45855a[dynamic.getType().ordinal()];
        if (i2 == 1) {
            return String.valueOf(dynamic.asDouble());
        }
        if (i2 != 2) {
            return null;
        }
        return dynamic.asString();
    }

    public SVGLength(double d2) {
        this.f45853a = d2;
        this.f45854b = UnitType.NUMBER;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SVGLength(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.SVGLength.<init>(java.lang.String):void");
    }
}
