package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.data.Datasourse
import com.example.cuadricula.model.Topic
import com.example.cuadricula.ui.theme.CuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CursosApp()
                }
            }
        }
    }
}

@Composable
fun CursosApp(){
     CursosLista(listaCursos= Datasourse().cargarCursos(), modifier = Modifier)
}


@Composable
fun CursosCuadricula(cursos: Topic ,modifier: Modifier= Modifier) {

    //elemento componioble card
    Card {
         Row{
             Column {
                 Image(
                     painter = painterResource(cursos.imageResourseId),
                     contentDescription = stringResource(cursos.stringResourceId),
                     modifier = Modifier
                         .width(100.dp)
                         .height(120.dp),
                     contentScale = ContentScale.Crop//determina como se debe  escalar y mostrar  la imagen
                 )
             }
               Column {
                   textoCard(
                       text = cursos.stringResourceId,
                       modifier = Modifier )
                   iconoCard(
                       icono = R.drawable.icono,
                       descripcion = R.string.Icono,
                       cantidad= cursos.cantidad,
                       modifier = Modifier)
               }
             }
        }
    }


@Composable
fun textoCard( text: Int ,modifier: Modifier){
    Row {
            Text(
                text = stringResource(id = text),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

    }

}
@Composable
fun iconoCard(icono : Int , descripcion: Int , cantidad: Int ,modifier: Modifier){
    Row {
        Column {
            Icon(
                painter = painterResource(id = icono),
                contentDescription = stringResource(id = descripcion),
                modifier = Modifier
                    .padding(20.dp, 10.dp, 15.dp, 20.dp)
            )
        }
        Column {
            Text(
                text = cantidad.toString(),
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineSmall

            )
        }
    }
}




@Preview
@Composable
fun CursoCuadriculaPreview() {
        CursosCuadricula(Topic(R.string.architecture,58,R.drawable.architecture))

}

@Composable
fun CursosLista(listaCursos : List<Topic> ,modifier :Modifier=Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {

        items(listaCursos) { topic ->
            CursosCuadricula(
                cursos = topic,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}