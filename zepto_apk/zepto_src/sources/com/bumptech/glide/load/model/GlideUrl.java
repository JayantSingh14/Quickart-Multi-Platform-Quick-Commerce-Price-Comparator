package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class GlideUrl implements Key {

    /* renamed from: b, reason: collision with root package name */
    public final LazyHeaders f16146b;

    /* renamed from: c, reason: collision with root package name */
    public final URL f16147c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16148d;

    /* renamed from: e, reason: collision with root package name */
    public String f16149e;

    /* renamed from: f, reason: collision with root package name */
    public URL f16150f;

    /* renamed from: g, reason: collision with root package name */
    public volatile byte[] f16151g;

    /* renamed from: h, reason: collision with root package name */
    public int f16152h;

    public GlideUrl(URL url) {
        LazyHeaders lazyHeaders = Headers.f16153a;
        Preconditions.c(url, "Argument must not be null");
        this.f16147c = url;
        this.f16148d = null;
        Preconditions.c(lazyHeaders, "Argument must not be null");
        this.f16146b = lazyHeaders;
    }

    @Override // com.bumptech.glide.load.Key
    public final void b(MessageDigest messageDigest) {
        if (this.f16151g == null) {
            this.f16151g = c().getBytes(Key.f15811a);
        }
        messageDigest.update(this.f16151g);
    }

    public final String c() {
        String str = this.f16148d;
        if (str != null) {
            return str;
        }
        URL url = this.f16147c;
        Preconditions.c(url, "Argument must not be null");
        return url.toString();
    }

    public final URL d() {
        if (this.f16150f == null) {
            if (TextUtils.isEmpty(this.f16149e)) {
                String string = this.f16148d;
                if (TextUtils.isEmpty(string)) {
                    URL url = this.f16147c;
                    Preconditions.c(url, "Argument must not be null");
                    string = url.toString();
                }
                this.f16149e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f16150f = new URL(this.f16149e);
        }
        return this.f16150f;
    }

    @Override // com.bumptech.glide.load.Key
    public final boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        return c().equals(glideUrl.c()) && this.f16146b.equals(glideUrl.f16146b);
    }

    @Override // com.bumptech.glide.load.Key
    public final int hashCode() {
        if (this.f16152h == 0) {
            int iHashCode = c().hashCode();
            this.f16152h = iHashCode;
            this.f16152h = this.f16146b.f16154b.hashCode() + (iHashCode * 31);
        }
        return this.f16152h;
    }

    public final String toString() {
        return c();
    }

    public GlideUrl(String str) {
        this(str, Headers.f16153a);
    }

    public GlideUrl(String str, LazyHeaders lazyHeaders) {
        this.f16147c = null;
        if (!TextUtils.isEmpty(str)) {
            this.f16148d = str;
            Preconditions.c(lazyHeaders, "Argument must not be null");
            this.f16146b = lazyHeaders;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
