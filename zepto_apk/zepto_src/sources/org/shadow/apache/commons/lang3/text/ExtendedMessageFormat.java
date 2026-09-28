package org.shadow.apache.commons.lang3.text;

import java.text.Format;
import java.text.MessageFormat;
import org.shadow.apache.commons.lang3.ObjectUtils;

/* loaded from: classes5.dex */
public class ExtendedMessageFormat extends MessageFormat {

    /* renamed from: a, reason: collision with root package name */
    public String f57763a;

    @Override // java.text.MessageFormat
    public final void applyPattern(String str) {
        super.applyPattern(str);
        this.f57763a = super.toPattern();
    }

    @Override // java.text.MessageFormat
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && super.equals(obj) && ObjectUtils.a(getClass(), obj.getClass()) && ObjectUtils.a(this.f57763a, ((ExtendedMessageFormat) obj).f57763a) && ObjectUtils.a(null, null);
    }

    @Override // java.text.MessageFormat
    public final int hashCode() {
        int iHashCode = super.hashCode() * 961;
        String str = this.f57763a;
        return (str == null ? 0 : str.hashCode()) + iHashCode;
    }

    @Override // java.text.MessageFormat
    public final void setFormat(int i2, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public final void setFormatByArgumentIndex(int i2, Format format) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public final void setFormats(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public final void setFormatsByArgumentIndex(Format[] formatArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public final String toPattern() {
        return this.f57763a;
    }
}
