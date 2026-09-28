package com.imagepicker;

import android.text.TextUtils;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes4.dex */
public class Options {

    /* renamed from: a, reason: collision with root package name */
    public final int f45938a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f45939b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f45940c;

    /* renamed from: d, reason: collision with root package name */
    public final int f45941d;

    /* renamed from: e, reason: collision with root package name */
    public final int f45942e;

    /* renamed from: f, reason: collision with root package name */
    public final int f45943f;

    /* renamed from: g, reason: collision with root package name */
    public final int f45944g;

    /* renamed from: h, reason: collision with root package name */
    public final Boolean f45945h;

    /* renamed from: i, reason: collision with root package name */
    public final int f45946i;

    /* renamed from: j, reason: collision with root package name */
    public final Boolean f45947j;

    /* renamed from: k, reason: collision with root package name */
    public final String f45948k;

    public Options(ReadableMap readableMap) {
        this.f45941d = 1;
        this.f45947j = Boolean.FALSE;
        this.f45948k = readableMap.getString("mediaType");
        this.f45938a = readableMap.getInt("selectionLimit");
        this.f45939b = Boolean.valueOf(readableMap.getBoolean("includeBase64"));
        this.f45940c = Boolean.valueOf(readableMap.getBoolean("includeExtra"));
        String string = readableMap.getString("videoQuality");
        if (!TextUtils.isEmpty(string) && !string.toLowerCase().equals("high")) {
            this.f45941d = 0;
        }
        if (readableMap.getString("cameraType").equals("front")) {
            this.f45947j = Boolean.TRUE;
        }
        this.f45942e = (int) (readableMap.getDouble("quality") * 100.0d);
        this.f45944g = readableMap.getInt("maxHeight");
        this.f45943f = readableMap.getInt("maxWidth");
        this.f45945h = Boolean.valueOf(readableMap.getBoolean("saveToPhotos"));
        this.f45946i = readableMap.getInt("durationLimit");
    }
}
