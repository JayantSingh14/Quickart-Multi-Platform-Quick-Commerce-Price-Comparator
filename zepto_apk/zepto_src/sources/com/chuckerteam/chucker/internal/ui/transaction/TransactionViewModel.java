package com.chuckerteam.chucker.internal.ui.transaction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.brentvatne.common.react.r;
import com.chuckerteam.chucker.internal.data.repository.HttpTransactionDatabaseRepository;
import com.chuckerteam.chucker.internal.data.repository.RepositoryProvider;
import com.chuckerteam.chucker.internal.support.LiveDataUtilsKt;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class TransactionViewModel extends ViewModel {

    /* renamed from: b, reason: collision with root package name */
    public final MutableLiveData f16966b;

    /* renamed from: c, reason: collision with root package name */
    public final MutableLiveData f16967c;

    /* renamed from: d, reason: collision with root package name */
    public final MediatorLiveData f16968d;

    /* renamed from: e, reason: collision with root package name */
    public final MediatorLiveData f16969e;

    /* renamed from: f, reason: collision with root package name */
    public final MediatorLiveData f16970f;

    /* renamed from: g, reason: collision with root package name */
    public final LiveData f16971g;

    /* renamed from: h, reason: collision with root package name */
    public final MediatorLiveData f16972h;

    public TransactionViewModel(long j2) {
        MutableLiveData mutableLiveData = new MutableLiveData(Boolean.FALSE);
        this.f16966b = mutableLiveData;
        this.f16967c = mutableLiveData;
        this.f16968d = LiveDataUtilsKt.a(((HttpTransactionDatabaseRepository) RepositoryProvider.b()).c(j2), mutableLiveData, new com.chuckerteam.chucker.internal.data.repository.a(2));
        this.f16969e = Transformations.a(((HttpTransactionDatabaseRepository) RepositoryProvider.b()).c(j2), new r(6));
        MediatorLiveData mediatorLiveDataA = Transformations.a(((HttpTransactionDatabaseRepository) RepositoryProvider.b()).c(j2), new r(7));
        this.f16970f = mediatorLiveDataA;
        this.f16971g = ((HttpTransactionDatabaseRepository) RepositoryProvider.b()).c(j2);
        this.f16972h = LiveDataUtilsKt.a(mediatorLiveDataA, mutableLiveData, new com.chuckerteam.chucker.internal.data.repository.a(3));
    }
}
