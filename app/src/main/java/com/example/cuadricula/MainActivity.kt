package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
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
     CursosLista(listaCursos = Datasourse().cargarCursos())
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
fun iconoCard(icono : Int , descripcion: Int ,modifier: Modifier){
    Row (
        modifier.fillMaxWidth()
    ){
        Icon(
            painter = painterResource(id = icono),
            contentDescription = stringResource(id = descripcion),
            modifier = Modifier.padding(20.dp ,10.dp ,15.dp, 20.dp)
            )
    }
}




@Preview
@Composable
fun CursoCuadriculaPreview() {
        CursosCuadricula(Topic(R.string.architecture,58,R.drawable.architecture))
}

@Composable
fun CursosLista(listaCursos : List<Topic>,modifier :Modifier=Modifier){

}