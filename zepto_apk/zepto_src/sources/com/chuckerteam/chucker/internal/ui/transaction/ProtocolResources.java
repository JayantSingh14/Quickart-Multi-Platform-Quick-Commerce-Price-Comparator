package com.chuckerteam.chucker.internal.ui.transaction;

import com.chuckerteam.chucker.R;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class ProtocolResources {

    /* renamed from: a, reason: collision with root package name */
    public final int f16903a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16904b;

    @Metadata
    public static final class Http extends ProtocolResources {
        public Http() {
            super(R.drawable.chucker_ic_http, R.color.chucker_color_error);
        }
    }

    @Metadata
    public static final class Https extends ProtocolResources {
        public Https() {
            super(R.drawable.chucker_ic_https, R.color.chucker_color_primary);
        }
    }

    public ProtocolResources(int i2, int i3) {
        this.f16903a = i2;
        this.f16904b = i3;
    }
}
