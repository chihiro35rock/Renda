package app.mita.chatamin.renda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //残り秒数を10秒にセット
    var second = 10

    // タップを数える変数を準備する
    var tapCount=0

    //タイマーを設定する
    var timer :CountDownTimer = object : CountDownTimer(10000,1000) {

        //タイマーが終了する時に呼ばれる
        override fun onFinish() {
            //STARTボタンを見える状態にする
            startButton.isVisible = true
            // TAPボタンを灰色にセットする
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle_glay)
            // 残り秒数を10秒に戻す
            second = 10
            // タップを数える変数を0に戻す
            tapCount = 0
        }

        //一秒ごとに呼ばれる
        override fun onTick(millisUntilFinished: Long){
            //TAPボタンをピンク色にセット
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle)
            //残り秒数にマイナス1をする
            second = second - 1
            //残り数字をテキストビューに反映する
            secondText.text = second.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //STARTボタンがタップされた時に
        startButton.setOnClickListener {
            //タップされた数をテキストビューに反映する
            countText.text = tapCount.toString()
            //STARTボタンを見えない状態にする
            startButton.isVisible = false

            //タイマーを開始する
            timer.start()
        }

        // ボタンがタップされた時に
        tapButton.setOnClickListener{

            //残り秒数が10秒より少ないときに
            if (second < 10) {

                // タップを数える変数にプラス1する
                tapCount = tapCount + 1

                // タップされた数をテキストビューに反映する
                countText.text = tapCount.toString()

            }

        }

    }
}