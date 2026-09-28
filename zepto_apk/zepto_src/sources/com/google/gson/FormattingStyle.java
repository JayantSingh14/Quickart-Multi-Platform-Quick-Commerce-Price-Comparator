package com.google.gson;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class FormattingStyle {

    /* renamed from: d, reason: collision with root package name */
    public static final FormattingStyle f45220d = new FormattingStyle("", "", false);

    /* renamed from: e, reason: collision with root package name */
    public static final FormattingStyle f45221e = new FormattingStyle(StringUtils.LF, "  ", true);

    /* renamed from: a, reason: collision with root package name */
    public final String f45222a;

    /* renamed from: b, reason: collision with root package name */
    public final String f45223b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f45224c;

    public FormattingStyle(String str, String str2, boolean z) {
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f45222a = str;
        this.f45223b = str2;
        this.f45224c = z;
    }
}
