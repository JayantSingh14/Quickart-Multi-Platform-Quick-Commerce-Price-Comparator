package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class BytesResource implements Resource<byte[]> {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f16337a;

    public BytesResource(byte[] bArr) {
        Preconditions.c(bArr, "Argument must not be null");
        this.f16337a = bArr;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class a() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Object get() {
        return this.f16337a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return this.f16337a.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void recycle() {
    }
}
