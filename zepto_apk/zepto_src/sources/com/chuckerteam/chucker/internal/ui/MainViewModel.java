package com.chuckerteam.chucker.internal.ui;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.brentvatne.common.react.r;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class MainViewModel extends ViewModel {

    /* renamed from: b, reason: collision with root package name */
    public final MutableLiveData f16887b;

    /* renamed from: c, reason: collision with root package name */
    public final MediatorLiveData f16888c;

    public MainViewModel() {
        MutableLiveData mutableLiveData = new MutableLiveData("");
        this.f16887b = mutableLiveData;
        this.f16888c = Transformations.b(mutableLiveData, new r(5));
    }
}
