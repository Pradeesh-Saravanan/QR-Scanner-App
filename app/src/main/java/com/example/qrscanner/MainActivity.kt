package com.example.qrscanner

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.qrscanner.databinding.ActivityMainBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class MainActivity : AppCompatActivity() {
    private val requestPermissionLauncher = registerForActivityResult(contract = ActivityResultContracts.RequestPermission()){
        isGranted:Boolean->
        if(isGranted){
            showCamera()
        }
    }
    private val scanLauncher=registerForActivityResult(ScanContract()){
        result: ScanIntentResult ->
        kotlin.run{
            if(result.contents==null){
                Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show()
            }
            else{
                setResult(result.contents)
                showQR(result.contents);
                binding.share.setOnClickListener{
                    shareContent(result.contents)
                }
            }
        }
    }
    private  fun showQR(string:String){
        binding.showqr.setOnClickListener{
                val intent = Intent(this, ShowQR::class.java)
                intent.putExtra("msg", string)
                startActivity(intent)
        }
    }
    private fun setResult(string:String){
        binding.textResult.text = string
    }
    private fun shareContent(content: String) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, content)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
    private lateinit var binding:ActivityMainBinding
    private fun showCamera(){
            val options = ScanOptions()
            options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
            options.setPrompt("Scan QR code")
            options.setCameraId(1)
            options.setBeepEnabled(false)
            options.setBarcodeImageEnabled(true)
            options.setOrientationLocked(false)
        scanLauncher.launch(options)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initBinding()
        initViews()
//        var show = findViewById<Button>(R.id.showqr)
//        binding.showqr.setOnClickListener{
//            startActivity(Intent(this,ShowQR::class.java))
//        }
    }
    private fun initViews(){
        binding.fab.setOnClickListener{
            checkPermissionCamera(this)
        }
    }
    private fun checkPermissionCamera(context: Context){
        if(ContextCompat.checkSelfPermission(context,android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            showCamera()
        }
        else if(shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)){
            Toast.makeText(context,"CAMERA permission required", Toast.LENGTH_SHORT).show()
        }
        else{
            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }
    private fun initBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}