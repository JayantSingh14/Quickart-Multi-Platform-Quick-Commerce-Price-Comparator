package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public class zzyy {
    public int b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzzb f() {
        if (this instanceof zzzb) {
            return (zzzb) this;
        }
        toString();
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzabe zzabeVar = new zzabe(stringWriter);
            zzabeVar.f37347e = true;
            ((zzaam) zzaba.f37327a).getClass();
            zzaam.b(zzabeVar, this);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
