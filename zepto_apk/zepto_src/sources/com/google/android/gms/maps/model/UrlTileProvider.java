package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes4.dex */
public abstract class UrlTileProvider implements TileProvider {

    /* renamed from: b, reason: collision with root package name */
    public final int f38571b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38572c;

    public UrlTileProvider(int i2, int i3) {
        this.f38571b = i2;
        this.f38572c = i3;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile a(int i2, int i3, int i4) {
        URL urlB = b(i2, i3, i4);
        if (urlB == null) {
            return TileProvider.f38570a;
        }
        try {
            com.google.android.gms.internal.maps.zze zzeVar = com.google.android.gms.internal.maps.zzf.f36738a;
            int i5 = this.f38571b;
            int i6 = this.f38572c;
            InputStream inputStream = urlB.openConnection().getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Preconditions.checkNotNull(inputStream, "from must not be null.");
            Preconditions.checkNotNull(byteArrayOutputStream, "to must not be null.");
            byte[] bArr = new byte[4096];
            while (true) {
                int i7 = inputStream.read(bArr);
                if (i7 == -1) {
                    Tile tile = new Tile(i5, byteArrayOutputStream.toByteArray(), i6);
                    com.google.android.gms.internal.maps.zze zzeVar2 = com.google.android.gms.internal.maps.zzf.f36738a;
                    return tile;
                }
                byteArrayOutputStream.write(bArr, 0, i7);
            }
        } catch (IOException unused) {
            com.google.android.gms.internal.maps.zze zzeVar3 = com.google.android.gms.internal.maps.zzf.f36738a;
            return null;
        } catch (Throwable th) {
            com.google.android.gms.internal.maps.zze zzeVar4 = com.google.android.gms.internal.maps.zzf.f36738a;
            throw th;
        }
    }

    public abstract URL b(int i2, int i3, int i4);
}
