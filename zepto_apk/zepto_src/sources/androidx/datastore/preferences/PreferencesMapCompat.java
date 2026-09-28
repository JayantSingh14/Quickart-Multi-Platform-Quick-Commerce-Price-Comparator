package androidx.datastore.preferences;

import androidx.annotation.RestrictTo;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import com.amazon.apay.hardened.external.model.APayConstants;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class PreferencesMapCompat {

    @Metadata
    public static final class Companion {
        public static PreferencesProto.PreferenceMap a(InputStream input) throws CorruptionException {
            Intrinsics.checkNotNullParameter(input, "input");
            try {
                PreferencesProto.PreferenceMap preferenceMapB = PreferencesProto.PreferenceMap.B(input);
                Intrinsics.checkNotNullExpressionValue(preferenceMapB, "{\n                Prefer…From(input)\n            }");
                return preferenceMapB;
            } catch (InvalidProtocolBufferException e2) {
                Intrinsics.checkNotNullParameter("Unable to parse preferences proto.", APayConstants.Error.MESSAGE);
                throw new CorruptionException("Unable to parse preferences proto.", e2);
            }
        }
    }
}
