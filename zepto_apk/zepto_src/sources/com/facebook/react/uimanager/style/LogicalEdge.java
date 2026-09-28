package com.facebook.react.uimanager.style;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public abstract class LogicalEdge {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f19898a;

    /* renamed from: b, reason: collision with root package name */
    public static final LogicalEdge f19899b;

    /* renamed from: c, reason: collision with root package name */
    public static final LogicalEdge f19900c;

    /* renamed from: d, reason: collision with root package name */
    public static final LogicalEdge f19901d;

    /* renamed from: e, reason: collision with root package name */
    public static final LogicalEdge f19902e;

    /* renamed from: f, reason: collision with root package name */
    public static final LogicalEdge f19903f;

    /* renamed from: g, reason: collision with root package name */
    public static final LogicalEdge f19904g;

    /* renamed from: h, reason: collision with root package name */
    public static final LogicalEdge f19905h;

    /* renamed from: i, reason: collision with root package name */
    public static final LogicalEdge f19906i;

    /* renamed from: j, reason: collision with root package name */
    public static final LogicalEdge f19907j;

    /* renamed from: k, reason: collision with root package name */
    public static final LogicalEdge f19908k;

    /* renamed from: l, reason: collision with root package name */
    public static final LogicalEdge f19909l;

    /* renamed from: m, reason: collision with root package name */
    public static final LogicalEdge f19910m;
    public static final /* synthetic */ LogicalEdge[] n;
    public static final /* synthetic */ EnumEntries o;

    @Metadata
    public static final class Companion {
        public static LogicalEdge a(int i2) {
            switch (i2) {
                case 0:
                    return LogicalEdge.f19900c;
                case 1:
                    return LogicalEdge.f19902e;
                case 2:
                    return LogicalEdge.f19901d;
                case 3:
                    return LogicalEdge.f19903f;
                case 4:
                    return LogicalEdge.f19904g;
                case 5:
                    return LogicalEdge.f19905h;
                case 6:
                    return LogicalEdge.f19906i;
                case 7:
                    return LogicalEdge.f19907j;
                case 8:
                    return LogicalEdge.f19899b;
                case 9:
                    return LogicalEdge.f19910m;
                case 10:
                    return LogicalEdge.f19909l;
                case 11:
                    return LogicalEdge.f19908k;
                default:
                    throw new IllegalArgumentException(b.f(i2, "Unknown spacing type: "));
            }
        }
    }

    static {
        LogicalEdge logicalEdge = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.ALL
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 8;
            }
        };
        f19899b = logicalEdge;
        LogicalEdge logicalEdge2 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.LEFT
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 0;
            }
        };
        f19900c = logicalEdge2;
        LogicalEdge logicalEdge3 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.RIGHT
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 2;
            }
        };
        f19901d = logicalEdge3;
        LogicalEdge logicalEdge4 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.TOP
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 1;
            }
        };
        f19902e = logicalEdge4;
        LogicalEdge logicalEdge5 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.BOTTOM
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 3;
            }
        };
        f19903f = logicalEdge5;
        LogicalEdge logicalEdge6 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.START
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 4;
            }
        };
        f19904g = logicalEdge6;
        LogicalEdge logicalEdge7 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.END
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 5;
            }
        };
        f19905h = logicalEdge7;
        LogicalEdge logicalEdge8 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.HORIZONTAL
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 6;
            }
        };
        f19906i = logicalEdge8;
        LogicalEdge logicalEdge9 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.VERTICAL
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 7;
            }
        };
        f19907j = logicalEdge9;
        LogicalEdge logicalEdge10 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK_START
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 11;
            }
        };
        f19908k = logicalEdge10;
        LogicalEdge logicalEdge11 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK_END
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 10;
            }
        };
        f19909l = logicalEdge11;
        LogicalEdge logicalEdge12 = new LogicalEdge() { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK
            @Override // com.facebook.react.uimanager.style.LogicalEdge
            public final int a() {
                return 9;
            }
        };
        f19910m = logicalEdge12;
        LogicalEdge[] logicalEdgeArr = {logicalEdge, logicalEdge2, logicalEdge3, logicalEdge4, logicalEdge5, logicalEdge6, logicalEdge7, logicalEdge8, logicalEdge9, logicalEdge10, logicalEdge11, logicalEdge12};
        n = logicalEdgeArr;
        o = EnumEntriesKt.a(logicalEdgeArr);
        f19898a = new Companion();
    }

    public static LogicalEdge valueOf(String str) {
        return (LogicalEdge) Enum.valueOf(LogicalEdge.class, str);
    }

    public static LogicalEdge[] values() {
        return (LogicalEdge[]) n.clone();
    }

    public abstract int a();
}
