package com.ralphmarondev.familysprout.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.familysprout.R

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    logout: () -> Unit
) {
    ModalDrawerSheet(
        modifier = modifier
            .fillMaxHeight()
            .padding(end = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .fillMaxWidth()
                .height(180.dp)
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = rememberAsyncImagePainter(R.drawable.mountain),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Family Sprout",
                fontSize = 18.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.onTertiary
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        NavigationDrawerItem(
            label = {
                Text(
                    text = "Logout",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W500
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = "Logout"
                )
            },
            onClick = logout,
            selected = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = NavigationDrawerItemDefaults.colors(
                unselectedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                selectedContainerColor = MaterialTheme.colorScheme.secondaryContainer
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}