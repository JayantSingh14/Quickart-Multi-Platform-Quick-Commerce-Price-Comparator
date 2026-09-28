package com.facebook.binaryresource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ByteArrayBinaryResource implements BinaryResource {
    @Override // com.facebook.binaryresource.BinaryResource
    public final InputStream a() {
        return new ByteArrayInputStream(null);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public final long size() {
        throw null;
    }
}
