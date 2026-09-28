package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public enum FrameType {
    f51452e("TEXT", false),
    f51453f("BINARY", false),
    f51454g("CLOSE", true),
    f51455h("PING", true),
    f51456i("PONG", true);


    /* renamed from: c, reason: collision with root package name */
    public static final int f51450c;

    /* renamed from: d, reason: collision with root package name */
    public static final FrameType[] f51451d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f51458a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51459b;

    @Metadata
    public static final class Companion {
    }

    static {
        FrameType frameType;
        FrameType[] frameTypeArrValues = values();
        if (frameTypeArrValues.length == 0) {
            frameType = null;
        } else {
            frameType = frameTypeArrValues[0];
            Intrinsics.checkNotNullParameter(frameTypeArrValues, "<this>");
            int length = frameTypeArrValues.length - 1;
            if (length != 0) {
                int i2 = frameType.f51459b;
                IntRange intRange = new IntRange(1, length, 1);
                IntProgressionIterator intProgressionIterator = new IntProgressionIterator(1, intRange.f53839b, intRange.f53840c);
                while (intProgressionIterator.f53843c) {
                    FrameType frameType2 = frameTypeArrValues[intProgressionIterator.a()];
                    int i3 = frameType2.f51459b;
                    if (i2 < i3) {
                        frameType = frameType2;
                        i2 = i3;
                    }
                }
            }
        }
        Intrinsics.c(frameType);
        int i4 = frameType.f51459b;
        f51450c = i4;
        int i5 = i4 + 1;
        FrameType[] frameTypeArr = new FrameType[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            FrameType[] frameTypeArrValues2 = values();
            int length2 = frameTypeArrValues2.length;
            int i7 = 0;
            boolean z = false;
            FrameType frameType3 = null;
            while (true) {
                if (i7 >= length2) {
                    if (!z) {
                        break;
                    }
                } else {
                    FrameType frameType4 = frameTypeArrValues2[i7];
                    if (frameType4.f51459b == i6) {
                        if (z) {
                            break;
                        }
                        z = true;
                        frameType3 = frameType4;
                    }
                    i7++;
                }
            }
            frameType3 = null;
            frameTypeArr[i6] = frameType3;
        }
        f51451d = frameTypeArr;
    }

    FrameType(String str, boolean z) {
        this.f51458a = z;
        this.f51459b = i;
    }
}
