package io.sentry.internal.gestures;

import android.view.View;
import io.sentry.util.Objects;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UiElement {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f52753a;

    /* renamed from: b, reason: collision with root package name */
    public final String f52754b;

    /* renamed from: c, reason: collision with root package name */
    public final String f52755c;

    /* renamed from: d, reason: collision with root package name */
    public final String f52756d = "old_view_system";

    public enum Type {
        CLICKABLE,
        SCROLLABLE
    }

    public UiElement(View view, String str, String str2) {
        this.f52753a = new WeakReference(view);
        this.f52754b = str;
        this.f52755c = str2;
    }

    public final String a() {
        return this.f52754b;
    }

    public final String b() {
        String str = this.f52755c;
        if (str != null) {
            return str;
        }
        Objects.b(null, "UiElement.tag can't be null");
        return null;
    }

    public final String c() {
        return this.f52756d;
    }

    public final String d() {
        return this.f52755c;
    }

    public final Object e() {
        return this.f52753a.get();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UiElement.class != obj.getClass()) {
            return false;
        }
        UiElement uiElement = (UiElement) obj;
        return Objects.a(this.f52754b, uiElement.f52754b) && Objects.a(this.f52755c, uiElement.f52755c) && Objects.a(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f52753a, this.f52755c, null});
    }
}
