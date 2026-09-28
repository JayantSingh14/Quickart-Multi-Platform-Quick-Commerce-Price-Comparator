package com.google.android.gms.internal.ads;

import androidx.datastore.core.Serializer;
import java.io.FileInputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zzfxz implements Serializer {

    /* renamed from: a, reason: collision with root package name */
    public static final zzfxz f31992a = new zzfxz();

    /* renamed from: b, reason: collision with root package name */
    public static final zzfxw f31993b;

    static {
        zzfxw zzfxwVarF = zzfxw.F();
        Intrinsics.checkNotNullExpressionValue(zzfxwVarF, "getDefaultInstance(...)");
        f31993b = zzfxwVarF;
    }

    public final zzfxw a(FileInputStream fileInputStream) {
        try {
            return zzfxw.E(fileInputStream);
        } catch (Exception unused) {
            return f31993b;
        }
    }
}
