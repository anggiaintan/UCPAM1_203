package com.example.ucp1pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Layout(modifier: Modifier = Modifier) {

    Column (modifier = modifier.fillMaxSize()) {
        TampilanHeader()
        LatihanInput()
    }
}

@Composable
fun TampilanHeader(){
    Box(modifier = Modifier.fillMaxWidth()
        .background(Color(0xFF0D92F4),
            shape = RoundedCornerShape(bottomEnd = 50.dp)
        )
        .padding(20.dp))

    {
        Row {
            Box (
                contentAlignment = Alignment.BottomEnd
            ){
                Image(
                    painterResource(
                        id = R.drawable.img
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .size(100.dp)
                        .clip(CircleShape))
            }
            Column (modifier = Modifier.padding(16.dp)) {
                Text(text = "Halo, " ,
                    color = Color.White, fontSize = 20.sp
                )
            }
        }
    }
}

@Composable
fun TampilData(
    judul: String,
    isinya: String) {
    Row (modifier = Modifier

        .fillMaxWidth()
        .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(isinya, modifier = Modifier.weight(2f))}
}

@Composable
fun LatihanInput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }

    var dataNama by remember { mutableStateOf("") }
    var dataNoHp by remember { mutableStateOf("") }
    var dataJenisK by remember { mutableStateOf("") }

    val dataJK = listOf("Laki-Laki", "Perempuan")

    Column (modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Yuk lengkapi data dirimu!", fontWeight = FontWeight.Bold,
            fontSize = 25.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = {nama = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Nama") },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )
        TextField(
            value = noHp,
            onValueChange = {noHp = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("No Handphone") },
            placeholder = {
                Text("Masukkan No HP Anda")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = jenisK,
            onValueChange = {jenisK = it},
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            label = { Text("Jenis Kelamin")},
            placeholder = {
                Text("Masukkan jenis kelamin Anda")
            }
        )
        Row {
            dataJK.forEach{selectedJK ->
                Row (verticalAlignment = Alignment.CenterVertically) { RadioButton(selected = jenisK == selectedJK, onClick = {jenisK = selectedJK})
                    Text(selectedJK)

                }}

        }
        Button(
            onClick = {dataNama = nama
            dataNoHp = noHp
            dataJenisK = jenisK}, modifier = Modifier.padding(vertical = 10.dp)
        ) {Text ("Simpan")}

        Card (modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Column {
                TampilData(
                    judul = "Nomor Handphone",
                    isinya = dataNoHp
                )
                TampilData(
                    judul = "Jenis kelamin",
                    isinya = dataJenisK
                )
            }

        }}}