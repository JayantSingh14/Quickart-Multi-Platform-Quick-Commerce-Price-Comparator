package com.facebook.react.animated;

import android.support.v4.media.b;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class InterpolationAnimatedNode extends ValueAnimatedNode {
    public static final Pattern p;

    /* renamed from: h, reason: collision with root package name */
    public final double[] f18558h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f18559i;

    /* renamed from: j, reason: collision with root package name */
    public final OutputType f18560j;

    /* renamed from: k, reason: collision with root package name */
    public final String f18561k;

    /* renamed from: l, reason: collision with root package name */
    public final String f18562l;

    /* renamed from: m, reason: collision with root package name */
    public final String f18563m;
    public ValueAnimatedNode n;
    public Object o;

    @Metadata
    public static final class Companion {
        public static int a(double[] dArr, double d2) {
            int i2 = 1;
            while (i2 < dArr.length - 1 && dArr[i2] < d2) {
                i2++;
            }
            return i2 - 1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        
            if (r20.equals("extend") == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
        
            if (r21.equals("extend") == false) goto L35;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static double b(double r10, double r12, double r14, double r16, double r18, java.lang.String r20, java.lang.String r21) {
            /*
                r0 = r20
                r1 = r21
                int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                java.lang.String r3 = "extend"
                java.lang.String r4 = "identity"
                java.lang.String r5 = "clamp"
                r6 = 94742715(0x5a5a8bb, float:1.5578507E-35)
                r7 = -135761730(0xfffffffff7e870be, float:-9.428903E33)
                r8 = -1289044198(0xffffffffb32abf1a, float:-3.9755015E-8)
                if (r2 >= 0) goto L38
                if (r0 == 0) goto L37
                int r9 = r0.hashCode()
                if (r9 == r8) goto L31
                if (r9 == r7) goto L2d
                if (r9 == r6) goto L24
                goto L37
            L24:
                boolean r0 = r0.equals(r5)
                if (r0 != 0) goto L2b
                goto L37
            L2b:
                r10 = r12
                goto L38
            L2d:
                r0.equals(r4)
                return r10
            L31:
                boolean r0 = r0.equals(r3)
                if (r0 != 0) goto L38
            L37:
                return r10
            L38:
                int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
                if (r0 <= 0) goto L5d
                if (r1 == 0) goto L5c
                int r0 = r1.hashCode()
                if (r0 == r8) goto L56
                if (r0 == r7) goto L52
                if (r0 == r6) goto L49
                goto L5c
            L49:
                boolean r0 = r1.equals(r5)
                if (r0 != 0) goto L50
                goto L5c
            L50:
                r10 = r14
                goto L5d
            L52:
                r1.equals(r4)
                return r10
            L56:
                boolean r0 = r1.equals(r3)
                if (r0 != 0) goto L5d
            L5c:
                return r10
            L5d:
                int r0 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
                if (r0 != 0) goto L62
                goto L68
            L62:
                int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r0 != 0) goto L6a
                if (r2 > 0) goto L69
            L68:
                return r16
            L69:
                return r18
            L6a:
                double r0 = r18 - r16
                double r10 = r10 - r12
                double r10 = r10 * r0
                double r12 = r14 - r12
                double r10 = r10 / r12
                double r10 = r10 + r16
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.InterpolationAnimatedNode.Companion.b(double, double, double, double, double, java.lang.String, java.lang.String):double");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class OutputType {

        /* renamed from: a, reason: collision with root package name */
        public static final OutputType f18564a;

        /* renamed from: b, reason: collision with root package name */
        public static final OutputType f18565b;

        /* renamed from: c, reason: collision with root package name */
        public static final OutputType f18566c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ OutputType[] f18567d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f18568e;

        static {
            OutputType outputType = new OutputType("Number", 0);
            f18564a = outputType;
            OutputType outputType2 = new OutputType("Color", 1);
            f18565b = outputType2;
            OutputType outputType3 = new OutputType("String", 2);
            f18566c = outputType3;
            OutputType[] outputTypeArr = {outputType, outputType2, outputType3};
            f18567d = outputTypeArr;
            f18568e = EnumEntriesKt.a(outputTypeArr);
        }

        public static OutputType valueOf(String str) {
            return (OutputType) Enum.valueOf(OutputType.class, str);
        }

        public static OutputType[] values() {
            return (OutputType[]) f18567d.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18569a;

        static {
            int[] iArr = new int[OutputType.values().length];
            try {
                OutputType outputType = OutputType.f18564a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OutputType outputType2 = OutputType.f18564a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OutputType outputType3 = OutputType.f18564a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18569a = iArr;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        p = patternCompile;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterpolationAnimatedNode(ReadableMap config) {
        double[] dArr;
        double[] dArr2;
        int[] iArr;
        super(null);
        Intrinsics.checkNotNullParameter(config, "config");
        ReadableArray array = config.getArray("inputRange");
        int i2 = 0;
        if (array != null) {
            int size = array.size();
            dArr = new double[size];
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = array.getDouble(i3);
            }
        } else {
            dArr = new double[0];
        }
        this.f18558h = dArr;
        this.f18562l = config.getString("extrapolateLeft");
        this.f18563m = config.getString("extrapolateRight");
        ReadableArray array2 = config.getArray("outputRange");
        if ("color".equals(config.getString("outputType"))) {
            this.f18560j = OutputType.f18565b;
            if (array2 != null) {
                int size2 = array2.size();
                iArr = new int[size2];
                while (i2 < size2) {
                    iArr[i2] = array2.getInt(i2);
                    i2++;
                }
            } else {
                iArr = new int[0];
            }
            this.f18559i = iArr;
            return;
        }
        if ((array2 != null ? array2.getType(0) : null) != ReadableType.String) {
            this.f18560j = OutputType.f18564a;
            if (array2 != null) {
                int size3 = array2.size();
                dArr2 = new double[size3];
                while (i2 < size3) {
                    dArr2[i2] = array2.getDouble(i2);
                    i2++;
                }
            } else {
                dArr2 = new double[0];
            }
            this.f18559i = dArr2;
            return;
        }
        this.f18560j = OutputType.f18566c;
        int size4 = array2.size();
        double[][] dArr3 = new double[size4][];
        String string = array2.getString(0);
        string = string == null ? "" : string;
        Pattern pattern = p;
        Matcher matcher = pattern.matcher(string);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            String strGroup = matcher.group();
            Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
            arrayList.add(Double.valueOf(Double.parseDouble(strGroup)));
        }
        int size5 = arrayList.size();
        double[] dArr4 = new double[size5];
        int size6 = arrayList.size();
        for (int i4 = 0; i4 < size6; i4++) {
            dArr4[i4] = ((Number) arrayList.get(i4)).doubleValue();
        }
        dArr3[0] = dArr4;
        for (int i5 = 1; i5 < size4; i5++) {
            double[] dArr5 = new double[size5];
            String string2 = array2.getString(i5);
            Matcher matcher2 = pattern.matcher(string2 == null ? "" : string2);
            for (int i6 = 0; matcher2.find() && i6 < size5; i6++) {
                String strGroup2 = matcher2.group();
                Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                dArr5[i6] = Double.parseDouble(strGroup2);
            }
            dArr3[i5] = dArr5;
        }
        this.f18559i = dArr3;
        this.f18561k = array2.getString(0);
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void b(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.n == null && (parent instanceof ValueAnimatedNode)) {
            this.n = (ValueAnimatedNode) parent;
        }
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void c(AnimatedNode parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.equals(this.n)) {
            this.n = null;
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public final String d() {
        return b.g(this.f18524d, "InterpolationAnimatedNode[", "] super: {super.prettyPrint()}");
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public final void e() {
        String pattern;
        ValueAnimatedNode valueAnimatedNode = this.n;
        if (valueAnimatedNode != null) {
            double dG = valueAnimatedNode.g();
            OutputType outputType = this.f18560j;
            int i2 = outputType == null ? -1 : WhenMappings.f18569a[outputType.ordinal()];
            Object obj = this.f18559i;
            double[] inputRange = this.f18558h;
            if (i2 == 1) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.DoubleArray");
                double[] outputRange = (double[]) obj;
                Intrinsics.checkNotNullParameter(inputRange, "inputRange");
                Intrinsics.checkNotNullParameter(outputRange, "outputRange");
                int iA = Companion.a(inputRange, dG);
                int i3 = iA + 1;
                this.f18673e = Companion.b(dG, inputRange[iA], inputRange[i3], outputRange[iA], outputRange[i3], this.f18562l, this.f18563m);
                return;
            }
            if (i2 == 2) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.IntArray");
                int[] outputRange2 = (int[]) obj;
                Intrinsics.checkNotNullParameter(inputRange, "inputRange");
                Intrinsics.checkNotNullParameter(outputRange2, "outputRange");
                int iA2 = Companion.a(inputRange, dG);
                int iD = outputRange2[iA2];
                int i4 = iA2 + 1;
                int i5 = outputRange2[i4];
                if (iD != i5) {
                    double d2 = inputRange[iA2];
                    double d3 = inputRange[i4];
                    if (d2 != d3) {
                        iD = ColorUtils.d((float) ((dG - d2) / (d3 - d2)), iD, i5);
                    } else if (dG > d2) {
                        iD = i5;
                    }
                }
                this.o = Integer.valueOf(iD);
                return;
            }
            if (i2 == 3 && (pattern = this.f18561k) != null) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.DoubleArray>");
                double[][] outputRange3 = (double[][]) obj;
                Intrinsics.checkNotNullParameter(pattern, "pattern");
                Intrinsics.checkNotNullParameter(inputRange, "inputRange");
                Intrinsics.checkNotNullParameter(outputRange3, "outputRange");
                int iA3 = Companion.a(inputRange, dG);
                StringBuffer stringBuffer = new StringBuffer(pattern.length());
                Matcher matcher = p.matcher(pattern);
                int i6 = 0;
                while (matcher.find()) {
                    double[] dArr = outputRange3[iA3];
                    if (i6 >= dArr.length) {
                        break;
                    }
                    int i7 = iA3 + 1;
                    StringBuffer stringBuffer2 = stringBuffer;
                    int i8 = i6;
                    double[][] dArr2 = outputRange3;
                    double dB = Companion.b(dG, inputRange[iA3], inputRange[i7], dArr[i6], outputRange3[i7][i6], this.f18562l, this.f18563m);
                    int i9 = (int) dB;
                    matcher.appendReplacement(stringBuffer2, ((double) i9) == dB ? String.valueOf(i9) : String.valueOf(dB));
                    i6 = i8 + 1;
                    stringBuffer = stringBuffer2;
                    outputRange3 = dArr2;
                }
                StringBuffer stringBuffer3 = stringBuffer;
                matcher.appendTail(stringBuffer3);
                String string = stringBuffer3.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                this.o = string;
            }
        }
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode
    public final Object f() {
        return this.o;
    }
}
