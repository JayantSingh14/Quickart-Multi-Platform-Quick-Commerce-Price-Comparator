package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@SuppressAnimalSniffer
/* loaded from: classes3.dex */
public final class ComposerForUnquotedLiterals extends Composer {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f56035c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnquotedLiterals(JsonToStringWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.f56035c = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void j(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.f56035c) {
            super.j(value);
        } else {
            h(value);
        }
    }
}
