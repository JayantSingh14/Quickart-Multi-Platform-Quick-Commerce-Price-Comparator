package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PacketJVMKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f51210a;

    static {
        String property;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter("max.copy.size", CLConstants.FIELD_PAY_INFO_NAME);
        try {
            property = System.getProperty("io.ktor.utils.io.max.copy.size");
        } catch (SecurityException unused) {
            property = null;
        }
        f51210a = (property == null || (intOrNull = kotlin.text.StringsKt.toIntOrNull(property)) == null) ? 500 : intOrNull.intValue();
    }

    public static final int a() {
        return f51210a;
    }
}
