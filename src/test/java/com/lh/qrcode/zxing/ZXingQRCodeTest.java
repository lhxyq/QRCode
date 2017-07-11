package com.lh.qrcode.zxing;


import java.io.File;
import java.nio.file.Path;

/**
 * Created by LH 2446059046@qq.com on 2017/7/11.
 */
public class ZXingQRCodeTest {
    public static void main(String[] args) throws Exception{
        Path path = new File("E:\\document\\lh\\program\\QRCode\\img\\baidu.png").toPath();
        ZXingQRCode zXingQRCode = new ZXingQRCode();
        zXingQRCode.createQRCode(300, 300, "png", "www.baidu.com", path );
    }
}