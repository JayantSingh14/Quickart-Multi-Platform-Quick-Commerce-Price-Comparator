package io.sentry.android.replay.util;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TextAttributes {

    /* renamed from: a, reason: collision with root package name */
    public final Color f52631a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f52632b;

    public TextAttributes(Color color, boolean z) {
        this.f52631a = color;
        this.f52632b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAttributes)) {
            return false;
        }
        TextAttributes textAttributes = (TextAttributes) obj;
        return Intrinsics.b(this.f52631a, textAttributes.f52631a) && this.f52632b == textAttributes.f52632b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        Color color = this.f52631a;
        int i2 = (color == null ? 0 : Color.hashCode-impl(color.unbox-impl())) * 31;
        boolean z = this.f52632b;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return i2 + i3;
    }

    public final String toString() {
        return "TextAttributes(color=" + this.f52631a + ", hasFillModifier=" + this.f52632b + ')';
    }
}
