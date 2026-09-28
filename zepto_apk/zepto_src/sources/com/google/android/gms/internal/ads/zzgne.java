package com.google.android.gms.internal.ads;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzgne {

    /* renamed from: a, reason: collision with root package name */
    public static final ClipData f32971a = ClipData.newIntent("", new Intent());

    public static Intent a(Intent intent, int i2) {
        zzgqa.b("Must set component on Intent.", intent.getComponent() != null);
        if (b(0, 1)) {
            zzgqa.b("Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.", !b(i2, 67108864));
        } else {
            zzgqa.b("Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.", b(i2, 67108864));
        }
        Intent intent2 = new Intent(intent);
        if (!b(i2, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!b(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!b(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!b(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!b(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(f32971a);
            }
        }
        return intent2;
    }

    public static boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
