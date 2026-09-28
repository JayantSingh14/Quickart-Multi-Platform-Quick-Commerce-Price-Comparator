package com.chuckerteam.chucker.internal.ui.transaction;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TransactionViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    /* renamed from: b, reason: collision with root package name */
    public final long f16973b;

    public TransactionViewModelFactory() {
        this(0);
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel c(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.equals(TransactionViewModel.class)) {
            return new TransactionViewModel(this.f16973b);
        }
        throw new IllegalArgumentException(("Cannot create " + modelClass).toString());
    }

    public /* synthetic */ TransactionViewModelFactory(int i2) {
        this(0L);
    }

    public TransactionViewModelFactory(long j2) {
        this.f16973b = j2;
    }
}
