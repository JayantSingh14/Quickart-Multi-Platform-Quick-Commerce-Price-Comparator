package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
final class PlatformRandom extends AbstractPlatformRandom implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Companion f53817c = new Companion(null);

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public final java.util.Random j() {
        return null;
    }
}
