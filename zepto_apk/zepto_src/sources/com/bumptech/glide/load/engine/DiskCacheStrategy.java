package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes3.dex */
public abstract class DiskCacheStrategy {

    /* renamed from: a, reason: collision with root package name */
    public static final DiskCacheStrategy f15936a;

    /* renamed from: b, reason: collision with root package name */
    public static final DiskCacheStrategy f15937b;

    /* renamed from: c, reason: collision with root package name */
    public static final DiskCacheStrategy f15938c;

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$1, reason: invalid class name */
    public class AnonymousClass1 extends DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean c(DataSource dataSource) {
            return dataSource == DataSource.f15789b;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.f15791d || dataSource == DataSource.f15792e) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$2, reason: invalid class name */
    public class AnonymousClass2 extends DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$3, reason: invalid class name */
    public class AnonymousClass3 extends DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean c(DataSource dataSource) {
            return (dataSource == DataSource.f15790c || dataSource == DataSource.f15792e) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$4, reason: invalid class name */
    public class AnonymousClass4 extends DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean c(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.f15791d || dataSource == DataSource.f15792e) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$5, reason: invalid class name */
    public class AnonymousClass5 extends DiskCacheStrategy {
        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean b() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean c(DataSource dataSource) {
            return dataSource == DataSource.f15789b;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public final boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.f15790c) || dataSource == DataSource.f15788a) && encodeStrategy == EncodeStrategy.f15799b;
        }
    }

    static {
        new AnonymousClass1();
        f15936a = new AnonymousClass2();
        f15937b = new AnonymousClass3();
        new AnonymousClass4();
        f15938c = new AnonymousClass5();
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
