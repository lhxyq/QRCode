package com.lh.qrcode.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LH 2446059046@qq.com on 2017/7/11.
 */
public class ZXingQRCode {
    /**
     *
     * @param width   宽
     * @param height  高
     * @param imaFormat 图片格式
     * @param content 二维码类容
     * @param path 二维码保存的位置
     * @throws Exception
     */
    public void createQRCode(int width, int height, String imaFormat, String content, Path path) throws Exception {
        Map map = new HashMap();

        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        map.put(EncodeHintType.MARGIN, 2);

        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, map);

        MatrixToImageWriter.writeToPath(bitMatrix, imaFormat, path);

    }

    public Result readQRCode(String filePath) throws Exception {
        MultiFormatReader reader = new MultiFormatReader();

        File file = new File(filePath);
        BufferedImage image = ImageIO.read(file);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

        Map map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");

        Result result = reader.decode(binaryBitmap, map);
        return  result;
    }
}
