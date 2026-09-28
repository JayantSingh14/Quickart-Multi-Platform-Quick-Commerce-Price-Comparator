package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class zzhjf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhxc f33886a = zzhxc.a(new byte[0]);

    public static final zzhxc a(int i2) {
        return zzhxc.a(ByteBuffer.allocate(5).put((byte) 0).putInt(i2).array());
    }

    public static final zzhxc b(int i2) {
        return zzhxc.a(ByteBuffer.allocate(5).put((byte) 1).putInt(i2).array());
    }
}
