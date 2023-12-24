package com.saydullin.duplifind.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.saydullin.duplifind.domain.model.GameObject

@Composable
fun GameObject(
    gameObject: GameObject,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .padding(5.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
               if (gameObject.isHidden) {
                   onClick()
               }
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(70.dp, 70.dp)
                .height(IntrinsicSize.Max)
                .width(IntrinsicSize.Max)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .alpha(
                        if (!gameObject.isHidden) 1f else 0.1f
                    ),
                painter = rememberAsyncImagePainter(gameObject.src),
                contentDescription = gameObject.title,
                contentScale = ContentScale.FillWidth,
            )
        }
    }

}


