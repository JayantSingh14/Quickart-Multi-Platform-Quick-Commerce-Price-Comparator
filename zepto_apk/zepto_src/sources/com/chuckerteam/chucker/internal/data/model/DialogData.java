package com.chuckerteam.chucker.internal.data.model;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DialogData {

    /* renamed from: a, reason: collision with root package name */
    public final String f16713a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16714b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16715c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16716d;

    public DialogData(String title, String message, String str, String str2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f16713a = title;
        this.f16714b = message;
        this.f16715c = str;
        this.f16716d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogData)) {
            return false;
        }
        DialogData dialogData = (DialogData) obj;
        return Intrinsics.b(this.f16713a, dialogData.f16713a) && Intrinsics.b(this.f16714b, dialogData.f16714b) && Intrinsics.b(this.f16715c, dialogData.f16715c) && Intrinsics.b(this.f16716d, dialogData.f16716d);
    }

    public final int hashCode() {
        int iE = e.e(this.f16713a.hashCode() * 31, 31, this.f16714b);
        String str = this.f16715c;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f16716d;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DialogData(title=");
        sb.append(this.f16713a);
        sb.append(", message=");
        sb.append(this.f16714b);
        sb.append(", positiveButtonText=");
        sb.append(this.f16715c);
        sb.append(", negativeButtonText=");
        return b.r(sb, this.f16716d, ")");
    }
}
