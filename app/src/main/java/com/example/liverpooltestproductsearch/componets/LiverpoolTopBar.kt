package com.example.liverpooltestproductsearch.componets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.liverpooltestproductsearch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiverpoolTopBar(title: String, onClickBackButton: () -> Unit, state: SearchState) {

    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = {

            IconButton(onClick = { onClickBackButton() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "",
                    tint = Color.White
                )
            }

        },
        actions = {

            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    painter = painterResource(R.drawable.baseline_sort_24),
                    tint = Color.White,
                    contentDescription = "More options"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // First section
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.label_lower_price), color = Color.White) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.currenccy_lvp),
                            contentDescription = null,
                            tint = Color.White,
                        )
                    },
                    onClick = { state.minSortPrice = 0; expanded = false; }
                )
                HorizontalDivider(color = Color.White)
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.label_higher_price), color = Color.White) },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.currenccy_lvp),
                            contentDescription = null,
                            tint = Color.White,
                        )
                    },
                    onClick = { state.minSortPrice = 1; expanded = false; }
                )

                HorizontalDivider(color = Color.White)

                DropdownMenuItem(
                    text = { Text(stringResource(R.string.label_Predefined), color = Color.White) },
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.arrow_predefinido),
                            contentDescription = null,
                            tint = Color.White,
                        )
                    },
                    onClick = { state.minSortPrice = -1; expanded = false; }
                )
            }

        }
    )
}


