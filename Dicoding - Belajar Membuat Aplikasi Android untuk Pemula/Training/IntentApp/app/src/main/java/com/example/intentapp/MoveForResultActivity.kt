package com.example.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup
    private lateinit var tvResult: TextView

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)
        tvResult = findViewById(R.id.tv_result_radio)

        btnChoose.setOnClickListener(this)

        // Inisialisasi btnBackHomeRadio Untuk Kembali ke Main Activity
        val btnBackHomeRadio: Button = findViewById(R.id.btn_move_activity_data_radio)
        btnBackHomeRadio.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_choose -> {
                if (rgNumber.checkedRadioButtonId > 0) {
                    var value = 0
                    when (rgNumber.checkedRadioButtonId) {
                        R.id.rb_50 -> value = 50
                        R.id.rb_100 -> value = 100
                        R.id.rb_150 -> value = 150
                        R.id.rb_200 -> value = 200
                    }

                    // See the result
                    val resultIntent = Intent()
                    resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                    setResult(RESULT_CODE, resultIntent)

                    // Display Value
                    tvResult.text = "Selected Value: $value"

                    // Finish the activity (if needed)
//                     finish()
                }
            }
            R.id.btn_move_activity_data_radio -> {
                val backIntent = Intent(this@MoveForResultActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }
}
