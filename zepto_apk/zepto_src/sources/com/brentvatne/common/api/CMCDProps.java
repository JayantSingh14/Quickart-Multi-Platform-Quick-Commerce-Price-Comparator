package com.brentvatne.common.api;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.facebook.react.bridge.ReadableType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class CMCDProps {

    /* renamed from: a, reason: collision with root package name */
    public final List f15363a;

    /* renamed from: b, reason: collision with root package name */
    public final List f15364b;

    /* renamed from: c, reason: collision with root package name */
    public final List f15365c;

    /* renamed from: d, reason: collision with root package name */
    public final List f15366d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15367e;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15368a;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f15368a = iArr;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.util.List a(com.facebook.react.bridge.ReadableArray r8) {
            /*
                if (r8 != 0) goto L5
                kotlin.collections.EmptyList r8 = kotlin.collections.EmptyList.f53609a
                return r8
            L5:
                r0 = 0
                int r1 = r8.size()
                kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.f(r0, r1)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Iterator r0 = r0.iterator()
            L17:
                r2 = r0
                kotlin.ranges.IntProgressionIterator r2 = (kotlin.ranges.IntProgressionIterator) r2
                boolean r2 = r2.f53843c
                if (r2 == 0) goto L72
                r2 = r0
                kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
                int r2 = r2.a()
                com.facebook.react.bridge.ReadableMap r2 = r8.getMap(r2)
                r3 = 0
                if (r2 == 0) goto L33
                java.lang.String r4 = "key"
                java.lang.String r4 = r2.getString(r4)
                goto L34
            L33:
                r4 = r3
            L34:
                java.lang.String r5 = "value"
                if (r2 == 0) goto L3d
                com.facebook.react.bridge.ReadableType r6 = r2.getType(r5)
                goto L3e
            L3d:
                r6 = r3
            L3e:
                if (r6 != 0) goto L42
                r6 = -1
                goto L4a
            L42:
                int[] r7 = com.brentvatne.common.api.CMCDProps.Companion.WhenMappings.f15368a
                int r6 = r6.ordinal()
                r6 = r7[r6]
            L4a:
                r7 = 1
                if (r6 == r7) goto L59
                r7 = 2
                if (r6 == r7) goto L52
            L50:
                r2 = r3
                goto L63
            L52:
                if (r2 == 0) goto L50
                java.lang.String r2 = r2.getString(r5)
                goto L63
            L59:
                if (r2 == 0) goto L50
                double r5 = r2.getDouble(r5)
                java.lang.Double r2 = java.lang.Double.valueOf(r5)
            L63:
                if (r4 == 0) goto L6c
                if (r2 == 0) goto L6c
                kotlin.Pair r3 = new kotlin.Pair
                r3.<init>(r4, r2)
            L6c:
                if (r3 == 0) goto L17
                r1.add(r3)
                goto L17
            L72:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.common.api.CMCDProps.Companion.a(com.facebook.react.bridge.ReadableArray):java.util.List");
        }
    }

    public CMCDProps(List cmcdObject, List cmcdRequest, List cmcdSession, List cmcdStatus, int i2) {
        Intrinsics.checkNotNullParameter(cmcdObject, "cmcdObject");
        Intrinsics.checkNotNullParameter(cmcdRequest, "cmcdRequest");
        Intrinsics.checkNotNullParameter(cmcdSession, "cmcdSession");
        Intrinsics.checkNotNullParameter(cmcdStatus, "cmcdStatus");
        this.f15363a = cmcdObject;
        this.f15364b = cmcdRequest;
        this.f15365c = cmcdSession;
        this.f15366d = cmcdStatus;
        this.f15367e = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CMCDProps)) {
            return false;
        }
        CMCDProps cMCDProps = (CMCDProps) obj;
        return Intrinsics.b(this.f15363a, cMCDProps.f15363a) && Intrinsics.b(this.f15364b, cMCDProps.f15364b) && Intrinsics.b(this.f15365c, cMCDProps.f15365c) && Intrinsics.b(this.f15366d, cMCDProps.f15366d) && this.f15367e == cMCDProps.f15367e;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f15367e) + e.f(e.f(e.f(this.f15363a.hashCode() * 31, 31, this.f15364b), 31, this.f15365c), 31, this.f15366d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CMCDProps(cmcdObject=");
        sb.append(this.f15363a);
        sb.append(", cmcdRequest=");
        sb.append(this.f15364b);
        sb.append(", cmcdSession=");
        sb.append(this.f15365c);
        sb.append(", cmcdStatus=");
        sb.append(this.f15366d);
        sb.append(", mode=");
        return b.o(sb, this.f15367e, ")");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CMCDProps() {
        EmptyList emptyList = EmptyList.f53609a;
        this(emptyList, emptyList, emptyList, emptyList, 1);
    }
}
