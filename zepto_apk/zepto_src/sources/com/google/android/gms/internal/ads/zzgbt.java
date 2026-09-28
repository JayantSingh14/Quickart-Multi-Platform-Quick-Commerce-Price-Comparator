package com.google.android.gms.internal.ads;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class zzgbt implements zzgby {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f32233a;

    public zzgbt(byte[] bArr) {
        this.f32233a = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgby
    public final Object a(FileInputStream fileInputStream) {
        try {
            return zzgwd.a(fileInputStream);
        } catch (IOException e2) {
            throw new zzgbu("Cannot read bytes.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgby
    public final /* synthetic */ void b(Object obj, FileOutputStream fileOutputStream) throws IOException {
        fileOutputStream.write((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgby
    public final /* synthetic */ Object zzc() {
        return this.f32233a;
    }
}
