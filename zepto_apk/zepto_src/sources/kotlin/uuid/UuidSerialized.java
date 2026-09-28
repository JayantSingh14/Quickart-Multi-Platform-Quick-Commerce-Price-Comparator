package kotlin.uuid;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@ExperimentalUuidApi
/* loaded from: classes3.dex */
final class UuidSerialized implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public long f54031a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f54032b = 0;

    @Metadata
    public static final class Companion {
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.f54031a = input.readLong();
        this.f54032b = input.readLong();
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeLong(this.f54031a);
        output.writeLong(this.f54032b);
    }
}
