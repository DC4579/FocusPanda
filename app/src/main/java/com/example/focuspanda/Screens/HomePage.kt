package com.example.focuspanda.Screens

import com.example.focuspanda.R


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focuspanda.CommenSection.MainsCard
import com.example.focuspanda.Data.QuickNavigationIterm
import com.example.focuspanda.Model.QuickNavigate1
import com.example.focuspanda.ui.theme.surfaceVariantLight


@Composable
fun MainScreen() {
    val searchQuery = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize() // Ensures full screen coverage
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Using paddingValues for content padding
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Welcome Text with "Cafe" and "Solace" styled separately and Cart icon on the right
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        ) {
                            append("Focus ")
                        }
                        withStyle(
                            style = SpanStyle(
                                MaterialTheme.colorScheme.outline,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        ) {
                            append("Panda")
                        }
                    }
                )

                IconButton(
                    onClick = { /* Handle user profile logic */ },
                    modifier = Modifier.size(36.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.panda_image),
                        contentDescription = "User Profile",
                        modifier = Modifier
                            .size(50.dp)
                            //.clip(RoundedCornerShape(30)) // Makes the image circular
                    )
                }
            }

            // Search Box Section
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 22.dp)
//            ) {
//                OutlinedTextField(
//                    value = searchQuery.value,
//                    onValueChange = { searchQuery.value = it },
//                    label = { Text("Search") },
//                    leadingIcon = {
//                        Icon(Icons.Filled.Search, contentDescription = "Search Icon")
//                    },
//                    shape = RoundedCornerShape(26.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .align(Alignment.Center)
//                )
//            }

            Spacer(modifier = Modifier.height(10.dp))

            // Banner Section
            Image(
                painter = painterResource(R.drawable.motivation_qoute),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Category Buttons Section
//            CategoryButtons()

            Spacer(modifier = Modifier.height(10.dp))

            // Featured Items Section
            Text(
                text = "Quick Navigation",
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold,fontSize = 18.sp), // Apply bold style
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.Start)
            )


            FooditemsList(foodList = QuickNavigationIterm().loadQuickNavigationIterm())
            Spacer(modifier = Modifier.height(10.dp))

            // Signature Items Section
            Text(
                text = "Play ambient Sounds",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp // Set the desired font size here
                ),
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .align(Alignment.Start)
            )



            Image(
                painter = painterResource(R.drawable.duli),
                contentDescription = "Banner11",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(R.drawable.duli),
                contentDescription = "Banner11",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(R.drawable.duli),
                contentDescription = "Banner11",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }


}

//@Composable
//fun CategoryButtons() {
//    // State to keep track of the selected category
//    val selectedCategory = remember { mutableStateOf<String?>(null) }
//
//    LazyRow(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 0.dp), // Padding for the entire LazyRow
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.spacedBy(28.dp) // Increased space between buttons
//    ) {
//        items(listOf("Coffee", "Mains", "Desserts")) { category ->
//            Box {
//                OutlinedButton(
//                    onClick = {
//                        selectedCategory.value = category // Update the selected category
//                    },
//                    modifier = Modifier
//                        .height(50.dp)
//                        .padding(horizontal = 4.dp), // Additional padding inside the button
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = if (selectedCategory.value == category) {
//                            Color(0xFFC99954) // Highlight color when selected
//                        } else {
//                            Color(0xA4A26854) // Default background color
//                        },
//                        contentColor = if (selectedCategory.value == category) {
//                            Color.White // Text color for selected
//                        } else {
//                            Color.Yellow // Text color for unselected
//                        }
//                    ),
//                    border = null // Remove or customize the border
//                ) {
//                    Text(
//                        text = category,
//                        color = if (selectedCategory.value == category) {
//                            Color.Black // Text color for selected
//                        } else {
//                            Color.White // Text color for unselected
//                        },
//                        fontSize = 16.sp, // Custom font size
//                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold) // Bold text style
//                    )
//                }
//            }
//        }
//    }
//}




@Composable
fun CoffeIterm(foodPictures: QuickNavigate1, modifier: Modifier) {
    MainsCard(
        imageResourceId = foodPictures.imageResId,
        title = stringResource(id = foodPictures.name),
        price = stringResource(id = foodPictures.price),
        backgroundColor = Color.White
    )
}

@Composable
fun FooditemsList(foodList: List<QuickNavigate1>) {
    val limitedFooditem = foodList.take(5)
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(limitedFooditem) { fooditem ->
            CoffeIterm(foodPictures = fooditem, modifier = Modifier.padding(9.dp))
        }
    }
}


