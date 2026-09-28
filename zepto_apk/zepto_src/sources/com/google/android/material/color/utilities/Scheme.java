package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
@RestrictTo
/* loaded from: classes4.dex */
public class Scheme {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme) || !super.equals(obj)) {
            return false;
        }
        ((Scheme) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return super.hashCode() * 11316127;
    }

    public final String toString() {
        return "Scheme{primary=0, onPrimary=0, primaryContainer=0, onPrimaryContainer=0, secondary=0, onSecondary=0, secondaryContainer=0, onSecondaryContainer=0, tertiary=0, onTertiary=0, tertiaryContainer=0, onTertiaryContainer=0, error=0, onError=0, errorContainer=0, onErrorContainer=0, background=0, onBackground=0, surface=0, onSurface=0, surfaceVariant=0, onSurfaceVariant=0, outline=0, outlineVariant=0, shadow=0, scrim=0, inverseSurface=0, inverseOnSurface=0, inversePrimary=0}";
    }
}
