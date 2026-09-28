package com.horcrux.svg;

import com.google.ads.interactivemedia.v3.impl.data.zzck;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.HashMap;

/* loaded from: classes4.dex */
class FilterProperties {

    public enum EdgeMode {
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN(zzck.UNKNOWN_CONTENT_TYPE),
        /* JADX INFO: Fake field, exist only in values array */
        DUPLICATE("duplicate"),
        /* JADX INFO: Fake field, exist only in values array */
        WRAP("wrap"),
        /* JADX INFO: Fake field, exist only in values array */
        NONE("none");


        /* renamed from: b, reason: collision with root package name */
        public static final HashMap f45689b = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45691a;

        static {
            for (EdgeMode edgeMode : values()) {
                f45689b.put(edgeMode.f45691a, edgeMode);
            }
        }

        EdgeMode(String str) {
            this.f45691a = str;
        }

        public static void a(String str) {
            HashMap map = f45689b;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException(android.support.v4.media.b.C("Unknown 'edgeMode' Value: ", str));
            }
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45691a;
        }
    }

    public enum FeBlendMode {
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN(zzck.UNKNOWN_CONTENT_TYPE),
        /* JADX INFO: Fake field, exist only in values array */
        NORMAL("normal"),
        MULTIPLY("multiply"),
        /* JADX INFO: Fake field, exist only in values array */
        SCREEN(PaymentConstants.Event.SCREEN),
        /* JADX INFO: Fake field, exist only in values array */
        DARKEN("darken"),
        /* JADX INFO: Fake field, exist only in values array */
        LIGHTEN("lighten");


        /* renamed from: c, reason: collision with root package name */
        public static final HashMap f45693c = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45695a;

        static {
            for (FeBlendMode feBlendMode : values()) {
                f45693c.put(feBlendMode.f45695a, feBlendMode);
            }
        }

        FeBlendMode(String str) {
            this.f45695a = str;
        }

        public static FeBlendMode a(String str) {
            HashMap map = f45693c;
            if (map.containsKey(str)) {
                return (FeBlendMode) map.get(str);
            }
            throw new IllegalArgumentException(android.support.v4.media.b.C("Unknown String Value: ", str));
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45695a;
        }
    }

    public enum FeColorMatrixType {
        /* JADX INFO: Fake field, exist only in values array */
        MATRIX("matrix"),
        /* JADX INFO: Fake field, exist only in values array */
        SATURATE("saturate"),
        /* JADX INFO: Fake field, exist only in values array */
        HUE_ROTATE("hueRotate"),
        /* JADX INFO: Fake field, exist only in values array */
        LUMINANCE_TO_ALPHA("luminanceToAlpha");


        /* renamed from: b, reason: collision with root package name */
        public static final HashMap f45696b = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45698a;

        static {
            for (FeColorMatrixType feColorMatrixType : values()) {
                f45696b.put(feColorMatrixType.f45698a, feColorMatrixType);
            }
        }

        FeColorMatrixType(String str) {
            this.f45698a = str;
        }

        public static FeColorMatrixType a(String str) {
            HashMap map = f45696b;
            if (map.containsKey(str)) {
                return (FeColorMatrixType) map.get(str);
            }
            throw new IllegalArgumentException(android.support.v4.media.b.C("Unknown String Value: ", str));
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45698a;
        }
    }

    public enum FeCompositeOperator {
        /* JADX INFO: Fake field, exist only in values array */
        OVER("over"),
        /* JADX INFO: Fake field, exist only in values array */
        IN("in"),
        /* JADX INFO: Fake field, exist only in values array */
        OUT("out"),
        /* JADX INFO: Fake field, exist only in values array */
        ATOP("atop"),
        /* JADX INFO: Fake field, exist only in values array */
        XOR("xor"),
        ARITHMETIC("arithmetic");


        /* renamed from: c, reason: collision with root package name */
        public static final HashMap f45700c = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45702a;

        static {
            for (FeCompositeOperator feCompositeOperator : values()) {
                f45700c.put(feCompositeOperator.f45702a, feCompositeOperator);
            }
        }

        FeCompositeOperator(String str) {
            this.f45702a = str;
        }

        public static FeCompositeOperator a(String str) {
            HashMap map = f45700c;
            if (map.containsKey(str)) {
                return (FeCompositeOperator) map.get(str);
            }
            throw new IllegalArgumentException(android.support.v4.media.b.C("Unknown String Value: ", str));
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45702a;
        }
    }

    public enum Units {
        OBJECT_BOUNDING_BOX("objectBoundingBox"),
        USER_SPACE_ON_USE("userSpaceOnUse");


        /* renamed from: d, reason: collision with root package name */
        public static final HashMap f45705d = new HashMap();

        /* renamed from: a, reason: collision with root package name */
        public final String f45707a;

        static {
            for (Units units : values()) {
                f45705d.put(units.f45707a, units);
            }
        }

        Units(String str) {
            this.f45707a = str;
        }

        public static Units a(String str) {
            HashMap map = f45705d;
            if (map.containsKey(str)) {
                return (Units) map.get(str);
            }
            throw new IllegalArgumentException(android.support.v4.media.b.C("Unknown 'Unit' Value: ", str));
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.f45707a;
        }
    }
}
