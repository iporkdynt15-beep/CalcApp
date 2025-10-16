package jp.techacademy.atsuko.motoyama.calcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalcAppUi()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalcAppUi() {
    // 数値1のテキストフィールド用
    var num1Text by remember { mutableStateOf("") }
    // 数値2のテキストフィールド用
    var num2Text by remember { mutableStateOf("") }
    // 計算結果のテキスト用
    var result   by remember { mutableDoubleStateOf(0.0) }

    val n1 = num1Text.toDoubleOrNull() ?: 0.0
    val n2 = num2Text.toDoubleOrNull() ?: 0.0
    var ans = 0


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 数値1
        TextField(
            value = num1Text,
            onValueChange = { num1Text = it },
            label = { Text("数値1") },
            placeholder = { Text("数値を入力してね") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        // 数値2
        TextField(
            value = num2Text,
            onValueChange = { num2Text = it },
            label = { Text("数値2") },
            placeholder = { Text("数値を入力してね") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()

        )

        // 四則演算ボタン
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // + ボタン
            Button(
                onClick = { result = n1 + n2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC0CB)
                )
            ) {
                Text(text = "+" , color=Color.Black)
            }

            // - ボタン
            Button(
                onClick = { result = n1 - n2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC0CB)
                )
            ) {
                Text(text = "-" , color=Color.Black)
            }

            // * ボタン
            Button(
                onClick = { result = n1 * n2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC0CB)
                )
            ) {
                Text(text = "*" , color=Color.Black)
            }

            // / ボタン
            Button(
                onClick = {
                    try{ result =
                        if(n2 == 0.0) {
                            0.0
                        } else {
                            n1 / n2
                        }
                    } catch (e: Exception){
                        result = 0.0
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC0CB)
                )
            ) {
                Text(text = "/" , color=Color.Black)
            }
        }

        // 結果表示
        Text(
            text = "result: $result")
    }


}