package com.chuckerteam.chucker.internal.support;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.support.SharableKt", f = "Sharable.kt", l = {31}, m = "shareAsUtf8Text")
/* loaded from: classes3.dex */
final class SharableKt$shareAsUtf8Text$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Activity f16807a;

    /* renamed from: b, reason: collision with root package name */
    public String f16808b;

    /* renamed from: c, reason: collision with root package name */
    public String f16809c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f16810d;

    /* renamed from: e, reason: collision with root package name */
    public int f16811e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16810d = obj;
        this.f16811e |= Integer.MIN_VALUE;
        return SharableKt.b(null, null, null, null, this);
    }
}
