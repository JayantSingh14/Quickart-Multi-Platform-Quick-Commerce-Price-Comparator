package kotlinx.serialization.internal;

import android.support.v4.media.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;

@Metadata
/* loaded from: classes3.dex */
public final class PluginExceptionsKt {
    public static final void a(int i2, int i3, PluginGeneratedSerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList missingFields = new ArrayList();
        int i4 = (~i2) & i3;
        for (int i5 = 0; i5 < 32; i5++) {
            if ((i4 & 1) != 0) {
                missingFields.add(descriptor.f55875e[i5]);
            }
            i4 >>>= 1;
        }
        String serialName = descriptor.f55871a;
        Intrinsics.checkNotNullParameter(missingFields, "missingFields");
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        throw new MissingFieldException(missingFields, missingFields.size() == 1 ? a.n(new StringBuilder("Field '"), (String) missingFields.get(0), "' is required for type with serial name '", serialName, "', but it was missing") : "Fields " + missingFields + " are required for type with serial name '" + serialName + "', but they were missing", null);
    }
}
