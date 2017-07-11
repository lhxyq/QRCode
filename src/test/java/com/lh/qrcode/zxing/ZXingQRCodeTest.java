package com.lh.qrcode.zxing;


import com.google.zxing.Result;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by LH 2446059046@qq.com on 2017/7/11.
 */
public class ZXingQRCodeTest {
    public static void main(String[] args) throws Exception{
        Path path = new File("E:\\document\\lh\\program\\QRCode\\img\\xyqb.jpg").toPath();
        ZXingQRCode zXingQRCode = new ZXingQRCode();
        zXingQRCode.createQRCode(300, 300, "jpg", "lhxyq.github.io", path );

        /*ZXingQRCode zXingQRCode = new ZXingQRCode();
        Result result = zXingQRCode.readQRCode("E:\\document\\lh\\program\\QRCode\\img\\xyq.png");
        System.out.println("解析结果: " + result.toString());
        System.out.println("二维码格式：" + result.getBarcodeFormat());
        System.out.println("二维码文本内容：" + result.getText());*/
    }
}