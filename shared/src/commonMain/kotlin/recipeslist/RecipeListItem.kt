package recipeslist

/**
 * Created by abdulbasit on 18/06/2023.
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import model.Recipe
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
@Composable
fun RecipeListItem(
    recipe: Recipe,
    width: Int,
    onClick: (recipe: Recipe) -> Unit,
) {

    Box(modifier = Modifier) {
        Box(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(35.dp),
                    clip = true,
                    ambientColor = Color(0xffCE5A01),
                    spotColor = Color(0xffCE5A01)
                ).width(width.dp)
                .aspectRatio(1.5f)
                .background(recipe.bgColor, RoundedCornerShape(35.dp))
                .fillMaxHeight()
                .clickable {
                    onClick(recipe)
                }
        ) {
//            SharedMaterialContainer(
//                key = "${recipe.id}",
//                screenKey = ListScreen,
//                shape = RoundedCornerShape(35.dp),
//                color = recipe.bgColor,
//                elevation = 0.dp,
//                transitionSpec = MaterialFadeOutTransitionSpec
//            ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxHeight().padding(16.dp).fillMaxWidth(0.55f),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(modifier = Modifier.align(Alignment.Bottom)) {
//                            SharedElement(
//                                key = "${recipe.title}",
//                                screenKey = "ListScreen",
//                                transitionSpec = CrossFadeTransitionSpec
//                            ) {
                        Text(
                            recipe.title,
                            style = MaterialTheme.typography.h4,
                        )
//                            }
//                            SharedElement(
//                                key = "${recipe.description}",
//                                screenKey = "ListScreen",
//                                transitionSpec = CrossFadeTransitionSpec
//                            ) {
                        Text(
                            recipe.description,
                            style = MaterialTheme.typography.subtitle1,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(top = 8.dp)
                        )
//                            }
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
//            }
        }

        RecipeListItemImageWrapper(modifier = Modifier.align(Alignment.BottomEnd)
            .fillMaxWidth(0.45f).aspectRatio(1f),
            child = {
//                SharedMaterialContainer(
//                    key = "${recipe.image}",
//                    screenKey = "ListScreen",
//                    shape = CircleShape,
//                    color = Color.Transparent,
//                    transitionSpec = FadeOutTransitionSpec
//                ) {
                RecipeImage(
                    recipe.image, Modifier
                )
//                }
            })
    }
}
