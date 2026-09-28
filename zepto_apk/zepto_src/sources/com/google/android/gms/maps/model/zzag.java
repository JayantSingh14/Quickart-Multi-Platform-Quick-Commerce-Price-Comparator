package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzao;

/* loaded from: classes4.dex */
final class zzag extends zzao {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TileProvider f38578b;

    public zzag(TileProvider tileProvider) {
        this.f38578b = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzap
    public final Tile O4(int i2, int i3, int i4) {
        return this.f38578b.a(i2, i3, i4);
    }
}
