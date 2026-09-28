package com.cardreader.card_reader_lib;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build;
import android.support.v4.media.b;
import android.util.Log;
import androidx.annotation.Keep;
import com.cardreader.card_reader_lib.enumModel.CommandEnum;
import com.cardreader.card_reader_lib.enumModel.TagValueTypeEnum;
import com.cardreader.card_reader_lib.models.Afl;
import com.cardreader.card_reader_lib.models.EmvCard;
import com.cardreader.card_reader_lib.xutils.ByteArrayWrapper;
import com.cardreader.card_reader_lib.xutils.BytesUtils;
import com.cardreader.card_reader_lib.xutils.CommandApdu;
import com.cardreader.card_reader_lib.xutils.EmvTags;
import com.cardreader.card_reader_lib.xutils.EmvTerminal;
import com.cardreader.card_reader_lib.xutils.ITag;
import com.cardreader.card_reader_lib.xutils.ResponseUtils;
import com.cardreader.card_reader_lib.xutils.TLV;
import com.cardreader.card_reader_lib.xutils.TagAndLength;
import com.cardreader.card_reader_lib.xutils.TagImpl;
import com.cardreader.card_reader_lib.xutils.TlvException;
import com.cardreader.card_reader_lib.xutils.TlvUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CardTask {

    /* renamed from: c, reason: collision with root package name */
    public static EmvCard f16536c;

    /* renamed from: d, reason: collision with root package name */
    public static final IntentFilter[] f16537d = {new IntentFilter("android.nfc.action.TECH_DISCOVERED"), new IntentFilter("android.nfc.action.TAG_DISCOVERED")};

    /* renamed from: e, reason: collision with root package name */
    public static final String[][] f16538e = {new String[]{NfcA.class.getName(), IsoDep.class.getName()}};

    /* renamed from: a, reason: collision with root package name */
    public NfcAdapter f16539a;

    /* renamed from: b, reason: collision with root package name */
    public PendingIntent f16540b;

    @Keep
    public CardTask() {
        f16536c = new EmvCard();
    }

    public static boolean a(byte[] bArr) {
        byte[] bArrC = TlvUtil.c(bArr, EmvTags.f16572d, EmvTags.f16578j);
        Log.d("Track2", BytesUtils.a(bArrC));
        if (bArrC != null) {
            Log.d("track2 succeded -", "We got track2 data Sam");
            try {
                String str = "";
                for (byte b2 : bArrC) {
                    str = str + String.format("%02X", Byte.valueOf(b2));
                }
                String[] strArrSplit = str.split("D");
                EmvCard emvCard = f16536c;
                emvCard.f16556a = strArrSplit[0];
                emvCard.f16557b = strArrSplit[1].substring(2, 4);
                f16536c.f16558c = strArrSplit[1].substring(0, 2);
                return true;
            } catch (Exception e2) {
                Log.e("parseTrack2 exception", e2.toString());
            }
        }
        return false;
    }

    @Keep
    public List<Afl> extractAfl(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        while (byteArrayInputStream.available() >= 4) {
            Afl afl = new Afl();
            afl.f16553a = byteArrayInputStream.read() >> 3;
            afl.f16554b = byteArrayInputStream.read();
            afl.f16555c = byteArrayInputStream.read();
            byteArrayInputStream.read();
            arrayList.add(afl);
        }
        return arrayList;
    }

    @Keep
    public boolean extractPublicData(IsoDep isoDep, byte[] bArr) throws IOException {
        boolean zA;
        byte[] bArrA = new CommandApdu(CommandEnum.f16541d, bArr).a();
        Log.d("APDU", BytesUtils.a(bArrA));
        byte[] bArrTransceive = isoDep.transceive(bArrA);
        Log.d("resData", BytesUtils.a(bArrTransceive));
        if (ResponseUtils.a(bArrTransceive, BytesUtils.b("9000"))) {
            Log.d("got resData -", BytesUtils.a(bArrTransceive));
            String string = "";
            for (byte b2 : TlvUtil.c(bArrTransceive, EmvTags.f16571c)) {
                StringBuilder sbW = b.w(string);
                sbW.append(String.format("%02X", Byte.valueOf(b2)));
                string = sbW.toString();
            }
            Log.d("AidString", string);
            f16536c.getClass();
            byte[] bArrC = TlvUtil.c(bArrTransceive, EmvTags.f16576h);
            if (bArrC != null) {
                Log.d("PDOL", BytesUtils.a(bArrC));
            }
            ArrayList arrayList = new ArrayList();
            if (bArrC != null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrC);
                while (byteArrayInputStream.available() > 0) {
                    if (byteArrayInputStream.available() < 2) {
                        throw new TlvException("Data length < 2 : " + byteArrayInputStream.available());
                    }
                    byte[] bArrE = TlvUtil.e(byteArrayInputStream);
                    LinkedHashMap linkedHashMap = EmvTags.f16569a;
                    bArrE.getClass();
                    ITag tagImpl = (ITag) linkedHashMap.get(new ByteArrayWrapper(bArrE));
                    if (tagImpl == null) {
                        tagImpl = new TagImpl(bArrE, TagValueTypeEnum.f16550a, "[UNKNOWN TAG]");
                    }
                    int iF = TlvUtil.f(byteArrayInputStream);
                    TagAndLength tagAndLength = new TagAndLength();
                    tagAndLength.f16587a = tagImpl;
                    tagAndLength.f16588b = iF;
                    arrayList.add(tagAndLength);
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(EmvTags.f16574f.f16589a);
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    i2 += ((TagAndLength) it.next()).f16588b;
                }
                byteArrayOutputStream.write(i2);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    TagAndLength tagAndLength2 = (TagAndLength) it2.next();
                    Log.d("PDOLList", tagAndLength2.toString());
                    byteArrayOutputStream.write(EmvTerminal.a(tagAndLength2));
                }
            } catch (IOException e2) {
                Log.e("getGPO exception", e2.toString());
            }
            byte[] bArrTransceive2 = isoDep.transceive(new CommandApdu(CommandEnum.f16542e, byteArrayOutputStream.toByteArray()).a());
            if (bArrTransceive2 != null) {
                Log.d("GPO", BytesUtils.a(bArrTransceive2));
            }
            if (ResponseUtils.a(bArrTransceive2, BytesUtils.b("9000"))) {
                Log.d("gpo succeded -", BytesUtils.a(bArrTransceive2));
                byte[] bArrC2 = TlvUtil.c(bArrTransceive2, EmvTags.f16573e);
                if (bArrC2 != null) {
                    Log.d("msgData", BytesUtils.a(bArrC2));
                    int length = bArrC2.length;
                    if (length > bArrC2.length) {
                        length = bArrC2.length;
                    }
                    int i3 = length - 2;
                    if (i3 <= 0) {
                        bArrC2 = new byte[0];
                    } else {
                        byte[] bArr2 = new byte[i3];
                        System.arraycopy(bArrC2, 2, bArr2, 0, i3);
                        bArrC2 = bArr2;
                    }
                    zA = false;
                } else {
                    zA = a(bArrTransceive2);
                    if (!zA) {
                        bArrC2 = TlvUtil.c(bArrTransceive2, EmvTags.f16575g);
                    }
                }
                if (bArrC2 != null) {
                    loop4: for (Afl afl : extractAfl(bArrC2)) {
                        for (int i4 = afl.f16554b; i4 <= afl.f16555c; i4++) {
                            byte[] bArrTransceive3 = isoDep.transceive(new CommandApdu(i4, (afl.f16553a << 3) | 4, 0).a());
                            if (ResponseUtils.a(bArrTransceive3, BytesUtils.b("6C"))) {
                                bArrTransceive3 = isoDep.transceive(new CommandApdu(i4, (afl.f16553a << 3) | 4, bArrTransceive3[bArrTransceive3.length - 1]).a());
                            }
                            if (ResponseUtils.a(bArrTransceive3, BytesUtils.b("9000")) && (zA = a(bArrTransceive3))) {
                                break loop4;
                            }
                        }
                    }
                }
                return zA;
            }
        }
        return false;
    }

    @Keep
    public String getCardDetails(Intent intent) {
        NfcAdapter nfcAdapter;
        try {
            EmvTags.a();
            if (!intent.getAction().equals("android.nfc.action.TECH_DISCOVERED") || (nfcAdapter = this.f16539a) == null || !nfcAdapter.isEnabled()) {
                return null;
            }
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag != null) {
                readWithPSE(IsoDep.get(tag));
            }
            EmvCard emvCard = f16536c;
            String str = emvCard.f16556a;
            String str2 = emvCard.f16557b;
            String str3 = emvCard.f16558c;
            if (str == null || str2 == null || str3 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cardNumber", f16536c.f16556a);
            jSONObject.put("expiryMonth", f16536c.f16557b);
            jSONObject.put("expiryYear", f16536c.f16558c);
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Keep
    public boolean isNFCEnabled(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        this.f16539a = defaultAdapter;
        if (defaultAdapter != null) {
            return defaultAdapter.isEnabled();
        }
        return false;
    }

    @Keep
    public boolean isNFCSupported(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        this.f16539a = defaultAdapter;
        return defaultAdapter != null;
    }

    @Keep
    public void onPauseClone(Activity activity) {
        NfcAdapter nfcAdapter = this.f16539a;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(activity);
        }
    }

    @Keep
    public void onResumeClone(Activity activity) {
        if (Build.VERSION.SDK_INT >= 31) {
            this.f16540b = PendingIntent.getActivity(activity.getApplicationContext(), 0, new Intent(activity.getApplicationContext(), activity.getClass()).addFlags(536870912), 33554432);
        } else {
            this.f16540b = PendingIntent.getActivity(activity.getApplicationContext(), 0, new Intent(activity.getApplicationContext(), activity.getClass()).addFlags(536870912), 67108864);
        }
        this.f16539a.enableForegroundDispatch(activity, this.f16540b, f16537d, f16538e);
    }

    @Keep
    public boolean readWithPSE(IsoDep isoDep) throws IOException {
        byte[] bArr;
        byte[] bytes = "2PAY.SYS.DDF01".getBytes();
        isoDep.connect();
        byte[] bArrTransceive = isoDep.transceive(new CommandApdu(CommandEnum.f16541d, bytes).a());
        Log.d("PSE", BytesUtils.a(bArrTransceive));
        if (ResponseUtils.a(bArrTransceive, BytesUtils.b("9000"))) {
            ArrayList arrayList = new ArrayList();
            Iterator it = TlvUtil.d(bArrTransceive, EmvTags.f16570b, EmvTags.f16579k).iterator();
            while (it.hasNext()) {
                TLV tlv = (TLV) it.next();
                ITag iTag = tlv.f16585a;
                TagImpl tagImpl = EmvTags.f16579k;
                byte[] bArr2 = tlv.f16586b;
                if (iTag != tagImpl || arrayList.size() == 0) {
                    arrayList.add(bArr2);
                } else {
                    byte[] bArr3 = (byte[]) b.c(1, arrayList);
                    if (bArr3 == null) {
                        bArr = bArr2 == null ? null : (byte[]) bArr2.clone();
                    } else if (bArr2 == null) {
                        bArr = (byte[]) bArr3.clone();
                    } else {
                        byte[] bArr4 = new byte[bArr3.length + bArr2.length];
                        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                        System.arraycopy(bArr2, 0, bArr4, bArr3.length, bArr2.length);
                        bArr = bArr4;
                    }
                    arrayList.add(bArr);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArr5 = (byte[]) it2.next();
                Log.d("PSE AIDs", BytesUtils.a(bArr5));
                try {
                    if (extractPublicData(isoDep, bArr5)) {
                        isoDep.close();
                        return true;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        isoDep.close();
        return false;
    }
}
