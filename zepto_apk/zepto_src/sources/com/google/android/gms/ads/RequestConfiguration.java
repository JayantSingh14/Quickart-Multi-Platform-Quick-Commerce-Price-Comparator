package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class RequestConfiguration {

    /* renamed from: c, reason: collision with root package name */
    public static final List f21019c = Arrays.asList("MA", "T", "PG", "G");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f21020a;

    /* renamed from: b, reason: collision with root package name */
    public final PublisherPrivacyPersonalizationState f21021b;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f21022a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final PublisherPrivacyPersonalizationState f21023b = PublisherPrivacyPersonalizationState.DEFAULT;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    public enum PublisherPrivacyPersonalizationState {
        DEFAULT(0),
        /* JADX INFO: Fake field, exist only in values array */
        ENABLED(1),
        /* JADX INFO: Fake field, exist only in values array */
        DISABLED(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f21026a;

        PublisherPrivacyPersonalizationState(int i2) {
            this.f21026a = i2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    public /* synthetic */ RequestConfiguration(ArrayList arrayList, PublisherPrivacyPersonalizationState publisherPrivacyPersonalizationState) {
        this.f21020a = arrayList;
        this.f21021b = publisherPrivacyPersonalizationState;
    }
}
