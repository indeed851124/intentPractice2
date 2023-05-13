package com.cnc.intentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cnc.intentpractice.databinding.ActivityEditNicknameBinding

class EditNicknameActivity : AppCompatActivity() {
    private var mBinding: ActivityEditNicknameBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityEditNicknameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.okBtn.setOnClickListener {
            val aa = binding.newNicknameEdt.text
            intent.putExtra("data", "")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}