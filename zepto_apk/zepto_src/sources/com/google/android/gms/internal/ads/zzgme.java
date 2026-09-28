package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
final class zzgme implements zzglz, zzgcb {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32897a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgnc f32898b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgad f32899c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f32900d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f32901e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public ListenableFuture f32902f = zzgym.a("E");

    public zzgme(Context context, zzgad zzgadVar, zzgnc zzgncVar, zzgyw zzgywVar) {
        this.f32897a = context;
        this.f32898b = zzgncVar;
        this.f32899c = zzgadVar;
        this.f32900d = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void a(HashMap map, Context context, View view) {
        d(map);
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void b(HashMap map) {
        d(map);
    }

    @Override // com.google.android.gms.internal.ads.zzglz
    public final void c(HashMap map) {
        d(map);
    }

    public final void d(HashMap map) {
        synchronized (this) {
            map.put("ai", this.f32902f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final ListenableFuture zza() {
        if (this.f32901e.getAndSet(true)) {
            return zzgyq.f33377b;
        }
        return this.f32900d.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzgmd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                final zzgme zzgmeVar = this.f32896a;
                zzgmeVar.getClass();
                zzgpr zzgprVar = new zzgpr() { // from class: com.google.android.gms.internal.ads.zzgmc
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final Object apply(Object obj) throws IOException {
                        String str = (String) obj;
                        boolean zA = zzgpz.a(str);
                        zzgme zzgmeVar2 = zzgmeVar;
                        if (!zA) {
                            zzgmeVar2.getClass();
                            return str;
                        }
                        File file = new File(zzgmeVar2.f32897a.getPackageResourcePath());
                        if (!file.exists() || !file.canRead()) {
                            return "";
                        }
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            try {
                                byte[] bArr = new byte[16384];
                                MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
                                for (int i2 = fileInputStream.read(bArr); i2 != -1; i2 = fileInputStream.read(bArr)) {
                                    messageDigest.update(bArr, 0, i2);
                                }
                                zzgvy zzgvyVarF = zzgvy.f33277c.f();
                                byte[] bArrDigest = messageDigest.digest();
                                String strG = zzgvyVarF.g(bArrDigest.length, bArrDigest);
                                fileInputStream.close();
                                return strG;
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (IOException | UnsupportedOperationException | NoSuchAlgorithmException unused) {
                            return "";
                        }
                    }
                };
                synchronized (zzgmeVar) {
                    zzgnc zzgncVar = zzgmeVar.f32898b;
                    final Context context = zzgmeVar.f32897a;
                    final zzgad zzgadVar = zzgmeVar.f32899c;
                    ListenableFuture listenableFutureI = zzgym.i(CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.gms.internal.ads.zzgma
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object a(final CallbackToFutureAdapter.Completer completer) throws PackageManager.NameNotFoundException, CertificateException {
                            String str;
                            String str2;
                            Context context2 = context;
                            zzgad zzgadVar2 = zzgadVar;
                            if (Build.VERSION.SDK_INT < 31) {
                                completer.a("");
                                return "";
                            }
                            try {
                                String packageName = context2.getPackageName();
                                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                                String[] strArr = {zzgadVar2.S(), "308204433082032ba003020102020900c2e08746644a308d300d06092a864886f70d01010405003074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f6964301e170d3038303832313233313333345a170d3336303130373233313333345a3074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f696430820120300d06092a864886f70d01010105000382010d00308201080282010100ab562e00d83ba208ae0a966f124e29da11f2ab56d08f58e2cca91303e9b754d372f640a71b1dcb130967624e4656a7776a92193db2e5bfb724a91e77188b0e6a47a43b33d9609b77183145ccdf7b2e586674c9e1565b1f4c6a5955bff251a63dabf9c55c27222252e875e4f8154a645f897168c0b1bfc612eabf785769bb34aa7984dc7e2ea2764cae8307d8c17154d7ee5f64a51a44a602c249054157dc02cd5f5c0e55fbef8519fbe327f0b1511692c5a06f19d18385f5c4dbc2d6b93f68cc2979c70e18ab93866b3bd5db8999552a0e3b4c99df58fb918bedc182ba35e003c1b4b10dd244a8ee24fffd333872ab5221985edab0fc0d0b145b6aa192858e79020103a381d93081d6301d0603551d0e04160414c77d8cc2211756259a7fd382df6be398e4d786a53081a60603551d2304819e30819b8014c77d8cc2211756259a7fd382df6be398e4d786a5a178a4763074310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e205669657731143012060355040a130b476f6f676c6520496e632e3110300e060355040b1307416e64726f69643110300e06035504031307416e64726f6964820900c2e08746644a308d300c0603551d13040530030101ff300d06092a864886f70d010104050003820101006dd252ceef85302c360aaace939bcff2cca904bb5d7a1661f8ae46b2994204d0ff4a68c7ed1a531ec4595a623ce60763b167297a7ae35712c407f208f0cb109429124d7b106219c084ca3eb3f9ad5fb871ef92269a8be28bf16d44c8d9a08e6cb2f005bb3fe2cb96447e868e731076ad45b33f6009ea19c161e62641aa99271dfd5228c5c587875ddb7f452758d661f6cc0cccb7352e424cc4365c523532f7325137593c4ae341f4db41edda0d0b1071a7c440f0fe9ea01cb627ca674369d084bd2fd911ff06cdbf2cfa10dc0f893ae35762919048c7efc64c7144178342f70581c9de573af55b390dd7fdb9418631895d5f759f30112687ff621410c069308a"};
                                int i2 = 0;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= 2) {
                                        str = "";
                                        break;
                                    }
                                    str = strArr[i3];
                                    if (!TextUtils.isEmpty(str)) {
                                        break;
                                    }
                                    i3++;
                                }
                                zzgvy zzgvyVar = zzgvy.f33277c;
                                byte[] bArrH = zzgvyVar.f().h(str);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrH)));
                                if (!Build.TYPE.equals(LogSubCategory.Action.USER)) {
                                    String[] strArr2 = {zzgadVar2.T(), "308204a830820390a003020102020900d585b86c7dd34ef5300d06092a864886f70d0101040500308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d301e170d3038303431353233333635365a170d3335303930313233333635365a308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d30820120300d06092a864886f70d01010105000382010d00308201080282010100d6ce2e080abfe2314dd18db3cfd3185cb43d33fa0c74e1bdb6d1db8913f62c5c39df56f846813d65bec0f3ca426b07c5a8ed5a3990c167e76bc999b927894b8f0b22001994a92915e572c56d2a301ba36fc5fc113ad6cb9e7435a16d23ab7dfaeee165e4df1f0a8dbda70a869d516c4e9d051196ca7c0c557f175bc375f948c56aae86089ba44f8aa6a4dd9a7dbf2c0a352282ad06b8cc185eb15579eef86d080b1d6189c0f9af98b1c2ebd107ea45abdb68a3c7838a5e5488c76c53d40b121de7bbd30e620c188ae1aa61dbbc87dd3c645f2f55f3d4c375ec4070a93f7151d83670c16a971abe5ef2d11890e1b8aef3298cf066bf9e6ce144ac9ae86d1c1b0f020103a381fc3081f9301d0603551d0e041604148d1cc5be954c433c61863a15b04cbc03f24fe0b23081c90603551d230481c13081be80148d1cc5be954c433c61863a15b04cbc03f24fe0b2a1819aa48197308194310b3009060355040613025553311330110603550408130a43616c69666f726e6961311630140603550407130d4d6f756e7461696e20566965773110300e060355040a1307416e64726f69643110300e060355040b1307416e64726f69643110300e06035504031307416e64726f69643122302006092a864886f70d0109011613616e64726f696440616e64726f69642e636f6d820900d585b86c7dd34ef5300c0603551d13040530030101ff300d06092a864886f70d0101040500038201010019d30cf105fb78923f4c0d7dd223233d40967acfce00081d5bd7c6e9d6ed206b0e11209506416ca244939913d26b4aa0e0f524cad2bb5c6e4ca1016a15916ea1ec5dc95a5e3a010036f49248d5109bbf2e1e618186673a3be56daf0b77b1c229e3c255e3e84c905d2387efba09cbf13b202b4e5a22c93263484a23d2fc29fa9f1939759733afd8aa160f4296c2d0163e8182859c6643e9c1962fa0c18333335bc090ff9a6b22ded1ad444229a539a94eefadabd065ced24b3e51e5dd7b66787bef12fe97fba484c423fb4ff8cc494c02f0f5051612ff6529393e8e46eac5bb21f277c151aa5f2aa627d1e89da70ab6033569de3b9897bfff7ca9da3e1243f60b"};
                                    while (true) {
                                        if (i2 >= 2) {
                                            str2 = "";
                                            break;
                                        }
                                        str2 = strArr2[i2];
                                        if (!TextUtils.isEmpty(str2)) {
                                            break;
                                        }
                                        i2++;
                                    }
                                    arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzgvyVar.f().h(str2))));
                                }
                                context2.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzgmb
                                    public final void onChecksumsReady(List list) {
                                        CallbackToFutureAdapter.Completer completer2 = completer;
                                        if (list == null) {
                                            completer2.a("");
                                            return;
                                        }
                                        try {
                                            int size = list.size();
                                            for (int i4 = 0; i4 < size; i4++) {
                                                ApkChecksum apkChecksumC = com.facebook.hermes.intl.a.c(list.get(i4));
                                                if (apkChecksumC.getType() == 8) {
                                                    zzgvy zzgvyVarF = zzgvy.f33277c.f();
                                                    byte[] value = apkChecksumC.getValue();
                                                    completer2.a(zzgvyVarF.g(value.length, value));
                                                    return;
                                                }
                                            }
                                        } catch (Throwable unused) {
                                        }
                                        completer2.a("");
                                    }
                                });
                                return "";
                            } catch (PackageManager.NameNotFoundException | NoClassDefFoundError | CertificateException unused) {
                                completer.a("");
                                return "";
                            }
                        }
                    }), zzgprVar, zzgmeVar.f32900d);
                    zzgncVar.e(52, listenableFutureI);
                    zzgmeVar.f32902f = listenableFutureI;
                }
                return "";
            }
        });
    }
}
