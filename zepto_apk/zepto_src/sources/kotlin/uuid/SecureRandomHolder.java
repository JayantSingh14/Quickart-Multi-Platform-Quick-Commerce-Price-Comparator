package kotlin.uuid;

import java.security.SecureRandom;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class SecureRandomHolder {
    static {
        new SecureRandom();
    }
}
