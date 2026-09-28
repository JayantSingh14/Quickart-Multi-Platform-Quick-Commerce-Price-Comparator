package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

@CoreFriendModuleApi
@Metadata
/* loaded from: classes.dex */
public final class ElementMarker {

    /* renamed from: e, reason: collision with root package name */
    public static final long[] f55805e = new long[0];

    /* renamed from: a, reason: collision with root package name */
    public final SerialDescriptor f55806a;

    /* renamed from: b, reason: collision with root package name */
    public final Function2 f55807b;

    /* renamed from: c, reason: collision with root package name */
    public long f55808c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f55809d;

    @Metadata
    public static final class Companion {
    }

    public ElementMarker(SerialDescriptor descriptor, Function2 readIfAbsent) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(readIfAbsent, "readIfAbsent");
        this.f55806a = descriptor;
        this.f55807b = readIfAbsent;
        int iE = descriptor.e();
        if (iE <= 64) {
            this.f55808c = iE != 64 ? (-1) << iE : 0L;
            this.f55809d = f55805e;
            return;
        }
        this.f55808c = 0L;
        int i2 = (iE - 1) >>> 6;
        long[] jArr = new long[i2];
        if ((iE & 63) != 0) {
            Intrinsics.checkNotNullParameter(jArr, "<this>");
            jArr[i2 - 1] = (-1) << iE;
        }
        this.f55809d = jArr;
    }
}
