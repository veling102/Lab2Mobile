package com.example.lab2mobile.ui.theme

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2mobile.R
import com.example.lab2mobile.data.Artwork

@Composable
fun ArtSpaceApp(artworks: List<Artwork>) {

    var currentIndex by rememberSaveable { mutableStateOf(0) }

    val currentArtwork = artworks[currentIndex]
    val configuration = LocalConfiguration.current

    val isPreviousEnabled = currentIndex > 0
    val isNextEnabled = currentIndex < artworks.size - 1

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LandscapeLayout(
                artwork = currentArtwork,
                onPrevClick = { currentIndex-- },
                onNextClick = { currentIndex++ },
                isPrevEnabled = isPreviousEnabled,
                isNextEnabled = isNextEnabled
            )
        } else {
            PortraitLayout(
                artwork = currentArtwork,
                onPrevClick = { currentIndex-- },
                onNextClick = { currentIndex++ },
                isPrevEnabled = isPreviousEnabled,
                isNextEnabled = isNextEnabled
            )
        }
    }
}


@Composable
fun PortraitLayout(
    artwork: Artwork,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    isPrevEnabled: Boolean,
    isNextEnabled: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ArtworkWall(
            artwork = artwork,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ArtworkDescriptor(artwork = artwork)
        Spacer(modifier = Modifier.height(24.dp))
        DisplayController(
            onPrevClick = onPrevClick,
            onNextClick = onNextClick,
            isPrevEnabled = isPrevEnabled,
            isNextEnabled = isNextEnabled
        )
    }
}


@Composable
fun LandscapeLayout(
    artwork: Artwork,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    isPrevEnabled: Boolean,
    isNextEnabled: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ArtworkWall(
            artwork = artwork,
            modifier = Modifier
                .weight(1.5f)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(24.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtworkDescriptor(artwork = artwork)
            Spacer(modifier = Modifier.height(24.dp))
            DisplayController(
                onPrevClick = onPrevClick,
                onNextClick = onNextClick,
                isPrevEnabled = isPrevEnabled,
                isNextEnabled = isNextEnabled
            )
        }
    }
}

@Composable
fun ArtworkWall(artwork: Artwork, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .padding(8.dp)
            .shadow(elevation = 8.dp),
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = artwork.imageResId),
            contentDescription = stringResource(id = artwork.contentDescriptionResId),
            modifier = Modifier.padding(24.dp),
            contentScale = ContentScale.Fit
        )
    }
}


@Composable
fun ArtworkDescriptor(artwork: Artwork) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = artwork.titleResId),
            fontSize = 22.sp,
            fontWeight = FontWeight.Light
        )
        Row {
            Text(
                text = stringResource(id = artwork.artistResId),
                fontWeight = FontWeight.Bold
            )
            Text(text = " (${stringResource(id = artwork.yearResId)})")
        }
    }
}


@Composable
fun DisplayController(
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit,
    isPrevEnabled: Boolean,
    isNextEnabled: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onPrevClick,
            enabled = isPrevEnabled,
            modifier = Modifier.weight(1f).padding(end = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.btn_previous))
        }
        Button(
            onClick = onNextClick,
            enabled = isNextEnabled,
            modifier = Modifier.weight(1f).padding(start = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.btn_next))
        }
    }
}