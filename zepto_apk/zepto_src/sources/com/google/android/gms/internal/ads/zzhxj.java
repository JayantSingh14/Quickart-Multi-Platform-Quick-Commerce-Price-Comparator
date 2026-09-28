package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes4.dex */
public class zzhxj {
    @Deprecated
    public zzhxj() {
    }

    public String b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final zzhxl d() {
        if (this instanceof zzhxl) {
            return (zzhxl) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }

    public final zzhxn f() {
        if (this instanceof zzhxn) {
            return (zzhxn) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: ".concat(toString()));
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            zzhyq zzhyqVar = new zzhyq(new zzhyd(sb));
            zzhyqVar.f34532h = zzhxo.f34472a;
            ((zzhyf) zzhym.f34509a).getClass();
            zzhyf.b(zzhyqVar, this);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
