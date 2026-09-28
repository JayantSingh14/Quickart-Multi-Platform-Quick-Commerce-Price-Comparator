package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.io.IOException;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzlk extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzlk(long j2, long j3, int i2, IndexOutOfBoundsException indexOutOfBoundsException) {
        Locale locale = Locale.US;
        StringBuilder sbV = b.v(j2, "Pos: ", ", limit: ");
        sbV.append(j3);
        sbV.append(", len: ");
        sbV.append(i2);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(sbV.toString()), indexOutOfBoundsException);
    }

    public zzlk(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }
}
