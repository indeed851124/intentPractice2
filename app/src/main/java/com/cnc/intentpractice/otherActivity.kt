package com.cnc.intentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cnc.intentpractice.databinding.ActivityOtherBinding
class otherActivity : AppCompatActivity() {
    private var mBinding: ActivityOtherBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnBtn.setOnClickListener {
            finish()
        }
    }
}