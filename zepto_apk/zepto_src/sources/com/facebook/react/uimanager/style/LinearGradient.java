package com.facebook.react.uimanager.style;

import android.support.v4.media.b;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class LinearGradient {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f19887a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f19888b;

    /* renamed from: c, reason: collision with root package name */
    public final Direction f19889c;

    @Metadata
    public static abstract class Direction {

        @Metadata
        public static final class Angle extends Direction {

            /* renamed from: a, reason: collision with root package name */
            public final double f19890a;

            public Angle(double d2) {
                this.f19890a = d2;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Angle) && Double.compare(this.f19890a, ((Angle) obj).f19890a) == 0;
            }

            public final int hashCode() {
                return Double.hashCode(this.f19890a);
            }

            public final String toString() {
                return "Angle(value=" + this.f19890a + ")";
            }
        }

        @Metadata
        public static final class Keyword extends Direction {

            /* renamed from: a, reason: collision with root package name */
            public final Keywords f19891a;

            public Keyword(Keywords value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.f19891a = value;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Keyword) && this.f19891a == ((Keyword) obj).f19891a;
            }

            public final int hashCode() {
                return this.f19891a.hashCode();
            }

            public final String toString() {
                return "Keyword(value=" + this.f19891a + ")";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata
        public static final class Keywords {

            /* renamed from: a, reason: collision with root package name */
            public static final Keywords f19892a;

            /* renamed from: b, reason: collision with root package name */
            public static final Keywords f19893b;

            /* renamed from: c, reason: collision with root package name */
            public static final Keywords f19894c;

            /* renamed from: d, reason: collision with root package name */
            public static final Keywords f19895d;

            /* renamed from: e, reason: collision with root package name */
            public static final /* synthetic */ Keywords[] f19896e;

            /* renamed from: f, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f19897f;

            static {
                Keywords keywords = new Keywords("TO_TOP_RIGHT", 0);
                f19892a = keywords;
                Keywords keywords2 = new Keywords("TO_BOTTOM_RIGHT", 1);
                f19893b = keywords2;
                Keywords keywords3 = new Keywords("TO_TOP_LEFT", 2);
                f19894c = keywords3;
                Keywords keywords4 = new Keywords("TO_BOTTOM_LEFT", 3);
                f19895d = keywords4;
                Keywords[] keywordsArr = {keywords, keywords2, keywords3, keywords4};
                f19896e = keywordsArr;
                f19897f = EnumEntriesKt.a(keywordsArr);
            }

            public static Keywords valueOf(String str) {
                return (Keywords) Enum.valueOf(Keywords.class, str);
            }

            public static Keywords[] values() {
                return (Keywords[]) f19896e.clone();
            }
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Direction.Keywords.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Direction.Keywords keywords = Direction.Keywords.f19892a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Direction.Keywords keywords2 = Direction.Keywords.f19892a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Direction.Keywords keywords3 = Direction.Keywords.f19892a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public LinearGradient(ReadableMap directionMap, int[] colors, float[] positions) {
        Direction.Keywords keywords;
        Direction keyword;
        Intrinsics.checkNotNullParameter(directionMap, "directionMap");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.f19887a = colors;
        this.f19888b = positions;
        String string = directionMap.getString("type");
        if (!Intrinsics.b(string, LinearGradientManager.PROP_ANGLE)) {
            if (!Intrinsics.b(string, "keyword")) {
                throw new IllegalArgumentException(b.C("Invalid direction type: ", string));
            }
            String string2 = directionMap.getString(CLConstants.FIELD_PAY_INFO_VALUE);
            if (string2 != null) {
                switch (string2.hashCode()) {
                    case -1849920841:
                        if (string2.equals("to bottom left")) {
                            keywords = Direction.Keywords.f19895d;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                    case -1507310228:
                        if (string2.equals("to bottom right")) {
                            keywords = Direction.Keywords.f19893b;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                    case -1359525897:
                        if (string2.equals("to top left")) {
                            keywords = Direction.Keywords.f19894c;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                    case 810031148:
                        if (string2.equals("to top right")) {
                            keywords = Direction.Keywords.f19892a;
                            keyword = new Direction.Keyword(keywords);
                            break;
                        }
                        break;
                }
            }
            throw new IllegalArgumentException(b.C("Invalid linear gradient direction keyword: ", directionMap.getString(CLConstants.FIELD_PAY_INFO_VALUE)));
        }
        keyword = new Direction.Angle(directionMap.getDouble(CLConstants.FIELD_PAY_INFO_VALUE));
        this.f19889c = keyword;
    }
}
