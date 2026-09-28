package io.ktor.http;

import io.ktor.util.StringValuesBuilderImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class HeadersBuilder extends StringValuesBuilderImpl {
    public HeadersBuilder() {
        super(true);
    }

    @Override // io.ktor.util.StringValuesBuilderImpl
    public final void j(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        super.j(name);
        List list = HttpHeaders.f50204a;
        Intrinsics.checkNotNullParameter(name, "name");
        int i2 = 0;
        int i3 = 0;
        while (i2 < name.length()) {
            char cCharAt = name.charAt(i2);
            int i4 = i3 + 1;
            if (Intrinsics.e(cCharAt, 32) <= 0 || StringsKt.o("\"(),/:;<=>?@[\\]{}", cCharAt)) {
                throw new IllegalHeaderNameException(name, i3);
            }
            i2++;
            i3 = i4;
        }
    }

    @Override // io.ktor.util.StringValuesBuilderImpl
    public final void k(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.k(value);
        List list = HttpHeaders.f50204a;
        Intrinsics.checkNotNullParameter(value, "value");
        int i2 = 0;
        int i3 = 0;
        while (i2 < value.length()) {
            char cCharAt = value.charAt(i2);
            int i4 = i3 + 1;
            if (Intrinsics.e(cCharAt, 32) < 0 && cCharAt != '\t') {
                throw new IllegalHeaderValueException(value, i3);
            }
            i2++;
            i3 = i4;
        }
    }

    public final HeadersImpl l() {
        return new HeadersImpl(this.f50508b);
    }
}
