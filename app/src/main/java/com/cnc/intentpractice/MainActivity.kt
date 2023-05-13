package com.cnc.intentpractice

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.cnc.intentpractice.databinding.ActivityEditNicknameBinding
import com.cnc.intentpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    // registerForActivityResult는 FirstFragment.kt 전역 부분에 선언하고 정의해야한다
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // 전달 받은 String 데이터를 출력
                when {
                    !result.data?.getStringExtra("data").isNullOrBlank() -> {
                        binding.nicknameTxt.text = result.data?.getStringExtra("data")

                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.naverWebBtn.setOnClickListener {
            val myUri = Uri.parse("https://www.naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        binding.kakaoStoreBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        binding.smsBtn.setOnClickListener {
            val inputPhoneNum = binding.phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body","미리 내용 입력")
            startActivity(myIntent)
        }

        binding.callBtn.setOnClickListener {
            val inputPhoneNum = binding.phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

        binding.dialBtn.setOnClickListener {
            val inputPhoneNum = binding.phoneNumEdt.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

        binding.sendMessageBtn.setOnClickListener {
            val inputMassage = binding.messageEdt.text.toString()
            val myIntent = Intent(this, messageActivity::class.java)
            myIntent.putExtra("message", inputMassage)
            startActivity(myIntent)
        }

        binding.moveToOtherBtn.setOnClickListener {
            val myIntent = Intent(this,otherActivity::class.java)
            startActivity(myIntent)
        }

        binding.editNicknameBtn.setOnClickListener {
            val myIntent = Intent(this, EditNicknameActivity::class.java)
            resultLauncher.launch(myIntent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


    }
}