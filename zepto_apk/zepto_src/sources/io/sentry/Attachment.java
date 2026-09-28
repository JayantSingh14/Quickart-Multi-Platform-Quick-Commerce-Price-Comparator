package io.sentry;

import com.reactnativecommunity.clipboard.ClipboardModule;
import io.sentry.protocol.ViewHierarchy;

/* loaded from: classes3.dex */
public final class Attachment {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f51546a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewHierarchy f51547b;

    /* renamed from: c, reason: collision with root package name */
    public final String f51548c;

    /* renamed from: d, reason: collision with root package name */
    public final String f51549d;

    /* renamed from: e, reason: collision with root package name */
    public final String f51550e;

    public Attachment(String str, String str2, byte[] bArr) {
        this.f51546a = bArr;
        this.f51547b = null;
        this.f51548c = str;
        this.f51549d = str2;
        this.f51550e = "event.attachment";
    }

    public static Attachment a(byte[] bArr) {
        return new Attachment("screenshot.png", ClipboardModule.MIMETYPE_PNG, bArr);
    }

    public static Attachment b(ViewHierarchy viewHierarchy) {
        return new Attachment(viewHierarchy);
    }

    public final String c() {
        return this.f51550e;
    }

    public final String d() {
        return this.f51549d;
    }

    public final String e() {
        return this.f51548c;
    }

    public Attachment(ViewHierarchy viewHierarchy) {
        this.f51546a = null;
        this.f51547b = viewHierarchy;
        this.f51548c = "view-hierarchy.json";
        this.f51549d = "application/json";
        this.f51550e = "event.view_hierarchy";
    }
}
