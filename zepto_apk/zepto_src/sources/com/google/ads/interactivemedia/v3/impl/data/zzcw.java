package com.google.ads.interactivemedia.v3.impl.data;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzuu;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzcw implements UiElement {
    public static final zzuu<zzcw> GSON_TYPE_ADAPTER = new zzcv();
    private final String name;

    public zzcw(String str) {
        this.name = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzcw)) {
            return this.name.equals(((zzcw) obj).name);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.api.UiElement
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name});
    }

    public String toString() {
        return b.r(new StringBuilder("UiElementImpl[name="), this.name, "]");
    }
}
