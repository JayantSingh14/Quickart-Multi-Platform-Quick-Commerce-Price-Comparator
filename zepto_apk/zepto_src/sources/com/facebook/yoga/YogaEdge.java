package com.facebook.yoga;

import android.support.v4.media.b;

/* loaded from: classes.dex */
public enum YogaEdge {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);


    /* renamed from: a, reason: collision with root package name */
    public final int f20361a;

    YogaEdge(int i2) {
        this.f20361a = i2;
    }

    public static YogaEdge a(int i2) {
        switch (i2) {
            case 0:
                return LEFT;
            case 1:
                return TOP;
            case 2:
                return RIGHT;
            case 3:
                return BOTTOM;
            case 4:
                return START;
            case 5:
                return END;
            case 6:
                return HORIZONTAL;
            case 7:
                return VERTICAL;
            case 8:
                return ALL;
            default:
                throw new IllegalArgumentException(b.f(i2, "Unknown enum value: "));
        }
    }
}
