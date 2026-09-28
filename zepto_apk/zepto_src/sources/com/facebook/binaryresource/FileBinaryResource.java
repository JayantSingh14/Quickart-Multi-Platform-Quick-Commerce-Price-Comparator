package com.facebook.binaryresource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
/* loaded from: classes3.dex */
public final class FileBinaryResource implements BinaryResource {

    /* renamed from: a, reason: collision with root package name */
    public final File f16987a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    public FileBinaryResource(File file) {
        this.f16987a = file;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public final InputStream a() {
        return new FileInputStream(this.f16987a);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return Intrinsics.b(this.f16987a, ((FileBinaryResource) obj).f16987a);
    }

    public final int hashCode() {
        return this.f16987a.hashCode();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public final long size() {
        return this.f16987a.length();
    }
}
