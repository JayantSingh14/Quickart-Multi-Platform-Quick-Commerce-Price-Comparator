package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzgy extends zzgt {

    /* renamed from: e, reason: collision with root package name */
    public final ContentResolver f33363e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f33364f;

    /* renamed from: g, reason: collision with root package name */
    public AssetFileDescriptor f33365g;

    /* renamed from: h, reason: collision with root package name */
    public FileInputStream f33366h;

    /* renamed from: i, reason: collision with root package name */
    public long f33367i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f33368j;

    public zzgy(Context context) {
        super(false);
        this.f33363e = context.getContentResolver();
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final long a(zzhf zzhfVar) throws IOException {
        int i2;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        long jPosition;
        try {
            try {
                Uri uriNormalizeScheme = zzhfVar.f33691a.normalizeScheme();
                this.f33364f = uriNormalizeScheme;
                d(zzhfVar);
                boolean zEquals = Objects.equals(uriNormalizeScheme.getScheme(), "content");
                ContentResolver contentResolver = this.f33363e;
                if (zEquals) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriNormalizeScheme, "r");
                }
                this.f33365g = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    String strValueOf = String.valueOf(uriNormalizeScheme);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
                    sb.append("Could not open file descriptor for: ");
                    sb.append(strValueOf);
                    i2 = 2000;
                    try {
                        throw new zzgx(2000, new IOException(sb.toString()));
                    } catch (IOException e2) {
                        e = e2;
                        throw new zzgx(true != (e instanceof FileNotFoundException) ? i2 : 2005, e);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.f33366h = fileInputStream;
                long j2 = zzhfVar.f33693c;
                if (length != -1 && j2 > length) {
                    throw new zzgx(2008, null);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j2) - startOffset;
                if (jSkip != j2) {
                    throw new zzgx(2008, null);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.f33367i = -1L;
                        jPosition = -1;
                    } else {
                        jPosition = size - channel.position();
                        this.f33367i = jPosition;
                        if (jPosition < 0) {
                            throw new zzgx(2008, null);
                        }
                    }
                } else {
                    jPosition = length - jSkip;
                    this.f33367i = jPosition;
                    if (jPosition < 0) {
                        throw new zzgx(2008, null);
                    }
                }
                long j3 = zzhfVar.f33694d;
                if (j3 != -1) {
                    this.f33367i = jPosition == -1 ? j3 : Math.min(jPosition, j3);
                }
                this.f33368j = true;
                e(zzhfVar);
                return j3 != -1 ? j3 : this.f33367i;
            } catch (IOException e3) {
                e = e3;
                i2 = 2000;
            }
        } catch (zzgx e4) {
            throw e4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int b(int i2, byte[] bArr, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f33367i;
        if (j2 != 0) {
            if (j2 != -1) {
                try {
                    i3 = (int) Math.min(j2, i3);
                } catch (IOException e2) {
                    throw new zzgx(2000, e2);
                }
            }
            FileInputStream fileInputStream = this.f33366h;
            String str = zzfj.f31254a;
            int i4 = fileInputStream.read(bArr, i2, i3);
            if (i4 != -1) {
                long j3 = this.f33367i;
                if (j3 != -1) {
                    this.f33367i = j3 - i4;
                }
                f(i4);
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final Uri zzc() {
        return this.f33364f;
    }

    @Override // com.google.android.gms.internal.ads.zzhb
    public final void zzd() {
        this.f33364f = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = this.f33366h;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.f33366h = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f33365g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.f33365g = null;
                        if (this.f33368j) {
                            this.f33368j = false;
                            g();
                        }
                    } catch (IOException e2) {
                        throw new zzgx(2000, e2);
                    }
                } catch (Throwable th) {
                    this.f33366h = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.f33365g;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.f33365g = null;
                        if (this.f33368j) {
                            this.f33368j = false;
                            g();
                        }
                        throw th;
                    } catch (IOException e3) {
                        throw new zzgx(2000, e3);
                    }
                }
            } catch (Throwable th2) {
                this.f33365g = null;
                if (this.f33368j) {
                    this.f33368j = false;
                    g();
                }
                throw th2;
            }
        } catch (IOException e4) {
            throw new zzgx(2000, e4);
        }
    }
}
