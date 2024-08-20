package com.example.qrscanner

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.journeyapps.barcodescanner.BarcodeEncoder

class ShowQR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qr_display);
        val qrcontent = intent.getStringExtra("msg");
//        MultiFormatWriter writer = new MultiFormatWriter();
        val img = findViewById<ImageView>(R.id.imageView);
        try{
//            BitMatrix matrix = writer.encode(qrcontent,BarcodeFormat.QR_CODE,400,400);
//            BarcodeEncoder encoder = new BarcodeEncoder();
//            Bitmap bitmap = encoder.createBitmap(matrix);
            val writer = QRCodeWriter()
            val bitMatrix : BitMatrix = writer.encode(qrcontent, BarcodeFormat.QR_CODE,300,300)
            val encoder = BarcodeEncoder()
            val bitmap:Bitmap = encoder.createBitmap(bitMatrix)
            img.setImageBitmap(bitmap);
        }
        catch(e: WriterException){
            e.printStackTrace()
        }
    }
}