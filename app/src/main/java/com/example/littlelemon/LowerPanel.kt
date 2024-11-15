package com.example.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun LowerPanel(navController: NavHostController, dishes: List<Dish> = listOf()) {
    Column {
        WeeklySpecialCard()
        LazyColumn {
            itemsIndexed(dishes) { _, dish ->
                MenuDish(navController, dish)
            }
        }
    }
}

@Preview
@Composable
fun WeeklySpecialCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.weekly_special),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    Card(onClick = {
        Log.d("AAA", "Click ${dish.id}")
        navController?.navigate(DishDetails.route + "/${dish.id}")
    }) {
        //TODO: Insert code here
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Column {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = dish.description,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth(.75f)
                        .padding(top = 5.dp, bottom = 5.dp)
                )
                Image(
                    painter = painterResource
                        (id = dish.imageResource),
                    contentDescription = "dish image",
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                        .size(100.dp)
                        .align(Alignment.End),
                )
                Text(
                    text = "${ dish.price }",
                    style = MaterialTheme.typography.body2,
                    color = LittleLemonColor.charcoal,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        //TODO: Insert code here
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonColor.yellow
    )
}


