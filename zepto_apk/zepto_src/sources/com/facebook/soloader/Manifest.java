package com.facebook.soloader;

import android.support.v4.media.b;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class Manifest {

    /* renamed from: a, reason: collision with root package name */
    public final String f20278a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20279b;

    public Manifest(String str, ArrayList arrayList) {
        this.f20278a = str;
        this.f20279b = Collections.unmodifiableList(arrayList);
    }

    public static Manifest a(InputStream inputStream) throws IOException {
        String str;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte b2 = dataInputStream.readByte();
        if (b2 == 1) {
            str = "arm64-v8a";
        } else if (b2 == 2) {
            str = "armeabi-v7a";
        } else if (b2 == 3) {
            str = "x86_64";
        } else {
            if (b2 != 4) {
                throw new RuntimeException(b.f(b2, "Unrecognized arch id: "));
            }
            str = "x86";
        }
        int i2 = dataInputStream.readShort() & 65535;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = new byte[dataInputStream.readShort() & 65535];
            dataInputStream.readFully(bArr);
            arrayList.add(new String(bArr, StandardCharsets.UTF_8));
        }
        return new Manifest(str, arrayList);
    }
}
