package com.playlab.bussolaagilimport android.content.res.Configuration.UI_MODE_NIGHT_YESimport androidx.compose.animation.core.LinearEasingimport androidx.compose.animation.core.animateFloatAsStateimport androidx.compose.animation.core.tweenimport androidx.compose.foundation.backgroundimport androidx.compose.foundation.borderimport androidx.compose.foundation.layout.*import androidx.compose.foundation.shape.CircleShapeimport androidx.compose.material.ExperimentalMaterialApiimport androidx.compose.material.MaterialThemeimport androidx.compose.material.Surfaceimport androidx.compose.material.Textimport androidx.compose.runtime.Composableimport androidx.compose.runtime.getValueimport androidx.compose.runtime.mutableStateOfimport androidx.compose.runtime.rememberimport androidx.compose.ui.Alignmentimport androidx.compose.ui.Modifierimport androidx.compose.ui.draw.rotateimport androidx.compose.ui.focus.FocusRequester.Companion.createRefsimport androidx.compose.ui.graphics.Colorimport androidx.compose.ui.res.stringResourceimport androidx.compose.ui.tooling.preview.Previewimport androidx.compose.ui.unit.Dpimport androidx.compose.ui.unit.dpimport androidx.compose.ui.unit.spimport androidx.constraintlayout.compose.ConstraintLayoutimport com.playlab.bussolaagil.ui.theme.BussolaAgilThemeimport kotlinx.coroutines.NonDisposableHandle.parent@Composablefun CompassAnimationStyled(    size: Dp = 300.dp,    color: Color = MaterialTheme.colors.onBackground,    degrees: Int = 360) {    val (lastRotation, setLastRotation) = remember { mutableStateOf(0) } // this keeps last rotation    var newRotation = lastRotation // newRotation will be updated in proper way    // last rotation converted to range [-359; 359]    val modLast = if (lastRotation > 0) lastRotation % 360 else 360 - (-lastRotation % 360)    // if modLast isn't equal rotation retrieved as function argument    // it means that newRotation has to be updated    if (modLast != degrees) {        // distance in degrees between modLast and rotation going backward        val backward = if (degrees > modLast) modLast + 360 - degrees else modLast - degrees        // distance in degrees between modLast and rotation going forward        val forward = if (degrees > modLast) degrees - modLast else 360 - modLast + degrees        // update newRotation so it will change rotation in the shortest way        newRotation = if (backward < forward) {            // backward rotation is shorter            lastRotation - backward        } else {            // forward rotation is shorter (or they are equal)            lastRotation + forward        }        setLastRotation(newRotation)    }    //negative value to rotate in opsite direction    // degrees - 270 to start the compass needle on top position    val rotation = -(newRotation - 270)    val angle by animateFloatAsState(        targetValue = rotation.toFloat(),        animationSpec = tween(            durationMillis = 300,            easing = LinearEasing        )    )    Box(modifier = Modifier,        contentAlignment = Alignment.Center    ){        Text(            text = "${degrees}°",            color = MaterialTheme.colors.onBackground,            fontSize = (size.value * .2f).toInt().sp,            style = MaterialTheme.typography.h1,        )        ConstraintLayout(            Modifier                .size(size)                .border(width = 15.dp, shape = CircleShape, color = color)                .rotate(angle)        ) {            val ( west, north, east, south) = createRefs()            //WEST            Text(                modifier = Modifier.constrainAs(west){                    top.linkTo(parent.top, 8.dp)                    start.linkTo(parent.start, 16.dp)                    end.linkTo(parent.end, 16.dp)                },                text = stringResource(id = R.string.west),                color = MaterialTheme.colors.onSurface,                style = MaterialTheme.typography.subtitle1            )            //EAST            Text(                modifier = Modifier.constrainAs(east){                    start.linkTo(parent.start, 16.dp)                    end.linkTo(parent.end, 16.dp)                    bottom.linkTo(parent.bottom, 8.dp)                }.rotate(180f),                text = stringResource(id = R.string.east),                color = MaterialTheme.colors.onBackground,                style = MaterialTheme.typography.subtitle1            )            //SOUTH            Text(                modifier = Modifier                    .constrainAs(south) {                        top.linkTo(parent.top, 16.dp)                        start.linkTo(parent.start, 12.dp)                        bottom.linkTo(parent.bottom, 16.dp)                    }                    .rotate(90f),                text = stringResource(id = R.string.south),                color = MaterialTheme.colors.onBackground,                style = MaterialTheme.typography.subtitle1            )            //NORTH            Text(                modifier = Modifier                    .constrainAs(north) {                        top.linkTo(parent.top, 16.dp)                        end.linkTo(parent.end, 12.dp)                        bottom.linkTo(parent.bottom, 16.dp)                    }                    .rotate(90f),                text = stringResource(id = R.string.north),                color = Color.Red,                style = MaterialTheme.typography.subtitle1            )        }    }}@OptIn(ExperimentalMaterialApi::class)@Composable@Preview(showBackground = true, showSystemUi = true)fun CompassAnimationStyledPreview() {    BussolaAgilTheme() {        Surface(onClick = { /*TODO*/ }) {            Column(                Modifier.fillMaxSize(),                horizontalAlignment = Alignment.CenterHorizontally,                verticalArrangement = Arrangement.Center            ) {                CompassAnimationStyled(degrees = 90)            }        }    }}@OptIn(ExperimentalMaterialApi::class)@Composable@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)fun CompassAnimationStyledDarkPreview() {    BussolaAgilTheme() {        Surface(onClick = { /*TODO*/ }) {            Column(                Modifier.fillMaxSize(),                horizontalAlignment = Alignment.CenterHorizontally,                verticalArrangement = Arrangement.Center            ) {                CompassAnimationStyled(degrees = 0)            }        }    }}