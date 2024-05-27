package test;

import main.AnalizadorLetras;
import main.Exception.analizadorLetrasException;
import main.Palabra;
import main.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AnalizadorLetrasTest {

    private AnalizadorLetras analizadorLetras;

    @BeforeEach
    public void setup() {
        analizadorLetras = new AnalizadorLetras();
    }

    @Test
    public void dadaUnaListaDePalabrasObtenerLaLetraQueMasSeRepite() {
        Palabra[] palabras = {
                new Palabra("arbol"),
                new Palabra("orden"),
                new Palabra("susana"),
                new Palabra("otro"),
                new Palabra("listo"),
                new Palabra("nexos")};

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('o'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("orden", "otro", "listo"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadoQueDosOMasLetrasSeRepitenDeFormaMaximaEntoncesSeObtienenTodasLetras() {
        Palabra[] palabras = {
                new Palabra("arbol"),
                new Palabra("orden")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('o', 'n', 'a', 'l'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("orden", "arbol"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadaUnaPalabraConMismaLetraExtremaInicialYFinalEntoncesCuentaPor2Repeticiones() {
        Palabra[] palabras = {
                new Palabra("arbol"),
                new Palabra("otro"),
                new Palabra("mora"),
                new Palabra("perro")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('o'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("otro", "perro"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadaUnaPalabraQueSeRepiteParaDosLetrasExtremasMaximasEntoncesSeMuestraUnaSolaVez() {
        Palabra[] palabras = {
                new Palabra("arbol")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('a', 'l'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("arbol"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void dadasPalabrasDeUnaLetraEntoncesCuentaPor2Repeticiones(){

        Palabra[] palabras = {
                new Palabra("y"),
                new Palabra("y"),
                new Palabra("y"),
                new Palabra("ana"),
                new Palabra("origami"),
                new Palabra("estrella")
        };
/* En este caso si las palabras que tienen una sola letra no contrarian por dos repeticiones tendriamos que las
 letras extremas mas repetidas son la letra "y" junto con la letra "a". Pero como cuentan como dos repeticiones,
  en este caso la letra extrema maxima es solo la letra "y"*/

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);
        validarCaracterMasRepetidos(List.of('y'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("y"), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void listaDe250Palabras(){
        Palabra[] palabras = {
                new Palabra("arbol"), // 1
                new Palabra("otro"), // 2
                new Palabra("mora"), // 3
                new Palabra("perro"), // 4
                new Palabra("casa"), // 5
                new Palabra("agua"), // 6
                new Palabra("sol"), // 7
                new Palabra("luz"), // 8
                new Palabra("mar"), // 9
                new Palabra("nube"), // 10
                new Palabra("cielo"), // 11
                new Palabra("flor"), // 12
                new Palabra("mesa"), // 13
                new Palabra("silla"), // 14
                new Palabra("libro"), // 15
                new Palabra("gato"), // 16
                new Palabra("pez"), // 17
                new Palabra("tierra"), // 18
                new Palabra("fuego"), // 19
                new Palabra("aire"), // 20
                new Palabra("lago"), // 21
                new Palabra("río"), // 22
                new Palabra("monte"), // 23
                new Palabra("campo"), // 24
                new Palabra("piedra"), // 25
                new Palabra("viento"), // 26
                new Palabra("trueno"), // 27
                new Palabra("lluvia"), // 28
                new Palabra("hoja"), // 29
                new Palabra("fruta"), // 30
                new Palabra("pan"), // 31
                new Palabra("vino"), // 32
                new Palabra("sal"), // 33
                new Palabra("miel"), // 34
                new Palabra("luna"), // 35
                new Palabra("estrella"), // 36
                new Palabra("noche"), // 37
                new Palabra("día"), // 38
                new Palabra("rayo"), // 39
                new Palabra("montaña"), // 40
                new Palabra("valle"), // 41
                new Palabra("bosque"), // 42
                new Palabra("selva"), // 43
                new Palabra("ciudad"), // 44
                new Palabra("pueblo"), // 45
                new Palabra("camino"), // 46
                new Palabra("puente"), // 47
                new Palabra("carro"), // 48
                new Palabra("tren"), // 49
                new Palabra("barco"), // 50
                new Palabra("avión"), // 51
                new Palabra("bicicleta"), // 52
                new Palabra("moto"), // 53
                new Palabra("rojo"), // 54
                new Palabra("verde"), // 55
                new Palabra("azul"), // 56
                new Palabra("amarillo"), // 57
                new Palabra("blanco"), // 58
                new Palabra("negro"), // 59
                new Palabra("gris"), // 60
                new Palabra("marrón"), // 61
                new Palabra("naranja"), // 62
                new Palabra("rosa"), // 63
                new Palabra("violeta"), // 64
                new Palabra("color"), // 65
                new Palabra("tela"), // 66
                new Palabra("ropa"), // 67
                new Palabra("zapato"), // 68
                new Palabra("sombrero"), // 69
                new Palabra("guante"), // 70
                new Palabra("bufanda"), // 71
                new Palabra("anillo"), // 72
                new Palabra("collar"), // 73
                new Palabra("pulsera"), // 74
                new Palabra("reloj"), // 75
                new Palabra("bolso"), // 76
                new Palabra("maleta"), // 77
                new Palabra("caja"), // 78
                new Palabra("bolsa"), // 79
                new Palabra("juguete"), // 80
                new Palabra("pelota"), // 81
                new Palabra("muñeca"), // 82
                new Palabra("coche"), // 83
                new Palabra("camión"), // 84
                new Palabra("tractor"), // 85
                new Palabra("grúa"), // 86
                new Palabra("patineta"), // 87
                new Palabra("trineo"), // 88
                new Palabra("globo"), // 89
                new Palabra("cohete"), // 90
                new Palabra("paracaídas"), // 91
                new Palabra("submarino"), // 92
                new Palabra("buzo"), // 93
                new Palabra("pirata"), // 94
                new Palabra("espada"), // 95
                new Palabra("escudo"), // 96
                new Palabra("casco"), // 97
                new Palabra("lanza"), // 98
                new Palabra("arco"), // 99
                new Palabra("flecha"), // 100
                new Palabra("dardo"), // 101
                new Palabra("balón"), // 102
                new Palabra("béisbol"), // 103
                new Palabra("tenis"), // 104
                new Palabra("ping-pong"), // 105
                new Palabra("baloncesto"), // 106
                new Palabra("fútbol"), // 107
                new Palabra("voleibol"), // 108
                new Palabra("natación"), // 109
                new Palabra("atletismo"), // 110
                new Palabra("gimnasia"), // 111
                new Palabra("ciclismo"), // 112
                new Palabra("esquí"), // 113
                new Palabra("patinaje"), // 114
                new Palabra("hockey"), // 115
                new Palabra("boxeo"), // 116
                new Palabra("karate"), // 117
                new Palabra("judo"), // 118
                new Palabra("taekwondo"), // 119
                new Palabra("esgrima"), // 120
                new Palabra("remo"), // 121
                new Palabra("vela"), // 122
                new Palabra("surf"), // 123
                new Palabra("buceo"), // 124
                new Palabra("pesca"), // 125
                new Palabra("caza"), // 126
                new Palabra("camping"), // 127
                new Palabra("senderismo"), // 128
                new Palabra("escalada"), // 129
                new Palabra("montañismo"), // 130
                new Palabra("parapente"), // 131
                new Palabra("paracaidismo"), // 132
                new Palabra("ala delta"), // 133
                new Palabra("dirigible"), // 134
                new Palabra("cometa"), // 135
                new Palabra("nave"), // 136
                new Palabra("satélite"), // 137
                new Palabra("astronauta"), // 138
                new Palabra("planeta"), // 139
                new Palabra("constelación"), // 140
                new Palabra("galaxia"), // 141
                new Palabra("universo"), // 142
                new Palabra("espacio"), // 143
                new Palabra("astronomía"), // 144
                new Palabra("telescopio"), // 145
                new Palabra("observatorio"), // 146
                new Palabra("explorador"), // 147
                new Palabra("científico"), // 148
                new Palabra("investigador"), // 149
                new Palabra("arqueólogo"), // 150
                new Palabra("biólogo"), // 151
                new Palabra("químico"), // 152
                new Palabra("físico"), // 153
                new Palabra("geólogo"), // 154
                new Palabra("meteorólogo"), // 155
                new Palabra("zoológico"), // 156
                new Palabra("botánico"), // 157
                new Palabra("astrónomo"), // 158
                new Palabra("oceanógrafo"), // 159
                new Palabra("antropólogo"), // 160
                new Palabra("historiador"), // 161
                new Palabra("filósofo"), // 162
                new Palabra("sociólogo"), // 163
                new Palabra("psicólogo"), // 164
                new Palabra("economista"), // 165
                new Palabra("político"), // 166
                new Palabra("diplomático"), // 167
                new Palabra("abogado"), // 168
                new Palabra("juez"), // 169
                new Palabra("notario"), // 170
                new Palabra("escritor"), // 171
                new Palabra("poeta"), // 172
                new Palabra("novelista"), // 173
                new Palabra("dramaturgo"), // 174
                new Palabra("periodista"), // 175
                new Palabra("fotógrafo"), // 176
                new Palabra("cineasta"), // 177
                new Palabra("director"), // 178
                new Palabra("productor"), // 179
                new Palabra("actor"), // 180
                new Palabra("actriz"), // 181
                new Palabra("músico"), // 182
                new Palabra("cantante"), // 183
                new Palabra("compositor"), // 184
                new Palabra("pintor"), // 185
                new Palabra("escultor"), // 186
                new Palabra("arquitecto"), // 187
                new Palabra("diseñador"), // 188
                new Palabra("modista"), // 189
                new Palabra("estilista"), // 190
                new Palabra("maquillador"), // 191
                new Palabra("peluquero"), // 192
                new Palabra("manicura"), // 193
                new Palabra("pedicura"), // 194
                new Palabra("cirujano"), // 195
                new Palabra("médico"), // 196
                new Palabra("enfermero"), // 197
                new Palabra("dentista"), // 198
                new Palabra("farmacéutico"), // 199
                new Palabra("psiquiatra"), // 200
                new Palabra("veterinario"), // 201
                new Palabra("fisioterapeuta"), // 202
                new Palabra("optometrista"), // 203
                new Palabra("podólogo"), // 204
                new Palabra("radiólogo"), // 205
                new Palabra("patólogo"), // 206
                new Palabra("cardiólogo"), // 207
                new Palabra("dermatólogo"), // 208
                new Palabra("neurólogo"), // 209
                new Palabra("nefrólogo"), // 210
                new Palabra("hematólogo"), // 211
                new Palabra("gastroenterólogo"), // 212
                new Palabra("neumólogo"), // 213
                new Palabra("oftalmólogo"), // 214
                new Palabra("oncólogo"), // 215
                new Palabra("ortopedista"), // 216
                new Palabra("pediatra"), // 217
                new Palabra("psicólogo"), // 218
                new Palabra("terapeuta"), // 219
                new Palabra("trabajador social"), // 220
                new Palabra("educador"), // 221
                new Palabra("profesor"), // 222
                new Palabra("maestro"), // 223
                new Palabra("tutor"), // 224
                new Palabra("instructor"), // 225
                new Palabra("entrenador"), // 226
                new Palabra("coach"), // 227
                new Palabra("asesor"), // 228
                new Palabra("consultor"), // 229
                new Palabra("consejero"), // 230
                new Palabra("mentor"), // 231
                new Palabra("guía"), // 232
                new Palabra("líder"), // 233
                new Palabra("jefe"), // 234
                new Palabra("director"), // 235
                new Palabra("gerente"), // 236
                new Palabra("administrador"), // 237
                new Palabra("supervisor"), // 238
                new Palabra("coordinador"), // 239
                new Palabra("organizador"), // 240
                new Palabra("promotor"), // 241
                new Palabra("agente"), // 242
                new Palabra("representante"), // 243
                new Palabra("delegado"), // 244
                new Palabra("embajador"), // 245
                new Palabra("ministro"), // 246
                new Palabra("secretario"), // 247
                new Palabra("presidente"), // 248
                new Palabra("vicepresidente"), // 249
                new Palabra("gobernador") // 250
        };
        assertEquals(palabras.length, 250);

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);
        validarCaracterMasRepetidos(List.of('o'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("ortopedista", "político", "consejero", "fuego",
                "gastroenterólogo", "dramaturgo", "río", "antropólogo", "músico", "patólogo", "remo", "espacio", "cielo",
                "judo", "filósofo", "oncólogo", "globo", "boxeo", "cardiólogo", "barco", "nefrólogo", "lago", "taekwondo",
                "arquitecto", "ministro", "zoológico", "perro", "viento", "secretario", "físico", "delegado", "cirujano",
                "oftalmólogo", "dardo", "atletismo", "enfermero", "diplomático", "fotógrafo", "baloncesto", "anillo",
                "químico", "submarino", "científico", "veterinario", "trineo", "zapato", "optometrista", "arco",
                "podólogo", "rojo", "maestro", "senderismo", "buceo", "vino", "notario", "ciclismo", "geólogo",
                "abogado", "amarillo", "paracaidismo", "neurólogo", "trueno", "libro", "casco", "dermatólogo", "campo",
                "moto", "rayo", "carro", "sombrero", "sociólogo", "observatorio", "telescopio", "peluquero", "camino",
                "bolso", "farmacéutico", "hematólogo", "médico", "radiólogo", "meteorólogo", "oceanógrafo", "biólogo",
                "otro", "pueblo", "astrónomo", "gato", "montañismo", "neumólogo", "buzo", "psicólogo", "botánico",
                "negro", "escudo", "blanco", "arqueólogo", "universo", "organizador"
        ), resultado.getPalabrasDeCaracteresMasRepetidos());
    }

    @Test
    public void listaDe251Palabras(){
        assertThrows(analizadorLetrasException.class, this::analizar251Palabras);
    }

    private void analizar251Palabras() throws analizadorLetrasException {
        Palabra[] palabras = {
                new Palabra("arbol"), // 1
                new Palabra("otro"), // 2
                new Palabra("mora"), // 3
                new Palabra("perro"), // 4
                new Palabra("casa"), // 5
                new Palabra("agua"), // 6
                new Palabra("sol"), // 7
                new Palabra("luz"), // 8
                new Palabra("mar"), // 9
                new Palabra("nube"), // 10
                new Palabra("cielo"), // 11
                new Palabra("flor"), // 12
                new Palabra("mesa"), // 13
                new Palabra("silla"), // 14
                new Palabra("libro"), // 15
                new Palabra("gato"), // 16
                new Palabra("pez"), // 17
                new Palabra("tierra"), // 18
                new Palabra("fuego"), // 19
                new Palabra("aire"), // 20
                new Palabra("lago"), // 21
                new Palabra("río"), // 22
                new Palabra("monte"), // 23
                new Palabra("campo"), // 24
                new Palabra("piedra"), // 25
                new Palabra("viento"), // 26
                new Palabra("trueno"), // 27
                new Palabra("lluvia"), // 28
                new Palabra("hoja"), // 29
                new Palabra("fruta"), // 30
                new Palabra("pan"), // 31
                new Palabra("vino"), // 32
                new Palabra("sal"), // 33
                new Palabra("miel"), // 34
                new Palabra("luna"), // 35
                new Palabra("estrella"), // 36
                new Palabra("noche"), // 37
                new Palabra("día"), // 38
                new Palabra("rayo"), // 39
                new Palabra("montaña"), // 40
                new Palabra("valle"), // 41
                new Palabra("bosque"), // 42
                new Palabra("selva"), // 43
                new Palabra("ciudad"), // 44
                new Palabra("pueblo"), // 45
                new Palabra("camino"), // 46
                new Palabra("puente"), // 47
                new Palabra("carro"), // 48
                new Palabra("tren"), // 49
                new Palabra("barco"), // 50
                new Palabra("avión"), // 51
                new Palabra("bicicleta"), // 52
                new Palabra("moto"), // 53
                new Palabra("rojo"), // 54
                new Palabra("verde"), // 55
                new Palabra("azul"), // 56
                new Palabra("amarillo"), // 57
                new Palabra("blanco"), // 58
                new Palabra("negro"), // 59
                new Palabra("gris"), // 60
                new Palabra("marrón"), // 61
                new Palabra("naranja"), // 62
                new Palabra("rosa"), // 63
                new Palabra("violeta"), // 64
                new Palabra("color"), // 65
                new Palabra("tela"), // 66
                new Palabra("ropa"), // 67
                new Palabra("zapato"), // 68
                new Palabra("sombrero"), // 69
                new Palabra("guante"), // 70
                new Palabra("bufanda"), // 71
                new Palabra("anillo"), // 72
                new Palabra("collar"), // 73
                new Palabra("pulsera"), // 74
                new Palabra("reloj"), // 75
                new Palabra("bolso"), // 76
                new Palabra("maleta"), // 77
                new Palabra("caja"), // 78
                new Palabra("bolsa"), // 79
                new Palabra("juguete"), // 80
                new Palabra("pelota"), // 81
                new Palabra("muñeca"), // 82
                new Palabra("coche"), // 83
                new Palabra("camión"), // 84
                new Palabra("tractor"), // 85
                new Palabra("grúa"), // 86
                new Palabra("patineta"), // 87
                new Palabra("trineo"), // 88
                new Palabra("globo"), // 89
                new Palabra("cohete"), // 90
                new Palabra("paracaídas"), // 91
                new Palabra("submarino"), // 92
                new Palabra("buzo"), // 93
                new Palabra("pirata"), // 94
                new Palabra("espada"), // 95
                new Palabra("escudo"), // 96
                new Palabra("casco"), // 97
                new Palabra("lanza"), // 98
                new Palabra("arco"), // 99
                new Palabra("flecha"), // 100
                new Palabra("dardo"), // 101
                new Palabra("balón"), // 102
                new Palabra("béisbol"), // 103
                new Palabra("tenis"), // 104
                new Palabra("ping-pong"), // 105
                new Palabra("baloncesto"), // 106
                new Palabra("fútbol"), // 107
                new Palabra("voleibol"), // 108
                new Palabra("natación"), // 109
                new Palabra("atletismo"), // 110
                new Palabra("gimnasia"), // 111
                new Palabra("ciclismo"), // 112
                new Palabra("esquí"), // 113
                new Palabra("patinaje"), // 114
                new Palabra("hockey"), // 115
                new Palabra("boxeo"), // 116
                new Palabra("karate"), // 117
                new Palabra("judo"), // 118
                new Palabra("taekwondo"), // 119
                new Palabra("esgrima"), // 120
                new Palabra("remo"), // 121
                new Palabra("vela"), // 122
                new Palabra("surf"), // 123
                new Palabra("buceo"), // 124
                new Palabra("pesca"), // 125
                new Palabra("caza"), // 126
                new Palabra("camping"), // 127
                new Palabra("senderismo"), // 128
                new Palabra("escalada"), // 129
                new Palabra("montañismo"), // 130
                new Palabra("parapente"), // 131
                new Palabra("paracaidismo"), // 132
                new Palabra("ala delta"), // 133
                new Palabra("dirigible"), // 134
                new Palabra("cometa"), // 135
                new Palabra("nave"), // 136
                new Palabra("satélite"), // 137
                new Palabra("astronauta"), // 138
                new Palabra("planeta"), // 139
                new Palabra("constelación"), // 140
                new Palabra("galaxia"), // 141
                new Palabra("universo"), // 142
                new Palabra("espacio"), // 143
                new Palabra("astronomía"), // 144
                new Palabra("telescopio"), // 145
                new Palabra("observatorio"), // 146
                new Palabra("explorador"), // 147
                new Palabra("científico"), // 148
                new Palabra("investigador"), // 149
                new Palabra("arqueólogo"), // 150
                new Palabra("biólogo"), // 151
                new Palabra("químico"), // 152
                new Palabra("físico"), // 153
                new Palabra("geólogo"), // 154
                new Palabra("meteorólogo"), // 155
                new Palabra("zoológico"), // 156
                new Palabra("botánico"), // 157
                new Palabra("astrónomo"), // 158
                new Palabra("oceanógrafo"), // 159
                new Palabra("antropólogo"), // 160
                new Palabra("historiador"), // 161
                new Palabra("filósofo"), // 162
                new Palabra("sociólogo"), // 163
                new Palabra("psicólogo"), // 164
                new Palabra("economista"), // 165
                new Palabra("político"), // 166
                new Palabra("diplomático"), // 167
                new Palabra("abogado"), // 168
                new Palabra("juez"), // 169
                new Palabra("notario"), // 170
                new Palabra("escritor"), // 171
                new Palabra("poeta"), // 172
                new Palabra("novelista"), // 173
                new Palabra("dramaturgo"), // 174
                new Palabra("periodista"), // 175
                new Palabra("fotógrafo"), // 176
                new Palabra("cineasta"), // 177
                new Palabra("director"), // 178
                new Palabra("productor"), // 179
                new Palabra("actor"), // 180
                new Palabra("actriz"), // 181
                new Palabra("músico"), // 182
                new Palabra("cantante"), // 183
                new Palabra("compositor"), // 184
                new Palabra("pintor"), // 185
                new Palabra("escultor"), // 186
                new Palabra("arquitecto"), // 187
                new Palabra("diseñador"), // 188
                new Palabra("modista"), // 189
                new Palabra("estilista"), // 190
                new Palabra("maquillador"), // 191
                new Palabra("peluquero"), // 192
                new Palabra("manicura"), // 193
                new Palabra("pedicura"), // 194
                new Palabra("cirujano"), // 195
                new Palabra("médico"), // 196
                new Palabra("enfermero"), // 197
                new Palabra("dentista"), // 198
                new Palabra("farmacéutico"), // 199
                new Palabra("psiquiatra"), // 200
                new Palabra("veterinario"), // 201
                new Palabra("fisioterapeuta"), // 202
                new Palabra("optometrista"), // 203
                new Palabra("podólogo"), // 204
                new Palabra("radiólogo"), // 205
                new Palabra("patólogo"), // 206
                new Palabra("cardiólogo"), // 207
                new Palabra("dermatólogo"), // 208
                new Palabra("neurólogo"), // 209
                new Palabra("nefrólogo"), // 210
                new Palabra("hematólogo"), // 211
                new Palabra("gastroenterólogo"), // 212
                new Palabra("neumólogo"), // 213
                new Palabra("oftalmólogo"), // 214
                new Palabra("oncólogo"), // 215
                new Palabra("ortopedista"), // 216
                new Palabra("pediatra"), // 217
                new Palabra("psicólogo"), // 218
                new Palabra("terapeuta"), // 219
                new Palabra("trabajador social"), // 220
                new Palabra("educador"), // 221
                new Palabra("profesor"), // 222
                new Palabra("maestro"), // 223
                new Palabra("tutor"), // 224
                new Palabra("instructor"), // 225
                new Palabra("entrenador"), // 226
                new Palabra("coach"), // 227
                new Palabra("asesor"), // 228
                new Palabra("consultor"), // 229
                new Palabra("consejero"), // 230
                new Palabra("mentor"), // 231
                new Palabra("guía"), // 232
                new Palabra("líder"), // 233
                new Palabra("jefe"), // 234
                new Palabra("director"), // 235
                new Palabra("gerente"), // 236
                new Palabra("administrador"), // 237
                new Palabra("supervisor"), // 238
                new Palabra("coordinador"), // 239
                new Palabra("organizador"), // 240
                new Palabra("promotor"), // 241
                new Palabra("agente"), // 242
                new Palabra("representante"), // 243
                new Palabra("delegado"), // 244
                new Palabra("embajador"), // 245
                new Palabra("ministro"), // 246
                new Palabra("secretario"), // 247
                new Palabra("presidente"), // 248
                new Palabra("vicepresidente"), // 249
                new Palabra("gobernador"), // 250
                new Palabra("oso") // 251
        };
        assertEquals(palabras.length, 251);
        analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);
    }

    @Test
    public void listaDeUnaSolaPalabra(){
        Palabra[] palabras = {
                new Palabra("hola")
        };

        Resultado resultado = analizadorLetras.obtenerUsosDeLetraExtremaMasUtilizada(palabras);

        validarCaracterMasRepetidos(List.of('h', 'a'), resultado.getCaracterMasRepetidos());
        validarPalabrasParaCaracteresMasRepetidos(List.of("hola"), resultado.getPalabrasDeCaracteresMasRepetidos());

    }

    private void validarCaracterMasRepetidos(List<Character> caracteresEsperados, List<Character> caracteresMasRepetidos) {
        assertEquals(caracteresEsperados.size(), caracteresMasRepetidos.size());
        assertTrue(caracteresMasRepetidos.containsAll(caracteresEsperados));
    }

    private void validarPalabrasParaCaracteresMasRepetidos(List<String> palabrasEsperadas, Set<String> palabrasDeCaracteresMasRepetidos) {
        assertEquals(palabrasEsperadas.size(), palabrasDeCaracteresMasRepetidos.size());
        assertTrue(palabrasDeCaracteresMasRepetidos.containsAll(palabrasEsperadas));
    }



}
