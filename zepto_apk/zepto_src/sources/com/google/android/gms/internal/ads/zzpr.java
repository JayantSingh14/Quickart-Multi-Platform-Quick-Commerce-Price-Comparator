package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzpr extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f35338a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f35339b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzpu f35340c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpr(zzpu zzpuVar, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        Objects.requireNonNull(zzpuVar);
        this.f35340c = zzpuVar;
        this.f35338a = contentResolver;
        this.f35339b = uri;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzpu zzpuVar = this.f35340c;
        zzpuVar.a(zzpp.a(zzpuVar.f35342a, zzpuVar.f35350i, zzpuVar.f35349h));
    }
}
