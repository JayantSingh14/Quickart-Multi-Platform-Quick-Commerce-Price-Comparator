package com.chuckerteam.chucker.internal.ui;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.chuckerteam.chucker.internal.ui.MainActivity", f = "MainActivity.kt", l = {341, 346}, m = "prepareDataToSave")
/* loaded from: classes3.dex */
final class MainActivity$prepareDataToSave$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public MainActivity f16877a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16878b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f16879c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16880d;

    /* renamed from: e, reason: collision with root package name */
    public int f16881e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$prepareDataToSave$1(MainActivity mainActivity, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f16880d = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f16879c = obj;
        this.f16881e |= Integer.MIN_VALUE;
        return MainActivity.m(this.f16880d, null, this);
    }
}
