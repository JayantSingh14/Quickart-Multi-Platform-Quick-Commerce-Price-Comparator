package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzbjk;
import com.google.android.gms.internal.ads.zzbjm;

/* loaded from: classes4.dex */
public class MediaView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public MediaContent f21714a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21715b;

    /* renamed from: c, reason: collision with root package name */
    public zzbjk f21716c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView.ScaleType f21717d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21718e;

    /* renamed from: f, reason: collision with root package name */
    public zzbjm f21719f;

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Nullable
    public MediaContent getMediaContent() {
        return this.f21714a;
    }

    public void setImageScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f21718e = true;
        this.f21717d = scaleType;
        zzbjm zzbjmVar = this.f21719f;
        if (zzbjmVar != null) {
            zzbjmVar.a(scaleType);
        }
    }

    public void setMediaContent(@Nullable MediaContent mediaContent) {
        this.f21715b = true;
        this.f21714a = mediaContent;
        zzbjk zzbjkVar = this.f21716c;
        if (zzbjkVar != null) {
            ((zzb) zzbjkVar).a(mediaContent);
        }
    }

    public MediaView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
