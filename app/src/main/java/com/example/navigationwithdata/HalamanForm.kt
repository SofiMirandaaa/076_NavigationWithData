package com.example.navigationwithdata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitButtonClick: (MutableList<String>)-> Unit,
    onCancelButtonClicked: () -> Unit,
    ) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var alamatTxt by remember {
        mutableStateOf("")
    }
    var telponTxt by remember {
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> = mutableListOf(namaTxt,alamatTxt,telponTxt)

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    )
    {
        Text(text = "Data Pelanggan ")
        Spacer(modifier = Modifier.padding(5.dp))

        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Nama")
        })
        OutlinedTextField(value = alamatTxt, onValueChange = {
            alamatTxt = it
        }, label = {
            Text(text = "Alamat")
        })
        OutlinedTextField(value = telponTxt, onValueChange = {
            telponTxt = it
        }, label = {
            Text(text = "Telepon")
        })
        Spacer(modifier = Modifier.padding(16.dp))
        Column(
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_small
                )) ,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(onClick = onCancelButtonClicked) {
                    Text(stringResource(R.string.cancel))
                }
                Button(onClick = { onSubmitButtonClick(listDataTxt) }) {
                    Text(text = stringResource(id = R.string.next))

                }
            }
        }
    }
}