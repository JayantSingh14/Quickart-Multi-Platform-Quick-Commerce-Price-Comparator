package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/* loaded from: classes4.dex */
public final class zzahs {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f23137a;

    /* renamed from: b, reason: collision with root package name */
    public final DataOutputStream f23138b;

    public zzahs() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f23137a = byteArrayOutputStream;
        this.f23138b = new DataOutputStream(byteArrayOutputStream);
    }
}
